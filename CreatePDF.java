import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class CreatePDF {
    public static void main(String[] args) throws IOException{
        PDDocument document = new PDDocument();
        PDPage firstPage=new PDPage();

        firstPage.getContents();
        document.addPage(firstPage);

        document.save("E:\\Project Practice\\APACHE PDFBOX\\PracticeTutorial\\newPDF.pdf");
        System.out.println("PDF created successfully");
        document.close();
    }
}
