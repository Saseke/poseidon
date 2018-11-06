package com.yoke.poseidon.web.exception;

/**
 * @Author Yoke
 * @Date 2018/10/19 下午8:37
 */
public abstract class ApiException extends RuntimeException {

    @Override
    public String getMessage() {
        String customMessage = getCustomMessage();
        return customMessage==null?super.getMessage():customMessage;
    }

    protected String getCustomMessage(){
       return null;
    }
}
