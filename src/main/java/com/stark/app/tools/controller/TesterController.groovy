package com.stark.app.tools.controller

import com.stark.utils.result.ResultO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/tools/tester")
class TesterController {

    class TT{
        private def userId
        private def keyword

        def getUserId() {
            return userId
        }

        void setUserId(userId) {
            this.userId = userId
        }

        def getKeyword() {
            return keyword
        }

        void setKeyword(keyword) {
            this.keyword = keyword
        }
    }

    @RequestMapping("/tt")
    @ResponseBody
    ResultO<?> tt(HttpServletRequest request){
        def userId = request.getParameter("userId")
        def keyword = request.getParameter("keyWord")

        TT t = new TT()
        t.setUserId(userId)
        t.setKeyword(keyword)
        return ResultO.success("测试成功",t,null)

    }

}
