package com.yoke.poseidon.elasticsearch.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoke.poseidon.elasticsearch.dto.ItemDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author Yoke
 * @Date 2019/01/29 下午2:25
 */
@Component
public class EventHandler {

	private final ObjectMapper objectMapper;

	@Autowired
	public EventHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@RabbitListener(queues = "${item.queue}")
	void handleMessage(String s) {
		ItemDto itemDto = null;
		try {
			itemDto = objectMapper.readValue(s, ItemDto.class);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(itemDto);
	}

}
