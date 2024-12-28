package com.example.service.impl;

import com.example.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    /**
     * @return
     */
    @Override
    public String test1() {
        return "test1 by Service without wrapper";
    }
}
