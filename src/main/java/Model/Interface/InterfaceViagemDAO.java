package Model.Interface;

import Model.entities.Passagem;
import Model.entities.Viagem;

public interface InterfaceViagemDAO {
    void adicionarViagem(String origem, String horarioSaida, String destino, String horarioChegada);
    Viagem buscarViagem(String Origem, String horarioSaida, String Destino, String horarioChegada);
    void atualizarViagem(Integer id_viagem, String origem, String horarioSaida, String destino, String horarioChegada);
    void deletarViagem(Integer id_viagem);
    Passagem locarPassagem(Integer id_viagem, Integer numero);
    void listarviagens();
}
