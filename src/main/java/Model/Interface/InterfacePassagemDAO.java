package Model.Interface;

import Model.entities.Passagem;
import Model.entities.Viagem;

import java.util.ArrayList;

public interface InterfacePassagemDAO {
    void adicionarPassagem(Integer id_cliente, Integer id_onibus, Integer id_viagem, Integer id_assento);
    ArrayList<String> buscarPassagem(Integer id_passagem);
    ArrayList<Integer> listarPassagem(Integer id_cliente);
    Integer buscarPassagem(Integer id_cliente, Integer id_onibus, Integer id_viagem, Integer id_assento);
    void atualizarPassagem(Integer id_passagem, Integer id_cliente, Integer id_onibus, Integer id_viagem, Integer id_assento);
    void deletarPassagem(Integer id_passagem);
}