package com.example.controller;


import com.example.entity.User;
import com.example.service.RegisterService;
import com.example.vo.ResultJson;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private RegisterService registerService;

    @GetMapping("/nameExist")
    public ResultJson<Boolean> checkNameExist(@RequestParam("userName") String userName){
        return registerService.existUser(userName);
    }

    @GetMapping("/wechatIdExist")
    public ResultJson<Boolean> checkWechatIdExist(@RequestParam("wechatId") String wechatId){
        return registerService.existWechatId(wechatId);
    }

    @PostMapping("/createUser")
    public ResultJson<Boolean> createUser(@RequestBody User user){
        return registerService.registerUser(user);
    }
}
