package DAO;

import Model.entities.Passagem;
import db.ConexaoBD;
import Model.Interface.InterfaceViagemDAO;
import Model.entities.Viagem;
import java.sql.*;
import java.time.LocalDateTime;

public class ViagemDAO implements InterfaceViagemDAO {
    Connection conexaoviagem;
    PreparedStatement pesquisaViagem;
    ResultSet resultadoViagem;

    public ViagemDAO(Connection conexaoviagem){
        this.conexaoviagem = conexaoviagem;
    }

    @Override
    public void adicionarViagem(String origem, String horarioSaida, String destino, String horarioChegada){

        try {
            pesquisaViagem = conexaoviagem.prepareStatement("insert into viagem (origem, horarioSaida, destino, horarioChegada)values(?,?,?,?)");
            pesquisaViagem.setString(1, origem);
            pesquisaViagem.setObject(2, horarioSaida);
            pesquisaViagem.setString(3, destino);
            pesquisaViagem.setObject(4, horarioChegada);

            pesquisaViagem.executeUpdate();

        }catch (SQLException e){
            System.out.println("Erro ao adicionar viagem! " + e);

        } finally {
            ConexaoBD.closeAcesso(pesquisaViagem);

        }
    }

    @Override
    public Viagem buscarViagem(String Origem, String horarioSaida, String Destino, String horarioChegada){

        Viagem viagem = new Viagem(Origem,horarioSaida,Destino,horarioChegada);

        try {
            pesquisaViagem = conexaoviagem.prepareStatement("select * from viagem where Origem = ? and horarioSaida = ? and Destino = ? and horarioChegada = ?");
            pesquisaViagem.setString(1, Origem);
            pesquisaViagem.setObject(2, horarioSaida);
            pesquisaViagem.setString(3, Destino);
            pesquisaViagem.setObject(4, horarioChegada);

            resultadoViagem = pesquisaViagem.executeQuery();
            resultadoViagem.next();

            viagem.setId_viagem(resultadoViagem.getInt("id_viagem"));

        } catch (SQLException e) {
            System.out.println("Erro ao buscar viagem! " + e);

        } finally {
            ConexaoBD.closeAcesso(pesquisaViagem,resultadoViagem);

        }
        return viagem;

    }

    @Override
    public void atualizarViagem(Integer id_viagem, String origem, String horarioSaida, String destino, String horarioChegada){

        try {
            pesquisaViagem = conexaoviagem.prepareStatement("update viagem set origem = ?, horarioSaida = ?, destino = ?, horarioChegada = ? where id_viagem = ?");
            pesquisaViagem.setString(1, origem);
            pesquisaViagem.setObject(2, horarioSaida);
            pesquisaViagem.setString(3, destino);
            pesquisaViagem.setObject(4, horarioChegada);
            pesquisaViagem.setInt(5, id_viagem);

            pesquisaViagem.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar viagem" + e);

        }finally {
            ConexaoBD.closeAcesso(pesquisaViagem);
        }
    }

    @Override
    public void deletarViagem(Integer id_viagem){

        try {
            pesquisaViagem = conexaoviagem.prepareStatement("delete from viagem where id_viagem = ?");
            pesquisaViagem.setInt(1, id_viagem);

            pesquisaViagem.executeUpdate();

        }catch (SQLException e){
            System.out.println("Erro ao deletar viagem! " + e);

        } finally {
            ConexaoBD.closeAcesso(pesquisaViagem);

        }
    }

    @Override
    public Passagem locarPassagem(Integer id_viagem, Integer numero) {


        return null;
    }

    @Override
    public void listarviagens() {

        try {
            pesquisaViagem = conexaoviagem.prepareStatement("select * from viagem");

            resultadoViagem = pesquisaViagem.executeQuery();

            while (resultadoViagem.next()){

                Viagem viagem = new Viagem("","","2004/04/04 09:09:08","2004/04/04 09:09:08");
                viagem.setId_viagem(resultadoViagem.getInt("id_viagem"));
                viagem.setOrigem(resultadoViagem.getString("origem"));
                viagem.setHorarioSaida((LocalDateTime)resultadoViagem.getObject("horarioSaida"));
                viagem.setDestino(resultadoViagem.getString("destino"));
                viagem.setHorarioChegada((LocalDateTime)resultadoViagem.getObject("horarioChegada"));

                System.out.println(viagem);

            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar viagens: " + ex);

        } finally {

            ConexaoBD.closeAcesso(pesquisaViagem,resultadoViagem);
        }
    }
}