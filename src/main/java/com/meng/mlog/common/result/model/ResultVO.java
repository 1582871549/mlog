package com.meng.mlog.common.result.model;

import java.io.Serializable;

public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 8934176536590889608L;
    private String code;
    private String message;
    private T data;

    public ResultVO<T> code(String code) {
        this.code = code;
        return this;
    }

    public ResultVO<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResultVO<T> data(T data) {
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
