package TestesConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;


public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        stm.setInt(1, 9);
        stm.execute();

       Integer linhasModificadas = stm.getUpdateCount(); // Quantas linhas foram modificadas apos esse statement 

       System.out.println("QUantidade de linhas modificadas " + linhasModificadas );
    }
}
