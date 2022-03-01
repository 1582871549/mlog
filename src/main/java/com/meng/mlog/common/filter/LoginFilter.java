package com.meng.mlog.common.filter;

import com.meng.mlog.common.result.enums.ResultCodeEnum;
import com.meng.mlog.common.result.helper.ExceptionHelper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoginFilter extends HttpFilter {

    private static final String URL = "/user";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("url: {}", request.getRequestURI());
        if (request.getRequestURI().startsWith(URL)) {
            chain.doFilter(request, response);
            return;
        }
        throw ExceptionHelper.createBusinessException(ResultCodeEnum.FAILED, "非法请求");
    }
}
