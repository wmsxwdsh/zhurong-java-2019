package com.zhurong.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * direct路由策略(路由键routingKey)的交换机注入、Queue与Exchange的绑定注入
 *
 * @author JustryDeng
 * 2018年7月16日 上午10:12:12
 */
@Configuration
public class DirectExchangeAndBindingConfiguration {

	/**
	 * 注入Direct路由策略的Exchange交换机实例
	 * @return Exchange“交换机”实例
	 */
	@Bean(name = "myDirectExchange")
	DirectExchange getDirectExchange() {
		// 创建并返回名为My-Direct-Exchange的交换机
		return new DirectExchange("My-Direct-Exchange");
	}

	/**
	 * 将Queue绑定到此directExchange，并指定路由键为 "routingKey.First"
	 */
	@Bean
	Binding bindingQueueOneToDirectExchange(@Qualifier("myFirstQueue") Queue myFirstQueue,
			@Qualifier("myDirectExchange") DirectExchange myDirectExchange) {
		return BindingBuilder.bind(myFirstQueue).to(myDirectExchange).with("routingKey.First");
	}

	/**
	 * 将 Queue 绑定到此 directExchange，并指定路由键为 "requestTest"
	 */
	@Bean
	Binding bindingQueueRequestTestToDirectExchange(@Qualifier("myRequestTestQueue") Queue myRequestTestQueue,
			@Qualifier("myDirectExchange") DirectExchange myDirectExchange) {
		return BindingBuilder.bind(myRequestTestQueue).to(myDirectExchange).with("requestTest.aa");
	}
}
