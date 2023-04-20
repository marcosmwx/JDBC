package TestesConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import model.Categoria;
import model.Produto;

public class TestaListagemCategoria {
    public static void main(String[] args) throws SQLException {
        //Exibe a listagem da categoria e seus produtos
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {

            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
            listaDeCategorias.stream().forEach(ct -> {
                System.out.println("_________________________________");
                System.out.println(ct.getNome());

                for (Produto produto : ct.getProdutos()) {
                    System.out.println(ct.getNome() + " - " + produto.getNome());
                }
                System.out.println("_________________________________");
            }

            );
        }
    }
}
