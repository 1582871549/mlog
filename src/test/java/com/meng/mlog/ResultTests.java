package com.meng.mlog;

import com.alibaba.fastjson.JSONObject;
import com.meng.mlog.common.result.helper.AssertHelper;
import com.meng.mlog.common.result.helper.ResultHelper;
import com.meng.mlog.common.result.model.ResultList;
import com.meng.mlog.common.result.model.ResultVO;
import com.meng.mlog.web.entity.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.meng.mlog.common.result.helper.ResultHelper.createResultList;

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

    @Test
    void testResultList() {

        List<UserVO> userVOS = IntStream.range(1, 10)
                .mapToObj(i -> {
                    UserVO userVO = new UserVO();
                    userVO.setId(i);
                    userVO.setName("meng-" + 1);
                    return userVO;
                })
                .collect(Collectors.toList());

        AssertHelper.notNull(userVOS, "用户集合不能为空");
        ResultList<UserVO> resultList = createResultList(userVOS);

        ResultVO<ResultList<UserVO>> success1 = ResultHelper.success(resultList);
        ResultVO<List<UserVO>> success2 = ResultHelper.success(userVOS);

        String jsonString = JSONObject.toJSONString(success2);

        System.out.println(jsonString);
    }

}
