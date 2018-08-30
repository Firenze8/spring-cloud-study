package com.csii.hystrix.feign;

import com.csii.hystrix.controller.MovieServiceByHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/25 - 23:36 -- 星期六
 */
@FeignClient(name = "user-Service")
public interface UserServiceFeign {
    @GetMapping(value = "/user/get/{id}")
    String getUser(@PathVariable(name = "id") int id);
}