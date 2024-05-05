package DAO;

import db.ConexaoBD;
import Model.Interface.InterfacePassagemDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassagemDAO implements InterfacePassagemDAO{
    Connection conexaoPassagem;
    PreparedStatement pesquisaPassagem;
    ResultSet resultadoPassagem;
    public PassagemDAO(Connection conexaoPassagem){
        this.conexaoPassagem = conexaoPassagem;
    }


    void ocuparAssento(Integer id_assento){

        try {
            pesquisaPassagem = conexaoPassagem.prepareStatement("update assento set ocupado = ? where id_assento = ?");
            pesquisaPassagem.setBoolean(1, true);
            pesquisaPassagem.setInt(2, id_assento);

            pesquisaPassagem.executeUpdate();

        }catch (SQLException ex) {
            System.out.println("Erro ao atualizar assento: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaPassagem);

        }
    }
    @Override
    public void adicionarPassagem(Integer id_cliente, Integer id_onibus, Integer id_viagem, Integer id_assento){
        ocuparAssento(id_assento);

        try {
            pesquisaPassagem = conexaoPassagem.prepareStatement("insert into passagem (id_cliente, id_onibus, id_viagem, id_assento) values (?,?,?,?)");
            pesquisaPassagem.setInt(1, id_cliente);
            pesquisaPassagem.setInt(2, id_onibus);
            pesquisaPassagem.setInt(3, id_viagem);
            pesquisaPassagem.setInt(4, id_assento);

            pesquisaPassagem.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar passagem: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaPassagem);

        }
    }

    @Override
    public void buscarPassagem(Integer id_passagem){

        try {
            pesquisaPassagem = conexaoPassagem.prepareStatement("select passagem.id_passagem, passagem.id_onibus, passagem.id_cliente, viagem.*, assento.numero from passagem join cliente on passagem.id_cliente = cliente.id_cliente join viagem on passagem.id_viagem = viagem.id_viagem  join assento on passagem.id_assento = assento.id_assento  where passagem.id_passagem = ?");
            pesquisaPassagem.setInt(1, id_passagem);

            resultadoPassagem = pesquisaPassagem.executeQuery();
            resultadoPassagem.next();

            System.out.println("Passagem = " + resultadoPassagem.getInt("passagem.id_passagem")
                    + ", Onibus = " + resultadoPassagem.getInt("passagem.id_onibus")
                    + ", Numero assento = " +  resultadoPassagem.getInt("assento.numero")
                    + ", Cliente = " + resultadoPassagem.getInt("passagem.id_cliente")
                    + ", Viagem = " + resultadoPassagem.getInt("viagem.id_viagem")
                    + ", Origem = " + resultadoPassagem.getString("viagem.origem")
                    + ", HorarioSaida + " + resultadoPassagem.getString("viagem.horarioSaida")
                    + ", Destino = " + resultadoPassagem.getString("viagem.destino")
                    + ", HorarioChegada = " + resultadoPassagem.getString("viagem.horarioChegada"));

        } catch (SQLException e){
            System.out.println("Erro ao listar passagens " + e);

        }finally {
            ConexaoBD.closeAcesso(pesquisaPassagem,resultadoPassagem);

        }
    }

    @Override
    public void atualizarPassagem(Integer id_passagem, Integer id_cliente, Integer id_onibus, Integer id_viagem, Integer id_assento) {
        ocuparAssento(id_assento);

        try {
            pesquisaPassagem = conexaoPassagem.prepareStatement("update passagem set id_cliente = ?, id_onibus = ?, id_viagem = ?, id_assento = ? where id_passagem = ?");
            pesquisaPassagem.setInt(1, id_cliente);
            pesquisaPassagem.setInt(2, id_onibus);
            pesquisaPassagem.setInt(3, id_viagem);
            pesquisaPassagem.setInt(4, id_assento);
            pesquisaPassagem.setInt(5, id_passagem);

            pesquisaPassagem.executeUpdate();

        }catch (SQLException ex) {
            System.out.println("Erro ao atualizar passagem: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaPassagem);

        }
    }

    @Override
    public void deletarPassagem(Integer id_passagem){

        try{
            pesquisaPassagem = conexaoPassagem.prepareStatement("delete from passagem where id_passagem = ?");
            pesquisaPassagem.setInt(1, id_passagem);

            pesquisaPassagem.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar passagem: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaPassagem);

        }
    }

    @Override
    public void listarPassagensCliente(Integer id_cliente) {

        try {
            pesquisaPassagem = conexaoPassagem.prepareStatement("select passagem.id_passagem, passagem.id_onibus, cliente.id_cliente, viagem.*, assento.numero from passagem join cliente on passagem.id_cliente = cliente.id_cliente join viagem on passagem.id_viagem = viagem.id_viagem  join assento on passagem.id_assento = assento.id_assento  where cliente.id_cliente = ?");
            pesquisaPassagem.setInt(1, id_cliente);

            resultadoPassagem = pesquisaPassagem.executeQuery();

            while (resultadoPassagem.next()){
                System.out.println("Passagem = " + resultadoPassagem.getInt("passagem.id_passagem")
                        + ", Onibus = " + resultadoPassagem.getInt("passagem.id_onibus")
                        + ", Numero assento = " +  resultadoPassagem.getInt("assento.numero")
                        + ", Cliente = " + resultadoPassagem.getInt("cliente.id_cliente")
                        + ", Viagem = " + resultadoPassagem.getInt("viagem.id_viagem")
                        + ", Origem = " + resultadoPassagem.getString("viagem.origem")
                        + ", HorarioSaida + " + resultadoPassagem.getString("viagem.horarioSaida")
                        + ", Destino = " + resultadoPassagem.getString("viagem.destino")
                        + ", HorarioChegada = " + resultadoPassagem.getString("viagem.horarioChegada"));

            }
        } catch (SQLException e){
            System.out.println("Erro ao listar passagens " + e);

        }finally {
            ConexaoBD.closeAcesso(pesquisaPassagem,resultadoPassagem);

        }
    }
}