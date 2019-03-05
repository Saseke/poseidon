package com.yoke.poseidon.elasticsearch.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Yoke
 * @Date 2019/01/29 下午2:31
 */
@Configuration
public class RabbitmqConfiguration {

	@Bean
	public TopicExchange topicExchange(
			@Value("${item.exchange}") final String exchangeName) {
		return new TopicExchange(exchangeName);
	}

	@Bean
	public Queue queue(@Value("${item.queue}") final String queue) {
		return new Queue(queue, true);
	}

	@Bean
	public Binding binding(final Queue queue, final TopicExchange topicExchange,
			@Value("${item.routing-key}") String routingKey) {
		return BindingBuilder.bind(queue).to(topicExchange).with(routingKey);
	}

}
