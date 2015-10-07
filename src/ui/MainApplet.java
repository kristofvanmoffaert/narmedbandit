/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.applet.Applet;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author kristof
 */
public class MainApplet extends JApplet {

    /**
     * Initialization method that will be called after the MainApplet is loaded
     * into the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
        try {
            SwingUtilities.invokeAndWait(new Runnable() {

                public void run() {

                createGUI();
                    
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

 

    private void createGUI() {
        //Create and set up the content pane.
        //MainFrame x = new MainFrame();
        //JPanel newContentPane = (JPanel) x.getContentPane();

        StartPanel newContentPane = new StartPanel();
        setSize(newContentPane.getPreferredSize());
        
        //System.out.println(newContentPane.getPreferredSize());
        newContentPane.setVisible(true);
        newContentPane.setOpaque(true);
        setContentPane(newContentPane);
        
    }

}


