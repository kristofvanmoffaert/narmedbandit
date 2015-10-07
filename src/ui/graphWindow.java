/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;


import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Vector;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.Spacer;

/**
 *
 * @author kristof
 */
public class graphWindow extends ApplicationFrame  {



    public graphWindow(Output data) {

        super(data.getTitle());

        final XYDataset dataset = createDataset(data);
        final JFreeChart chart = createChart(dataset, data);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);


    }

    public void windowClosing(java.awt.event.WindowEvent event) {
        setVisible(false);
    }

    /**
     * Creates a sample dataset.
     *
     * @return a sample dataset.
     */
    private XYDataset createDataset(Output data) {

        XYSeriesCollection dataset = new XYSeriesCollection();
        
        for (int i=0; i < data.size(); i++) {
            XYSeries series = new XYSeries(data.getDescription(i));
            for (int j=0; j < data.getStatistics(i).length; j++)
                series.add(j, data.getStatistics(i)[j]);
            dataset.addSeries(series);
        }
        return dataset;

    }

    /**
     * Creates a chart.
     *
     * @param dataset  the data for the chart.
     *
     * @return a chart.
     */
    private JFreeChart createChart(final XYDataset dataset, Output data) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            data.getTitle(),      // chart title
            "Iteration",                      // x axis label
            data.getTitle(),                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final StandardXYItemRenderer renderer = new StandardXYItemRenderer();
        //renderer.setLinesVisible(true);
        //renderer.setShapesVisible(true);
        renderer.setStroke(new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {10.0f, 6.0f}, 0.0f
            ));

        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }
}
