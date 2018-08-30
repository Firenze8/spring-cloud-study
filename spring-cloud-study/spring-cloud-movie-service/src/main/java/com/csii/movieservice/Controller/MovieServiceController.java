package com.csii.movieservice.Controller;

import com.csii.movieservice.entity.User;
import com.sun.media.jfxmedia.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/25 - 13:46 -- 星期六
 */
@RestController
public class MovieServiceController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MovieServiceController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping(value = "/get/author/{id}")
    public String getAuthor(@PathVariable int id){
       return restTemplate.getForEntity("http://localhost:8080/user/get/ "+id,User.class).toString();
    }
    @GetMapping("/service_instance")
    public String getServiceInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("user-service");
        logger.debug("service.host:{},service.port:{}",
                serviceInstance.getHost(),serviceInstance.getPort());
        return "success!";
    }
}
