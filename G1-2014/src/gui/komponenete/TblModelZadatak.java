/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponenete;

import domen.Zadatak;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vujke
 */
public class TblModelZadatak extends AbstractTableModel {
    
    List<Zadatak> zadaci;
    String[] kolone = new String[]{"SifraZadatka", "naziv", "opis","datum","zaposleni"};

    public TblModelZadatak(List<Zadatak> zadaci) {
        this.zadaci = zadaci;
    }
    
    
    @Override
    public int getRowCount() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(zadaci == null) return 0;
        return zadaci.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zadatak zad = zadaci.get(rowIndex);
        
        switch(columnIndex){
        case 0: return zad.getSifraZadatka();
        case 3: return zad.getDatum();
        case 1: return zad.getNaziv();
        case 2: return zad.getOpis();
        case 4: return zad.getZaposleni();
        default: return "n/a";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void dodajRed(Zadatak zadatak){
        zadaci.add(zadatak);
        fireTableDataChanged(); // osvezi prikaz tabele 
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(kolone[columnIndex] == "SifraZadatka" || 
                kolone[columnIndex] == "datum" || kolone[columnIndex] == "opis") return true;
        return false;
// return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Zadatak> vratiSve(){
        return zadaci;
    }
    
    
}
