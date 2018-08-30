package com.csii.moviefeign.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/25 - 14:57 -- 星期六
 */
@FeignClient(name = "user-service")
public interface FeignService {
   @RequestMapping(value = "/user/get/{id}",method = RequestMethod.GET)
   String getUser(@PathVariable(name = "id") int id);
}
