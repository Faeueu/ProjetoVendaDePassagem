package Test;

import DAO.ClienteDAO;
import Model.entities.Cliente;

public class teste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Teste1");
        cliente.setCpf("00000000000");
        cliente.setTelefone("1111111111");
        cliente.setEmail("teste1@teste.com");

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.updateCliente(cliente);
        //clienteDAO.addCliente(cliente);
        //clienteDAO.deleteCliente(cliente);
        //clienteDAO.printCliente();



    }
}
