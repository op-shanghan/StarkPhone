<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>文件系统</title>
  <base href="<%=basePath %>">
  <link rel="stylesheet" href="/resources/css/fonts/iconfont.css">
  <script src='/resources/js/vue.min.js'></script>
  <script src='/resources/js/zepto.min.js'></script>
  <style>
    body, body * {
      margin: 0;
      padding: 0;
    }

    #file-system {
      padding: 20px;
    }

    .iconfont {
      color: #F1D874;
    }
    
  </style>
</head>
<body>

  <div id="file-system">
    <dl>
      <dt>
        名称
      </dt>
      <dd class="item" v-show='!(/resources\/?$/.test(this.parentUrl))' @click='back(parentUrl)'>
        <span class="iconfont icon-wenjianjia" ></span> ../
      </dd>
      <dd class="item" v-for='item in datas.resFileBeans'>
        <span class="iconfont" 
          :class='[item.ifFile?"icon-wenjian":"icon-wenjianjia"]'></span>
        <a :href="item.filePath" v-if='item.ifFile'>{{item.fileName}}</a>
        <!--  target="_blank" -->
        <span v-else @click='open(item.filePath)' style='color:#0000ff'>{{item.fileName}}</span>
      </dd>
    </dl>
  </div>
  <script>
    new Vue({
      el: "#file-system",
      data: {
        datas: {},
        parentUrl: '',
        isShow: false
      },
      created: function () {
        this.getDatas('<%=basePath %>/resources')
      },
      methods: {
        getDatas: function (url) {
          this.parentUrl = url
          this.isShow = url === "<%=basePath %>/resources" ? false : true
          $.get(url, (data) => {
            data.resFileBeans.forEach((item) => {
              item.ifFile = item.fileName.indexOf('.') > -1 ? true : false
            })
            this.datas = data
          })
        },

        open (url) {
          this.getDatas(url)
        },
        back (url) {
          var _url = url.substring(0, url.lastIndexOf('/', url.length - 2))
          this.getDatas(_url)
        }
      },
      mounted: function () {
        
      }
    })
  </script>
</body>
</html>