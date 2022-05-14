package providers;

import db.DBConnection;
import model.Order;
import model.Order_Products;

import java.sql.SQLException;

public class OrderProductsProvider {


    //id	productoID	ordenID	cantidad_Producto	precio_total
    public void createOrderProduct(Order_Products order_products, int precioProducto) throws SQLException {
        String sql= "INSERT INTO orden_producto(productoID,ordenID,cantidad_Producto,precio_total) VALUES ($PRODUCTOID,$ORDENID,$CANTIDAD_PRODUCTO,$PRECIO_TOTAL)";
        int finalPrice = order_products.getCantidad_Producto()*precioProducto;
        order_products.setPrecio_total(finalPrice);
        sql = sql.replace("$PRODUCTOID",""+order_products.getProductoID());
        sql = sql.replace("$ORDENID",""+order_products.getOrdenID());
        sql = sql.replace("$CANTIDAD_PRODUCTO",""+order_products.getCantidad_Producto());
        sql = sql.replace("$PRECIO_TOTAL",(""+order_products.getPrecio_total()));
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }



    public void editOrder(Order order) throws SQLException {
        String sql= "UPDATE orden SET pago_no_si ='$PAGO_NO_SI', fecha_cración = '$FHECHA_CREACION', fecha_pago ='$FHECHA_PAGO', , userId = '$USERID' WHERE id=$IDs";
        sql = sql.replace("$ID",String.valueOf(order.getId()));
        sql = sql.replace("$PAGO_NO_SI",order.getPago_no_si());
        sql = sql.replace("$FHECHA_CREACI0N",""+order.getFecha_creacion());
        sql = sql.replace("$FHECHA_PAGO",""+order.getFecha_pago());
        sql = sql.replace("$USERID",String.valueOf(order.getUserId()));
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public void deleteOrderById(int id) throws SQLException {

        String sql= "DELETE FROM orden WHERE id="+id;
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }
}