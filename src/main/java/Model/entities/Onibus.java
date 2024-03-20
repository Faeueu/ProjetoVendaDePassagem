package Model.entities;

import Model.interfaces.InterfaceOnibus;

public class Onibus extends InterfaceOnibus{
    private boolean disponibilidade = true;

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Onibus(int codigoOnibus, String nome, int nmrAssentos){
        super(nome, nmrAssentos, codigoOnibus);
        disponibilidade = true;
    }

    @Override
    public String toString(){
        return "Onibus [ Codigo = " + getCodigoOnibus()
                + ", Nome = " + getNome()
                + ", Quantidade de Assentos = " + getNmrAssentos()
                + " onibusDisponivel =  " + disponibilidade
                + " ]";
    }

    public boolean getDisponibilidade(){
        return disponibilidade;
    }
}
