package db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConn {

    private static BasicDataSource ds = new BasicDataSource();
    static {
        ds.setUrl("jdbc:mysql://200.3.193.22:3306/P09728_1_11");
        ds.setUsername("P09728_1_11");
        ds.setPassword("ZCSaQGZU");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    private Connection connection;


    public DbConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = ds.getConnection();
    }

    public ResultSet getData(String sql) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        return resultSet;
    }

    public void runQuery(String sql) throws SQLException {
        connection.createStatement().execute(sql);
    }

    public void close() throws SQLException {
        connection.close();
    }
}
