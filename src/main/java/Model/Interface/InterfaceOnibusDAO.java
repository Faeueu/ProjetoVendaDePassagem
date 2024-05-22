package Model.Interface;

import Model.entities.Onibus;

public interface InterfaceOnibusDAO {
    void adicionarOnibus(Integer id_viagem);
    Integer buscarOnibus(Integer id_viagem);
    void atualizarOnibus(Integer id_onibus, Integer id_viagem);
    void deletarOnibus(Integer id_onibus);
}
