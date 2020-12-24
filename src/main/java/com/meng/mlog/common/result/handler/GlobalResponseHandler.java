package com.meng.mlog.common.result.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meng.mlog.common.result.enums.ResultCodeEnum;
import com.meng.mlog.common.result.helper.ExceptionHelper;
import com.meng.mlog.common.result.helper.ResultHelper;
import com.meng.mlog.common.result.model.ResultVO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局响应处理器
 */
@RestControllerAdvice(basePackages = {"com.meng.mlog.web.controller"})
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
        return !methodParameter.getParameterType().equals(ResultVO.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String类型不能直接包装，所以要进行些特别的处理
        if (methodParameter.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在Result里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(ResultHelper.success(data));
            } catch (JsonProcessingException e) {
                throw ExceptionHelper.createBusinessException(ResultCodeEnum.RETURN_STRING_TYPE_ERROR);
            }
        }
        // 将原本的数据包装在ResultVO里
        return ResultHelper.success(data);
    }
}
