package services;

import model.Message;
import model.Order_Products;
import model.Usuario;
import providers.OrderProductsProvider;
import providers.ProductoProvider;
import providers.UsuarioProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
}
