package com.zhurong.RabbitJ2ee.SteadyJack.controller;

import com.debug.steadyjack.entity.User;
import com.debug.steadyjack.entity.UserLog;
import com.debug.steadyjack.mapper.UserLogMapper;
import com.debug.steadyjack.mapper.UserMapper;
import com.debug.steadyjack.response.BaseResponse;
import com.debug.steadyjack.response.StatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Administrator on 2018/8/30.
 * 异步写日志
 */
@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    private static final String Prefix = "user";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserLogMapper userLogMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;


    @RequestMapping(value = Prefix + "/login", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public BaseResponse login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            User user = userMapper.selectByUserNamePassword(userName, password);
            if (user != null) {

                //TODO：异步写用户日志
                try {
                    /*UserLog log=new UserLog(userName,"Login","login",objectMapper.writeValueAsString(user));
                    userLogMapper.insertSelective(log);*/ //同步

                    UserLog userLog = new UserLog(userName, "Login", "login", objectMapper.writeValueAsString(user));
                    userLog.setCreateTime(new Date());
                    rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
                    rabbitTemplate.setExchange(env.getProperty("log.user.exchange.name"));
                    rabbitTemplate.setRoutingKey(env.getProperty("log.user.routing.key.name"));

                    /*MessageProperties properties=new MessageProperties();
                    properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    properties.setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
                    Message message=new Message(objectMapper.writeValueAsBytes(userLog),properties);*/ //发送消息写法一


                    Message message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(userLog)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
                    message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON); //发送消息写法二
                    rabbitTemplate.convertAndSend(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                //TODO：塞权限数据-资源数据-视野数据

            } else {
                response = new BaseResponse(StatusCode.Fail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


}



























