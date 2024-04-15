package DAO;

import Model.entities.Cliente;
import utils.ConexaoBd;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    public void addCliente(Cliente cliente){
        Connection conexao = ConexaoBd.getConexao();

        String sql = "INSERT INTO cliente (nome, cpf, telefone, email) VALUES(?,?,?,?)";

        try(PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());

            ps.executeUpdate();
            ps.close();
            conexao.close();

            JOptionPane.showMessageDialog(null, "Cliente adcionado !");
        }catch (Exception eSQL){
            JOptionPane.showMessageDialog(null, "Erro ao add cliente");
        }
    }

    public void updateCliente(Cliente cliente){
        Connection conexao = ConexaoBd.getConexao();
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE id_cliente = ?";

        try(PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());
            ps.setInt(5, cliente.getId_paciente());

            ps.executeUpdate();
            ps.close();
            conexao.close();

            JOptionPane.showMessageDialog(null, "Cliente atualizado !");
        }catch (Exception eSQL){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }

    }

    public void deleteCliente(Cliente cliente){
        Connection conexao = ConexaoBd.getConexao();
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        int opc = JOptionPane.showConfirmDialog(null, "Deseja deletar o cliente "+cliente.getNome() + "?", "Excluir", JOptionPane.YES_NO_OPTION);

        if(opc == JOptionPane.YES_OPTION){
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setInt(1, cliente.getId_paciente());
                ps.executeUpdate();
                ps.close();
                conexao.close();

                JOptionPane.showMessageDialog(null, "Cliente deletado !");
            }catch (Exception eSQL){
                JOptionPane.showMessageDialog(null, "Erro ao deletar cliente");
            }
        }

    }

    public List<Cliente> printCliente(){
        Connection conexao = ConexaoBd.getConexao();
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY nome";

        try(PreparedStatement ps = conexao.prepareStatement(sql)){

            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Cliente cliente = new Cliente();
                cliente.setId_paciente(resultado.getInt("id_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEmail(resultado.getString("email"));

                listaClientes.add(cliente);
                JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(listaClientes.toString())),
                        "Lista de Clientes ", JOptionPane.INFORMATION_MESSAGE);
            }

        }catch (Exception eSQL){
            JOptionPane.showMessageDialog(null, "Erro ao listar os clientes");
        }
        return listaClientes;
    }
}
