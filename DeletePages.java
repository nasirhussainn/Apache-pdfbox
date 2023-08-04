import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class DeletePages {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("E:\\Project Practice\\APACHE PDFBOX\\DeletePages\\nasir.pdf");
        PDDocument document = PDDocument.load(oldFile);

//        simple delete page
//        document.removePage(0);

        int pageStart=1;
        int pageEnd=4;

/*    if for loop start from front so after deleting Page1 the Page2 will become Page1 so
for next iteration 2 will ignore and go to 3rd page as 2nd so we use reverse simple*/
        for(int i=pageEnd;i>=pageStart;i--){
            document.removePage(i-1);
//            as we want to remove 4 pages mean 0 to 3
        }
        document.save("E:\\Project Practice\\APACHE PDFBOX\\DeletePages\\deleteRange.pdf");
        System.out.println("PDF Created after deletion");
    }

}
