package utils;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBd {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/BDguanabira";
    private static final String user = "root";
    private static final String password = "admin";

    public static Connection getConexao() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, password);

        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados \n" + e.getMessage());
        }
        return conexao;
    }
}
