/**
 * @Title: EchoWebSocketHandler.java
 * @Package: com.yuzhong.myspringboot.echo
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.yuzhong.myspringboot.controller.echo;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @description:
 * @author LZG
 * @date 2020年06月04日
 */
public class EchoWebSocketHandler extends TextWebSocketHandler {

    private EchoServcie echoService;

    public EchoWebSocketHandler(EchoServcie echoService) {
        this.echoService = echoService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("连接建立");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String echoMessage = this.echoService.getMessage(message.getPayload());

        session.sendMessage(new TextMessage(echoMessage));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        session.close(CloseStatus.SERVER_ERROR);
    }

}