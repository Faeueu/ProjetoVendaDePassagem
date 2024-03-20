package Model.entities;

import java.util.Scanner;
import java.util.Random;
import Model.enums.StatusViagem;
public class Viagem {
    Scanner sc = new Scanner(System.in);

    private String origem;
    private String destino;
    private String horario;
    private Onibus onibus;
    private String nmrViagem;
    private int assentosDisponiveis;
    private StatusViagem status;

    public Onibus getOnibus(){
        return onibus;
    }

    public String getNmrViagem(){
        return nmrViagem;
    }

    public String getHorario(){
        return horario;
    }

    public String getDestino(){
        return destino;
    }

    public String getOrigem(){
        return origem;
    }

    public StatusViagem getStatus(){
        return status;
    }

    public void setStatus(StatusViagem status){
        this.status = status;
    }

    public int getAssentosDisponiveis(){
        return assentosDisponiveis;
    }

    public void decrementarAssentos(){
        assentosDisponiveis --;
    }

    public Viagem (String origem, String destino, String horario, Onibus onibus) throws Exception {
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.onibus = onibus;
        assentosDisponiveis = onibus.getNmrAssentos();
        nmrViagem = gerarNmrViagem();
        status = StatusViagem.DESCONFIRMADO;
    }

    private String gerarNmrViagem(){
        Random numero = new Random();
        StringBuilder geradorString = new StringBuilder();

        for(int i=0; i<5; i++){
            int digit = numero.nextInt(10);
            geradorString.append(digit);
        }
        String codigoViagem = geradorString.toString();
        return codigoViagem;
    }

    @Override
    public String toString() {
        return "Viagem -> Origem = " + origem
                + ", Destino = " + destino
                + ", Horario = " + horario
                + " Número da Viagem = [ " + nmrViagem
                + " ]";
    }
}
