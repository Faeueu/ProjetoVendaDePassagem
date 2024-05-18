package Model.Interface;

import Model.entities.Cliente;

public interface InterfaceClienteDAO {
    void adicionarCliente(String nome, String cpf, String telefone, String email, String login, String senha);
    void buscarCliente(String nome, String senha, Cliente cliente);
    void atualizarCliente(Integer id_cliente, String nome, String cpf, String telefone, String email, String login, String senha);
    void deletarCliente(Integer id_cliente);
    void listarClientes();
    void clienteLogin(String login, String senha, Cliente cliente);
    boolean login(String login);
}