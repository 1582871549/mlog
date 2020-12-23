package com.meng.mlog.common.result.helper;

import com.meng.mlog.common.result.enums.ResultCodeEnum;
import com.meng.mlog.common.result.exception.BusinessException;

public class ExceptionHelper {

    public static BusinessException newBusinessException(ResultCodeEnum codeEnum) {
        return new BusinessException(codeEnum);
    }

    public static BusinessException newBusinessException(ResultCodeEnum codeEnum, String message) {
        return new BusinessException(codeEnum, message);
    }

    public static BusinessException newBusinessException(ResultCodeEnum codeEnum, Throwable cause) {
        return new BusinessException(codeEnum, cause);
    }

}
