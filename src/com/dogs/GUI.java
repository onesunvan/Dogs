/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dogs;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/**
 *
 * @author ivan
 */
public class GUI extends JFrame {
    Box northBox;  
    Box southBox;
    JTable tables;
    DogsDB db;
    JFrame thisFrame = this;
    
    
    
    
    public GUI() {
        super("Dogs");
        db = new DogsDB();
        
        tables = new JTable();
        JScrollPane scrollPane = new JScrollPane(tables);
        tables.setFillsViewportHeight(true);        
        this.getContentPane().add(BorderLayout.CENTER, scrollPane);
        
        northBox = new Box(BoxLayout.LINE_AXIS);
        this.getContentPane().add(BorderLayout.NORTH, northBox);
        
        crtBtnSelectBre();
        crtBtnSelectClub();
        crtBtnSelectCyn();
        crtBtnSelectDog();
        crtBtnSelectOwner();
        
        createMenu();
        
        southBox = new Box(BoxLayout.PAGE_AXIS);
        this.getContentPane().add(BorderLayout.SOUTH, southBox);
        
        crtButton("Знайти клички собак по заданому імені породи",
                "SELECT Dog.name "
                + "FROM Dog " + 
                "WHERE Dog.KB " + "IN ( " +
                "SELECT Breed.KB FROM Breed WHERE Breed.name = '%1$s')");
       
        crtButton("Знайти імена людей, собаки яких входять до клубу,"
                + " з заданим ім’ям",
                "SELECT Owner.name "
                + "FROM Owner "
                + "WHERE Owner.KO IN ( "
                    + "SELECT Dog.KO "
                    + "FROM Dog "
                    + "WHERE Dog.KCB IN ( "
                        + "SELECT Club.KCB "
                        + "FROM Club "
                        + "WHERE Club.name='%1$s'))");
        
        crtButton("Знайти імена і вік тих кінологів, стаж яких більше заданого",
                "SELECT Cynolog.name, Cynolog.age "
                + "FROM Cynolog "
                + "WHERE Cynolog.stage>%1$s");
        
        crtButton("Знайти вагу і зріст тих собак, порода яких виникла"
                + " не в заданій країні",
                "  SELECT Dog.weight, Dog.height "
                + "FROM Dog "
                + "WHERE Dog.KB NOT IN ( "
                    + "SELECT Breed.KB "
                    + "FROM Breed "
                    + "WHERE Breed.country='%1$s')");
        
        crtButton("Знайти дату народження собак, власники "
                + "яких не з заданого міста",
                "  SELECT Dog.birthday "
                + "FROM Dog "
                + "WHERE Dog.KO NOT IN ("
                + "SELECT Owner.KO "
                + "FROM Owner "
                + "WHERE Owner.city='%1$s')");
        
        crtButton("Знайти імена тих кінологів, які тренують собак"
                + " тільки заданої породи",
                "  SELECT Cynolog.name "
                + "FROM Cynolog "
                + "WHERE NOT EXISTS ( "
                    + "SELECT Dog.KD "
                    + "FROM Dog "
                    + "WHERE (Dog.KC=Cynolog.KC) AND (Dog.KD NOT IN ("
                        + "SELECT Dog1.KD "
                        + "FROM Dog AS Dog1 "
                        + "WHERE Dog1.KB IN ( "
                            + "SELECT Breed.KB "
                            + "FROM Breed "
                            + "WHERE Breed.name='%1$s'))))");
        
        crtButton("Знайти роки створення тих клубів,"
                + " до яких входять тільки собаки заданого господаря ",
                "  SELECT Club.year "
                + "FROM Club "
                + "WHERE NOT EXISTS ( "
                    + "SELECT Dog.KD "
                    + "FROM Dog "
                    + "WHERE Dog.KD NOT IN ( "
                        + "SELECT D1.KD "
                        + "FROM Dog AS D1 "
                        + "WHERE D1.KO IN ( "
                            + "SELECT Owner.KO "
                            + "FROM Owner "
                            + "WHERE Owner.name='%1$s')) "
                    + "AND Dog.KD IN ( "
                        + "SELECT D2.KD "
                        + "FROM Dog AS D2 "
                        + "WHERE D2.KCB=Club.KCB))");
        
        crtButton("Знайти імена тих кінологів, що обслуговують лише"
                + " клієнтів із заданого міста",
                "  SELECT Cynolog.name "
                + "FROM Cynolog "
                + "WHERE NOT EXISTS ( "
                + "SELECT Dog.KD "
                + "FROM Dog "
                + "WHERE Dog.KD IN ( "
                + "SELECT D1.KD "
                + "FROM Dog AS D1 "
                + "WHERE D1.KC=Cynolog.KC) "
                + "AND Dog.KD NOT IN ( "
                + "SELECT D2.KD "
                + "FROM Dog AS D2 "
                + "WHERE D2.KO IN ( "
                + "SELECT Owner.KO "
                + "FROM Owner "
                + "WHERE Owner.city='%1$s')))");
        
        crtButton("Знайти назву породу, всі собаки якої принаймні"
                + " у заданого кінолога",
                "  SELECT Breed.name "
                + "FROM Breed "
                + "WHERE NOT EXISTS ("
                + "SELECT Dog.KD "
                + "FROM Dog "
                + "WHERE Dog.KC IN ( "
                + "SELECT Cynolog.KC "
                + "FROM Cynolog "
                + "WHERE Cynolog.name='%1$s' ) "
                + "AND NOT (Dog.KB=Breed.KB))");
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
    }
    
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        JMenu addRow = new JMenu("Add Row");
        JMenu deleteRow = new JMenu("Delete Row");
        menuBar.add(addRow);
        menuBar.add(deleteRow);
        
        JMenuItem addBre = new JMenuItem("Add Row to Breed");
        addBre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFrame cynfrm = new AddFrame(thisFrame, db);
                cynfrm.insertIntoBreed();
            }
        });
        
        JMenuItem addClub = new JMenuItem("Add Row to Club");
        addClub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFrame cynfrm = new AddFrame(thisFrame, db);
                cynfrm.insertIntoClub();
            }
        });
        
        JMenuItem addCyn = new JMenuItem("Add Row to Cynolog");
        addCyn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFrame cynfrm = new AddFrame(thisFrame, db);
                cynfrm.insertIntoCynolog();
            }
        });
        
        JMenuItem addDog = new JMenuItem("Add Row to Dog");
        addDog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFrame cynfrm = new AddFrame(thisFrame, db);
                cynfrm.insertIntoDog();
            }
        });        
        
        JMenuItem addOwn = new JMenuItem("Add Row to Owner");
        addOwn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFrame cynfrm = new AddFrame(thisFrame, db);
                cynfrm.insertIntoOwner();
            }
        });
        
        addRow.add(addBre);
        addRow.add(addClub);
        addRow.add(addCyn);
        addRow.add(addDog);
        addRow.add(addOwn);
        
        JMenuItem delBre = new JMenuItem("Delete Row from Breed");
        delBre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFrame frm = new AddFrame(thisFrame, db);
                frm.deleteFromBreed();
            }
        });
        JMenuItem delClub = new JMenuItem("Delete Row from Club");
        delClub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFrame frm = new AddFrame(thisFrame, db);
                frm.deleteFromClub();
            }
        });
        JMenuItem delCyn = new JMenuItem("Delete Row from Cynolog");
        delCyn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFrame frm = new AddFrame(thisFrame, db);
                frm.deleteFromCynolog();
            }
        });
        JMenuItem delDog = new JMenuItem("Delete Row from Dog");
        delDog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFrame frm = new AddFrame(thisFrame, db);
                frm.deleteFromDog();
            }
        });
        JMenuItem delOwn = new JMenuItem("Delete Row from Owner");
        delOwn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFrame frm = new AddFrame(thisFrame, db);
                frm.deleteFromOwner();
            }
        });
        
        deleteRow.add(delBre);
        deleteRow.add(delClub);
        deleteRow.add(delCyn);
        deleteRow.add(delDog);
        deleteRow.add(delOwn);
        
        JMenuItem updt = new JMenuItem("Update");
        menuBar.add(updt);
        updt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateFrame updtFr = new UpdateFrame(thisFrame, db);
            }
        });
        
        JMenuItem help = new JMenuItem("Help");
        menuBar.add(help);
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HelpFrame hlp = new HelpFrame(thisFrame);
                
            }
        });
        
        
    }
    
    private void crtBtnSelectCyn() {
        JButton selectBtnCyn = new JButton("Таблиця Cynolog ");
        selectBtnCyn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> column = new ArrayList<String>();
                column.add("KC");
                column.add("name");
                column.add("age");
                column.add("sex");
                column.add("stage");
                ArrayList<ArrayList<String>> data = db.selectFromCynolog();
                tables.setModel(new MyTable(column, data));
            }
        });
        northBox.add(selectBtnCyn);
    }
      
    private void crtBtnSelectBre() {
        JButton selectBtnBre = new JButton("Таблиця Breed ");
        selectBtnBre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> column = new ArrayList<String>();
                column.add("KB");
                column.add("name");
                column.add("year");
                column.add("country");
                column.add("assignment");
                ArrayList<ArrayList<String>> data = db.selectFromBreed();
                tables.setModel(new MyTable(column, data));
            }
        });
        northBox.add(selectBtnBre);
    }
    
    private void crtBtnSelectClub() {
        JButton selectBtnClu = new JButton("Таблиця Club ");
        selectBtnClu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> column = new ArrayList<String>();
                column.add("KCB");
                column.add("name");
                column.add("kerivnik");
                column.add("year");
                column.add("city");
                ArrayList<ArrayList<String>> data = db.selectFromClub();
                tables.setModel(new MyTable(column, data));
            }
        });
        northBox.add(selectBtnClu);
    }
    
    private void crtBtnSelectOwner() {
        JButton selectBtnOwn = new JButton("Таблиця Owner ");
        selectBtnOwn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> column = new ArrayList<String>();
                column.add("KO");
                column.add("name");
                column.add("age");
                column.add("sex");
                column.add("city");
                ArrayList<ArrayList<String>> data = db.selectFromOwner();
                tables.setModel(new MyTable(column, data));
            }
        });
        northBox.add(selectBtnOwn);
    }
    
    private void crtBtnSelectDog() {
        JButton selectBtnDog = new JButton("Таблиця Dog ");
        selectBtnDog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> column = new ArrayList<String>();
                column.add("KD");
                column.add("KB");
                column.add("KO");
                column.add("KCB");
                column.add("KC");
                column.add("name");
                column.add("age");
                column.add("sex");
                column.add("weight");
                column.add("height");
                column.add("birthday");
                ArrayList<ArrayList<String>> data = db.selectFromDog();
                tables.setModel(new MyTable(column, data));
            }
        });
        northBox.add(selectBtnDog);
    }

    private void crtButton(String name, final String query) {
        JButton selectButton = new JButton(name);
        southBox.add(selectButton);
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFrame frm = new AddFrame(thisFrame,db);
                frm.query(query, tables);
            }
        });
    }
}
