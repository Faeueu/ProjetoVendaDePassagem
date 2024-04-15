package Model.entities;


public class Cliente extends Pessoa {

    private int id_paciente;
    protected String cpf;
    protected String telefone;
    protected String email;

    public Cliente(){
        super(null);
    }

    public Cliente(String nome, int id_paciente, String cpf, String telefone, String email) {
        super(nome);
        this.id_paciente = id_paciente;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_paciente=" + id_paciente +

                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
