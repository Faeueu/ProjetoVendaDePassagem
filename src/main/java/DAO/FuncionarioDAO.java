package DAO;




import Model.entities.Funcionario;
import utils.ConexaoBd;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public void addFuncionario(Funcionario funcionario){
        Connection conexao = ConexaoBd.getConexao();

        String sql = "INSERT INTO funcionario (nome) VALUES(?)";

        try(PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, funcionario.getNome());

            ps.executeUpdate();
            ps.close();
            conexao.close();

            JOptionPane.showMessageDialog(null, "Funcionario adcionado !");
        }catch (Exception eSQL){
            JOptionPane.showMessageDialog(null, "Erro ao add funcionario");
        }
    }

    public void updateFuncionario(Funcionario funcionario){
        Connection conexao = ConexaoBd.getConexao();
        String sql = "UPDATE funcionario SET nome = ? WHERE id_funcionario = ?";

        try(PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getId_funcionario());

            ps.executeUpdate();
            ps.close();
            conexao.close();

            JOptionPane.showMessageDialog(null, "Funcionario atualizado !");
        }catch (Exception eSQL){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionario");
        }
    }


    public void deleteFuncionario(Funcionario funcionario){
        Connection conexao = ConexaoBd.getConexao();
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        int opc = JOptionPane.showConfirmDialog(null, "Deseja deletar o funcionario "+funcionario.getNome() + "?", "Excluir", JOptionPane.YES_NO_OPTION);

        if(opc == JOptionPane.YES_OPTION){
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setInt(1, funcionario.getId_funcionario());
                ps.executeUpdate();
                ps.close();
                conexao.close();

                JOptionPane.showMessageDialog(null, "uncionario deletado !");
            }catch (Exception eSQL){
                JOptionPane.showMessageDialog(null, "Erro ao deletar funcionario");
            }
        }
    }


    public List<Funcionario> printFuncionario(){
        Connection conexao = ConexaoBd.getConexao();
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario ORDER BY nome";

        try(PreparedStatement ps = conexao.prepareStatement(sql)){

            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(resultado.getInt("id_funcionario"));
                funcionario.setNome(resultado.getString("nome"));

                listaFuncionarios.add(funcionario);
                JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(listaFuncionarios.toString())),
                        "Lista de Funcionarios ", JOptionPane.INFORMATION_MESSAGE);
            }

        }catch (Exception eSQL){
            JOptionPane.showMessageDialog(null, "Erro ao listar os funcionarios");
        }
        return listaFuncionarios;
    }
}
