import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class CreateTable {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);

        int pageHeight = (int) firstPage.getTrimBox().getHeight();
        int pageWidth = (int) firstPage.getTrimBox().getWidth();

        PDPageContentStream contentStream = new PDPageContentStream(document, firstPage);
        contentStream.setStrokingColor(Color.gray);
        contentStream.setLineWidth(1);

        int initX = 50;
        int initY = pageHeight - 50;

        int cellWidth = 100;
        int cellHeight = 30;

        int rowCount = 6; // Including the header
        int colCount = 5;

        Random random = new Random();
        String[] studentNames = {"Alice", "Bob", "Charlie", "David", "Emma"};

        // Adding headers
        String[] headers = {"Name", "StudentID", "Class", "ContactNo", "Address"};
        for (String header : headers) {
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
            contentStream.newLineAtOffset(initX + 5, initY - 15);
            contentStream.showText(header);
            contentStream.endText();
            initX += cellWidth;
        }

        initX = 50;
        initY -= cellHeight;

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                contentStream.addRect(initX, initY, cellWidth, cellHeight);
                contentStream.stroke();

                // Adding student info
                String studentName = studentNames[random.nextInt(studentNames.length)];
                int studentId = 1000 + random.nextInt(9000); // Random 4-digit ID
                String studentClass = "Class " + (random.nextInt(5) + 1);
                String contactNo = "123-456-789" + random.nextInt(10);
                String address = random.nextInt(1000) + " Elm Street";

                String[] studentInfo = {studentName, String.valueOf(studentId), studentClass, contactNo, address};

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(initX + 5, initY - 15);
                String truncatedInfo = truncateTextToFitCell(studentInfo[j - 1], cellWidth - 10);
                contentStream.showText(truncatedInfo); // Displaying the appropriate student info
                contentStream.endText();

                initX += cellWidth;
            }
            initX = 50;
            initY -= cellHeight;
        }

        contentStream.close();
        document.save("E:\\Project Practice\\APACHE PDFBOX\\PracticeTutorial\\table.pdf");
        document.close();
        System.out.println("New document created");
    }

    private static String truncateTextToFitCell(String text, int maxWidth) {
        if (text.length() <= 10) {
            return text;
        } else {
            return text.substring(0, 10); // Truncate to fit cell width
        }
    }
}
