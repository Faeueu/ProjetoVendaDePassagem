package Model.Interface;

import Model.entities.Passagem;
import Model.entities.Viagem;

public interface InterfacePassagemDAO {
    void adicionarPassagem(Integer id_cliente, Integer id_onibus, Integer id_viagem, Integer id_assento);
    void buscarPassagem(Integer id_passagem);
    void atualizarPassagem(Integer id_passagem, Integer id_cliente, Integer id_onibus, Integer id_viagem, Integer id_assento);
    void deletarPassagem(Integer id_passagem);
}