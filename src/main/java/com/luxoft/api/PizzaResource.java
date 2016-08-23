package com.luxoft.api;

import com.luxoft.domain.Pizza;
import com.luxoft.domain.PizzaBakery;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by msokolov on 6/8/2016.
 */
@Path("/pizza")
@Produces(MediaType.APPLICATION_JSON)
public class PizzaResource {
    private PizzaBakery bakery;

    public PizzaResource(PizzaBakery bakery) {
        this.bakery = bakery;
    }

    @GET
    public Response<Pizza> get() throws InterruptedException {
        return new Response<>(bakery.bake());
    }

}
