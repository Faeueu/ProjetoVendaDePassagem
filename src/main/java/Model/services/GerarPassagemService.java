package Model.services;

import DAO.DAOfactory;
import Model.Interface.InterfacePassagemDAO;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;

public class GerarPassagemService {

    public void gerarPassagem(Integer id_passagem, Integer numeroAssento) throws FileNotFoundException {

        InterfacePassagemDAO IPD = DAOfactory.criarPassagemDAO();
        ArrayList<String> dadosPassagem = IPD.buscarPassagem(id_passagem);

        String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
        String pdfFilePath = documentsPath + File.separator + "simple_document"+id_passagem+numeroAssento+".pdf";

        PdfWriter writer = new PdfWriter(pdfFilePath);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        Paragraph cabecario = new Paragraph("Guanabira Express").setTextAlignment(TextAlignment.CENTER);
        document.add(cabecario);

        Table table = new Table(4);
        table.setWidth(UnitValue.createPercentValue(100));

        document.add(new Paragraph("Passageiro(a): "+dadosPassagem.get(0)));
        document.add(new Paragraph("Ticker da passagem: "+id_passagem));
        document.add(new Paragraph("Numero do assento: "+numeroAssento));

        table.addCell(new Cell().add(new Paragraph("Origem")));
        table.addCell(new Cell().add(new Paragraph("Data saida")));
        table.addCell(new Cell().add(new Paragraph("Destino")));
        table.addCell(new Cell().add(new Paragraph("Data chegada")));

        table.addCell(new Cell().add(new Paragraph(dadosPassagem.get(1))));
        table.addCell(new Cell().add(new Paragraph(dadosPassagem.get(2))));
        table.addCell(new Cell().add(new Paragraph(dadosPassagem.get(3))));
        table.addCell(new Cell().add(new Paragraph(dadosPassagem.get(4))));

        document.add(table);

        Paragraph agradecimento = new Paragraph("A Gunabira Express agradece sua preferencia!").setTextAlignment(TextAlignment.CENTER);
        document.add(agradecimento);

        document.close();
    }
}