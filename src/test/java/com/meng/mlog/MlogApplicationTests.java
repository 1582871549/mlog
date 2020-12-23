package com.meng.mlog;

import com.meng.mlog.common.result.helper.AssertHelper;
import com.meng.mlog.web.entity.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MlogApplicationTests {


    @Test
    void contextLoads() {

        UserVO userVO = null;

        AssertHelper.notNull(userVO, "用户信息不能为空");


    }

}
