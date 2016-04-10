/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBbroker;
import domen.Polozio;
import domen.Predmet;
import java.util.List;

/**
 *
 * @author vujke
 */
public class Kontroler {
    
    private static Kontroler instance;
    
    DBbroker db;
    
    public static Kontroler getInstance(){
        if(instance == null){
            instance = new Kontroler();
        }
        return instance;
    }

    public Kontroler() {
        db = new DBbroker();
    }

    public List<Predmet> vratiSvePredmete() {
        return db.vratiSvePredmete();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Polozio> vratiSaPolozenim(Predmet p) {
        return db.vratiSaPolozenim(p);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void obrisiPrijavu(Polozio polozio) {
        db.obrisiPrijavu(polozio);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
