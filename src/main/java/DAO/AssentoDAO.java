package DAO;

import db.ConexaoBD;
import Model.Interface.InterfaceAssentoDAO;
import Model.entities.Assento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void buscarAssento(Integer id_assento){

        try{
            pesquisaAssento = conexaoAssento.prepareStatement("select * from assento where id_assento = ?");
            pesquisaAssento.setInt(1, id_assento);

            resultadoAssento = pesquisaAssento.executeQuery();
            resultadoAssento.next();

            Assento assento = new Assento(0,0,0,false);
            assento.setId_assento(resultadoAssento.getInt("id_assento"));
            assento.setId_onibus(resultadoAssento.getInt("id_onibus"));
            assento.setNumero(resultadoAssento.getInt("numero"));
            assento.setOcupado(resultadoAssento.getBoolean("ocupado"));

            System.out.println(assento);

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar assento: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaAssento,resultadoAssento);

        }
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
}
