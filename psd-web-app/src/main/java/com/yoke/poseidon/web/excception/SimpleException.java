package com.yoke.poseidon.web.excception;

/**
 * @Author Yoke
 * @Date 2018/10/19 下午8:42
 */
public class SimpleException extends ApiException {
    private String message;

    public SimpleException(String message) {
        this.message = message;
    }

    @Override
    protected String getCustomMessage() {
        return message;
    }
}
