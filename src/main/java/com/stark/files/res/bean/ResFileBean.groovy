package com.stark.files.res.bean

class ResFileBean implements Serializable{

    String fileName

    String filePath

    String getFileName() {
        return fileName
    }

    void setFileName(String fileName) {
        this.fileName = fileName
    }

    String getFilePath() {
        return filePath
    }

    void setFilePath(String filePath) {
        this.filePath = filePath
    }
}
