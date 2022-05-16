package services;

import model.InformationOrder;
import model.Message;
import model.Order_Products;
import model.Usuario;
import providers.OrderProductsProvider;
import providers.OrderProvider;
import providers.ProductoProvider;
import providers.UsuarioProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("OrderProduct")
public class Oerder_ProductServices {

    //CREAR USUSARIO
    @POST
    @Path("create")
    @Consumes("application/json")
    public Response create(Order_Products order_products){


        try {

            OrderProductsProvider provider = new OrderProductsProvider();
            ProductoProvider provider1 = new ProductoProvider();
            int precio = provider1.getPriceProduct(order_products.getProductoID());
            System.out.println(precio);
            provider.createOrderProduct(order_products, precio);

            return Response.ok(new Message("operacion exitosa")).header("Content-Type","application/json").build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response.status(500).entity(new Message("operacion fallida")).header("Content-Type","application/json").build();

        }
    }


    @GET
    @Path("infoOrder/{id}")
    @Consumes("application/json")
    public javax.ws.rs.core.Response obtainByID(@PathParam("id") int id){
        try {
            OrderProductsProvider ordenProduct = new OrderProductsProvider();
            InformationOrder informationOrder = ordenProduct.orderInfo(id);
            return javax.ws.rs.core.Response
                    .ok(informationOrder)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response.status(500).entity(new Message("operacion fallida")).header("Content-Type","application/json").build();
        }

    }
}
