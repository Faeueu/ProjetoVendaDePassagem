package Model.entities;

public class Funcionario extends Pessoa{

    protected String funcionarioID;

    public Funcionario(String nome, String funcionarioID){
        super(nome);
        this.funcionarioID = funcionarioID;
    }

    public String getFuncionarioID() {
        return funcionarioID;
    }

    //Removi o set até pq o ID em tese nunca muda

    @Override
    public String toString() {
        return "Funcionario{" + "nome='" + nome +
                ", funcionarioID='" + funcionarioID + '}';
    }
}
