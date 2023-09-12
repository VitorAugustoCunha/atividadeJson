package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;

    public static void initialize() {
        String jdbcURL = "jdbc:h2:~/test";
        String username = "sa";
        String password = "1234";

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Conectado ao banco de dados");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão com o banco de dados fechada");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados");
                e.printStackTrace();
            }
        }
    }
}
