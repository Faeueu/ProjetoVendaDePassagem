package Model.entities;

public class Onibus {
    protected Integer id_onibus;
    protected Viagem viagem;

    public Onibus(Integer id_onibus, Viagem viagem) {
        this.id_onibus = id_onibus;
        this.viagem = viagem;
    }

    public Integer getId_onibus() {
        return id_onibus;
    }

    public void setId_onibus(Integer id_onibus) {
        this.id_onibus = id_onibus;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    @Override
    public String toString() {
        return "Onibus{" +
                "id_onibus=" + id_onibus +
                ", viagem=" + viagem +
                '}';
    }
}
