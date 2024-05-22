package Model.services;

import DAO.DAOfactory;
import Model.Interface.InterfaceAssentoDAO;
import Model.Interface.InterfaceOnibusDAO;
import Model.Interface.InterfacePassagemDAO;

public class LocarPassagemService {

    public void locarPaddagem(Integer id_viagem, Integer numero, Integer id_cliente){
        InterfaceOnibusDAO IOD = DAOfactory.criarOnibusDAO();
        Integer id_Onibus = IOD.buscarOnibus(id_viagem);

        InterfaceAssentoDAO IAD = DAOfactory.criarAssentoDAO();
        Integer id_Assento = IAD.buscarAssento(id_Onibus,numero);

        IAD.ocuparAssento(id_Assento);

        InterfacePassagemDAO IPD = DAOfactory.criarPassagemDAO();
        IPD.adicionarPassagem(id_cliente,id_Onibus,id_viagem,id_Assento);

    }

}
