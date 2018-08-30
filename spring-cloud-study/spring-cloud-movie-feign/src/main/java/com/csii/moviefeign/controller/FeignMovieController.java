package com.csii.moviefeign.controller;

import com.csii.moviefeign.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/25 - 15:00 -- 星期六
 */
@RestController
public class FeignMovieController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/get/{id}")
    public String getUser(@PathVariable int id){
        return feignService.getUser(id);
    }
}
