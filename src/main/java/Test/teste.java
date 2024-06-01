package Test;

import DAO.ClienteDAO;
import DAO.DAOfactory;
import Model.Interface.InterfaceAssentoDAO;
import Model.Interface.InterfaceClienteDAO;
import Model.Interface.InterfacePassagemDAO;
import Model.Interface.InterfaceViagemDAO;
import Model.entities.Cliente;
import Model.entities.Viagem;
import Model.services.GerarListaPassagemService;
import Model.services.GerarPassagemService;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class teste {
    public static void main(String[] args) throws Exception {
        Cliente c = new Cliente();
        c.setId_cliente(2);
        c.setNome("Maciano Dantas");
        GerarListaPassagemService gerar = new GerarListaPassagemService();
        gerar.pdfListaPassagem(c);
    }
}