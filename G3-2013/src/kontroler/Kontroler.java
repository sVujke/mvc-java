/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBbroker;
import domen.Asistent;
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

    public void sacuvajAsistente(List<Asistent> asistenti) {
        db.sacuvajAsistente(asistenti);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
