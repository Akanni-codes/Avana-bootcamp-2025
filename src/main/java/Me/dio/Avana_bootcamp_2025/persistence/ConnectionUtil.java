package Me.dio.Avana_bootcamp_2025.persistence;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost/test", "test", "test");
    }

}
