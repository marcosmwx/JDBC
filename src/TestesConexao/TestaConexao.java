package TestesConexao;
import java.sql.Connection;

import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();
        System.out.println("Fechando conexao");
        con.close();
    }
}
