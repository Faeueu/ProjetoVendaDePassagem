package Model.entities;

public class Assento {
    protected Integer id_assento, id_onibus, numero;
    protected boolean ocupado;

    public Assento(Integer id_assento, Integer id_onibus, Integer numero, boolean ocupado) {
        this.id_assento = id_assento;
        this.id_onibus = id_onibus;
        this.numero = numero;
        this.ocupado = ocupado;
    }

    public Integer getId_assento() {
        return id_assento;
    }

    public void setId_assento(Integer id_assento) {
        this.id_assento = id_assento;
    }

    public Integer getId_onibus() {
        return id_onibus;
    }

    public void setId_onibus(Integer id_onibus) {
        this.id_onibus = id_onibus;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Assento{" +
                "id_assento=" + id_assento +
                ", id_onibus=" + id_onibus +
                ", numero=" + numero +
                ", ocupado=" + ocupado +
                '}';
    }
}
