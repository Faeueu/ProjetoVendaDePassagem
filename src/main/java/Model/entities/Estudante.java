package Model.entities;

public class Estudante extends Cliente{


    private int carteiraEstudante;

    public Estudante(String nome, int id_cliente, String cpf, String telefone, String email, int carteiraEstudante) {
        super(nome, id_cliente, cpf, telefone, email);
        this.carteiraEstudante = carteiraEstudante;
    }


    public int getCarteiraEstudante() {
        return carteiraEstudante;
    }

    public void setCarteiraEstudante(int carteiraEstudante) {
        this.carteiraEstudante = carteiraEstudante;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
