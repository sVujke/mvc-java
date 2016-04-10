/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Polozio;
import domen.Predmet;
import domen.Student;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.Kontroler;

/**
 *
 * @author vujke
 */
public class TblModel extends AbstractTableModel{
    
    List<Polozio> polozili;
    String[] kolone = new String[]{"Godina upisa","BRoj indeksa","Ime i Prezime", "Ocena"};

    public TblModel(ArrayList<Polozio> polozili) {
        this.polozili = polozili;
    }
    
    
    @Override
    public int getRowCount() {
        return polozili.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Polozio p = polozili.get(rowIndex);
       Student s = p.getStudent();
        //Predmet red = p.getPredmet();
       switch(columnIndex){
           case 0: return s.getGodinaUpisa();
           case 1: return s.getBrIndexa();
                   case 2: return s.getIme()+s.getPrezime();
                           case 3: return p.getOcena();
                           default: return "n/a";
       }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column]; //super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }

    

  

    public void prikaziStudene(List<Polozio> vratiSaPolozenim) {
        polozili.clear();
        polozili.addAll(vratiSaPolozenim);
        //Collections()
        fireTableDataChanged();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Polozio vratiPolozioIzMemorije(int red){
            System.out.println(polozili.get(red).getPredmet());
        return polozili.get(red);
         
    }
    
    public List<Polozio> vratiPoloziliIzMemorije(){
         return polozili;
    }
}
