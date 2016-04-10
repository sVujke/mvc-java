/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Asistent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vujke
 */
public class TblModel extends AbstractTableModel{

    List<Asistent> asistenti = new ArrayList<Asistent>();
    String[] kolone = new String[]{"Sifra", "Ime", "Prezime","Titula","Predmet"};

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
            case 3: return a.getTitula();
            case 4: return a.getPredmet();
            default: return "n/a";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];//super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Asistent> vratiAsistenteIzMemorije(){
        return asistenti;
    }
    
    public void ubaciAsistenteUMemoriju(Asistent a){
        asistenti.add(a);
        fireTableDataChanged();
    }
    
    public void izbaciAsistenteIzMemoriju(Asistent a){
        asistenti.remove(a);
        fireTableDataChanged();
    }

    public void obrisiAsistente() {
        asistenti.removeAll(asistenti);
        fireTableDataChanged();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
