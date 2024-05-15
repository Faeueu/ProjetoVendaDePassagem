package DAO;

import db.ConexaoBD;
import Model.Interface.InterfaceClienteDAO;
import Model.entities.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO implements InterfaceClienteDAO{
    Connection conexaoCliente;
    PreparedStatement pesquisaCliente;
    ResultSet resultadoCliente;

    public ClienteDAO(Connection conexaoCliente){
        this.conexaoCliente = conexaoCliente;
    }

    @Override
    public void adicionarCliente(String nome, String cpf, String telefone, String email, String login, String senha){

        try {
            pesquisaCliente = conexaoCliente.prepareStatement("insert into cliente (nome, cpf, telefone, email, login, senha)VALUES(?,?,?,?,?,?)");
            pesquisaCliente.setString(1, nome);
            pesquisaCliente.setString(2, cpf);
            pesquisaCliente.setString(3, telefone);
            pesquisaCliente.setString(4, email);
            pesquisaCliente.setString(5, login);
            pesquisaCliente.setString(6, senha);

            pesquisaCliente.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar cliente");

        } finally {
            ConexaoBD.closeAcesso(pesquisaCliente);

        }
    }

    @Override
    public void buscarCliente(String login, String senha, Cliente cliente){

        try{
            pesquisaCliente = conexaoCliente.prepareStatement("select * from cliente where login = ? and senha = ?");
            pesquisaCliente.setString(1, login);
            pesquisaCliente.setString(2, senha);

            resultadoCliente = pesquisaCliente.executeQuery();
            resultadoCliente.next();

            cliente.setId_cliente(resultadoCliente.getInt("id_cliente"));
            cliente.setNome(resultadoCliente.getString("nome"));
            cliente.setCpf(resultadoCliente.getString("cpf"));
            cliente.setTelefone(resultadoCliente.getString("telefone"));
            cliente.setEmail(resultadoCliente.getString("email"));
            cliente.setLogin(resultadoCliente.getString("login"));
            cliente.setSenha(resultadoCliente.getString("senha"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente");

        } finally {
            ConexaoBD.closeAcesso(pesquisaCliente,resultadoCliente);

        }
    }

    @Override
    public void atualizarCliente(Integer id_cliente, String nome, String cpf, String telefone, String email, String login, String senha){

        try {
            pesquisaCliente = conexaoCliente.prepareStatement("update cliente set nome = ?, cpf = ?, telefone = ?, email = ?, login = ?, senha = ? where id_cliente = ?");
            pesquisaCliente.setString(1, nome);
            pesquisaCliente.setString(2, cpf);
            pesquisaCliente.setString(3, telefone);
            pesquisaCliente.setString(4, email);
            pesquisaCliente.setString(5, login);
            pesquisaCliente.setString(6, senha);
            pesquisaCliente.setInt(7, id_cliente);

            pesquisaCliente.executeUpdate();

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");

        } finally {
            ConexaoBD.closeAcesso(pesquisaCliente);

        }
    }

    @Override
    public void deletarCliente(Integer id_cliente){

        try{
            pesquisaCliente = conexaoCliente.prepareStatement("delete from cliente where id_cliente = ?");
            pesquisaCliente.setInt(1, id_cliente);

            pesquisaCliente.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente");

        } finally {
            ConexaoBD.closeAcesso(pesquisaCliente);

        }
    }

    @Override
    public void listarClientes(){

        try {
            pesquisaCliente = conexaoCliente.prepareStatement("select * from cliente");

            resultadoCliente = pesquisaCliente.executeQuery();

            while (resultadoCliente.next()){
                Cliente cliente = new Cliente("","","","","","");
                cliente.setId_cliente(resultadoCliente.getInt("id_cliente"));
                cliente.setNome(resultadoCliente.getString("nome"));
                cliente.setCpf(resultadoCliente.getString("cpf"));
                cliente.setTelefone(resultadoCliente.getString("telefone"));
                cliente.setEmail(resultadoCliente.getString("email"));
                cliente.setLogin(resultadoCliente.getString("login"));
                cliente.setSenha(resultadoCliente.getString("senha"));

                System.out.println(cliente);

            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar clientes: " + ex);

        } finally {

            ConexaoBD.closeAcesso(pesquisaCliente,resultadoCliente);
        }
    }

    @Override
    public void clienteLogin(String login, String senha, Cliente cliente){

        try{
            pesquisaCliente = conexaoCliente.prepareStatement("select * from cliente where login = ? and senha = ?");
            pesquisaCliente.setString(1, login);
            pesquisaCliente.setString(2, senha);

            resultadoCliente = pesquisaCliente.executeQuery();
            resultadoCliente.next();

            cliente.setId_cliente(resultadoCliente.getInt("id_cliente"));
            cliente.setNome(resultadoCliente.getString("nome"));
            cliente.setCpf(resultadoCliente.getString("cpf"));
            cliente.setTelefone(resultadoCliente.getString("telefone"));
            cliente.setEmail(resultadoCliente.getString("email"));
            cliente.setLogin(resultadoCliente.getString("login"));
            cliente.setSenha(resultadoCliente.getString("senha"));

        } catch (SQLException ex) {
            System.out.println("Erro ao logar: " + ex);

        } finally {
            ConexaoBD.closeAcesso(pesquisaCliente,resultadoCliente);

        }
    }
}