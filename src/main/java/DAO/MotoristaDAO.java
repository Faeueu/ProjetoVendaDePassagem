package DAO;

import db.ConexaoBD;
import Model.Interface.InterfaceMotoristaDAO;
import Model.entities.Cliente;
import Model.entities.Motorista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MotoristaDAO implements InterfaceMotoristaDAO {
    Connection conexaoMotorista;
    PreparedStatement pesquisaMotorista;
    ResultSet resultadoMotorista;

    public MotoristaDAO(Connection conexaoMotorista){
        this.conexaoMotorista = conexaoMotorista;
    }

    @Override
    public void adicionarMotorista(String nome, Integer id_onibus) {

        try {
            pesquisaMotorista = conexaoMotorista.prepareStatement("insert into motorista (nome, id_onibus)VALUES(?,?)");
            pesquisaMotorista.setString(1, nome);
            pesquisaMotorista.setInt(2, id_onibus);

            pesquisaMotorista.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar motorista: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaMotorista);

        }
    }

    @Override
    public void buscarMotorista(Integer id_motorista, Motorista motorista) {

        try{
            pesquisaMotorista = conexaoMotorista.prepareStatement("select * from motorista where id_motorista = ?");
            pesquisaMotorista.setInt(1, id_motorista);

            resultadoMotorista = pesquisaMotorista.executeQuery();
            resultadoMotorista.next();

            motorista.setId_motorista(resultadoMotorista.getInt("id_motorista"));
            motorista.setId_onibus(resultadoMotorista.getInt("id_onibus"));
            motorista.setNome(resultadoMotorista.getString("nome"));

            System.out.println(motorista);


        } catch (SQLException ex) {
            System.out.println("Erro ao buscar motorista: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaMotorista,resultadoMotorista);

        }
    }

    @Override
    public void atualizarMotorista(Integer id_motorista, Integer id_onibus, String nome) {

        try {
            pesquisaMotorista = conexaoMotorista.prepareStatement("update motorista set nome = ?, id_onibus = ? where id_motorista = ?");
            pesquisaMotorista.setString(1, nome);
            pesquisaMotorista.setInt(2, id_onibus);
            pesquisaMotorista.setInt(3, id_motorista);

            pesquisaMotorista.executeUpdate();

        }catch (SQLException ex) {
            System.out.println("Erro ao atualizar motorista: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaMotorista);

        }
    }

    @Override
    public void deletarMotorista(Integer id_motorista) {

        try{
            pesquisaMotorista = conexaoMotorista.prepareStatement("delete from motorista where id_motorista = ?");
            pesquisaMotorista.setInt(1, id_motorista);

            pesquisaMotorista.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao deletar motorista: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaMotorista);

        }
    }

    @Override
    public void listarMotorista() {

        try {
            pesquisaMotorista = conexaoMotorista.prepareStatement("select * from motorista");

            resultadoMotorista = pesquisaMotorista.executeQuery();

            while (resultadoMotorista.next()){
                Motorista motorista = new Motorista(0,"");
                motorista.setId_motorista(resultadoMotorista.getInt("id_motorista"));
                motorista.setNome(resultadoMotorista.getString("nome"));
                motorista.setId_onibus(resultadoMotorista.getInt("id_onibus"));

                System.out.println(motorista);

            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar motorista: " + ex);

        } finally {

            ConexaoBD.closeAcesso(pesquisaMotorista,resultadoMotorista);
        }
    }
}