package Main;

import Model.entities.Cliente;
import DAO.ClienteDAO;

//import Model.actions.Rodoviaria;
public class Main {
    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente(
                "Rafael",
                "123.456.789-00",
                "123456789",
                "rafael@gmail.com"
        );

        new ClienteDAO().addCliente(cliente);
    }
}
