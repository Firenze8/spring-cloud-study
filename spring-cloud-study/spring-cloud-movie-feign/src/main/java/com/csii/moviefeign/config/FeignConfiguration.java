package com.csii.moviefeign.config;

import feign.Contract;
import feign.Logger;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/25 - 15:22 -- 星期六
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
        //return new feign.Contract.BaseContract();
    }
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }
}
