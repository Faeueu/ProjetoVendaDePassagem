package Test;

import DAO.ClienteDAO;
import DAO.DAOfactory;
import Model.Interface.InterfaceClienteDAO;

import java.sql.Connection;

public class teste {
    public static void main(String[] args) {
        InterfaceClienteDAO i = DAOfactory.criarClienteDAO();
        boolean valor = i.login("maciano123");
        System.out.println(valor);
    }
}
