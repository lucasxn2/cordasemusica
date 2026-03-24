
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendasDAO {
    
         public ArrayList<Vendas> listarVendas(){

        ArrayList<Vendas> lista = new ArrayList<>();
        String sql = "SELECT * FROM vendas";

        try (Connection conn = new ConexaoDB().conectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while(rs.next()){
                Vendas venda = new Vendas();

                venda.setIdCliente(rs.getInt("vendas_clientesID"));
                venda.setIdGuitarra(rs.getInt("vendas_guitarrasID"));
                venda.setDataVenda(rs.getString("data_venda"));

                lista.add(venda);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }

        return lista;
    }
         
    
         public void cadastrarVenda(Vendas venda) {
    String sql = "INSERT INTO vendas (Vendas_ClientesID, Vendas_GuitarrasID, data_venda) VALUES (?, ?, ?)";

    try (Connection conn = new ConexaoDB().conectDB();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, venda.getIdCliente());
        stmt.setInt(2, venda.getIdGuitarra());
        stmt.setString(3, venda.getDataVenda());

        stmt.executeUpdate();

        JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda: " + e.getMessage());
    }
}
         
         
}