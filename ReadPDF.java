import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPDF {

    public static void main(String[] args) {
        // Path to the PDF file
        String pdfPath = "E:\\Project Practice\\ReadPDF\\ReadPDF.pdf";

        try {
            // Load the PDF document
            PDDocument document = PDDocument.load(new File(pdfPath));

            // Create an instance of PDFTextStripper
            PDFTextStripper pdfStripper = new PDFTextStripper();

            // Extract text from the PDF
            String text = pdfStripper.getText(document);

            // Print the extracted text
            System.out.println(text);

            // Close the PDF document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
