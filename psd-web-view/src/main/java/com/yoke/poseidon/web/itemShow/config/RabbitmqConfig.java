package com.yoke.poseidon.web.itemShow.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Yoke
 * @Date 2019/01/29 下午12:16
 */
@Configuration
public class RabbitmqConfig {

	@Bean
	public TopicExchange itemExchange(
			@Value("${item.exchange}") final String exchangeName) {

		return new TopicExchange(exchangeName);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		return new RabbitTemplate(connectionFactory);
	}

}
