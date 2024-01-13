package JBDC.Repository;

import JBDC.Connection.ConnectionJ;
import JBDC.UserClass.Usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    public static int inseridos = 0;
    public static int removidos = 0;
    public static int editados = 0;
    public static void save(Usuarios user){
        String sql = "INSERT INTO mydb.Usuarios (name, email) VALUES ('" + user.getName() + "','" + user.getEmail() + "');";
        try(Connection conn = ConnectionJ.getConnection();
            Statement stmt = conn.createStatement()){
            int linhasMudadadas = stmt.executeUpdate(sql);
            inseridos++;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(String name){
        String sql = "DELETE FROM mydb.Usuarios as usu WHERE usu.name = '%s';".formatted(name);
        try(Connection conn = ConnectionJ.getConnection();
            Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
            removidos++;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void delete(Integer id){
        String sql = "DELETE FROM mydb.Usuarios as usu WHERE usu.ID = '%d';".formatted(id.intValue());
        try(Connection conn = ConnectionJ.getConnection();
            Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
            removidos++;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Usuarios> dados(){
        List<Usuarios> users = new ArrayList<>();
        try(Connection conn = ConnectionJ.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.Usuarios;")){
            while(rs.next()) {
                if (rs.getString("name") == null) break;
                Usuarios user = new Usuarios(rs.getNString("name"));
                user.setId(rs.getInt("ID"));
                user.setCreated_at(rs.getTimestamp("Created_AT"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public static <T> List<Usuarios> dadoBy(T searchKey){
        List<Usuarios> users = new ArrayList<>();
        try(Connection conn = ConnectionJ.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.Usuarios as usu WHERE usu.name = '" + searchKey + "' OR  usu.id = '" + searchKey + "';")){
            while(rs.next()) {
                Usuarios user = new Usuarios(rs.getNString("name"));
                user.setId(rs.getInt("ID"));
                user.setCreated_at(rs.getTimestamp("Created_AT"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

//    public static List<Usuarios> dadoBy(Integer id){
//        List<Usuarios> users = new ArrayList<>();
//        try(Connection conn = ConnectionJ.getConnection();
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.Usuarios as usu WHERE usu.ID = '%d';".formatted(id.intValue()))){
//            while(rs.next()) {
//                Usuarios user = new Usuarios(rs.getNString("name"));
//                user.setId(rs.getInt("ID"));
//                user.setCreated_at(rs.getTimestamp("Created_AT"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return users;
//    }

}
