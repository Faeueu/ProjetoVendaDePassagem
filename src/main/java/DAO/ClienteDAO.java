package DAO;

import Model.entities.Cliente;
import db.BdConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    public void addCliente(Cliente cliente){
        String sql = "INSERT INTO CLIENTE (cpf, nome, telefone, email) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;
        try {
            ps = BdConnection.getConnection().prepareStatement(sql);

            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());

            ps.execute();
            ps.close();


        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
