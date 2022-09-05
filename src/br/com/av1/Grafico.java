package br.com.av1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A demonstration application showing a time series chart where you can dynamically add
 * (random) data by clicking on a button.
 *
 */
public class Grafico extends ApplicationFrame {

    /** The time series data. */
    private TimeSeries series1;
    private TimeSeries series2;
    private TimeSeries series3;
    /** The most recent value added. */
    private double lastValue = 100.0;

    /**
     * Constructs a new demonstration application.
     *
     * @param title  the frame title.
     */
    public Grafico(final String title) {

        super(title);
        this.setSeries1(new TimeSeries("Ativo", Millisecond.class));
        this.setSeries2(new TimeSeries("Média Curta", Millisecond.class));
        this.setSeries3(new TimeSeries("Média Longa", Millisecond.class));
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
       
       
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);
     
 
      

        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
      
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(content);

    }

    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return A sample chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            "Ativo", 
            "Time", 
            "Value",
            dataset, 
            true, 
            true, 
            false
        );
        final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
      
        return result;
    }
    
 
 
    

	public TimeSeries getSeries1() {
		return series1;
	}

	public void setSeries1(TimeSeries series) {
		this.series1 = series;
	}
	public TimeSeries getSeries2() {
		return series2;
	}

	public void setSeries2(TimeSeries series) {
		this.series2 = series;
	}
	public TimeSeries getSeries3() {
		return series3;
	}

	public void setSeries3(TimeSeries series) {
		this.series3 = series;
	}
 

}
