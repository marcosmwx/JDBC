package TestesConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factory.ConnectionFactory;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {

        // Try catch com rollback com autoclose ()

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.recuperarConexao()) {
            connection.setAutoCommit(false); // Autocommit falso para controlar o envio das transacoes

            try (PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);) {

                adicionarVariavel("SmartTv", "45' polegadas", stm);
                adicionarVariavel("Radio", "Radio portatil", stm);

                connection.commit();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("Rollback executado");
                connection.rollback();
            }

        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        // VALIDAÇÃO DOS PRODUTOS
        if (nome.equals("Radio")) {
            throw new RuntimeException("Nao foi possivel adicionar o produto");
        }

        stm.execute();

        try (ResultSet rst = stm.getGeneratedKeys()) {
            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println("ID criado: " + id);
            }
        }
    }

}
