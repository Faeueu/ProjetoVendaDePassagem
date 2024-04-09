package Model.entities;

public class Motorista extends Pessoa {

    private final String Id;
    public Motorista(String nome, String id) {
        super(nome);
        this.Id = id;
    }
}
