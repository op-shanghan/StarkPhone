package com.stark.app.user.dao

import com.stark.app.user.bean.AreaInfoBean

interface AreaInfoDao {

    List<AreaInfoBean> selectAll()

    void insertAllCity(AreaInfoBean areaInfoBean)
}
