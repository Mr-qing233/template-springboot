package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.LoginService;
import com.example.vo.ResultEnum;
import com.example.vo.ResultJson;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserRepository userRepository;

    /**
     * @param wechatId 用户id
     * @param password 用户密码
     * @return ResultJson
     */
    @Override
    public ResultJson<User> loginUser(String wechatId, String password) {
        User userByUid = userRepository.judgeUserPassword(wechatId,password);
        if (userByUid == null){
            return ResultJson.Error(ResultEnum.USERNOTEXISTORPWDERROR);
        }
        userByUid.setPassword(null);
        return ResultJson.Success(userByUid);
    }
}
