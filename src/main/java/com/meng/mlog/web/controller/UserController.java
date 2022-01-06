package com.meng.mlog.web.controller;

import com.meng.mlog.common.base.BaseController;
import com.meng.mlog.common.base.BaseService;
import com.meng.mlog.common.result.helper.AssertHelper;
import com.meng.mlog.common.result.model.ResultList;
import com.meng.mlog.web.entity.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController implements BaseController, BaseService {

    @RequestMapping(value = "/listUsers1", method = RequestMethod.GET)
    public ResultList<UserVO> listUsers() {
        System.out.println("-----------");
        List<UserVO> userVOS = getUserVOS();
        AssertHelper.notNull(userVOS, "用户集合不能为空");
        return createResultList(userVOS, 10);
    }

    @RequestMapping(value = "/listUsers2", method = RequestMethod.GET)
    public List<UserVO> listUsers2() {
        log.info("hello");
        List<UserVO> userVOS = getUserVOS();

        AssertHelper.notNull(userVOS, "用户集合不能为空");

        return userVOS;
    }

    private List<UserVO> getUserVOS() {

        List<UserVO> userVOS = new ArrayList<>();

        String date = LocalDateTime.now().toString();

        for (int i = 1; i <= 10; i++) {

            UserVO userVO = new UserVO();
            userVO.setId(i);
            userVO.setName("dudu_" + i);
            userVO.setAddress("上海市普陀区金沙江路 " + i + " 弄");
            userVO.setDate(date);

            userVOS.add(userVO);
        }
        return userVOS;
    }

}

