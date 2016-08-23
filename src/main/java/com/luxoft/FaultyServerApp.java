package com.luxoft;

import com.luxoft.api.BeerResource;
import com.luxoft.api.PizzaResource;
import com.luxoft.domain.Brewery;
import com.luxoft.domain.PizzaBakery;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by msokolov on 6/8/2016.
 */
public class FaultyServerApp extends Application<FaultyServerConfiguration> {
    @Override
    public void run(FaultyServerConfiguration faultyServerConfiguration, Environment environment) throws Exception {
        Brewery brewery = faultyServerConfiguration.getBreweryFactory().create();
        PizzaBakery bakery = faultyServerConfiguration.getBakeryFactory().create();
        environment.jersey().register(new BeerResource(brewery));
        environment.jersey().register(new PizzaResource(bakery));
        environment.lifecycle().manage(brewery);
        environment.lifecycle().manage(bakery);
    }

    public static void main(String[] args) throws Exception {
        new FaultyServerApp().run(args);
    }
}
