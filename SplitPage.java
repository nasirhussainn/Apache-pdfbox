import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SplitPage {
    public static void main(String[] args) throws IOException{
        File oldfile=new File("E:\\Project Practice\\APACHE PDFBOX\\SplitPages\\nasir.pdf");
        PDDocument document = PDDocument.load(oldfile);

        Splitter splitter=new Splitter();

        List<PDDocument> splitPages=splitter.split(document);

        int num=1;
        for(PDDocument mydoc : splitPages){
            mydoc.save("E:\\Project Practice\\APACHE PDFBOX\\SplitPages\\split_0"+num+".pdf");
            num++;
            mydoc.close();
        }
        System.out.println("Splitting Document successfully");
    }
}
