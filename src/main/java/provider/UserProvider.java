package provider;

import db.DbConn;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserProvider {

    public ArrayList<User> getAllUsers(int page) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();
        ArrayList<User> users = new ArrayList<>();

        int beg = (page-1)*5;
        int end = (page)*5;
        ResultSet results = conn.getData("SELECT * FROM users ORDER BY id LIMIT "+beg+","+end);

        while(results.next()){
            int id = results.getInt("id");
            String username = results.getString("username");
            String name = results.getString("name");
            String natId = results.getString("natId");
            int age = results.getInt("age");
            String pass = results.getString("pass");
            User user = new User(id, username, name, natId, age, pass);
            users.add(user);
        }
        conn.close();
        return  users;
    }

}
