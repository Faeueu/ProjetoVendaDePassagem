package Model.entities;

public class Motorista extends Funcionario {

    public Motorista(String nome, String motoristaID) {
        super(nome, motoristaID);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "funcionarioID='" + funcionarioID + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
