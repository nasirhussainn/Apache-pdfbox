import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class MergePages {
    public static void main(String[] args) throws IOException {
        File oldFile1 = new File("E:\\Project Practice\\APACHE PDFBOX\\DeletePages\\newPDF.pdf");
        File oldFile2 = new File("E:\\Project Practice\\APACHE PDFBOX\\DeletePages\\ReadPDF.pdf");

        File newFile = new File("E:\\Project Practice\\APACHE PDFBOX\\DeletePages");
        newFile.mkdir();

        PDFMergerUtility merge = new PDFMergerUtility();
        merge.setDestinationFileName(newFile+"\\new.pdf");

        merge.addSource(oldFile1);
        merge.addSource(oldFile2);

        merge.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        PDDocument document1=PDDocument.load(oldFile1);
        PDDocument document2=PDDocument.load(oldFile2);

        for(int i=0;i<document2.getNumberOfPages();i++){
            document1.addPage(document2.getPage(i));
        }
        document1.save(newFile+"\\loop.pdf");



//        System.out.println("PDF Created after deletion");
        System.out.println("PDF Created after Merge");
    }

}