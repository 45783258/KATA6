package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;


public class KATA6 {
    public static void main(String[] args) throws IOException{
        KATA6 histo= new KATA6();
        histo.execute();
    }
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
    
    private void execute() throws IOException{
        input();
        process();
        output();
        
    }
    
    private void input() throws IOException{
        filename="C:\\Users\\DaniCerv\\Desktop\\KATA4\\emails.txt";
        mailList= MailListReader.read(filename);
    }
    
    private void process(){
        histogram=MailHistogramBuilder.build(mailList);
    }
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
