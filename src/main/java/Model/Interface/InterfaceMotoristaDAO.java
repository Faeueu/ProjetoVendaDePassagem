package Model.Interface;

import Model.entities.Motorista;

public interface InterfaceMotoristaDAO {
    void adicionarMotorista(String nome, Integer id_onibus);
    void buscarMotorista(Integer id_motorista, Motorista motorista);
    void atualizarMotorista(Integer id_motorista, Integer id_onibus, String nome);
    void deletarMotorista(Integer id_motorista);
    void listarMotorista();
}