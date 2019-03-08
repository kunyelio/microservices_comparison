package org.olpexamples.inventories.rest;

import org.olpexamples.inventories.model.Inventory;
import org.olpexamples.inventories.service.InventoryService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@RequestScoped
@Path("cars")
public class InventoryResource {
    @Inject
    protected InventoryService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("inventories")
    public Collection<Inventory> getInventories(){
        return service.getAllInventories();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("setInventory")
    public Response setInventory(Inventory inventory){
        service.setInventory(inventory);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
