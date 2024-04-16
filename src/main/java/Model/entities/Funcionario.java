package Model.entities;

public class Funcionario extends Pessoa{

    private int id_funcionario;


    public Funcionario(){
        super(null);
    }
    public Funcionario(String nome, int id_funcionario){
        super(nome);
        this.id_funcionario = id_funcionario;
    }


    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    @Override
    public String toString() {
        return "Funcionario{"
                + "nome='" + nome +
                ", funcionarioID='" + id_funcionario + '}';
    }
}
