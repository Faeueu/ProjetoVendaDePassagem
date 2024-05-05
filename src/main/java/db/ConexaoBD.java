package db;

import java.sql.*;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/BDguanabira";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConexao(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);

        }
    }

    public static void closeConexao(Connection conexao){

        try {
            if (conexao != null) {
                conexao.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException();

        }
    }

    public static void closeAcesso(PreparedStatement pesquisa){

        try {
            if (pesquisa != null) {
                pesquisa.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException();

        }
    }

    public static void closeAcesso(PreparedStatement pesquisa, ResultSet resultado){
        closeAcesso(pesquisa);

        try {
            if (resultado != null) {
                resultado.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException();

        }
    }
}
