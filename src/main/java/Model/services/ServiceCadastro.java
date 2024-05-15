package Model.services;

import DAO.DAOfactory;
import Model.Interface.InterfaceClienteDAO;
import Model.entities.Cliente;

public class ServiceCadastro {
    public Cliente Cadastrar(String nome, String cpf, String telefone, String email, String login, String senha){

        InterfaceClienteDAO ICD = DAOfactory.criarClienteDAO();
        ICD.adicionarCliente(nome, cpf, telefone, email, login, senha);
        Cliente cliente = new Cliente();
        ICD.buscarCliente(login,senha,cliente);
        return cliente;
    }
}
