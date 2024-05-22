package Test;

import DAO.ClienteDAO;
import DAO.DAOfactory;
import Model.Interface.InterfaceAssentoDAO;
import Model.Interface.InterfaceClienteDAO;
import Model.Interface.InterfaceViagemDAO;
import Model.entities.Viagem;

import java.sql.Connection;

public class teste {
    public static void main(String[] args) {
        InterfaceAssentoDAO IAD = DAOfactory.criarAssentoDAO();
        InterfaceViagemDAO IVD = DAOfactory.criarViagemDAO();
        Viagem viagem = IVD.buscarViagem("Uirauna","2024/04/23 08:00:00","Cajazeiras","2024/04/23 12:00:00");
        System.out.println(IAD.buscarAssentos(viagem));
    }
}
