package com.luxoft.api;

/**
 * Created by msokolov on 8/21/2016.
 */
public class Response<T> {
    private T item;

    public Response(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
