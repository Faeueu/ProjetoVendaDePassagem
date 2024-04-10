package db;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    public static java.sql.Connection conectar() {
        java.sql.Connection conexao = null;
        try {

            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";

            String usuario = "root";
            String senha = "root1234";

            conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }

}