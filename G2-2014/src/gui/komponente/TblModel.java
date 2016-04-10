/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Zadatak;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vujke
 */
public class TblModel extends AbstractTableModel{
    List<Zadatak> zadaci;
    String[] kolone = new String[]{"SifraZadatka","naziv","opis","datum","zaposleni"};

    public TblModel(List<Zadatak> zadaci) {
        this.zadaci = zadaci;
    }

    @Override
    public int getRowCount() {
        if(zadaci==null) return 0;
        return zadaci.size();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zadatak zad = zadaci.get(rowIndex);
        switch(columnIndex){
            case 0: return zad.getSifraZadatka();
            case 1: return zad.getNaziv();
            case 2: return zad.getOpis();
            case 3: return zad.getDatum();
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
    
    public void popuniTabelu(List<Zadatak> zadaciBaza){
        zadaci = zadaciBaza;
    }

    public void dodajRed(Zadatak z) {
        zadaci.add(z);
        fireTableDataChanged();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Zadatak> vratiZadatkeIzMemorije(){
        return zadaci;
    }
    
}
