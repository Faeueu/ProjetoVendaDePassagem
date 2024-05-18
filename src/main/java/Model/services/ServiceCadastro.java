package Model.services;

import DAO.DAOfactory;
import Model.Interface.InterfaceClienteDAO;
import Model.entities.Cliente;

import javax.swing.*;

public class ServiceCadastro {
    public Cliente Cadastrar(String nome, String cpf, String telefone, String email, String login, String senha){

        Cliente cliente = new Cliente();

        if(nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || email.isEmpty() || login.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos!");
        }
        else {
            InterfaceClienteDAO ICD = DAOfactory.criarClienteDAO();
            boolean valor = ICD.login(login);
            if(valor){

            }else{
                ICD.adicionarCliente(nome, cpf, telefone, email, login, senha);
                ICD.buscarCliente(login,senha,cliente);

            }
        }
        return cliente;
    }
};