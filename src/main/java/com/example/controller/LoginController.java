package com.example.controller;


import com.example.dto.CheckDto;
import com.example.entity.User;
import com.example.service.LoginService;
import com.example.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping("/user")
    public ResultJson<User> loginUser(@RequestBody CheckDto checkDto){
        return loginService.loginUser(checkDto.getWechatId(), checkDto.getPassword());
    }
}
