/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dogs;
import javax.swing.table.*;
import java.util.*;
/**
 *
 * @author ivan
 */
public class MyTable extends AbstractTableModel   {
    ArrayList<String> column;
    ArrayList< ArrayList<String> > data;
    
    MyTable(ArrayList<String> col, ArrayList<ArrayList<String>> dat) {
        super();
        column = col;
        data = dat;
    }
    
    @Override
    public int getColumnCount() {
        return column.size();
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public Object getValueAt(int r, int c) {
        return data.get(r).get(c);
    }
    
    @Override
    public String getColumnName(int c) {
        return column.get(c);
    }
}
