package Model.entities;

public class Motorista extends Funcionario {

    private String id_motorista;



    public Motorista(String nome, String id_motorista, int id_funcionario) {
        super(nome, id_funcionario);
        this.id_motorista = id_motorista;
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "id_motorista='" + id_motorista + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
