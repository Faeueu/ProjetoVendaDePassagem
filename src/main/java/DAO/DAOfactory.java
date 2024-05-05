package DAO;

import db.ConexaoBD;
import Model.Interface.*;

public class DAOfactory {
    public static InterfaceClienteDAO criarClienteDAO(){
        return new ClienteDAO(ConexaoBD.getConexao());
    }
    public static InterfaceViagemDAO criarViagemDAO(){
        return new ViagemDAO(ConexaoBD.getConexao());
    }
    public static InterfaceOnibusDAO criarOnibusDAO(){
        return new OnibusDAO(ConexaoBD.getConexao());
    }
    public static InterfaceAssentoDAO criarAssentoDAO(){
        return new AssentoDAO(ConexaoBD.getConexao());
    }
    public static InterfaceMotoristaDAO criarMotoristaDAO(){
        return new MotoristaDAO(ConexaoBD.getConexao());
    }
    public static InterfacePassagemDAO criarPassagemDAO(){
        return new PassagemDAO(ConexaoBD.getConexao());
    }
}
