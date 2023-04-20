package TestesConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO"); // cria um statement
                                                                                                 // para selecionar no
                                                                                                 // banco de dados ou
                                                                                                 // fazer algo
        stm.execute();
        ResultSet rst = stm.getResultSet();

        while (rst.next()) { // é preciso para exibir os proximos

            Integer id = rst.getInt("ID");
            String nome = rst.getString("NOME");
            String desc = rst.getString("DESCRICAO");

            System.out.println(id + " " + "-" + " " + nome + " " + desc);
        }

        con.close();
    }
}
