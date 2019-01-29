package com.yoke.poseidon.web.itemShow.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author Yoke
 * @Date 2019/01/29 下午12:24
 */
@Component
public class EventDispatcher {

	private final RabbitTemplate rabbitTemplate;

	private final String itemExchange;

	private final String itemVaryKey;

	private final ObjectMapper objectMapper;

	@Autowired
	public EventDispatcher(RabbitTemplate rabbitTemplate,
			@Value("${item.exchange}") String itemExchange,
			@Value("${item.vary_key}") String itemVaryKey, ObjectMapper objectMapper) {
		this.rabbitTemplate = rabbitTemplate;
		this.itemExchange = itemExchange;
		this.itemVaryKey = itemVaryKey;
		this.objectMapper = objectMapper;
	}

	public void send(ItemDto itemDto) {
		try {
			rabbitTemplate.convertAndSend(itemExchange, itemVaryKey,
					objectMapper.writeValueAsString(itemDto));
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
