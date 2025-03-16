package Tb2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Contato {
    private Integer idContato;
    private String nome;
    private String eMail;
    private String telefone;
    private Connection conexao;

    public Contato(Connection conexao) {
        this.conexao = conexao;
    }

    public Contato() {}

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getEMail() {
        return eMail;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravarContato() throws SQLException {
        String sql = "INSERT INTO contato (nome, eMail, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, eMail);
            stmt.setString(3, telefone);
            stmt.executeUpdate();
        }
    }

    public void atualizarContato() throws SQLException {
        String sql = "UPDATE contato SET nome = ?, telefone = ?, eMail = ? WHERE idContato = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, eMail);
            stmt.setInt(4, idContato);
            stmt.executeUpdate();
        }
    }

    public boolean deletarContato(Integer idContato) throws SQLException {
        String sql = "DELETE FROM contato WHERE idContato = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idContato);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Contato> obterListaContato() throws SQLException {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contato";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setIdContato(rs.getInt("idContato"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEMail(rs.getString("eMail"));
                contatos.add(contato);
            }
        }
        return contatos;
    }

    @Override
    public String toString() {
        return "ID=" + idContato + "\nNome=" + nome + "\nTelefone=" + telefone + "\nEmail=" + eMail + "";
    }
}

