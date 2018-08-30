package com.csii.springcloudstream.sink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/30 - 14:02 -- 星期四
 */
/*
@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver {
    private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("Receive -> "+payload.toString()+"  自定义实现");
    }
}
*/
