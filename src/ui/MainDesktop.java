/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author kristof
 */
public class MainDesktop {

    public static void main(String args[]) {

                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                StartPanel p = new StartPanel();
                f.setContentPane(p);
                Dimension d = p.getPreferredSize();
                f.setSize(d.width, d.height+30);
                f.setResizable(false);
                f.setVisible(true);
    }

}
