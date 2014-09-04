/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dogs;

import javax.swing.*;
import java.io.*;
/**
 *
 * @author ivan
 */
public class HelpFrame extends JFrame {
    public HelpFrame(JFrame parent) {
        super("Help");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(800, 500);
        JTextArea text = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(text);
        this.getContentPane().add(scrollPane);
        text.setEditable(false);
        try {
            FileReader fr = new FileReader(
                    "/home/ivan/Desktop/Dogs/src/com/dogs/Help.txt");
            BufferedReader br = new BufferedReader(fr);
            String all = "";
            String s;
            while ((s = br.readLine()) != null) {
                all = all + "\n" + s;
            }
            text.setText(all);
        }
        catch (IOException ex) {
        }
    }
    
}
