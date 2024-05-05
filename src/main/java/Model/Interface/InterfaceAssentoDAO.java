package Model.Interface;

public interface InterfaceAssentoDAO  {
    void adicionarAssento(Integer id_onibus, Integer numero, boolean ocupado);
    void buscarAssento(Integer id_assento);
    void atualizarAssento(Integer id_assento, Integer id_onibus, Integer numero, boolean ocupado);
    void deletarAssento(Integer id_assento);
}
