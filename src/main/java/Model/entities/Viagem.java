package Model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Viagem {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    protected Integer id_viagem;
    protected String origem, horaSaida, destino, horaChegada;
    protected LocalDateTime horarioSaida, horarioChegada;

    public Viagem( String origem, String destino, String horaSaida, String horaChegada) {
        this.origem = origem;
        this.horarioSaida = LocalDateTime.parse(horaSaida, formato);
        this.destino = destino;
        this.horarioChegada = LocalDateTime.parse(horaChegada, formato);
    }

    public DateTimeFormatter getFormato() {
        return formato;
    }

    public void setFormato(DateTimeFormatter formato) {
        this.formato = formato;
    }

    public Integer getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(Integer id_viagem) {
        this.id_viagem = id_viagem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public LocalDateTime getHorarioChegada() {
        return horarioChegada;
    }

    public void setHorarioChegada(LocalDateTime horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id_viagem='" + id_viagem + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", horarioSaida=" + horarioSaida.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) +
                ", horarioChegada=" + horarioChegada.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) +
                '}';
    }
}
