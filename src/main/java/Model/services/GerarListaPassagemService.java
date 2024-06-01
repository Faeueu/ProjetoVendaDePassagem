package Model.services;

import DAO.DAOfactory;
import Model.Interface.InterfacePassagemDAO;
import Model.entities.Cliente;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GerarListaPassagemService {

    public void pdfListaPassagem(Cliente cliente) throws IOException, InterruptedException {

        String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
        String pdfFilePath = documentsPath + File.separator + "bilhetes-"+cliente.getNome()+".pdf";
        try {
            PdfWriter writer = new PdfWriter(pdfFilePath);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            InterfacePassagemDAO IPD = DAOfactory.criarPassagemDAO();
            ArrayList<Integer> passagens = IPD.listarPassagem(cliente.getId_cliente());

            while (!passagens.isEmpty()){
                Integer passagem = passagens.get(passagens.size() -1);
                ArrayList<String> dados = IPD.buscarPassagem(passagem);

                Table table = new Table(5);
                table.setWidth(UnitValue.createPercentValue(100));

                table.addCell(new Cell().add(new Paragraph("Origem")));
                table.addCell(new Cell().add(new Paragraph("Data saida")));
                table.addCell(new Cell().add(new Paragraph("Destino")));
                table.addCell(new Cell().add(new Paragraph("Data chegada")));
                table.addCell(new Cell().add(new Paragraph("Assento")));

                table.addCell(new Cell().add(new Paragraph(dados.get(1))));
                table.addCell(new Cell().add(new Paragraph(dados.get(2))));
                table.addCell(new Cell().add(new Paragraph(dados.get(3))));
                table.addCell(new Cell().add(new Paragraph(dados.get(4))));
                table.addCell(new Cell().add(new Paragraph(dados.get(5))));

                document.add(table);

                document.add(new Paragraph(" "));

                passagens.remove(passagens.size() -1);
            }

        document.close();

        Server server = new Server(8080);
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setBaseResource(Resource.newResource(documentsPath));
        server.setHandler(resourceHandler);

        server.start();

        openBrowser("http://localhost:8080/bilhetes-"+cliente.getNome()+".pdf");

        server.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    private static void openBrowser(String url) throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        if (os.contains("win")) {

            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } else if (os.contains("mac")) {

            rt.exec("open " + url);
        } else if (os.contains("nix") || os.contains("nux")) {

            String[] browsers = {"xdg-open", "gnome-open", "xdg-open", "google-chrome", "chromium-browser", "firefox"};
            for (String browser : browsers) {
                if (rt.exec(new String[]{"which", browser}).waitFor() == 0) {
                    rt.exec(new String[]{browser, url});
                    return;
                }
            }
        }
    }
}
