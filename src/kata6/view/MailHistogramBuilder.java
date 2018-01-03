package kata6.view;

import java.util.List;
import kata6.main.Attribute;
import kata6.model.Histogram;
import kata6.model.Mail;


public class MailHistogramBuilder<T> {
    private final List<T> items;
    public MailHistogramBuilder(List<T> items){
        this.items=items;
    }
    
    public <A>Histogram<A> build(Attribute<T,A> attribute){
        Histogram<A> histo= new Histogram<>();
        for(T item1:items){
            A value=attribute.get(item1);
            histo.increment(value);
        }
        return histo;
        
    }
    
}
