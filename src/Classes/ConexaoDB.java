
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {
    
        public Connection conectDB() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cordas_e_musica",
                "root",
                "1234"
            );
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    
}
