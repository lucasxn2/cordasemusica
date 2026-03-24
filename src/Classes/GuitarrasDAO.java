
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class GuitarrasDAO {
    
    
    public void cadastrarGuitarra(Guitarras guitarra) {

        String sql = "INSERT INTO guitarras (nome, marca, modelo, fabricacao, cor, preco) VALUES (?, ?, ?, ?, ?, ?)";

        ConexaoDB conexaoDB = new ConexaoDB();
        Connection conn = conexaoDB.conectDB();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, guitarra.getNome());
            stmt.setString(2, guitarra.getMarca());
            stmt.setString(3, guitarra.getModelo());
            stmt.setString(4, guitarra.getFabricacao());
            stmt.setString(5, guitarra.getCor());
            stmt.setDouble(6, guitarra.getPreco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Guitarra cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar guitarra:");
            e.printStackTrace();
        }
    }
    
    
    
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
                guitarra.setCor(rs.getString("cor"));
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
