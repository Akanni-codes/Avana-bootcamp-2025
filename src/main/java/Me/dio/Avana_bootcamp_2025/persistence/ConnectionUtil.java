package Me.dio.Avana_bootcamp_2025.persistence;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
        // Lê as variáveis de ambiente (com prefixo DB_)
        String host = System.getenv("DB_HOST");
        String port = System.getenv("DB_PORT");
        String database = System.getenv("DB_NAME");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        // Constrói a URL de conexão JDBC
        String url = String.format(
                "jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
                host,
                port,
                database
        );

        // Retorna a conexão
        return DriverManager.getConnection(url, user, password);
    }
}
