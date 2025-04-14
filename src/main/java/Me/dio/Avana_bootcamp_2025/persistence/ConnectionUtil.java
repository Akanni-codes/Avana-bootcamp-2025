package Me.dio.Avana_bootcamp_2025.persistence;

import lombok.NoArgsConstructor;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
        try {
            String dbUrl = System.getenv("DB_URL"); // formato: mysql://user:pass@host:port/database
            URI uri = new URI(dbUrl.replace("mysql", "http")); // para conseguir usar URI parser

            String userInfo = uri.getUserInfo(); // user:password
            String[] credentials = userInfo.split(":");
            String user = credentials[0];
            String password = credentials[1];

            String host = uri.getHost();
            int port = uri.getPort();
            String db = uri.getPath().substring(1); // remove o '/'

            String jdbcUrl = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC", host, port, db);

            return DriverManager.getConnection(jdbcUrl, user, password);

        } catch (URISyntaxException e) {
            throw new SQLException("Erro ao interpretar DB_URL", e);
        }
    }
}
