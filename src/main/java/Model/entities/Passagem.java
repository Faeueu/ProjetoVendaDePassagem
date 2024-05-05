package Model.entities;

public class Passagem {
    protected Integer id_passagem, id_cliente, id_onibus, id_viagem, id_assento;

    public Passagem(Integer id_cliente, Integer id_onibus, Integer id_viagem, Integer id_assento) {
        this.id_cliente = id_cliente;
        this.id_onibus = id_onibus;
        this.id_viagem = id_viagem;
        this.id_assento = id_assento;
    }

    public Integer getId_passagem() {
        return id_passagem;
    }

    public void setId_passagem(Integer id_passagem) {
        this.id_passagem = id_passagem;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_onibus() {
        return id_onibus;
    }

    public void setId_onibus(Integer id_onibus) {
        this.id_onibus = id_onibus;
    }

    public Integer getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(Integer id_viagem) {
        this.id_viagem = id_viagem;
    }

    public Integer getId_assento() {
        return id_assento;
    }

    public void setId_assento(Integer id_assento) {
        this.id_assento = id_assento;
    }
}
