package com.example.service;


import com.example.entity.User;
import com.example.vo.ResultJson;

public interface RegisterService {
    ResultJson<Boolean> existUser(String userName);
    ResultJson<Boolean> existWechatId(String wechatId);
    ResultJson<Boolean> registerUser(User user);
}
