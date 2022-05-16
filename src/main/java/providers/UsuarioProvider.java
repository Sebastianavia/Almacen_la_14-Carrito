package providers;

import db.DBConnection;
import model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioProvider {



    public void createUsuario(Usuario usuario) throws SQLException {

        String sql= "INSERT INTO usuario(nombre, cedula) VALUES ('$NOMBRE',$CEDULA)";
        sql = sql.replace("$NOMBRE",usuario.getNombre());
        sql = sql.replace("$CEDULA",String.valueOf(usuario.getCedula()));
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }


    public ArrayList<Usuario> getAllUsuario() throws SQLException {
        ArrayList<Usuario> output = new ArrayList<>();

        String sql = "SELECT * FROM usuario";
        DBConnection connection = new DBConnection();
        connection.connect();

        ResultSet resultSet = connection.getDataBySQL(sql);
        while (resultSet.next()){
            int id=resultSet.getInt(resultSet.findColumn("id"));
            String nombre =resultSet.getString(resultSet.findColumn("nombre"));
            int cedula=resultSet.getInt(resultSet.findColumn("cedula"));

            Usuario usuario = new Usuario(id, nombre, cedula);
            output.add(usuario);
        }

    connection.disconnect();
    return output;
    }


    public void editUsuario(Usuario usuario) throws SQLException {

        String sql= "UPDATE usuario SET nombre ='$NOMBRE', , cedula = '$CEDULA' WHERE id=$IDs";
        sql = sql.replace("$ID",String.valueOf(usuario.getId()));
        sql = sql.replace("$NOMBRE",usuario.getNombre());
        sql = sql.replace("$CEDULA",String.valueOf(usuario.getCedula()));
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public void deleteUsuarioById(int id) throws SQLException {

        String sql= "DELETE FROM usuario WHERE id="+id;
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }
    //posible no funcione?____________________________________________________________________
        public Usuario infoUserBynit(int cedulaCho) throws SQLException {

            Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuario";
        DBConnection connection =  new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);

        while(resultSet.next()){
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String nombre = resultSet.getString(resultSet.findColumn("nombre"));
            int cedula = resultSet.getInt(resultSet.findColumn("cedula"));

            if(cedula == cedulaCho){
                usuario.setId(id);
                usuario.setNombre(nombre);
                usuario.setCedula(cedula);
            }

        }

        connection.disconnect();
        return usuario;
    }

}
