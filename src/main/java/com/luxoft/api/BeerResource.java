package com.luxoft.api;

import com.luxoft.domain.Beer;
import com.luxoft.domain.Brewery;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by msokolov on 6/8/2016.
 */
@Path("/beer")
@Produces(MediaType.APPLICATION_JSON)
public class BeerResource {
    private Brewery brewery;

    public BeerResource(Brewery brewery) {
        this.brewery = brewery;
    }

    @GET
    public Response<Beer> get() throws InterruptedException {
        return new Response<>(brewery.brew());
    }
}
