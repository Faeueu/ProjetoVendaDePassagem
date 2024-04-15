package Main;

import DAO.ClienteDAO;
import Model.entities.Cliente;

public class teste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        /*cliente.setNome("Teste1");
        cliente.setCpf("0000000000");
        cliente.setTelefone("11111111");
        cliente.setEmail("teste@teste.com");*/

        ClienteDAO clienteDAO = new ClienteDAO();
        //clienteDAO.addCliente(cliente);
        clienteDAO.printCliente();



    }
}
