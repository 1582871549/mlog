package com.meng.mlog.common.result.handler;

import com.meng.mlog.common.result.exception.BusinessException;
import com.meng.mlog.common.result.helper.ResultHelper;
import com.meng.mlog.common.result.model.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * 通过日志系统记录系统中的错误, 不在程序中进行处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e) {
        log.error("全局异常", e);
        return ResultHelper.failure();
    }

    @ExceptionHandler(BusinessException.class)
    public ResultVO handleBusinessException(BusinessException be) {
        log.error("业务异常", be);
        return ResultHelper.failure(be.getCode(), be.getMessage());
    }



}
