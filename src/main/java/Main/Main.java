package Main;

import Model.entities.Cliente;
import DAO.ClienteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import Model.actions.Rodoviaria;
public class Main {
    public static void main(String[] args) {
        // URL de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/BDguanabira";
        // Nome de usuário do banco de dados
        String user = "root";
        // Senha do banco de dados
        String password = "admin";

        try {
            // Estabelecer a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida!");

            // Use a conexão aqui...

            // Feche a conexão quando terminar
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
