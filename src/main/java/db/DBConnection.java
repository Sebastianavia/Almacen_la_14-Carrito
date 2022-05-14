package db;

import java.sql.*;

public class DBConnection {

    private Connection connection;

    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void connect() throws SQLException {

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacenes_la_14_carrito",
                "root",
                "");

    }

    //pide info
    public ResultSet getDataBySQL(String sql) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    //Comandos: DELETE, EDIT, INSERT
    public void commandSQL(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}
