package Model.Interface;

import Model.entities.Viagem;

import java.util.ArrayList;

public interface InterfaceAssentoDAO  {
    void adicionarAssento(Integer id_onibus, Integer numero, boolean ocupado);
    Integer buscarAssento(Integer id_onibus, Integer numero);
    void atualizarAssento(Integer id_assento, Integer id_onibus, Integer numero, boolean ocupado);
    void deletarAssento(Integer id_assento);
    ArrayList<Integer> buscarAssentos(Viagem viagem);
    void ocuparAssento(Integer id_assento);
}