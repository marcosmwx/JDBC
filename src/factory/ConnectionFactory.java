package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
    public DataSource dataSource;

    public ConnectionFactory() { // Utilizando jar c3p0 para implementar o pool de conexoções
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/dbalura?userTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("");

        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /*
         * nao utilizando mais o drive manager pois abri a pool reaproveitando a conexao
         * 
         * DriverManager
         * .getConnection(
         * "jdbc:mysql://localhost/dbalura?userTimezone=true&serverTimezone=UTC",
         * "root", "");
         */
    }
}
