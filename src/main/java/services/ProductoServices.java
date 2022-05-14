package services;

import model.Message;
import model.Producto;
import providers.ProductoProvider;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("product")
public class ProductoServices {


    //CREAR USUSARIO
    @POST
    @Path("create")
    @Consumes("application/json")
    public Response create(Producto producto){
        try {
            ProductoProvider provider = new ProductoProvider();
            provider.createProducto(producto);
            return Response.ok(new Message("operacion exitosa")).header("Content-Type","application/json").build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response.status(500).entity(new Message("operacion fallida")).header("Content-Type","application/json").build();
        }
    }

    @PUT
    @Path("productEdit")
    @Consumes("application/json")
    public  Response editProducto(Producto producto){
        try {
            ProductoProvider provider= new ProductoProvider();
            provider.editProdcto(producto);
            return Response
                    .ok(new Message("operacion exitosa"))
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.
                    status(500).
                    entity(new Message("operacion fallida")).
                    header("Content-Type","application/json").
                    build();
        }
    }

    @DELETE
    @Path("productDelete/{id}")
    public  Response userDelete(@PathParam("id") int id){
        try {
            ProductoProvider provider = new ProductoProvider();
            provider.deleteProductById(id);
            return Response
                    .ok(new Message("operacion exitosa"))
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.
                    status(500).
                    entity(new Message("operacion fallida")).
                    header("Content-Type","application/json").
                    build();
        }
    }
}
