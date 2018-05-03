package com.stark.app.user.model;

import com.stark.app.user.bean.UserBean;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class UserModel extends UserBean implements Serializable {
    @Id
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
