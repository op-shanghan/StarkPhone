package com.stark.files.res.logic

import com.stark.files.res.bean.ResBean
import com.stark.files.res.bean.ResFileBean

class CataLogic {

    static ResBean getCats(String basePath,String fileCata){
        String resourcesCata = System.getProperty("StarkPhone") + fileCata
        File file = new File(resourcesCata)
        File[] tempList = file.listFiles()
        ResBean resBean = new ResBean()
        if(null != tempList){
            resBean.setFileNumber(tempList.length)
            List<ResFileBean> resFileBeans = new ArrayList<>()

            for (File temp:tempList) {
                ResFileBean resFileBean = new ResFileBean()
                resFileBean.setFileName(temp.getName())
                resFileBean.setFilePath(basePath+fileCata+"/"+temp.getName())
                resFileBeans.add(resFileBean)
            }
            resBean.setResFileBeans(resFileBeans)
        }else{
            resBean.setFileNumber(0)
        }
        return resBean
    }

}
