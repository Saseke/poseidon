package com.yoke.poseidon.web.itemShow.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Author Yoke
 * @Date 2018/12/24 上午8:29
 */
public class Message implements Serializable {

	private static final long serialVersionUID = -3788526494940077434L;

	private int code;

	private String msg;

	private Object data;

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

    private Message(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static Message success(Object data) {
		return new Message(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
	}

	public static Message failed() {
		return new Message(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null);
	}

	@Override
	public String toString() {
		return "Message{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data
				+ '}';
	}

}
