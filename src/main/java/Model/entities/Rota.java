package Model.entities;

public class Rota {
    private String rotaID;
    private Parada inicio;
    private Parada fim;
    private Onibus onibus;

    public Rota(String rotaID, Parada inicio, Parada fim, Onibus onibus) {
        this.rotaID = rotaID;
        this.inicio = inicio;
        this.fim = fim;
        this.onibus = onibus;
    }

    public String getRotaID() {
        return rotaID;
    }

    public void setRotaID(String rotaID) {
        this.rotaID = rotaID;
    }

    public Parada getInicio() {
        return inicio;
    }

    public void setInicio(Parada inicio) {
        this.inicio = inicio;
    }

    public Parada getFim() {
        return fim;
    }

    public void setFim(Parada fim) {
        this.fim = fim;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    //Removi o set de onibus

    @Override
    public String toString() {
        return "Rota{" +
                "rotaID='" + rotaID + '\'' +
                ", inicio=" + inicio +
                ", fim=" + fim +
                ", onibus= "  + onibus +
                '}';
    }
}
