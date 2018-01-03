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
        String filename="emails.txt";
        List<Mail> mailList=MailListReader.read(filename);
        MailHistogramBuilder<Mail> builder= new MailHistogramBuilder<>(mailList);
        Histogram<String> domains=builder.build(new Attribute<Mail,String>(){
            @Override
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
         
        });
        new HistogramDisplay(domains,"Dominios").execute();
         
        Histogram<Character> letters=builder.build(new Attribute<Mail,Character>(){
            @Override
             public Character get(Mail item){
                 return item.getMail().charAt(0);
             }
        });
         
        new HistogramDisplay(letters,"Primer Caracter").execute();
    }
}
