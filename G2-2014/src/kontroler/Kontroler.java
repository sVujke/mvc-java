/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBbroker;
import domen.Zadatak;
import domen.Zaposleni;
import java.util.List;

/**
 *
 * @author vujke
 */
public class Kontroler {
    
    private static Kontroler instance;
    private DBbroker db;
    
    public static Kontroler getInstance(){
        if(instance == null){
            instance = new Kontroler();
        }
        
        return instance;
    }

    public Kontroler() {
        db = new DBbroker();
    }
    
    public List<Zaposleni> vratiListuZaposlenih(){
       
        return db.vratiListuZaposlenih();
    }
    
    public List<Zadatak> vratiListuZadataka(){
        return db.vratiListuZadataka();
    }

    public void obrisiZadatkeIzBaze() {
        db.obrisiZadatke();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public void upisiZadatkeIzMemorije(List<Zadatak> vratiZadatkeIzMemorije) {
        db.sacuvajZadatke(vratiZadatkeIzMemorije);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
