package Model.services;

import DAO.DAOfactory;
import Model.Interface.InterfaceAssentoDAO;
import Model.Interface.InterfaceOnibusDAO;
import Model.Interface.InterfacePassagemDAO;

import java.io.FileNotFoundException;

public class LocarPassagemService {

    public void locarPassagem(Integer id_viagem, Integer numero, Integer id_cliente) throws FileNotFoundException {
        InterfaceOnibusDAO IOD = DAOfactory.criarOnibusDAO();
        Integer id_Onibus = IOD.buscarOnibus(id_viagem);

        InterfaceAssentoDAO IAD = DAOfactory.criarAssentoDAO();
        Integer id_Assento = IAD.buscarAssento(id_Onibus,numero);

        IAD.atualizarAssento(id_Assento);

        InterfacePassagemDAO IPD = DAOfactory.criarPassagemDAO();
        IPD.adicionarPassagem(id_cliente,id_Onibus,id_viagem,id_Assento);
        Integer id_passagem = IPD.buscarPassagem(id_cliente,id_Onibus,id_viagem,id_Assento);
        GerarPassagemService gerar = new GerarPassagemService();
        gerar.gerarPassagem(id_passagem,numero);

    }
}