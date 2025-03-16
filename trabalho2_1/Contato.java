package trabalho2_1;
/* Nomes: André e Felipe */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Contato {
    public void incluir(String nome, String telefone, String email) throws SQLException {
        String sql = "INSERT INTO contato (nome, eMail, telefone) VALUES (?, ?, ?)";
        try (Connection conn = Banco.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, telefone);
            stmt.executeUpdate();
        }
    }

    public void alterar(int id, String nome, String telefone, String email) throws SQLException {
        String sql = "UPDATE contato SET nome = ?, telefone = ?, eMail = ? WHERE idContato = ?";
        try (Connection conn = Banco.getConexao();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, email);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM contato WHERE idContato = ?";
        try (Connection conn = Banco.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();

        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT * FROM contato";
        try (Connection conn = Banco.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idContato"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Email: " + rs.getString("eMail"));
                System.out.println("--------------------------");
            }
        }
    }
}
