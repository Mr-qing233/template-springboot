package com.example.controller;

import com.example.service.TestService;
import com.example.vo.ResultJson;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/1")
    public ResultJson<String> test1() {
        return ResultJson.Success("Wrapper");
    }

    @GetMapping("/2")
    public String test2() {
        return "No Wrapper";
    }

    @GetMapping("/3")
    public String test3() {
        return testService.test1();
    }
}
