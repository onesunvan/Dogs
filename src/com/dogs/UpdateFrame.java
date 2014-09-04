/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dogs;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *
 * @author ivan
 */
public class UpdateFrame extends JFrame {
    JFrame parent;
    JFrame thisFrame = this;
    DogsDB db;
    JLabel mainLabel;
    JPanel breedPanel = new JPanel(new BorderLayout());
    JPanel clubPanel = new JPanel(new BorderLayout());
    JPanel cynologPanel = new JPanel(new BorderLayout());
    JPanel dogPanel = new JPanel(new BorderLayout());
    JPanel ownerPanel = new JPanel(new BorderLayout());
    
    JTextField idValueField = new JTextField();
    JTextField colValueField = new JTextField();
    JButton goBtn = new JButton("GO");
    
    String table = "Breed";
    String id = "KB";
    String idValue;
    String col = "name";
    String colValue;
    
    UpdateFrame(JFrame prnt, DogsDB datab) {
        super("Update Table");
        this.setVisible(true);
        this.setSize(500, 450);
        this.setLocationRelativeTo(parent);
        parent = prnt;      
        parent.setEnabled(false);
        db = datab;
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowDeactivated(WindowEvent event) {
 
            }
 
            @Override
            public void windowDeiconified(WindowEvent event) {
 
            }
 
            @Override
            public void windowIconified(WindowEvent event) {
 
            }
 
            @Override
            public void windowOpened(WindowEvent event) {
 
            }
            
            @Override
            public void windowActivated(WindowEvent event) {
 
            }
 
            @Override
            public void windowClosed(WindowEvent event) {
 
            }
 
            @Override
            public void windowClosing(WindowEvent event) {
                parent.setEnabled(true);
            }
        });
        
        Box northBox = new Box(BoxLayout.PAGE_AXIS);
        mainLabel = new JLabel("Введіть значення ключа рядка, "
                + "який ви хочете змінити");
        northBox.add(mainLabel);
        northBox.add(idValueField);
        this.getContentPane().add(BorderLayout.NORTH, northBox);
        
        final JTabbedPane tabe = new JTabbedPane();
        this.getContentPane().add(BorderLayout.CENTER, tabe);
        
        tabe.addTab("Breed",  breedPanel);
        tabe.addTab("Club", clubPanel);
        tabe.addTab("Cynolog", cynologPanel);
        tabe.addTab("Dog", dogPanel);
        tabe.addTab("Owner", ownerPanel);
        
        tabe.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                table = tabe.getTitleAt(tabe.getSelectedIndex());
                if (table.equals("Breed")) {
                    id = "KB";
                }
                else if (table.equals("Club")) {
                    id = "KCB";
                }
                else if (table.equals("Cynolog")) {
                    id = "KC";
                }
                else if (table.equals("Dog")) {
                    id = "KD";
                }
                else if (table.equals("Owner")) {
                    id = "KO";
                }
                
            }
        });
        
        createBreed();
        createClub();
        createCynolog();
        createOwner();
        createDog();
        
        Box southBox = new Box(BoxLayout.PAGE_AXIS);
        JLabel colLabel = new JLabel("Введіть нове значення поля");
        southBox.add(colLabel);
        southBox.add(colValueField);
        southBox.add(goBtn);
        this.getContentPane().add(BorderLayout.SOUTH, southBox);
        
        goBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean flag;
                idValue = idValueField.getText();
                colValue = colValueField.getText();
                flag = db.update(table, id, idValue, col, colValue);
                if (flag) {
                    parent.setEnabled(true);
                    thisFrame.dispose();
                }
                else {
                    mainLabel.setText("Введіть коректні дані");
                }
            }
        });
    }
    
    private void createBreed() {
        JLabel kbLabel = new JLabel("Ідентифікатор для Breed - KB");
        breedPanel.add(BorderLayout.NORTH,kbLabel);
        
        ButtonGroup bg = new ButtonGroup();
        final JRadioButton rbKB = new JRadioButton("KB");
        final JRadioButton rbname = new JRadioButton("name", true);
        final JRadioButton rbyear = new JRadioButton("year");
        final JRadioButton rbcountry = new JRadioButton("country");
        final JRadioButton rbassignment = new JRadioButton("assignment");
        
        bg.add(rbKB);
        bg.add(rbname);
        bg.add(rbyear);
        bg.add(rbcountry);
        bg.add(rbassignment);
        
        Box centerBox = new Box(BoxLayout.PAGE_AXIS);
        centerBox.add(rbKB);
        centerBox.add(rbname);
        centerBox.add(rbyear);
        centerBox.add(rbcountry);
        centerBox.add(rbassignment);
        breedPanel.add(centerBox);
        
        ActionListener rbListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rbKB.isSelected()) {
                    col = "KB";
                }
                else if (rbname.isSelected()) {
                    col = "name";
                }
                else if (rbyear.isSelected()) {
                    col = "year";
                }
                else if (rbcountry.isSelected()) {
                    col = "country";
                }
                else if (rbassignment.isSelected()) {
                    col = "assignment";
                }
            }
        };
        
        rbKB.addActionListener(rbListener);
        rbname.addActionListener(rbListener);
        rbyear.addActionListener(rbListener);
        rbcountry.addActionListener(rbListener);
        rbassignment.addActionListener(rbListener);
    }
    
    private void createClub() {
        JLabel kcbLabel = new JLabel("Ідентифікатор для Club - KCB");
        clubPanel.add(BorderLayout.NORTH,kcbLabel);
        
        ButtonGroup bg = new ButtonGroup();
        final JRadioButton rbKCB = new JRadioButton("KCB");
        final JRadioButton rbname = new JRadioButton("name", true);
        final JRadioButton rbkerivnik = new JRadioButton("kerivnik");
        final JRadioButton rbyear = new JRadioButton("year");
        final JRadioButton rbcity = new JRadioButton("city");
        
        bg.add(rbKCB);
        bg.add(rbname);
        bg.add(rbkerivnik);
        bg.add(rbyear);
        bg.add(rbcity);
        
        Box centerBox = new Box(BoxLayout.PAGE_AXIS);
        centerBox.add(rbKCB);
        centerBox.add(rbname);
        centerBox.add(rbkerivnik);
        centerBox.add(rbyear);
        centerBox.add(rbcity);
        clubPanel.add(centerBox);
        
        ActionListener rbListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rbKCB.isSelected()) {
                    col = "KCB";
                }
                else if (rbname.isSelected()) {
                    col = "name";
                }
                else if (rbkerivnik.isSelected()) {
                    col = "kerivnik";
                }
                else if (rbyear.isSelected()) {
                    col = "year";
                }
                else if (rbcity.isSelected()) {
                    col = "city";
                }
            }
        };
        
        rbKCB.addActionListener(rbListener);
        rbname.addActionListener(rbListener);
        rbkerivnik.addActionListener(rbListener);
        rbyear.addActionListener(rbListener);
        rbcity.addActionListener(rbListener);
    }
    
    private void createCynolog() {
        JLabel kcLabel = new JLabel("Ідентифікатор для Cynolog - KC");
        cynologPanel.add(BorderLayout.NORTH,kcLabel);
        
        ButtonGroup bg = new ButtonGroup();
        final JRadioButton rbKC = new JRadioButton("KC");
        final JRadioButton rbname = new JRadioButton("name", true);
        final JRadioButton rbage = new JRadioButton("age");
        final JRadioButton rbsex = new JRadioButton("sex");
        final JRadioButton rbstage = new JRadioButton("stage");
        
        bg.add(rbKC);
        bg.add(rbname);
        bg.add(rbage);
        bg.add(rbsex);
        bg.add(rbstage);
        
        Box centerBox = new Box(BoxLayout.PAGE_AXIS);
        centerBox.add(rbKC);
        centerBox.add(rbname);
        centerBox.add(rbage);
        centerBox.add(rbsex);
        centerBox.add(rbstage);
        cynologPanel.add(centerBox);
        
        ActionListener rbListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rbKC.isSelected()) {
                    col = "KC";
                }
                else if (rbname.isSelected()) {
                    col = "name";
                }
                else if (rbage.isSelected()) {
                    col = "age";
                }
                else if (rbsex.isSelected()) {
                    col = "sex";
                }
                else if (rbstage.isSelected()) {
                    col = "stage";
                }
            }
        };
        
        rbKC.addActionListener(rbListener);
        rbname.addActionListener(rbListener);
        rbage.addActionListener(rbListener);
        rbsex.addActionListener(rbListener);
        rbstage.addActionListener(rbListener);
    }
    
    private void createOwner() {
        JLabel koLabel = new JLabel("Ідентифікатор для Owner - KO");
        ownerPanel.add(BorderLayout.NORTH,koLabel);
        
        ButtonGroup bg = new ButtonGroup();
        final JRadioButton rbKO = new JRadioButton("KO");
        final JRadioButton rbname = new JRadioButton("name", true);
        final JRadioButton rbage = new JRadioButton("age");
        final JRadioButton rbsex = new JRadioButton("sex");
        final JRadioButton rbcity = new JRadioButton("city");
        
        bg.add(rbKO);
        bg.add(rbname);
        bg.add(rbage);
        bg.add(rbsex);
        bg.add(rbcity);
        
        Box centerBox = new Box(BoxLayout.PAGE_AXIS);
        centerBox.add(rbKO);
        centerBox.add(rbname);
        centerBox.add(rbage);
        centerBox.add(rbsex);
        centerBox.add(rbcity);
        ownerPanel.add(centerBox);
        
        ActionListener rbListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rbKO.isSelected()) {
                    col = "KO";
                }
                else if (rbname.isSelected()) {
                    col = "name";
                }
                else if (rbage.isSelected()) {
                    col = "age";
                }
                else if (rbsex.isSelected()) {
                    col = "sex";
                }
                else if (rbcity.isSelected()) {
                    col = "city";
                }
            }
        };
        
        rbKO.addActionListener(rbListener);
        rbname.addActionListener(rbListener);
        rbage.addActionListener(rbListener);
        rbsex.addActionListener(rbListener);
        rbcity.addActionListener(rbListener);
    }
    
    private void createDog() {
        JLabel kdLabel = new JLabel("Ідентифікатор для Dog - KD");
        dogPanel.add(BorderLayout.NORTH,kdLabel);
        
        ButtonGroup bg = new ButtonGroup();
        final JRadioButton rbKD = new JRadioButton("KD");
        final JRadioButton rbKB = new JRadioButton("KB");
        final JRadioButton rbKO = new JRadioButton("KO");
        final JRadioButton rbKCB = new JRadioButton("KCB");
        final JRadioButton rbKC = new JRadioButton("KC");
        final JRadioButton rbname = new JRadioButton("name", true);
        final JRadioButton rbage = new JRadioButton("age");
        final JRadioButton rbsex = new JRadioButton("sex");
        final JRadioButton rbweight = new JRadioButton("weight");
        final JRadioButton rbheight = new JRadioButton("height");
        final JRadioButton rbbirthday = new JRadioButton("birthday");
        
        bg.add(rbKD);
        bg.add(rbKB);
        bg.add(rbKO);
        bg.add(rbKCB);
        bg.add(rbKC);
        bg.add(rbname);
        bg.add(rbage);
        bg.add(rbsex);
        bg.add(rbweight);
        bg.add(rbheight);
        bg.add(rbbirthday);
        
        Box centerBox = new Box(BoxLayout.PAGE_AXIS);
        centerBox.add(rbKD);
        centerBox.add(rbKB);
        centerBox.add(rbKO);
        centerBox.add(rbKCB);
        centerBox.add(rbKC);
        centerBox.add(rbname);
        centerBox.add(rbage);
        centerBox.add(rbsex);
        centerBox.add(rbweight);
        centerBox.add(rbheight);
        centerBox.add(rbbirthday);
        dogPanel.add(centerBox);
        
        ActionListener rbListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rbKD.isSelected()) {
                    col = "KD";
                }
                else if (rbKB.isSelected()) {
                    col = "KB";
                }
                else if (rbKO.isSelected()) {
                    col = "KO";
                }
                else if (rbKCB.isSelected()) {
                    col = "KCB";
                }
                else if (rbKC.isSelected()) {
                    col = "KC";
                }
                else if (rbname.isSelected()) {
                    col = "name";
                }
                else if (rbage.isSelected()) {
                    col = "age";
                }
                else if (rbsex.isSelected()) {
                    col = "sex";
                }
                else if (rbweight.isSelected()) {
                    col = "weight";
                }
                else if (rbheight.isSelected()) {
                    col = "height";
                }
                else if (rbbirthday.isSelected()) {
                    col = "birthday";
                }
            }
        };
        
        rbKD.addActionListener(rbListener);
        rbKB.addActionListener(rbListener);
        rbKO.addActionListener(rbListener);
        rbKCB.addActionListener(rbListener);
        rbKC.addActionListener(rbListener);
        rbname.addActionListener(rbListener);
        rbage.addActionListener(rbListener);
        rbsex.addActionListener(rbListener);
        rbweight.addActionListener(rbListener);
        rbheight.addActionListener(rbListener);
        rbbirthday.addActionListener(rbListener);
    }
}
