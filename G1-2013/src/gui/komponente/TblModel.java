/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Asistent;
import domen.Predmet;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.Kontroler;

/**
 *
 * @author vujke
 */
public class TblModel extends AbstractTableModel {
    
    List<Asistent> asistenti; 
    String[] kolone = new String[]{"Sifra", "Ime", "Prezime", "Titula", "Predmet"};

    public TblModel(List<Asistent> asistenti) {
        this.asistenti = asistenti;
    }
    
    
    @Override
    public int getRowCount() {
        return asistenti.size();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Asistent a = asistenti.get(rowIndex);
        
        switch(columnIndex){
        case 0: return a.getSifraAsistenta();
        case 1: return a.getIme();
        case 2: return a.getPrezime();
        case 4: return a.getPredmet();
        case 3: return a.getTitula();
        default: return "n/a";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Asistent a = asistenti.get(rowIndex);
        Kontroler kontroler = Kontroler.getInstance();
        
        switch(columnIndex){
        case 0: a.setSifraAsistenta(Integer.parseInt((String) aValue));
        case 1: a.setIme((String) aValue);
        case 2: a.setPrezime((String) aValue);
        case 3: a.setTitula((String) aValue);
        case 4: a.setPredmet((Predmet) aValue);
        }
        } catch (Exception e) {
                
        }
        
        
        }
//super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    
    
    

    public void napraviRed() {
        Asistent a = new Asistent();
        Predmet p = new Predmet(0, "ImePredmeta", 0, 0);
        a.setIme("default");
        a.setPrezime("default");
        a.setSifraAsistenta(0);
        a.setTitula("default");
        a.setPredmet(p);
        asistenti.add(a);
        fireTableDataChanged();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];//super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;//super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Asistent> vratiAsistenteIzMemorije(){
        return asistenti;
    }
    

    
}
