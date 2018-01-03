package kata6.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import javax.swing.*;
import java.awt.*;
import kata6.model.Histogram;

public class HistogramDisplay<T> extends ApplicationFrame {
    
    private final Histogram<T> histogram;
    private final String nameEjex;
    private final String nameEjey;
    
    public HistogramDisplay(Histogram<T> histogram,String nameEjex,
                            String nameEjey){
        super("HISTOGRAM");
        this.histogram=histogram;
        this.nameEjex=nameEjex;
        this.nameEjey=nameEjey;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel= new ChartPanel (createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart (DefaultCategoryDataset dataset){
        JFreeChart chart= ChartFactory.createBarChart(
                        "JFreeChart Histogram",
                        nameEjex,
                        nameEjey,
                        dataset,
                        PlotOrientation.VERTICAL,
                        false,
                        rootPaneCheckingEnabled,
                        rootPaneCheckingEnabled);
                      
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset= new DefaultCategoryDataset();
        for(T key: histogram.keySet()){
            dataset.addValue(histogram.get(key),"",(Comparable)key);
        }
        return dataset;
    }
}
