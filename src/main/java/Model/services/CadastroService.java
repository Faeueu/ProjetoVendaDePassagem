package Model.services;

import DAO.DAOfactory;
import Model.Interface.InterfaceClienteDAO;
import Model.entities.Cliente;

import javax.swing.*;

public class CadastroService {

    private boolean verificarDados(String nome, String cpf, String telefone, String email, String login, String senha){

        InterfaceClienteDAO ICD = DAOfactory.criarClienteDAO();

        boolean verificarLogin = ICD.verificarLogin(login);

        if(nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || email.isEmpty() || login.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos!");
            return false;

        } else if(senha.length() > 8){
            JOptionPane.showMessageDialog(null, "A senha nao pode conter mais de 8 caracteres!");
            return false;

        } else if(verificarLogin) {
            return false;

        } else {
            return true;

        }
    }

    public Cliente Cadastrar(String nome, String cpf, String telefone, String email, String login, String senha) {

        InterfaceClienteDAO ICD = DAOfactory.criarClienteDAO();
        Cliente cliente = new Cliente();

        boolean verificarDados = verificarDados(nome, cpf, telefone, email, login, senha);

        if (verificarDados){
            ICD.adicionarCliente(nome, cpf, telefone, email, login, senha);
            ICD.buscarCliente(login, senha, cliente);
            return cliente;

        } else {
            return cliente;

        }
    }
}