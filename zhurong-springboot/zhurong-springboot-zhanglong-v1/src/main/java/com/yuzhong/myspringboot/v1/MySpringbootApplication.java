package com.yuzhong.myspringboot.v1;

import com.yuzhong.myspringboot.v1.echo.DefaultEchoService;
import com.yuzhong.myspringboot.v1.echo.EchoServcie;
import com.yuzhong.myspringboot.v1.echo.EchoWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableWebSocket
public class MySpringbootApplication implements WebSocketConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(MySpringbootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MySpringbootApplication.class, args);
    }

    @PostConstruct
    public void getLog() {
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
    }


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoWebSocketHandler(), "/echo").withSockJS();
    }

    @Bean
    public EchoServcie echoServcie() {
        return new DefaultEchoService("you said \"%s\"!");
    }

    @Bean
    public WebSocketHandler echoWebSocketHandler() {
        return new EchoWebSocketHandler(echoServcie());
    }

}


