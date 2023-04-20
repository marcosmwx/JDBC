package controller;

import java.sql.Connection;
import java.util.List;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import model.Categoria;

public class CategoriaController {
	// O metodo utiliza o proprios metodo instanciado pela DAO de Categoria 
	
	private CategoriaDAO categoriaDAO;

	public CategoriaController()  {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.categoriaDAO = new CategoriaDAO(connection);

	}

	public List<Categoria> listar()  {
		return this.categoriaDAO.listar();
	}

}
