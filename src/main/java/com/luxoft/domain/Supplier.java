package com.luxoft.domain;

import io.dropwizard.lifecycle.Managed;

import java.util.concurrent.*;

/**
 * Created by msokolov on 8/14/2016.
 */
public abstract class Supplier<T> implements Managed {
    private TransferQueue<T> storage;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture handle;
    private long delay;

    public Supplier(TransferQueue<T> storage, long delay) {
        this.storage = storage;
        this.delay = delay;
    }

    protected T take() throws InterruptedException {
        //return storage.poll(1, TimeUnit.SECONDS);
        return storage.take();
    }

    protected abstract T item();

    @Override
    public void start() throws Exception {
        handle = scheduler.scheduleAtFixedRate(
            this::put,
            10_000L,
            delay,
            TimeUnit.MILLISECONDS
        );
    }

    private void put() {
        storage.tryTransfer(item());
    }

    @Override
    public void stop() throws Exception {
        handle.cancel(true);
    }
}
