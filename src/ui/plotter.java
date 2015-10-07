/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import core.settings.basicSettings;
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.*;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author kristof
 */
public class plotter {

    Output[] statistics;

    public plotter(Output[] o) {
        statistics = o;
    }




    public void createPlots()  {



        for (int i=0; i < statistics.length; i++) {

            graphWindow w = new graphWindow(statistics[i]);
            w.pack();
            RefineryUtilities.positionFrameRandomly(w);
            w.setVisible(true);

         }
        

    }


}
