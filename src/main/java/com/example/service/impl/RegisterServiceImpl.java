package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.RegisterService;
import com.example.vo.ResultEnum;
import com.example.vo.ResultJson;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private UserRepository userRepository;

    /**
     * @param userName 用户名
     * @return boolean
     */
    @Override
    public ResultJson<Boolean> existUser(String userName) {
        User name = userRepository.findUserByUserName(userName);
        if (name!=null){
            return ResultJson.Error(ResultEnum.USERNAMEHASEXISTED);
        }
        return ResultJson.Success(true);
    }

    /**
     * @param wechatId 微信账号
     * @return Boolean
     */
    @Override
    public ResultJson<Boolean> existWechatId(String wechatId) {
        User id = userRepository.findUserByWechatId(wechatId);
        if (id!=null){
            return ResultJson.Error(ResultEnum.WECHATIDBIND);
        }
        return ResultJson.Success(true);
    }

    /**
     * @param user 用户实体
     * @return boolean
     */
    @Override
    public ResultJson<Boolean> registerUser(User user) {
        if(userRepository.newUser(user).equals(0)){
            return ResultJson.Error(ResultEnum.CREATEUSERFAILED);
        }
        return ResultJson.Success(true);
    }
}
