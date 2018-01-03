package kata6.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.model.Person;
import kata6.view.DataBaseList;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;


public class KATA6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
        String filename="emails.txt";
        List<Mail> mailList=MailListReader.read(filename);
        MailHistogramBuilder<Mail> builder= new MailHistogramBuilder<>(mailList);
        Histogram<String> domains=builder.build(new Attribute<Mail,String>(){
            @Override
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
         
        });
        new HistogramDisplay(domains,"Dominios","NºEmails").execute();
         
        Histogram<Character> letters=builder.build(new Attribute<Mail,Character>(){
            @Override
             public Character get(Mail item){
                 return item.getMail().charAt(0);
             }
        });
         
        new HistogramDisplay(letters,"Primer Caracter","NºEmails").execute();
        String filename2="C:\\Users\\DaniCerv\\Downloads"
                + "\\SQLiteDatabaseBrowserPortable\\Data\\KATA.sDB";
        List<Person> people=DataBaseList.read(filename2);
        MailHistogramBuilder<Person> builderPerson= 
                                            new MailHistogramBuilder<>(people);
        Histogram<Character> gender=builderPerson.build(new Attribute<Person,
                                                           Character>(){
           @Override
           public Character get(Person item){
               return item.getGender();
           }
                                                               
        });
        
        new HistogramDisplay(gender,"Géneros","NºPersonas").execute();
        
        Histogram<Float> weight=builderPerson.build(new Attribute<Person,Float>(){
            @Override
            public Float get(Person item){
                return item.getWeight();
            }
        });
        new HistogramDisplay(weight,"Pesos","NºPersonas").execute();
        
        
    }
}
