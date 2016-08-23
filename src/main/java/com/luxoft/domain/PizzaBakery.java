package com.luxoft.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by msokolov on 8/14/2016.
 */
public class PizzaBakery extends Supplier<Pizza> {

    public PizzaBakery(TransferQueue<Pizza> oven, long delay) {
        super(oven, delay);
    }

    @Override
    protected Pizza item() {
        return Pizza.LOGEEK;
    }

    public Pizza bake() throws InterruptedException {
        return take();
    }

    public static class Factory {
        @Min(5)
        @JsonProperty
        private long delayInMillis;

        public PizzaBakery create() {
            return new PizzaBakery(new LinkedTransferQueue<>(), delayInMillis);
        }
    }
}
