package com.stark.app.tools.controller;

import com.stark.utils.result.ResultO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/tools/fileUpDo")
public class FileUpDoController {

    class FileUp{
        private Integer status;
        private String filePath;
        private String fileUrl;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }
    }

    private boolean CheckFileLastName(String fileLastName){
        switch (fileLastName.toLowerCase()){
            case "png":
                return true;
            case "jpg":
                return true;
            case "gif":
                return true;
            case "mp3":
                return true;
            case "mp4":
                return true;
            default:
                return false;
        }
    }


    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/fileUp")
    @ResponseBody
    public ResultO<?> fileUp(HttpServletRequest request, MultipartFile file,Integer status){
        if(null != file && !file.isEmpty() && null != status && status>0){
            //获取文件后缀名 为其所在目录文件夹命名
            String fileLastName = file.getOriginalFilename();
            fileLastName = fileLastName.substring(fileLastName.lastIndexOf(".")+1);

            if(CheckFileLastName(fileLastName)){
                status = status * 5;
                //首先获取到esources人静态资源库路径
                String path = request.getServletContext().getRealPath("/resources/");
                //获取当前日期
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String timeFile = simpleDateFormat.format(new Date());

                //创建文件上传目录地址   目录地址以  后缀名_日期  存储当前日期下的文件
                path = path + fileLastName+"_"+timeFile;
                //校验目录是否存在  不存在则创建文件夹目录
                File rootFile = new File(path);
                if(!rootFile.exists()){
                    rootFile.mkdir();
                }
                //生成文件名称
                String fileName = UUID.randomUUID().toString()+"."+fileLastName;
                String filePath = path + File.separator + fileName;
                try {
                    file.transferTo(new File(filePath));
                } catch (IOException e) {
                    return ResultO.lose(50000,"上传失败，错误的数据流异常!!!",e.getMessage());
                }

                FileUp fileUp = new FileUp();
                fileUp.setStatus(status);
                fileUp.setFilePath(filePath);
                fileUp.setFileUrl("/resources/"+fileLastName+"_"+timeFile+"/"+fileName);

                return ResultO.success("上传成功成功",fileUp,null);
            }else{
                return ResultO.lose(50000,"上传失败，不支持上传的文件类型!!!",null);
            }


        }
        if(null == status || status <= 0){
            return ResultO.lose(50000,"上传失败，状态码错误!!!",null);
        }
        return ResultO.lose(50000,"上传失败，未知的文件!!!",null);
    }

}
