package services;

import model.HisUser;
import model.Message;
import model.Order;
import model.Usuario;
import providers.OrderProvider;
import providers.UsuarioProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

//api/usuario/echo
@Path("usuario")
public class UserServices {

    @GET
    @Path("echo")
    public String echo(){
        return "echo";
    }


    //CREAR USUSARIO
    @POST
    @Path("createUser")
    @Consumes("application/json")
    public Response create(Usuario usuario){


        try {

            UsuarioProvider provider = new UsuarioProvider();
            provider.createUsuario(usuario);

            return Response.ok(new Message("operacion exitosa")).header("Content-Type","application/json").build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response.status(500).entity(new Message("operacion fallida")).header("Content-Type","application/json").build();

        }
    }

    //OBTENER TODOS LOS USUARIOS
    @GET
    @Path("allUser")
    public Response getAll(){
        try {

            UsuarioProvider provider = new UsuarioProvider();
            ArrayList<Usuario> usuarios = provider.getAllUsuario();
            return Response
                    .ok(usuarios)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }
    }
//EDITRA USUARIO
    @PUT
    @Path("userEdit")
    @Consumes("application/json")
    public  Response editUser(Usuario usuario){
        try {
            UsuarioProvider provider= new UsuarioProvider();
            provider.editUsuario(usuario);
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

//METODO PARA ELIMINAR USUARIO
    @DELETE
    @Path("userDelete/{id}")
    public  Response userDelete(@PathParam("id") int id){
        try {
            UsuarioProvider provider = new UsuarioProvider();
            provider.deleteUsuarioById(id);
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
    //____________________________________________________________________
    @GET
    @Path("HistoryUser/{cedula}")
    public Response usurioHistory(@PathParam("cedula") int cedula){
        try {
            UsuarioProvider provider = new UsuarioProvider();
            OrderProvider provider1= new OrderProvider();
            Usuario usuario = provider.infoUserBynit(cedula);
            ArrayList<Order> orders = provider1.getOrderByID(usuario.getId());
            HisUser history = new HisUser(usuario.getId(), orders);

            return Response
                    .ok(history)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response.
                    status(500).
                    entity(new Message("operacion fallida")).
                    header("Content-Type","application/json").
                    build();
        }
    }

}
