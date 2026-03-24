
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

                venda.setIdCliente(rs.getInt("vendas_guitarrasID"));
                venda.setIdGuitarra(rs.getInt("vendas_clientesID"));
                venda.setDataVenda(rs.getString("data_venda"));

                lista.add(venda);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }

        return lista;
    }
         
         
}