package Model.entities;

public class Passagem {

    private String passagemID;
    private Rota rota;
    private Onibus onibus;
    private String destino;

    public Passagem(String passagemID, Rota rota, Onibus onibus, String destino) {
        this.passagemID = passagemID;
        this.rota = rota;
        this.onibus = onibus;
        this.destino = destino;
    }

    public String getPassagemID() {
        return passagemID;
    }

    public Rota getRota() {
        return rota;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPassagemID(String passagemID) {
        this.passagemID = passagemID;
    }

    @Override
    public String toString() {
        return "Passagem{" +
                "passagemID='" + passagemID + '\'' +
                ", rota=" + rota +
                ", onibus=" + onibus +
                ", destino='" + destino + '\'' +
                '}';
    }
}
