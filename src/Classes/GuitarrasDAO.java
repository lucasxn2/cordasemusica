
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class GuitarrasDAO {
    
     public ArrayList<Guitarras> listarGuitarras(){

        ArrayList<Guitarras> lista = new ArrayList<>();
        String sql = "SELECT * FROM guitarras";

        try (Connection conn = new ConexaoDB().conectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while(rs.next()){
                Guitarras guitarra = new Guitarras();

                guitarra.setId(rs.getInt("guitarrasid"));
                guitarra.setNome(rs.getString("nome"));
                guitarra.setMarca(rs.getString("marca"));
                guitarra.setModelo(rs.getString("modelo"));
                guitarra.setFabricacao(rs.getString("fabricacao"));
                guitarra.setPreco(rs.getInt("preco"));

                lista.add(guitarra);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }

        return lista;
    }
    
    
    
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
