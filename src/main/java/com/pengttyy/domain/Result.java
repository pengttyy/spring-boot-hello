package com.pengttyy.domain;

/**
 * Created by pengt on 2017/8/9.
 */
public class Result<T> {
    private T data;
    private int status;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
