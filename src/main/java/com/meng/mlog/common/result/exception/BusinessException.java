package com.meng.mlog.common.result.exception;

import com.meng.mlog.common.result.enums.ResultCodeEnum;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 5880039837372775774L;
    private String code;

    public BusinessException(ResultCodeEnum codeEnum) {
        super(codeEnum.message());
        this.code = codeEnum.code();
    }

    public BusinessException(ResultCodeEnum codeEnum, String message) {
        super(message);
        this.code = codeEnum.code();
    }

    public BusinessException(ResultCodeEnum codeEnum, Throwable cause) {
        super(codeEnum.message(), cause);
        this.code = codeEnum.code();
    }

    public BusinessException(ResultCodeEnum codeEnum, String message, Throwable cause) {
        super(message, cause);
        this.code = codeEnum.code();
    }



}
