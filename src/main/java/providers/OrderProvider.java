package providers;

import db.DBConnection;
import model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;



public class OrderProvider {

    public void createOrder(Order order) throws SQLException {
        String sql= "INSERT INTO orden(pago_no_si,fecha_creacion,fecha_pago,userId) VALUES ('$PAGO_NO_SI',$FECHA_CREACION,$FECHA_PAGO,$USERID)";
        order.setPago_no_si("No");
        sql = sql.replace("$PAGO_NO_SI",order.getPago_no_si());
        sql = sql.replace("$FECHA_CREACION",""+order.getFecha_creacion());
        sql = sql.replace("$FECHA_PAGO",""+order.getFecha_pago());
        sql = sql.replace("$USERID",String.valueOf(order.getUserId()));
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

    public void updatePayOrder(Order order) throws SQLException {
        String sql= "UPDATE orden SET pago_no_si ='$PAGO_NO_SI', fecha_pago =$FECHA_PAGO WHERE id=$ID";
        sql = sql.replace("$ID",String.valueOf(order.getId()));
        order.setPago_no_si("Si");
        sql = sql.replace("$PAGO_NO_SI",order.getPago_no_si());
        sql = sql.replace("$FECHA_PAGO",""+order.getFecha_pago());
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }


    public void updateUnpaidOrder(Order order) throws SQLException {
        String sql= "UPDATE orden SET pago_no_si ='$PAGO_NO_SI', fecha_pago =$FECHA_PAGO WHERE id=$ID";
        sql = sql.replace("$ID",String.valueOf(order.getId()));
        order.setPago_no_si("No");
        sql = sql.replace("$PAGO_NO_SI",order.getPago_no_si());
        sql = sql.replace("$FECHA_PAGO",""+order.getFecha_pago());
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
    public Order  getOrder(int idOrden) throws SQLException {
      Order order = new Order();

        String sql = "SELECT * FROM orden";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            int id=resultSet.getInt(resultSet.findColumn("id"));
            String pago_no_si =resultSet.getString(resultSet.findColumn("pago_no_si"));
            long fecha_creacion=resultSet.getLong(resultSet.findColumn("fecha_creacion"));
            long fecha_pago=resultSet.getLong(resultSet.findColumn("fecha_pago"));
            int userId=resultSet.getInt(resultSet.findColumn("userId"));
            if(id==idOrden){
                order.setId(id);order.setPago_no_si(pago_no_si);order.setFecha_creacion(fecha_creacion);
                order.setFecha_pago(fecha_pago);order.setUserId(userId);
            }
        }

        connection.disconnect();
        return order;
    }


}
