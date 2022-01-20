package com.meng.mlog.common.filter;

import com.meng.mlog.common.result.enums.ResultCodeEnum;
import com.meng.mlog.common.result.helper.ExceptionHelper;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        throw ExceptionHelper.createBusinessException(ResultCodeEnum.FAILED, "LoginFilter");
        // chain.doFilter(request, response);
    }

}
