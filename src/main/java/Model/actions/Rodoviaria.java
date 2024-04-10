package Model.actions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Model.entities.*;
import Model.enums.StatusViagem;
public class Rodoviaria {
    private ArrayList<Onibus> onibus;
    private ArrayList<Parada> viagens;
    private ArrayList<Cliente> clientes;
    private ArrayList<Venda> vendasAtivas;
    private ArrayList<Venda> vendasCanceladas;

    Scanner sc = new Scanner(System.in);

    public Rodoviaria(){
        this.vendasAtivas = vendasAtivas;
        this.vendasCanceladas = vendasCanceladas;
        this.onibus = new ArrayList<Onibus>();
        this.viagens = new ArrayList<Parada>();
        this.clientes = new ArrayList<Cliente>();
    }

    public void run() throws Exception{
        menu();
    }

    public ArrayList<Onibus> getOnibus(){
        return onibus;
    }

    public ArrayList<Parada> getViagens() {
        return viagens;
    }

    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    private void menu(){
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        while (continuar){
            try {
                System.out.println("Seja Bemvinda à Rodoviaria Cz");
                System.out.println(" ");
                System.out.println("Escolha uma opcao abaxio: ");
                System.out.println("1 - Parametros do sistema");
                System.out.println("2 - Parametros do cliente");
                System.out.println("3 - Parametros da viagem");
                System.out.println("4 - Relatorio");
                System.out.println("5 - Sair");
                System.out.println("Selecione uma opção: ");

                int opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        menuParametrosSistema();
                        break;

                    case 2:
                        menuCliente();

                        break;

                    case 3:
                        menuParametrosViagem();
                        break;

                    case 4:
                        menuRelatorios();
                        break;

                    default:
                        System.out.println("Certeza que deseja sair? (S/N)");
                        String resposta = sc.next();
                        if (resposta.equalsIgnoreCase("S")) {
                            continuar = false;
                        } else {
                            System.out.println("Voltando ao menu principal...");
                        }
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada inválida. Por favor, insira um número.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    private void menuParametrosSistema() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("=========== MENU DE PARÂMETROS DO SISTEMA ===========");
            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println(" 1 - Cadastrar Onibus");
            System.out.println(" 2 - Cadastrar Viagem");
            System.out.println(" 3 - Cadastrar Cliente");
            System.out.println(" 4 - Voltar");

            try {
                int escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        cadastrarOnibus();
                        break;
                    case 2:
                        cadastrarViagem();
                        break;
                    case 3:
                        cadastrarCliente();
                        break;
                    case 4:
                        menu();
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void cadastrarOnibus() throws Exception {

        System.out.println("Digite o código do Onibus: ");
        int codigoOnibus = sc.nextInt();
        sc.nextLine();
        if (verificarCodigoOnibus(codigoOnibus) == false) {
            System.out.println("Código inválido");
            menuParametrosSistema();
        }

        System.out.println("Digite o nome do Onibus: ");
        String nome = sc.nextLine();


        System.out.println("Digite a quantidade de assentos: ");
        int qtdAssentos = sc.nextInt();
        sc.nextLine();
        if (auxiliarQtdAssentos(qtdAssentos) == false) {
            System.out.println("Quantidade de assentos inválido");
            menuParametrosSistema();
        }

        onibus.add(new Onibus(codigoOnibus, nome, qtdAssentos));
        System.out.println("Onibus cadastrado com sucesso!");
    }

    private void cadastrarViagem() throws Exception {

        System.out.println("Digite o código do Onibus: ");
        int codigoOnibus = sc.nextInt();
        if (verificarDisponibilidade(codigoOnibus) == false) {
            System.out.println("Onibus indisponível");
            menuParametrosSistema();
        }

        System.out.println("Origem da viagem: ");
        String origem = sc.next();
        if (validarNome(origem) == false) {
            System.out.println("Origem inválida");
            menuParametrosSistema();
        }
        System.out.println("Destino da viagem: ");
        String destino = sc.next();
        if (validarNome(destino) == false) {
            System.out.println("Destino inválido");
            menuParametrosSistema();
        }
        System.out.println("Horário da viagem: [HH/MM]");
        String horario = sc.next();
        if (verificaHorario(horario) == false) {
            System.out.println("Horário inválido");
            menuParametrosSistema();
        }



        viagens.add(new Parada(origem, destino, horario, buscarOnibus(codigoOnibus)));
        System.out.println("Viagem cadastrada com sucesso!");
    }

    private void cadastrarCliente() throws Exception {
        System.out.println("Digite o nome do cliente: ");
        sc.nextLine();
        String nome = sc.nextLine();
        if (validarNome(nome) == false) {
            System.out.println("Nome inválido");
            menuParametrosSistema();
        }

        System.out.println("Digite o CPF do cliente: ");
        String cpf = sc.nextLine();
        cpf = adicionarCPF(cpf);

        System.out.println("Digite o telefone do cliente: ");
        String telefone = sc.nextLine();
        if (validarTelefone(telefone) == false) {
            System.out.println("Telefone inválido");
            menuParametrosSistema();
        }

        clientes.add(new Cliente(nome, cpf, telefone));
        System.out.println("Cliente cadastrado com sucesso!");
    }


    public void menuParametrosViagem() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("=========== MENU DE VIAGENS ===========");
            System.out.println(" 1 - Cancelar Viagem");
            System.out.println(" 2 - Confirmar Viagem");
            System.out.println(" 3 - Desconfirmar Viagem");
            System.out.println(" 4 - Listar Viagens");
            System.out.println(" 5 - Voltar");

            try {
                int escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        cancelarViagem();
                        break;
                    case 2:
                        confirmarViagem();
                        break;
                    case 3:
                        desconfirmarViagem();
                        break;
                    case 4:
                        if (viagens.isEmpty()) {
                            System.out.println("Não há voos cadastrados");
                        } else {
                            listarViagem();
                        }
                        break;
                    case 5:
                        menu();
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.nextLine();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }


    private void cancelarViagem() {
        System.out.println("Digite o código da viagem: ");
        String codigoViagem = sc.next();
        if (verificarCodigoViagem(codigoViagem) == false) {
            System.out.println("Código inválido");
            menuParametrosViagem();
        } else if (buscarViagem(codigoViagem).getStatus() == StatusViagem.CANCELADO) {
            System.out.println("Viagem já cancelado");
            menuParametrosViagem();
        }

        buscarViagem(codigoViagem).setStatus(StatusViagem.CANCELADO);
        viagens.remove(buscarViagem(codigoViagem));
        System.out.println("Viagem cancelada com sucesso!");
    }

    private void confirmarViagem() {
        System.out.println("Digite o código da viagem: ");
        String codigoViagem = sc.next();
        if (verificarCodigoViagem(codigoViagem) == false) {
            System.out.println("Código inválido");
            menuParametrosViagem();
        } else if (buscarViagem(codigoViagem).getStatus() == StatusViagem.CONFIRMADO) {
            System.out.println("Viagem já confirmado");
            menuParametrosViagem();
        } else if (buscarViagem(codigoViagem).getStatus() == StatusViagem.CANCELADO) {
            System.out.println("Viagem cancelada");
            menuParametrosViagem();
        }

        buscarViagem(codigoViagem).setStatus(StatusViagem.CONFIRMADO);
        System.out.println("Viagem confirmada com sucesso!");
    }

    private void desconfirmarViagem() {
        System.out.println("Digite o código da viagem: ");
        String codigoViagem = sc.next();
        if (verificarCodigoViagem(codigoViagem) == false) {
            System.out.println("Código inválido");
            menuParametrosViagem();
        } else if (buscarViagem(codigoViagem).getStatus() == StatusViagem.DESCONFIRMADO) {
            System.out.println("Viagem já desconfirmada");
            menuParametrosViagem();
        } else if (buscarViagem(codigoViagem).getStatus() == StatusViagem.CANCELADO) {
            System.out.println("Viagem cancelada");
            menuParametrosViagem();
        }

        buscarViagem(codigoViagem).setStatus(StatusViagem.DESCONFIRMADO);
        System.out.println("Viagem desconfirmada com sucesso!");
    }

    private void listarViagem() {
        for (int i = 0; i < viagens.size(); i++) {
            System.out.println(viagens.get(i).toString());
        }
    }

    private void menuRelatorios() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("=========== MENU DE RELATÓRIOS ===========");
            System.out.println(" 1 - Listar Onibus");
            System.out.println(" 2 - Listar Clientes");
            System.out.println(" 3 - Listar Vendas");
            System.out.println(" 4 - Listar Viagens");
            System.out.println(" 5 - Voltar");

            try {
                int escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        if (onibus.isEmpty()) {
                            System.out.println("Não há Onibus cadastrados");
                        } else {
                            listarOnibus();
                        }
                        break;
                    case 2:
                        if (clientes.isEmpty()) {
                            System.out.println("Não há clientes cadastrados");
                        } else {
                            listarClientes();
                        }
                        break;
                    case 3:
                        if (viagens.isEmpty()) {
                            System.out.println("Não há vendas cadastradas");
                        } else {
                            listarTodasVendas();
                        }
                        break;
                    case 4:
                        if (viagens.isEmpty()) {
                            System.out.println("Não há viagens cadastrados");
                        } else {
                            listarViagem();
                        }
                        break;
                    case 5:
                        menu();
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.nextLine();
            }
        }
    }

    private void listarTodasVendas() {
        if(vendasAtivas.isEmpty()){
            System.out.println("Não possui vendas ativas");
            return;
        }
        for (int i = 0; i < vendasAtivas.size(); i++) {
            System.out.println(vendasAtivas.get(i).toString() + " - VENDA ATIVA");
        }
        if(vendasCanceladas.isEmpty()){
            System.out.println("Não possui vendas canceladas");
            return;
        }
        for(int i = 0; i < vendasCanceladas.size(); i++) {
            System.out.println(vendasCanceladas.get(i).toString() + " - VENDA CANCELADA");
        }
    }


    private void listarOnibus() {
        for (int i = 0; i < onibus.size(); i++) {
            System.out.println(onibus.get(i).toString());
        }
    }

    private void listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i).toString());
        }
    }

    private void listarVendas() {
        for (int i = 0; i < viagens.size(); i++) {
            System.out.println(viagens.get(i).toString());
        }
    }

    private void menuCliente() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("=========== MENU DE CLIENTES ===========");
            System.out.println(" 1 - Comprar Passagem");
            System.out.println(" 2 - Cancelar Passagem");
            System.out.println(" 3 - Listar Viagens");
            System.out.println(" 4 - Voltar");

            try {
                int escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        comprarPassagem();
                        break;
                    case 2:
                        cancelarPassagem();
                        break;
                    case 3:
                        listarVendas();
                        break;
                    case 4:
                        menu();
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.nextLine();
            }
        }
    }


    private void comprarPassagem() {
        System.out.println("Digite o código da viagem: ");
        String codigoViagem = sc.next();
        if (verificarCodigoViagem(codigoViagem) == false) {
            System.out.println("Código inválido");
            menuCliente();
        } else if (buscarViagem(codigoViagem).getStatus() == StatusViagem.CANCELADO) {
            System.out.println("Viagem cancelada");
            menuCliente();
        } else if (buscarViagem(codigoViagem).getStatus() == StatusViagem.CONFIRMADO) {
            System.out.println("Viagem confirmada");
            menuCliente();
        } else if (buscarViagem(codigoViagem).getAssentosDisponiveis() < 0) {
            System.out.println("Não há assentos disponíveis");
            menuCliente();
        }

        System.out.println("Digite o CPF do cliente: ");
        String cpf = sc.next();
        if (clienteExiste(cpf) == false) {
            System.out.println("Cliente não existe");
            menuCliente();
        }

        buscarViagem(codigoViagem).decrementarAssentos();
        vendasAtivas.add(new Venda(buscarCliente(cpf), buscarViagem(codigoViagem)));
        System.out.println("Passagem comprada com sucesso!");
    }

    private void cancelarPassagem() {
        System.out.println("Digite o código da viagem: ");
        String codigoViagem = sc.next();
        if (verificarCodigoViagem(codigoViagem) == false) {
            System.out.println("Código inválido");
            menuCliente();
        } else if (buscarViagem(codigoViagem).getStatus() == StatusViagem.CANCELADO) {
            System.out.println("Viagem cancelada");
            menuCliente();
        } else if (buscarViagem(codigoViagem).getStatus() == StatusViagem.DESCONFIRMADO) {
            System.out.println("Viagem desconfirmada");
            menuCliente();
        }

        System.out.println("Digite o CPF do cliente: ");
        String cpf = sc.next();
        if (clienteExiste(cpf) == false) {
            System.out.println("Cliente não existe");
            menuCliente();
        }

        for (int i = 0; i < vendasAtivas.size(); i++) {
            if (vendasAtivas.get(i).getCliente().getCpf().equals(cpf)
                    && vendasAtivas.get(i).getViagem().getNmrViagem().equals(codigoViagem)) {
                vendasCanceladas.add(vendasAtivas.get(i));
                vendasAtivas.remove(i);
                buscarViagem(codigoViagem).decrementarAssentos();
                System.out.println("Passagem cancelada com sucesso!");
                menuCliente();
            }
        }

        buscarViagem(codigoViagem).decrementarAssentos();
        vendasAtivas.add(new Venda(buscarCliente(cpf), buscarViagem(codigoViagem)));
        System.out.println("Passagem comprada com sucesso!");
    }

    private Cliente buscarCliente(String cpf) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                return clientes.get(i);
            }
        }
        return null;
    }

    private boolean clienteExiste(String cpf) {
        if (clientes.isEmpty()) {
            return false;
        }
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    private Parada buscarViagem(String nmrViagem) {
        for (int i = 0; i < viagens.size(); i++) {
            if (viagens.get(i).getNmrViagem().equals(nmrViagem)) {
                return viagens.get(i);
            }
        }
        return null;
    }

    private boolean verificarCodigoViagem(String nmrViagem) {
        for (int i = 0; i < viagens.size(); i++) {
            if (viagens.get(i).getNmrViagem().equals(nmrViagem)) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarCodigoOnibus(int codigoOnibus) {
        for (int i = 0; i < onibus.size(); i++) {
            if (onibus.get(i).getCodigoOnibus() == codigoOnibus) {
                return false;
            }
        }
        return true;
    }

    private boolean auxiliarQtdAssentos(int qtdAssentos) {
        if (qtdAssentos > 0) {
            return true;
        }
        return false;
    }

    private boolean vericarValidadeCodigoOnibus(int codigoOnibus) {
        for (int i = 0; i < onibus.size(); i++) {
            if (onibus.get(i).getCodigoOnibus() == codigoOnibus) {
                return true;
            }
        }
        return false;
    }

    private Onibus buscarOnibus(int codigoOnibus) {
        for (int i = 0; i < onibus.size(); i++) {
            if (onibus.get(i).getCodigoOnibus() == codigoOnibus) {
                return onibus.get(i);
            }
        }
        return null;
    }

    private Boolean verificarDisponibilidade(int codigoOnibus) {
        Onibus onibus = buscarOnibus(codigoOnibus);
        if (onibus != null) {
            return onibus.getDisponibilidade();
        } else {
            return false;
        }
    }


    private boolean verificaHorario(String horario) {
        if (horario.length() == 5) {
            if (horario.charAt(2) == ':') {
                return true;
            }
        }
        return false;
    }

    private boolean validarNome(String nome) {
        for (int i = 0; i < nome.length(); i++) {
            if (Character.isLetter(nome.charAt(i)) == false && nome.charAt(i)!= ' ') {
                return false;
            }
        }

        if (nome.length() > 0) {
            return true;
        }
        return false;
    }

    private String adicionarCPF(String cpf) throws Exception {
        if(validarCPF(cpf) == false){
            System.out.println("CPF inválido");
            menuParametrosSistema();
        }
        if (clientes.isEmpty()) {
            return cpf;
        }

        if (validarCPF(cpf)) {
            if (!CPFDuplicado(cpf)) {
                return cpf;
            }
        }

        while (!validarCPF(cpf) || CPFDuplicado(cpf)) {
            System.out.println("CPF inválido ou já cadastrado!");
            System.out.println("Digite novamente o CPF: ");
            cpf = sc.nextLine();
        }
        return cpf;
    }

    private boolean CPFDuplicado(String cpf) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    private boolean validarCPF(String cpf) {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                cpf.length() != 11) {
            return false;
        }
        return true;
    }

    private boolean validarTelefone(String telefone) {
        for (int i = 0; i < telefone.length(); i++) {
            char c = telefone.charAt(i);
            if (Character.isLetter(c) == true) {
                return false;

            }
        }
        if (telefone.length() > 14 && telefone.length() < 8) {
            return false;
        }
        return true;
    }
}