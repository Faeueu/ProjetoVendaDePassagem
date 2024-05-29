package Main;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

import java.io.File;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;

//import Model.actions.Rodoviaria;
public class Main {
    public static void main(String[] args) {


        /*
        * Duas novas dependencias para gerar pdf
        *
        * */

        // Diretório onde será salvo o PDF
        String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
        String pdfFilePath = documentsPath + File.separator + "simple_document.pdf";

        try {
            // Inicializa o documento PDF
            PdfWriter writer = new PdfWriter(pdfFilePath);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Adiciona parágrafos de texto ao documento
            document.add(new Paragraph("Este é um documento PDF simples gerado com o iText."));
            document.add(new Paragraph("Você pode adicionar mais parágrafos, tabelas ou outros elementos conforme necessário."));

            // Fecha o documento
            document.close();

            // Configura o servidor Jetty para servir o PDF
            Server server = new Server(8080);
            ResourceHandler resourceHandler = new ResourceHandler();
            resourceHandler.setBaseResource(Resource.newResource(documentsPath));
            server.setHandler(resourceHandler);

            // Inicia o servidor Jetty
            server.start();

            // Abre o navegador para acessar o PDF no servidor local
            openBrowser("http://localhost:8080/simple_document.pdf");

            // Aguarda a finalização do servidor
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
            // Windows
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } else if (os.contains("mac")) {
            // macOS
            rt.exec("open " + url);
        } else if (os.contains("nix") || os.contains("nux")) {
            // Linux/Unix
            String[] browsers = {"xdg-open", "gnome-open", "xdg-open", "google-chrome", "chromium-browser", "firefox"};
            for (String browser : browsers) {
                if (rt.exec(new String[]{"which", browser}).waitFor() == 0) {
                    rt.exec(new String[]{browser, url});
                    break;
                }
            }
        }
    }
}
