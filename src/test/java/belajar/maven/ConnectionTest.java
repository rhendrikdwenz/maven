package belajar.maven;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    @BeforeAll
    static void beforeAll() {
            try {
                Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(mysqlDriver);
            }catch (SQLException exception){
        }
    }

    @Test
    void testConnection() {
        String jdbcurl = "jdbc:mysql://localhost:3306/wms_db";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcurl, username, password);
            System.out.println("Sukses konek ke database");
        }catch (SQLException exception){
            Assertions.fail(exception);
        }
    }
}
