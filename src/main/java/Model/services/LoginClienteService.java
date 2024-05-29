package Model.services;

import DAO.ClienteDAO;
import DAO.DAOfactory;
import Model.Interface.InterfaceClienteDAO;
import Model.entities.Cliente;

import javax.swing.*;
import java.sql.Connection;

public class LoginClienteService {

    private boolean verificarDados(String login, String senha){

        if( login.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos!");
            return false;

        } else {
            return true;

        }
    }

    public Cliente logar(String login, String senha){

        InterfaceClienteDAO ICD = DAOfactory.criarClienteDAO();
        Cliente cliente = new Cliente();

        boolean verificarDados = verificarDados(login,senha);

        if(verificarDados){
            return ICD.clienteLogin(login, senha);


        } else {
            return cliente;

        }
    }
}
