package com.ccljjk.server.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiang Jiangcheng
 * @date 2020/7/29 15:13
 */
@RestController
@PreAuthorize("hasRole('DEMO')")
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello SpringSecurity!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello SpringSecurity 2!";
    }
}