/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dogs;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author ivan
 */
public class AddFrame extends JFrame {
    JFrame parent;
    JFrame thisFrame = this;
    JButton execBtn;
    JLabel mainLabel;
    DogsDB db;
    
    
    public AddFrame(JFrame prnt, DogsDB datab) {
        super("Database Interface");
        this.setVisible(true);
        this.setSize(500, 300);
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
    
        mainLabel = new JLabel("        Заповніть всі поля, будь ласка.");
        this.getContentPane().add(BorderLayout.NORTH,mainLabel);
        
        execBtn = new JButton("Виконати запит");
        this.getContentPane().add(BorderLayout.SOUTH, execBtn);
    }
    
    public void insertIntoCynolog() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel kcLabel = new JLabel("KC");
        panel.add(kcLabel);
        final JTextField kcField = new JTextField();
        panel.add(kcField);
        
        JLabel nameLabel = new JLabel("name");
        panel.add(nameLabel);
        final JTextField nameField = new JTextField();
        panel.add(nameField);
        
        JLabel ageLabel = new JLabel("age");
        panel.add(ageLabel);
        final JTextField ageField = new JTextField();
        panel.add(ageField);
        
        JLabel sexLabel = new JLabel("sex");
        panel.add(sexLabel);
        final JTextField sexField = new JTextField();
        panel.add(sexField);
        
        JLabel stageLabel = new JLabel("stage");
        panel.add(stageLabel);
        final JTextField stageField = new JTextField();
        panel.add(stageField);
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.insertIntoCynolog(kcField.getText(), nameField.getText()
                        , ageField.getText(), sexField.getText(),
                        stageField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
    
    public void insertIntoBreed() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel kbLabel = new JLabel("KB");
        panel.add(kbLabel);
        final JTextField kbField = new JTextField();
        panel.add(kbField);
        
        JLabel nameLabel = new JLabel("name");
        panel.add(nameLabel);
        final JTextField nameField = new JTextField();
        panel.add(nameField);
        
        JLabel yearLabel = new JLabel("year");
        panel.add(yearLabel);
        final JTextField yearField = new JTextField();
        panel.add(yearField);
        
        JLabel countryLabel = new JLabel("country");
        panel.add(countryLabel);
        final JTextField countryField = new JTextField();
        panel.add(countryField);
        
        JLabel assignmentLabel = new JLabel("assignment");
        panel.add(assignmentLabel);
        final JTextField assignmentField = new JTextField();
        panel.add(assignmentField);
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.insertIntoBreed(kbField.getText(), nameField.getText()
                        , yearField.getText(), countryField.getText(),
                        assignmentField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
    
    public void insertIntoClub() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel kcbLabel = new JLabel("KCB");
        panel.add(kcbLabel);
        final JTextField kcbField = new JTextField();
        panel.add(kcbField);
        
        JLabel nameLabel = new JLabel("name");
        panel.add(nameLabel);
        final JTextField nameField = new JTextField();
        panel.add(nameField);
        
        JLabel kerivnikLabel = new JLabel("kerivnik");
        panel.add(kerivnikLabel);
        final JTextField kerivnikField = new JTextField();
        panel.add(kerivnikField);
        
        JLabel yearLabel = new JLabel("year");
        panel.add(yearLabel);
        final JTextField yearField = new JTextField();
        panel.add(yearField);
        
        JLabel cityLabel = new JLabel("city");
        panel.add(cityLabel);
        final JTextField cityField = new JTextField();
        panel.add(cityField);
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.insertIntoClub(kcbField.getText(), nameField.getText()
                        , kerivnikField.getText(), yearField.getText(),
                        cityField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
    
    public void insertIntoOwner() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel koLabel = new JLabel("KO");
        panel.add(koLabel);
        final JTextField koField = new JTextField();
        panel.add(koField);
        
        JLabel nameLabel = new JLabel("name");
        panel.add(nameLabel);
        final JTextField nameField = new JTextField();
        panel.add(nameField);
        
        JLabel ageLabel = new JLabel("age");
        panel.add(ageLabel);
        final JTextField ageField = new JTextField();
        panel.add(ageField);
        
        JLabel sexLabel = new JLabel("sex");
        panel.add(sexLabel);
        final JTextField sexField = new JTextField();
        panel.add(sexField);
        
        JLabel cityLabel = new JLabel("city");
        panel.add(cityLabel);
        final JTextField cityField = new JTextField();
        panel.add(cityField);
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.insertIntoOwner(koField.getText(), nameField.getText()
                        , ageField.getText(), sexField.getText(),
                        cityField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
    
    public void insertIntoDog() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel kdLabel = new JLabel("KD");
        panel.add(kdLabel);
        final JTextField kdField = new JTextField();
        panel.add(kdField);
        
        JLabel kbLabel = new JLabel("KB");
        panel.add(kbLabel);
        final JTextField kbField = new JTextField();
        panel.add(kbField);
        
        JLabel koLabel = new JLabel("KO");
        panel.add(koLabel);
        final JTextField koField = new JTextField();
        panel.add(koField);
        
        JLabel kcbLabel = new JLabel("KCB");
        panel.add(kcbLabel);
        final JTextField kcbField = new JTextField();
        panel.add(kcbField);
        
        JLabel kcLabel = new JLabel("KC");
        panel.add(kcLabel);
        final JTextField kcField = new JTextField();
        panel.add(kcField);
        
        JLabel nameLabel = new JLabel("name");
        panel.add(nameLabel);
        final JTextField nameField = new JTextField();
        panel.add(nameField);
        
        JLabel ageLabel = new JLabel("age");
        panel.add(ageLabel);
        final JTextField ageField = new JTextField();
        panel.add(ageField);
        
        JLabel sexLabel = new JLabel("sex");
        panel.add(sexLabel);
        final JTextField sexField = new JTextField();
        panel.add(sexField);
        
        JLabel weightLabel = new JLabel("weight");
        panel.add(weightLabel);
        final JTextField weightField = new JTextField();
        panel.add(weightField);
        
        JLabel heightLabel = new JLabel("height");
        panel.add(heightLabel);
        final JTextField heightField = new JTextField();
        panel.add(heightField);

        JLabel birthdayLabel = new JLabel("birthday");
        panel.add(birthdayLabel);
        final JTextField birthdayField = new JTextField();
        panel.add(birthdayField);
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.insertIntoDog(kdField.getText(), 
                        kbField.getText(), koField.getText(), 
                        kcbField.getText(), kcField.getText(),
                        nameField.getText() , ageField.getText(),
                        sexField.getText(), weightField.getText(),
                        heightField.getText(), birthdayField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
    
    public void deleteFromBreed() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel kbLabel = new JLabel("KB");
        panel.add(kbLabel);
        final JTextField kbField = new JTextField();
        panel.add(kbField);
        
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.deleteFromBreed(kbField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
    
        public void deleteFromClub() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel kcbLabel = new JLabel("KCB");
        panel.add(kcbLabel);
        final JTextField kcbField = new JTextField();
        panel.add(kcbField);
        
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.deleteFromClub(kcbField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
        
    public void deleteFromCynolog() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel kcLabel = new JLabel("KC");
        panel.add(kcLabel);
        final JTextField kcField = new JTextField();
        panel.add(kcField);
        
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.deleteFromCynolog(kcField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
    
    public void deleteFromDog() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel kdLabel = new JLabel("KD");
        panel.add(kdLabel);
        final JTextField kdField = new JTextField();
        panel.add(kdField);
        
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.deleteFromDog(kdField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
    
    public void deleteFromOwner() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel koLabel = new JLabel("KO");
        panel.add(koLabel);
        final JTextField koField = new JTextField();
        panel.add(koField);
        
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean flag = db.deleteFromOwner(koField.getText());
                if (flag) {
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
    
    public void query(final String query, final JTable tables) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));
        this.getContentPane().add(panel);
        
        JLabel koLabel = new JLabel("Введіть значення параметра");
        panel.add(koLabel);
        final JTextField koField = new JTextField();
        panel.add(koField);
        
        
        execBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = String.format(query, koField.getText());
                ArrayList<ArrayList<String>> data = db.query(s);
                if (data != null) {
                    ArrayList<String> col = data.remove(data.size() - 1);
                    tables.setModel(new MyTable(col,data));
                    thisFrame.dispose();
                    parent.setEnabled(true);
                }
                else {
                    mainLabel.setText("Введіть коректні дані!!");
                }
            }
        });
    }
}
