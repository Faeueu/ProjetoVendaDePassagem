package Model.entities;

public class Onibus {
    private final String onibusID;
    private Integer capacidadeMaxiama;
    private Motorista motorista;

    public Onibus(String onibusID, Integer capacidadeMaxiama, Motorista motorista){
        this.onibusID = onibusID;
        this.capacidadeMaxiama = capacidadeMaxiama;
        this.motorista = motorista;
    }

    public String getOnibusID() {
        return onibusID;
    }

    public Integer getCapacidadeMaxiama() {
        return capacidadeMaxiama;
    }

    public void setCapacidadeMaxiama(Integer capacidadeMaxiama) {
        this.capacidadeMaxiama = capacidadeMaxiama;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    @Override
    public String toString() {
        return "Onibus{" +
                "onibusID='" + onibusID + '\'' +
                ", capacidadeMaxiama=" + capacidadeMaxiama +
                ", motorista=" + motorista +
                '}';
    }
}
