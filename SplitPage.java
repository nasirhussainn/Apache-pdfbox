import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SplitPage {
    public static void main(String[] args) throws IOException{
//        File oldfile=new File("E:\\Project Practice\\APACHE PDFBOX\\SplitPages\\nasir.pdf");
//        PDDocument document = PDDocument.load(oldfile);
//
//        Splitter splitter=new Splitter();
//
//        List<PDDocument> splitPages=splitter.split(document);
//
//        int num=1;
//        for(PDDocument mydoc : splitPages){
//            mydoc.save("E:\\Project Practice\\APACHE PDFBOX\\SplitPages\\split_0"+num+".pdf");
//            num++;
//            mydoc.close();
//        }
//       System.out.println("Splitting Document successfully");
        File oldfile=new File("E:\\Project Practice\\APACHE PDFBOX\\SplitPages\\nasir.pdf");
        PDDocument document = PDDocument.load(oldfile);

        File newFileDestination= new File("E:\\Project Practice\\APACHE PDFBOX\\SplitPages");
        newFileDestination.mkdirs();
//        the above if directory not exist

        Splitter splitter=new Splitter();
        splitter.setStartPage(2);
        splitter.setEndPage(5);

        List<PDDocument> splitPages=splitter.split(document);

        PDDocument newDoc= new PDDocument();
        for(PDDocument mydoc : splitPages){
            newDoc.addPage(mydoc.getPage(0));
        }
        newDoc.save("E:\\Project Practice\\APACHE PDFBOX\\SplitPages\\range.pdf");
        newDoc.close();
        System.out.println("Splitting Document successfully");
    }
}
