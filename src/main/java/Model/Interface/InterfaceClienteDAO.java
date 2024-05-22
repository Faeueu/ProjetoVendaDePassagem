package Model.Interface;

import Model.entities.Cliente;

public interface InterfaceClienteDAO {
    void adicionarCliente(String nome, String cpf, String telefone, String email, String login, String senha);
    Cliente buscarCliente(String cpf);
    void atualizarCliente(Integer id_cliente, String nome, String cpf, String telefone, String email, String login, String senha);
    void deletarCliente(Integer id_cliente);
    Cliente clienteLogin(String login, String senha);
    boolean verificarLogin(String login);
}