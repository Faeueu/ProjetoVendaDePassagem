package Model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parada {

    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
    private final String rotaID;
    private String cidade;
    private String proxima;
    private LocalDateTime date;

    public Parada(DateTimeFormatter formatoHora, String rotaID, String cidade, String proxima, LocalDateTime date) {
        this.formatoHora = formatoHora;
        this.rotaID = rotaID;
        this.cidade = cidade;
        this.proxima = proxima;
        this.date = date;
    }

    public DateTimeFormatter getFormatoHora() {
        return formatoHora;
    }

    public void setFormatoHora(DateTimeFormatter formatoHora) {
        this.formatoHora = formatoHora;
    }

    public String getRotaID() {
        return rotaID;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getProxima() {
        return proxima;
    }

    public void setProxima(String proxima) {
        this.proxima = proxima;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Rota{" +
                "formatoHora=" + formatoHora +
                ", rotaID='" + rotaID + '\'' +
                ", cidade='" + cidade + '\'' +
                ", proxima='" + proxima + '\'' +
                ", date=" + date +
                '}';
    }
}
