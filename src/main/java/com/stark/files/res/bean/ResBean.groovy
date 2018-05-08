package com.stark.files.res.bean

class ResBean implements Serializable{

    Integer fileNumber

    List<ResFileBean> resFileBeans

    Integer getFileNumber() {
        return fileNumber
    }

    void setFileNumber(Integer fileNumber) {
        this.fileNumber = fileNumber
    }

    List<ResFileBean> getResFileBeans() {
        return resFileBeans
    }

    void setResFileBeans(List<ResFileBean> resFileBeans) {
        this.resFileBeans = resFileBeans
    }
}
