/**   
 * @Title: KafkaProducerCallbackHandler.java
 * @Package: com.zhurong.kafka.module
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.kafka.module;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @description: kafka生产者回调处理器
 * @author LZG
 * @date 2019/7/19
 */
@Component
public class KafkaProducerCallbackHandler implements ProducerListener {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerCallbackHandler.class);

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info("Message send success : " + producerRecord.toString());
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        log.info("Message send error : " + producerRecord.toString());
    }

}