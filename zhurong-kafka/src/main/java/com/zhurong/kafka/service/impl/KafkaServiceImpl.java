/**
 * @Title: KafkaServiceImpl.java
 * @Package: com.zhurong.kafka.service.impl
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.kafka.service.impl;

import com.zhurong.db.persistence.domain.MerchUser;
import com.zhurong.kafka.service.KafkaService;
import com.zhurong.utils.gen.ChineseNameGen;
import com.zhurong.utils.gen.EmailGen;
import com.zhurong.utils.gen.MobileNumberGen;
import com.zhurong.utils.idgen.UuidUtil;
import com.zhurong.utils.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author LZG
 * @date 2019/7/18
 */
@Service
public class KafkaServiceImpl implements KafkaService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * @Description: 发送消息的方法
     * @return void
     * @author LZG
     * @date 2019/7/18
     */
    @Override
    public void sendMessage() {

        MerchUser merchUser = new MerchUser();
        merchUser.setId(UuidUtil.get32UUIDStr());
        merchUser.setMerchUserName(ChineseNameGen.generate());
        merchUser.setMerchUserMobile(MobileNumberGen.generate());
        merchUser.setMerchUserEmail(EmailGen.generate());

        //这个 topic 在 Java 程序中是不需要提前在 Kafka 中设置的，因为它会在发送的时候自动创建你设置的 topic
        //消息确认，第1种方式，看KafkaProducerCallbackHandler.java
        kafkaTemplate.send("zhurong", JsonUtil.objectToJson(merchUser));

        //消息确认，第2种方式
        //ListenableFuture listenableFuture = kafkaTemplate.send("zhurong", JsonUtil.objectToJson(merchUser));
    }

}