package providers;

import db.DBConnection;
import model.Producto;
import model.Usuario;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoProvider {


    public void createProducto(Producto producto) throws SQLException {

        String sql= "INSERT INTO producto(nombre, precio) VALUES ('$NOMBRE',$PRECIO)";
        sql = sql.replace("$NOMBRE",producto.getNombre());
        sql = sql.replace("$PRECIO",String.valueOf(producto.getPrecio()));
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public void editProdcto(Producto producto) throws SQLException {

        String sql= "UPDATE producto SET nombre ='$NOMBRE', , precio = '$PRECIO' WHERE id=$IDs";
        sql = sql.replace("$ID",String.valueOf(producto.getId()));
        sql = sql.replace("$NOMBRE",producto.getNombre());
        sql = sql.replace("$PRECIO",String.valueOf(producto.getPrecio()));
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public void deleteProductById(int id) throws SQLException {

        String sql= "DELETE FROM producto WHERE id="+id;
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public int  getPriceProduct(int productoId) throws SQLException {
        int price=0;

        String sql = "SELECT * FROM producto";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            int id=resultSet.getInt(resultSet.findColumn("id"));
            int precio=resultSet.getInt(resultSet.findColumn("precio"));

            if(id==productoId){
                price = precio;
            }
        }

        connection.disconnect();
        return price;
    }

    public ArrayList<Producto> getAllProducts() throws SQLException {
        ArrayList<Producto> output = new ArrayList<>();

        String sql = "SELECT * FROM producto";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            int id=resultSet.getInt(resultSet.findColumn("id"));
            String nombre =resultSet.getString(resultSet.findColumn("nombre"));
            int precio=resultSet.getInt(resultSet.findColumn("precio"));

            Producto producto = new Producto(id, nombre, precio);
            output.add(producto);
        }

        connection.disconnect();
        return output;
    }


}
