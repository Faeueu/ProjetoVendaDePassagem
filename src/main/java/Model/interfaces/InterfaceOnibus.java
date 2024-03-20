package Model.interfaces;

public abstract class InterfaceOnibus {
    private String nome;
    private int nmrAssentos;
    private int codigoOnibus;

    public InterfaceOnibus(String nome, int nmrAssentos, int codigoOnibus){
        this.nome = nome;
        this.nmrAssentos = nmrAssentos;
        this.codigoOnibus = codigoOnibus;
    }

    public String getNome(){
        return this.nome;
    }

    public int getNmrAssentos(){
        return this.nmrAssentos;
    }

    public int getCodigoOnibus(){
        return this.codigoOnibus;
    }
}
