package com.example.service;


import com.example.entity.User;
import com.example.vo.ResultJson;

public interface LoginService {
    ResultJson<User> loginUser(String wechatId, String password);
}
