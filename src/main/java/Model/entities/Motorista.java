package Model.entities;

public class Motorista {
    protected Integer id_motorista, id_onibus;
    protected String nome;

    public Motorista(Integer id_onibus, String nome) {
        this.id_onibus = id_onibus;
        this.nome = nome;
    }

    public Integer getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(Integer id_motorista) {
        this.id_motorista = id_motorista;
    }

    public Integer getId_onibus() {
        return id_onibus;
    }

    public void setId_onibus(Integer id_onibus) {
        this.id_onibus = id_onibus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "id_motorista=" + id_motorista +
                ", id_onibus=" + id_onibus +
                ", nome='" + nome + '\'' +
                '}';
    }
}
