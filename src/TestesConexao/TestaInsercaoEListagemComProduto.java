package TestesConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import model.Produto;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        // Try com parametro de conexao para query
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
           
            ProdutoDAO produtoDao = new ProdutoDAO(connection);
            produtoDao.Salvar(comoda);
            
            List<Produto> listaDeProdutos = produtoDao.listar();
            listaDeProdutos.stream().forEach(lp -> System.out.println(lp));

        }

        
    }
}
