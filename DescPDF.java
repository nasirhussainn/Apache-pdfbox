import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.io.File;
import java.util.Calendar;

public class DescPDF {
    public static void main(String[] args) throws IOException{
        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);

//        add document description
        PDDocumentInformation docInfo = document.getDocumentInformation();
        docInfo.setAuthor("Nasir Hussain");
        docInfo.setTitle("Apache PDFBox");
        docInfo.setSubject("Apache Tutorial");
        docInfo.setKeywords("apache,pdf,document");
        docInfo.setCreationDate(Calendar.getInstance());

        document.save("E:\\Project Practice\\APACHE PDFBOX\\PracticeTutorial\\desc1.pdf");
        document.close();
        System.out.println("Document Created");

    }
}
