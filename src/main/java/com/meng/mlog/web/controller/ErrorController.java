package com.meng.mlog.web.controller;

import com.meng.mlog.common.result.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/error")
public class ErrorController {

    /**
     * 重新抛出异常
     */
    @RequestMapping(value = "/exthrow", method = RequestMethod.GET)
    public void rethrow(HttpServletRequest request) {
        throw (BusinessException) request.getAttribute("filter.error");
    }
}
