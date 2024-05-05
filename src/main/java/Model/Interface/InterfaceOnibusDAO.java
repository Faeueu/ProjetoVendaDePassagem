package Model.Interface;

import Model.entities.Onibus;

public interface InterfaceOnibusDAO {
    void adicionarOnibus(Integer id_viagem);
    void buscarOnibus(Integer id_onibus, Onibus onibus);
    void atualizarOnibus(Integer id_onibus, Integer id_viagem);
    void deletarOnibus(Integer id_onibus);
    void listarOnibus();
    void assentosDisponiveis(Integer id_onibus);
}
