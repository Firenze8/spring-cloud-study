package com.csii.springcloudstream.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/30 - 15:41 -- 星期四
 */
@EnableBinding(value = {Processor.class})
public class AppTwo {

    private static final Logger logger = LoggerFactory.getLogger(AppTwo.class);

    @Bean
    @InboundChannelAdapter(value = Processor.OUTPUT,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource(){
        return ()->  new GenericMessage<>(new Date());
    }

    @StreamListener(Processor.OUTPUT)
    public void receiveFromOutput(Object payLoad){
        logger.info("Receive:"+payLoad);
    }
}
