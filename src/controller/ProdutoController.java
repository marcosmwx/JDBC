package controller;

import java.sql.Connection;
import java.util.List;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import model.Produto;

public class ProdutoController {

    // Os metodos utilizam os proprios metodos instanciados pela DAO de produto 

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.produtoDAO = new ProdutoDAO(connection);
    }

    public void deletar(Integer id) {
        this.produtoDAO.deletar(id);
        System.out.println("Deletando produto");
    }

    public void salvar(Produto produto) {
        System.out.println("Salvando produto");
        this.produtoDAO.Salvar(produto);
    }

    public List<Produto> listar() {
       return this.produtoDAO.listar();
    }

    public void alterar(String nome, String descricao, Integer id) {
        this.produtoDAO.alterar(nome, descricao, id);
        System.out.println("Alterando produto");
    }
}
