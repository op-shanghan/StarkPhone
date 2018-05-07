package com.stark.app.tools.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * MD5 模型对象
 */
@Document(collection = "md5Model")
class MD5Model implements Serializable{
    @Id
    String id

    String md5

    String md516

    String oldPsd

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getMd5() {
        return md5
    }

    void setMd5(String md5) {
        this.md5 = md5
    }

    String getMd516() {
        return md516
    }

    void setMd516(String md516) {
        this.md516 = md516
    }

    String getOldPsd() {
        return oldPsd
    }

    void setOldPsd(String oldPsd) {
        this.oldPsd = oldPsd
    }
}
