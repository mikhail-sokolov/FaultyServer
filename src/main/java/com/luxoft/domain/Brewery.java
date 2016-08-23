package com.luxoft.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by msokolov on 8/14/2016.
 */
public class Brewery extends Supplier<Beer> {
    public Brewery(TransferQueue<Beer> storage, long delay) {
        super(storage, delay);
    }

    @Override
    protected Beer item() {
        return Beer.LOGEEK;
    }

    public Beer brew() throws InterruptedException {
        return take();
    }

    public static class Factory {
        @Min(5)
        @JsonProperty private long delayInMillis;

        public Brewery create() {
            return new Brewery(new LinkedTransferQueue<>(), delayInMillis);
        }
    }
}
