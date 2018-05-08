package com.stark.app.backstage.mongoDao

import com.stark.app.backstage.model.BackUserModel

interface UserMongoDao {

    void insertUser(BackUserModel backUserModel)

    BackUserModel findByAccount(String account)

    BackUserModel findByLogin(BackUserModel backUserModel)
}