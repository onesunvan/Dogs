package com.dogs;

import java.sql.*;
import java.util.*;

public class DogsDB {
    Connection con;
    
    public DogsDB() {
        try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DogsDB",
                "ivan","100494");
        }
        catch (SQLException e) {
            System.out.println(e + "\n Не вдалося зв’язатися з базою");
        }
    }
    
    public ArrayList<ArrayList<String>> selectFromCynolog() {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Cynolog");
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<String>();
                row.add(rs.getString("KC"));
                row.add(rs.getString("name"));
                row.add(rs.getString("age"));
                row.add(rs.getString("sex"));
                row.add(rs.getString("stage"));
                data.add(row);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }        
        return data; 
    }
    
    public ArrayList<ArrayList<String>> selectFromBreed() {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Breed");
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<String>();
                row.add(rs.getString("KB"));
                row.add(rs.getString("name"));
                row.add(rs.getString("year"));
                row.add(rs.getString("country"));
                row.add(rs.getString("assignment"));
                data.add(row);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }        
        return data; 
    }
    
    public ArrayList<ArrayList<String>> selectFromClub() {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Club");
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<String>();
                row.add(rs.getString("KCB"));
                row.add(rs.getString("name"));
                row.add(rs.getString("kerivnik"));
                row.add(rs.getString("year"));
                row.add(rs.getString("city"));
                data.add(row);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }        
        return data; 
    }
    
    public ArrayList<ArrayList<String>> selectFromOwner() {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Owner");
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<String>();
                row.add(rs.getString("KO"));
                row.add(rs.getString("name"));
                row.add(rs.getString("age"));
                row.add(rs.getString("sex"));
                row.add(rs.getString("city"));
                data.add(row);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }        
        return data; 
    }
    
    public ArrayList<ArrayList<String>> selectFromDog() {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Dog");
            while (rs.next()) {
                ArrayList<String> row = new ArrayList<String>();
                row.add(rs.getString("KD"));
                row.add(rs.getString("KB"));
                row.add(rs.getString("KO"));
                row.add(rs.getString("KCB"));
                row.add(rs.getString("KC"));
                row.add(rs.getString("name"));
                row.add(rs.getString("age"));
                row.add(rs.getString("sex"));
                row.add(rs.getString("weight"));
                row.add(rs.getString("height"));
                row.add(rs.getString("birthday"));
                data.add(row);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }        
        return data; 
    }
    
    public boolean insertIntoCynolog(String KC, String name, String age,
            String sex, String stage) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `DogsDB`.`Cynolog` "
                    + " VALUES ('" + KC + "', '"
                    + name + "',"
                    + age + " , '" + sex + "'"
                    + "," + stage + " )");
        }
        catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public boolean insertIntoBreed(String KB, String name, String year,
            String country, String assignment) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `DogsDB`.`Breed` "
                    + " VALUES ('" + KB + "', '"
                    + name + "',"
                    + year + " , '" + country + "'"
                    + ", '" + assignment + "' )");
        }
        catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public boolean insertIntoClub(String KCB, String name, String kerivnik,
            String year, String city) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `DogsDB`.`Club` "
                    + " VALUES ('" + KCB + "', '"
                    + name + "', '"
                    + kerivnik + "' , " + year 
                    + ", '" + city + "' )");
        }
        catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public boolean insertIntoOwner(String KO, String name, String age,
            String sex, String city) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `DogsDB`.`Owner` "
                    + " VALUES ('" + KO + "', '"
                    + name + "',"
                    + age + " , '" + sex + "'"
                    + ", '" + city + "' )");
        }
        catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public boolean insertIntoDog(String KD, String KB, String KO,
            String KCB, String KC, String name, String age, String sex, 
            String weight, String height, String birthday ) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `DogsDB`.`Dog` "
                    + " VALUES ('" + KD + "', '"
                    + KB + "', '"
                    + KO + "' , '" + KCB + "'"
                    + ", '" + KC + "', "
                    +"'" + name + "', " + age + ", '" + sex + "', " +
                    weight + ", " + height + ", '" + birthday +
                    "')");
        }
        catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteFromBreed(String KB) {
         try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `DogsDB`.`Breed` WHERE `KB`='"
                    + KB + "';");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteFromClub(String KCB) {
         try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `DogsDB`.`Club` WHERE `KCB`='"
                    + KCB + "';");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteFromCynolog(String KC) {
         try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `DogsDB`.`Cynolog` WHERE `KC`='"
                    + KC + "';");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteFromDog(String KD) {
         try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `DogsDB`.`Dog` WHERE `KD`='"
                    + KD + "';");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteFromOwner(String KO) {
         try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `DogsDB`.`Owner` WHERE `KO`='"
                    + KO + "';");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean update(String table, String id, String idValue,
            String col, String colValue) {
        boolean flag = true;
        if (!(col.equals("age") || col.equals("stage") || col.equals("year")
                || col.equals("weight") || col.equals("height"))) {
            colValue = "'" + colValue + "'";
        }
        try {
            Statement stmnt = con.createStatement();
            stmnt.executeUpdate("UPDATE `DogsDB`.`" + table + "` SET `" + col +
                   "`= " + colValue + " WHERE `" + id + "`='" + idValue + "';");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public ArrayList<ArrayList<String>> query(String s) {
        ArrayList<String> column = new ArrayList<String>();;
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            Statement stmnt = con.createStatement();
            ResultSet res = stmnt.executeQuery(s);
            ResultSetMetaData met = res.getMetaData();
            for (int i = 1; i <= met.getColumnCount(); i++) {
                column.add(met.getColumnName(i));
            }
            while (res.next()) {
                ArrayList<String> row = new ArrayList<String>();
                for (int i = 0; i < column.size(); i++) {
                    row.add(res.getString(column.get(i)));
                } 
                data.add(row);
            }
            data.add(column);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }
}


