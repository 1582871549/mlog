package com.meng.mlog.common.filter;

import com.meng.mlog.common.result.exception.BusinessException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Filter的实现方式是责任链
 * 第一个Filter处理之后, 调用第二个Filter, 依次往后
 * 直到Filter全部处理完成后结束, 当某一个Filter处理中断, 则依次返回结果经过前一个Filter
 * 直到经过第一个Filter结束过滤责任链
 * <p>
 * 根据Filter过滤的特点, 只需要在业务过滤器之前加上用于处理其他过滤器异常捕获的Filter就可以实现对过滤器异常的处理
 */
public class ExceptionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (BusinessException e) {
            // 异常捕获，发送到error controller
            request.setAttribute("filter.error", e);
            // 将异常转发到控制器
            request.getRequestDispatcher("/error/exthrow").forward(request, response);
        }
    }

}
