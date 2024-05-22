package DAO;
import db.ConexaoBD;
import Model.Interface.InterfaceOnibusDAO;
import Model.entities.Assento;
import Model.entities.Onibus;
import Model.entities.Viagem;

import java.lang.runtime.ObjectMethods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OnibusDAO implements InterfaceOnibusDAO {
    Connection conexaoOnibus;
    PreparedStatement pesquisaOnibus;
    ResultSet resultadoOnibus;

    public OnibusDAO(Connection conexaoOnibus){
        this.conexaoOnibus = conexaoOnibus;
    }

    public boolean verificarId_viagem(Integer id_viagem, Boolean valor){

        try {
            pesquisaOnibus = conexaoOnibus.prepareStatement("select * from viagem where id_viagem = ?");
            pesquisaOnibus.setInt(1, id_viagem);

            resultadoOnibus = pesquisaOnibus.executeQuery();

            if(resultadoOnibus.next()){
                valor = true;
                System.out.println("A viagem existe");

            }
            else {
                valor = false;

            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar viagem! " + e);

        } finally {

            ConexaoBD.closeAcesso(pesquisaOnibus,resultadoOnibus);

        }

        return valor;
    }

    @Override
    public void adicionarOnibus(Integer id_viagem){
        boolean valor = false;
        boolean teste = verificarId_viagem(id_viagem, valor);
        if(teste){

            try {
                pesquisaOnibus = conexaoOnibus.prepareStatement("insert into onibus (id_viagem) values (?)");
                pesquisaOnibus.setInt(1, id_viagem);

                pesquisaOnibus.executeUpdate();

            } catch (SQLException ex) {
                System.out.println("Erro ao adicionar onibus: " + ex);

            } finally {
                ConexaoBD.closeAcesso(pesquisaOnibus);

            }
        } else{
            System.out.println("Viagem invalida!");

        }

    }

    @Override
    public Integer buscarOnibus(Integer id_viagem){

        Integer id_onibus = null;

        try{
            pesquisaOnibus = conexaoOnibus.prepareStatement("SELECT \n" +
                    "    onibus.id_onibus\n" +
                    "FROM \n" +
                    "    onibus\n" +
                    "JOIN \n" +
                    "    viagem ON onibus.id_viagem = viagem.id_viagem\n" +
                    "WHERE \n" +
                    "    viagem.id_viagem = ?");

            pesquisaOnibus.setInt(1, id_viagem);

            resultadoOnibus = pesquisaOnibus.executeQuery();
            resultadoOnibus.next();

            id_onibus = resultadoOnibus.getInt("onibus.id_onibus");

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar onibus: " + ex);

        } finally {

            ConexaoBD.closeAcesso(pesquisaOnibus,resultadoOnibus);
        }
        return id_onibus;

    }

    @Override
    public void atualizarOnibus(Integer id_onibus, Integer id_viagem) {

        try {
            pesquisaOnibus = conexaoOnibus.prepareStatement("update onibus set id_viagem = ? where id_onibus = ?");
            pesquisaOnibus.setInt(1, id_viagem);
            pesquisaOnibus.setInt(2, id_onibus);

            pesquisaOnibus.executeUpdate();

        }catch (SQLException ex) {
            System.out.println("Erro ao atualizar onibus: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaOnibus);

        }
    }

    @Override
    public void deletarOnibus(Integer id_onibus){

        try{
            pesquisaOnibus = conexaoOnibus.prepareStatement("delete from onibus where id_onibus = ?");
            pesquisaOnibus.setInt(1, id_onibus);

            pesquisaOnibus.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar onibus: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaOnibus);

        }
    }
}