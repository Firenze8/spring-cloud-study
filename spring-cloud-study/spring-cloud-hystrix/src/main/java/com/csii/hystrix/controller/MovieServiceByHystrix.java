package com.csii.hystrix.controller;

import com.csii.hystrix.feign.UserServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/25 - 23:34 -- 星期六
 */
@RestController
public class MovieServiceByHystrix {
    @Autowired
    private UserServiceFeign userServiceFeign;

    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),
            @HystrixProperty(name = "requestLog.enabled",value = "true"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "10000")
    },threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "10"),
            @HystrixProperty(name="maximumSize",value = "20")
    })
    @GetMapping("/get/user/{id}")
    public String getUserById(@PathVariable int id) throws InterruptedException {
        int num_sleep = new Random().nextInt(10);
        System.err.println("睡眠时间为：num_sleep -> "+num_sleep);
        TimeUnit.SECONDS.sleep(num_sleep );
        return userServiceFeign.getUser(id);
    }

    public String fallback(int id){
        return "Hystrix -> fallback!";
    }
}
