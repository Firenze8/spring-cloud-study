package com.csii.springcloudstream.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/30 - 15:36 -- 星期四
 */
@EnableBinding(value ={Processor.class})
public class AppOne {
    private static final Logger logger = LoggerFactory.getLogger(AppOne.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload){
        logger.info("Receive -> ",payload);
        return "From Input Channel Return ->"+ payload;
    }

}
