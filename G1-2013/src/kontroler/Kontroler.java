/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBBroker;
import domen.Asistent;
import domen.Predmet;
import java.util.List;

/**
 *
 * @author vujke
 */
public class Kontroler {
    
    private static Kontroler  instance;
    private DBBroker db;
    
    public static Kontroler getInstance(){
        if(instance == null){
            instance = new Kontroler();
        }
        
        return instance;
    }

    public Kontroler() {
        db = new DBBroker();
    }
    
    public List<Predmet> vratiListuPredmeta(){
        return db.vratiSvePredmete();
    }

    public void napraviRed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Predmet vratiPredmetpoID(int id){
        Predmet p = null;
        List<Predmet> predmeti = vratiListuPredmeta();
        for (int i = 0; i < predmeti.size(); i++) {
            if(predmeti.get(i).getSifraPredmeta() == id){
                p = predmeti.get(i);
                return p;
            }
        }
        return p;
    }

    public void sacuvajAsistente(List<Asistent> vratiAsistenteIzMemorije) {
        db.sacuvajAsistente(vratiAsistenteIzMemorije);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
