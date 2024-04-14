package Model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Onibus {

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
    private final String onibusID;
    private Integer capacidadeMaxiama;
    private Motorista motorista;
    private LocalDateTime horario;

    public Onibus(String onibusID, Integer capacidadeMaxiama, Motorista motorista,LocalDateTime horario){
        this.onibusID = onibusID;
        this.capacidadeMaxiama = capacidadeMaxiama;
        this.motorista = motorista;
        this.horario = horario;
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

    //Removi o set de motorista

    public LocalDateTime getHorario(){return horario;}

    public void setHorario(LocalDateTime horario){this.horario = horario;}

    @Override
    public String toString() {
        return "Onibus{" +
                "onibusID='" + onibusID + '\'' +
                ", capacidadeMaxiama=" + capacidadeMaxiama +
                ", motorista=" + motorista +
                '}';
    }
}
