
package Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClientesDAO {
    
        public void cadastrarCliente(Clientes cliente) {

        String sql = "INSERT INTO clientes (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";

        ConexaoDB conexaoDB = new ConexaoDB();
        Connection conn = conexaoDB.conectDB();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente:");
            e.printStackTrace();
        }
    }
        
         public ArrayList<Clientes> listarClientes(){

        ArrayList<Clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = new ConexaoDB().conectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while(rs.next()){
                Clientes cliente = new Clientes();

                cliente.setId(rs.getInt("clientesid"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));

                lista.add(cliente);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }

        return lista;
    }
    
}
