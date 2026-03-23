
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class GuitarrasDAO {
    
    public List<String> listarNomesGuitarras() {

    List<String> lista = new ArrayList<>();

    String sql = "SELECT nome FROM guitarras";

    Connection conn = new ConexaoDB().conectDB();

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            lista.add(rs.getString("nome"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
    
}
