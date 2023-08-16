import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;
import java.io.File;

public class WritePDF {
    public static void main(String[] args) throws IOException{
        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);

//        To add text content in pdf
        PDPageContentStream pdPageContentStream = new PDPageContentStream(document,firstPage);
        pdPageContentStream.beginText();
        pdPageContentStream.setFont(PDType1Font.HELVETICA,18);
        pdPageContentStream.setNonStrokingColor(Color.green);
        pdPageContentStream.setLeading(16.0f);

//        x is increasing from left width and y is decreasing upper height
        pdPageContentStream.newLineAtOffset(25,firstPage.getTrimBox().getHeight()-25);

        String mytext1 = "Nasir Hussain is Computer Science Student";
        String mytext2 = "He is studying in Quaid-i-Azam University Islamabad";
        String mytext3 = "He is going to Graduate in 2024";

        pdPageContentStream.showText(mytext1);
        pdPageContentStream.newLine();
        pdPageContentStream.showText(mytext2);
        pdPageContentStream.newLine();
//        pdPageContentStream.setFont(PDType1Font.TIMES_BOLD,14); to set individually
        pdPageContentStream.showText(mytext3);
        pdPageContentStream.newLine();

        pdPageContentStream.endText();
//        pdPageContentStream.close();

//        To add image content in pdf
        PDImageXObject imageXObject = PDImageXObject.createFromFile("E:\\Project Practice\\APACHE PDFBOX\\PracticeTutorial\\berry.jpg",document);
        pdPageContentStream.drawImage(imageXObject,200,585,160,120);


// to set custom font from file
//        File myFont1 = new File("finalem");
//        File myFont2 = new File("");
//
//        PDFont font1 = PDType0Font.load(document,myFont1);
//        PDFont font2 = PDType0Font.load(document,myFont2);
//        pdPageContentStream.setFont(font1,20);

        pdPageContentStream.close();


        document.save("E:\\Project Practice\\APACHE PDFBOX\\PracticeTutorial\\input.pdf");
        document.close();
        System.out.println("New document created");
    }
}
