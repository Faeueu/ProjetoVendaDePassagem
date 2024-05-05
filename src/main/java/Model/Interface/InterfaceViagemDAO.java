package Model.Interface;

import Model.entities.Viagem;

public interface InterfaceViagemDAO {
    void adicionarViagem(String origem, String horarioSaida, String destino, String horarioChegada);
    void buscarViagem(Integer id_viagem, Viagem viagem);
    void atualizarViagem(Integer id_viagem, String origem, String horarioSaida, String destino, String horarioChegada);
    void deletarViagem(Integer id_viagem);
    void listarviagens();
}
