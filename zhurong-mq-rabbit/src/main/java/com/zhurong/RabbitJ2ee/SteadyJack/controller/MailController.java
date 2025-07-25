package com.zhurong.RabbitJ2ee.SteadyJack.controller;

import com.debug.steadyjack.response.BaseResponse;
import com.debug.steadyjack.response.StatusCode;
import com.debug.steadyjack.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Administrator on 2018/9/1.
 * 异步发邮件
 */
@RestController
public class MailController {

    private static final Logger log = LoggerFactory.getLogger(MailController.class);

    private static final String Prefix = "mail";

    @Autowired
    private MailService mailService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;


    @RequestMapping(value = Prefix + "/send", method = RequestMethod.GET)
    public BaseResponse sendMail() {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            //mailService.sendEmail();

            rabbitTemplate.setExchange(env.getProperty("mail.exchange.name"));
            rabbitTemplate.setRoutingKey(env.getProperty("mail.routing.key.name"));
            rabbitTemplate.convertAndSend(MessageBuilder.withBody("mail发送".getBytes("UTF-8")).build());

        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("邮件发送完毕----");
        return response;
    }

}























