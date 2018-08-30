package com.csii.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/29 - 11:03 -- 星期三
 */
@RefreshScope//该注解标明该类为动态刷新的类
@RestController
public class TestController {
    @Value("${form}")
    private String form;
    @Autowired
    private Environment environment;

    @GetMapping("/form")
    public String getForm(){
        return this.form;
    }
    @GetMapping("/envri/form")
    public String getFormEnv(){
        return this.environment.getProperty("form","not found target object!");
    }
    @GetMapping("/actuator/health")
    public String getHealth(){
        return "Success!";
    }
}
