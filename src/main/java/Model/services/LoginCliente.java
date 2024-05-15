package Model.services;

import DAO.DAOfactory;
import Model.Interface.InterfaceClienteDAO;
import Model.entities.Cliente;

import javax.swing.*;

public class LoginCliente {
    public LoginCliente(){}

    public Cliente logar(String login, String senha){
        InterfaceClienteDAO ICD = DAOfactory.criarClienteDAO();
        Cliente cliente = new Cliente();
        ICD.buscarCliente(login, senha, cliente);

        return cliente;
    }
}
