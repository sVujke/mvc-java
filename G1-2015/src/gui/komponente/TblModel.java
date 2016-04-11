/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Prijava;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vujke
 */
public class TblModel extends AbstractTableModel{

        List<Prijava> prijave;
        //List<Prijava> dodatePrijave = new ArrayList<>();
        String[] kolone = new String[]{"Ime i prezime","Datum","BrIndeksa","Ocena","Predmet"};

    public TblModel(ArrayList<Prijava> prijave) {
        this.prijave = prijave;
    }
        
        
    @Override
    public int getRowCount() {
        return prijave.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
       return  kolone.length;
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prijava p = prijave.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getStudent().getIme()+" "+p.getStudent().getPrezime();
            case 1: return p.getDatum();
            case 2: return p.getStudent().getBrIndexa();
            case 3: return p.getOcena();
            case 4: return p.getPredmet().getNaziv();
            default: return "n/a";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];//super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }

    public void popuniTabelu(List<Prijava> prijaveVracene) {
        prijave.clear();
        prijave.addAll(prijaveVracene);
        fireTableDataChanged();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ubaciUPrijave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ubaciUPrijave(Prijava prijava) {
        //dodatePrijave.add(prijava);
        boolean nepreskoci = true;
        for (Prijava p : prijave) {
            if(p.equals(prijava)){
                p.setDatum(prijava.getDatum());
                p.setOcena(prijava.getOcena());
                nepreskoci = false;
                break;
            }
        }
        
        if(nepreskoci){
            prijave.add(prijava);
            
        }
        
        fireTableDataChanged();
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Prijava> vratiPrijaveIzMemorije() {
        return prijave;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
