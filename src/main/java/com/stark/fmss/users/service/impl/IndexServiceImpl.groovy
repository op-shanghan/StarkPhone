package com.stark.fmss.users.service.impl

import com.stark.fmss.users.dao.IndexDao
import com.stark.fmss.users.service.IndexService
import org.springframework.stereotype.Service

import javax.annotation.Resource

@Service
class IndexServiceImpl implements IndexService{
    @Resource
    IndexDao indexDao

    @Override
    String Index() {
        return indexDao.selectCount()+""
    }
}
