package Model.Interface;

import Model.entities.Cliente;

public interface InterfaceCadastroService {

    public  boolean verificarDados(String nome, String cpf, String telefone, String email, String login, String senha);

    public Cliente Cadastrar(String nome, String cpf, String telefone, String email, String login, String senha);

}
