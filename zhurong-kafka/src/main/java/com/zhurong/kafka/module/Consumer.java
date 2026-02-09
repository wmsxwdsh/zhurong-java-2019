package com.zhurong.kafka.module;

import com.zhurong.db.persistence.domain.MerchUser;
import com.zhurong.utils.json.JsonUtil;
import java.util.Optional;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 * 2019/7/18
 */
@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    /**
     * 同时监听两个 topic 的消息了，可同时监听多个topic
     */
    @KafkaListener(topics = {"test", "zhurong"})
    public void listen(ConsumerRecord<?, ?> record) throws Exception {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("消费者开始消费message：" + message);

            MerchUser merchUser = JsonUtil.jsonToPojo(message.toString(), MerchUser.class);
            logger.info("该消息消费完毕！{}", merchUser);
        }
    }

}