package com.zhurong.Rabbit.exchange.direct;

import com.rabbitmq.client.*;

import java.io.IOException;

public class MultiConsumerTwo {

    private static final String Exchange_Name = "rabbit:mq03:exchange:e01";

    private static final String Queue_Name_02 = "rabbit:mq03:queue:q02";

    private static final String Routing_Key_02 = "rabbit:mq03:routing:key:r02";
    private static final String Routing_Key_03 = "rabbit:mq03:routing:key:r03";

    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            //TODO：direct-exchange+routingKey分发消息模型
            channel.exchangeDeclare(Exchange_Name, BuiltinExchangeType.DIRECT);
            channel.queueDeclare(Queue_Name_02, true, false, false, null);
            channel.queueBind(Queue_Name_02, Exchange_Name, Routing_Key_02);
            channel.queueBind(Queue_Name_02, Exchange_Name, Routing_Key_03);

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("消费者2接收到消息成功---> " + message);
                }
            };

            channel.basicConsume(Queue_Name_02, true, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}