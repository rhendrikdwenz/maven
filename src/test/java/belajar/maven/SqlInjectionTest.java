package belajar.maven;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {

    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                SELECT * FROM cabang
                                    
                """;
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            String KodeCabang = resultSet.getString("kodeCabang");
            String NamaCabang = resultSet.getString("NamaCabang");


            System.out.println(
                    String.join(",", KodeCabang, NamaCabang)
            );
        }


        resultSet.close();
        statement.close();
        connection.close();
    }
}
