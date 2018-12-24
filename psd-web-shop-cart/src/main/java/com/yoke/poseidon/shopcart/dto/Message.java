package com.yoke.poseidon.shopcart.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Author Yoke
 * @Date 2018/12/24 上午8:29
 */
@ApiModel(value = "response model", description = "请求返回的消息模型")
public class Message implements Serializable {

	private static final long serialVersionUID = 8897361511166938169L;

	@ApiModelProperty(value = "请求状态码", allowableValues = "200: 请求成功,500: 请求失败")
	private int code;

	@ApiModelProperty(value = "请求返回的消息")
	private String msg;

	@ApiModelProperty(value = "请求返回的消息主体")
	private Object data;

	public Message() {
	}

	public Message(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Message{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data
				+ '}';
	}

	public static Message success(Object data) {
		return new Message(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
	}

	public static Message failed() {
		return new Message(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null);
	}

}
