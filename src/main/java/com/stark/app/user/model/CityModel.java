package com.stark.app.user.model;

import com.stark.app.user.bean.AreaInfoBean;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class CityModel extends AreaInfoBean implements Serializable {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
