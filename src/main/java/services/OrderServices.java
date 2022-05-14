package services;

import model.Message;
import model.Order;
import model.Usuario;
import providers.OrderProvider;
import providers.UsuarioProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("orden")
public class OrderServices {

    @POST
    @Path("createOrder")
    @Consumes("application/json")
    public Response createOrder(Order order){


        try {

                OrderProvider provider = new OrderProvider();
            provider.createOrder(order);

            return Response.ok(new Message("operacion exitosa")).header("Content-Type","application/json").build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response.status(500).entity(new Message("operacion fallida")).header("Content-Type","application/json").build();

        }
    }

    @PUT
    @Path("orderEdit")
    @Consumes("application/json")
    public  Response editOrder(Order order){
        try {
            OrderProvider provider= new OrderProvider();
            provider.editOrder(order);
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
    @Path("orderDelete/{id}")
    public  Response orderDelete(@PathParam("id") int id){
        try {
            OrderProvider provider = new OrderProvider();
            provider.deleteOrderById(id);
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

    @PUT
    @Path("orderPaid/{id}")
    public  Response orderPay(@PathParam("id") int id){
        try {
            OrderProvider provider = new OrderProvider();
            Order order = provider.getOrder(id);
            provider.updatePayOrder(order);

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

    @PUT
    @Path("orderUnpaid/{id}")
    public  Response orderUnpaid(@PathParam("id") int id){
        try {
            OrderProvider provider = new OrderProvider();
            Order order = provider.getOrder(id);
            provider.updateUnpaidOrder(order);

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
