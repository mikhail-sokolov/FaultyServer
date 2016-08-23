package com.luxoft;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.luxoft.domain.Brewery;
import com.luxoft.domain.PizzaBakery;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by msokolov on 6/8/2016.
 */
public class FaultyServerConfiguration extends Configuration {
    @Valid
    @NotNull
    private final Brewery.Factory breweryFactory = new Brewery.Factory();

    @Valid
    @NotNull
    private final PizzaBakery.Factory bakeryFactory = new PizzaBakery.Factory();


    @JsonProperty("brewery")
    public Brewery.Factory getBreweryFactory() {
        return breweryFactory;
    }

    @JsonProperty("bakery")
    public PizzaBakery.Factory getBakeryFactory() {
        return bakeryFactory;
    }
}
