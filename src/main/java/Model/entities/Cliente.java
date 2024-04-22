package Model.entities;


public class Cliente extends Pessoa {

    private int id_cliente;
    protected String cpf;
    protected String telefone;
    protected String email;

    public Cliente(){
        super(null);
    }

    public Cliente(String nome, int id_cliente, String cpf, String telefone, String email) {
        super(nome);
        this.id_cliente = id_cliente;
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

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
