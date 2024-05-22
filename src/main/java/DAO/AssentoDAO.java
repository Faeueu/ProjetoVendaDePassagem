package DAO;

import Model.entities.Viagem;
import db.ConexaoBD;
import Model.Interface.InterfaceAssentoDAO;
import Model.entities.Assento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssentoDAO implements InterfaceAssentoDAO {
    Connection conexaoAssento;
    PreparedStatement pesquisaAssento;
    ResultSet resultadoAssento;

    public AssentoDAO(Connection conexaoAssento){
        this.conexaoAssento = conexaoAssento;
    }

    @Override
    public void adicionarAssento(Integer id_onibus, Integer numero, boolean ocupado){

        try {
            pesquisaAssento = conexaoAssento.prepareStatement("insert into assento (id_onibus, numero, ocupado) VALUES (?,?,?);");
            pesquisaAssento.setInt(1,id_onibus);
            pesquisaAssento.setInt(2, numero);
            pesquisaAssento.setBoolean(3, ocupado);

            pesquisaAssento.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar assento: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaAssento);

        }
    }

    @Override
    public Integer buscarAssento(Integer id_onibus, Integer numero){

        Integer id_assento = null;

        try{
            pesquisaAssento = conexaoAssento.prepareStatement("SELECT \n" +
                    "    assento.id_assento\n" +
                    "FROM \n" +
                    "    assento\n" +
                    "JOIN \n" +
                    "    onibus ON onibus.id_onibus = assento.id_onibus\n" +
                    "WHERE \n" +
                    "    onibus.id_onibus = ? and assento.numero = ?;");

            pesquisaAssento.setInt(1, id_onibus);
            pesquisaAssento.setInt(2, numero);

            resultadoAssento = pesquisaAssento.executeQuery();
            resultadoAssento.next();

            id_assento = resultadoAssento.getInt("assento.id_assento");

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar assento: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaAssento,resultadoAssento);

        }
        return id_assento;

    }

    @Override
    public void atualizarAssento(Integer id_assento, Integer id_onibus, Integer numero, boolean ocupado){

        try {
            pesquisaAssento = conexaoAssento.prepareStatement("update assento set id_onibus = ?, numero = ?, ocupado = ? where id_assento = ?");
            pesquisaAssento.setInt(1,id_onibus);
            pesquisaAssento.setInt(2, numero);
            pesquisaAssento.setBoolean(3, ocupado);
            pesquisaAssento.setInt(4, id_assento);

            pesquisaAssento.executeUpdate();

        }catch (SQLException ex) {
            System.out.println("Erro ao atualizar assento: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaAssento);

        }
    }

    @Override
    public void atualizarAssento(Integer id_assento) {

        try {
            pesquisaAssento = conexaoAssento.prepareStatement("UPDATE assento set ocupado = true where id_assento = ?");
            pesquisaAssento.setInt(1,id_assento);

            pesquisaAssento.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar assento: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaAssento);

        }
    }

    @Override
    public void deletarAssento(Integer id_assento) {

        try{
            pesquisaAssento = conexaoAssento.prepareStatement("delete from assento where id_assento = ?");
            pesquisaAssento.setInt(1, id_assento);

            pesquisaAssento.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar assento: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaAssento);

        }
    }

    @Override
    public ArrayList<Integer> buscarAssentos(Viagem viagem) {

        ArrayList<Integer> assentos = new ArrayList<>();

        try{
            pesquisaAssento = conexaoAssento.prepareStatement("SELECT \n" +
                    "    assento.numero\n" +
                    "FROM \n" +
                    "    assento\n" +
                    "JOIN \n" +
                    "    onibus ON assento.id_onibus = onibus.id_onibus\n" +
                    "JOIN \n" +
                    "    viagem ON onibus.id_viagem = viagem.id_viagem\n" +
                    "WHERE \n" +
                    "    viagem.id_viagem = ? and assento.ocupado = false;");

            pesquisaAssento.setInt(1, viagem.getId_viagem());

            resultadoAssento = pesquisaAssento.executeQuery();

            while(resultadoAssento.next()) {
                assentos.add(resultadoAssento.getInt("assento.numero"));

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar assento: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaAssento,resultadoAssento);

        }
        return assentos;

    }
}
