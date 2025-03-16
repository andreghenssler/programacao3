package Tb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    private Connection conexao;
    private boolean estaConectado;
    private String mensagemErro;

    public Banco(String servidor, String porta, String nomeBanco, String usuario, String senha) {
        try {
            String url = "jdbc:mysql://" + servidor + ":" + porta + "/" + nomeBanco;
            this.conexao = DriverManager.getConnection(url, usuario, senha);
            this.estaConectado = true;
        } catch (SQLException e) {
            this.mensagemErro = e.getMessage();
            this.estaConectado = false;
        }
    }

    public Connection obterConexao() {
        return conexao;
    }

    public boolean conectado() {
        return estaConectado;
    }

    public String obterMensagemErro() {
        return mensagemErro;
    }

    public void encerraConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                estaConectado = false;
            }
        } catch (SQLException e) {
            mensagemErro = e.getMessage();
        }
    }
}
