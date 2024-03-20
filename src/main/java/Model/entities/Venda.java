package Model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
public class Venda {
    private String horarioCompra;
    private Cliente cliente;
    private Viagem viagem;

    public Cliente getCliente(){
        return cliente;
    }

    public Viagem getViagem(){
        return viagem;
    }

    public Venda(Cliente cliente, Viagem viagem){
        this.cliente = cliente;
        this.viagem = assentosDisponiveis(viagem);
        this.horarioCompra = obterHorarioAtual();
        imprimirVenda();
    }

    @Override
    public String toString(){
        System.out.println("Dados do Cliente: " + "Nome = [" + cliente.getNome() + "], CPF = [" + cliente.getCpf() + "]");
        System.out.println("Dados da Viagem: " + "Numero = [" + viagem.getNmrViagem() + "], Origem = ["+ viagem.getOrigem() + " ], Destino = [" + viagem.getDestino() + "], Horario = [" + viagem.getHorario() + "]");
        System.out.println("Horario da Compra = [" + horarioCompra + "]");
        return "==========================================";
    }

    private Viagem assentosDisponiveis(Viagem viagem){
        if(viagem.getAssentosDisponiveis() > 0){
            return viagem;
        } else {
            System.out.println("Sem assentos disponiveis!!");
            return null;
        }
    }

    public static String obterHorarioAtual(){
        String data = LocalDateTime.now().toString().substring(0, 9);
        String hora = LocalDateTime.now().toString().substring(11, 19);
        String HorarioAtual = data + " | " + hora;
        return HorarioAtual;
    }

    private void imprimirVenda() {
        System.out.println("========= VENDA CONFIRMADA ========== ");
        System.out.println("Venda Número: " + this.viagem.getNmrViagem());
        System.out.println("Origem: " + this.viagem.getOrigem());
        System.out.println("Destino: " + this.viagem.getDestino());
        System.out.println("Horario da Venda: " + this.viagem.getHorario());
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("=====================================");
    }

}
