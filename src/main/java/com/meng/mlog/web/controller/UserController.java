package com.meng.mlog.web.controller;

import com.meng.mlog.common.base.BaseController;
import com.meng.mlog.common.base.BaseService;
import com.meng.mlog.common.result.helper.AssertHelper;
import com.meng.mlog.common.result.model.ResultList;
import com.meng.mlog.web.entity.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements BaseController, BaseService<UserVO> {

    @RequestMapping(value = "/listUsers1", method = RequestMethod.GET)
    public ResultList<UserVO> listUsers1() {

        List<UserVO> userVOS = getUserVOS();
        return createResultList(userVOS, 10);
    }

    @RequestMapping(value = "/listUsers2", method = RequestMethod.GET)
    public List<UserVO> listUsers2() {

        List<UserVO> userVOS = getUserVOS();

        AssertHelper.notNull(userVOS, "用户集合不能为空");

        return userVOS;
    }

    private List<UserVO> getUserVOS() {

        List<UserVO> userVOS = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            UserVO userVO = new UserVO();
            userVO.setUsername("dudu_" + i);
            userVO.setPassword("admin_" + i);

            userVOS.add(userVO);
        }
        return userVOS;
    }

}

