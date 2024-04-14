package Model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parada {

    private final String rotaID;
    private String cidade;
    private String proxima;


    public Parada(String rotaID, String cidade, String proxima, LocalDateTime date) {

        this.rotaID = rotaID;
        this.cidade = cidade;
        this.proxima = proxima;
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


    @Override
    public String toString() {
        return "Rota{" +
                ", rotaID='" + rotaID + '\'' +
                ", cidade='" + cidade + '\'' +
                ", proxima='" + proxima + '\'' +
                '}';
    }
}
