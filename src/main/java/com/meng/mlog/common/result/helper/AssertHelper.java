package com.meng.mlog.common.result.helper;

import com.meng.mlog.common.result.enums.ResultCodeEnum;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

public class AssertHelper {

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw ExceptionHelper.createBusinessException(ResultCodeEnum.PARAM_CANNOT_BE_NULL, message);
        }
    }

    public static void notNull(Collection<?> coll, String message) {
        if (CollectionUtils.isEmpty(coll)) {
            throw ExceptionHelper.createBusinessException(ResultCodeEnum.PARAM_CANNOT_BE_NULL, message);
        }
    }

}
