<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>404-OP-伤寒接口站</title>
    <base href="<%=basePath %>">
    <%-- 404-GBOOK_有趣的工具站 --%>
    <meta name="keywords" content="Pro伤寒,技术,接口,util,工作站,29160047,肖博夷,Mongodb,MySql,Groovy,1877378299,18616220047">
    <meta name="description" content="Pro伤寒,技术,接口,util,工作站,29160047,肖博夷,Mongodb,MySql,Groovy,1877378299,18616220047">
    <meta name="robots" content="all">
    <meta name="googlebot" content="all">
    <meta name="baiduspider" content="all">
</head>
<body>
<h1>Pro伤寒接口社区</h1>
<h3>共享接口文档指南:</h3>
<a href="/tools/region/getRegions">获取所有城市一级地区接口</a>http://www.29160047.com/tools/region/getRegions<br/>
<a href="/tools/region/getRegions/110000">获取所有子级地区接口</a>http://www.29160047.com/tools/region/getRegions/{cityId}<br/>
<a href="/tools/md5/toMD5">MD5加密接口&nbsp;参数: psd | string&nbsp; psd 被加密字符串 </a>http://www.29160047.com/tools/md5/toMD5<br/>
<a href="/tools/cipher/aesGenerator">AES加密接口</a>http://www.29160047.com/tools/cipher/aesGenerator<br/>
参数:pwd 需要加密的密码<br/>
参数:key 密文  只能为16位密文<br/>
<a href="/tools/cipher/aesParser">AES解密接口</a>http://www.29160047.com/tools/cipher/aesParser<br/>
参数:pwd 需要解密的AES加密后密文<br/>
参数:key 密文  只能为16位密文<br/>
<a href="/tools/cipher/shaEncrypt">SHA加密接口</a>http://www.29160047.com/tools/cipher/shaEncrypt<br/>
参数:pwd<br/>

</body>
</html>
