package Main;

import DAO.DAOfactory;
import Model.Interface.InterfaceClienteDAO;
import Model.entities.Cliente;
import db.ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import Model.actions.Rodoviaria;
public class Main {
    public static void main(String[] args) {

        InterfaceClienteDAO interfaceClienteDAO = DAOfactory.criarClienteDAO();

        interfaceClienteDAO.login("joaozinho");
    }
}
