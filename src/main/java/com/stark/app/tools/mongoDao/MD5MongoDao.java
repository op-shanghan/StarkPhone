package com.stark.app.tools.mongoDao;

import com.stark.app.tools.model.MD5Model;

public interface MD5MongoDao {

    MD5Model findByPSD(String psd);

    void insertMD5Model(MD5Model md5Model);

}
