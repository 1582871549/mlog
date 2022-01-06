package com.meng.mlog;

import com.meng.mlog.common.result.helper.ResultHelper;
import com.meng.mlog.common.result.model.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ResultTests {

    @Test
    void contextLoads() {

        log.info("init");
        ResultVO<Void> success1 = ResultHelper.success();
        ResultVO<String> success2 = ResultHelper.success("data");
        ResultVO<Integer> success3 = ResultHelper.success(123);

        System.out.println(success1);
        System.out.println(success2);
        System.out.println(success3);

        ResultVO<Void> failure = ResultHelper.failure();
        System.out.println(failure);
    }

}
