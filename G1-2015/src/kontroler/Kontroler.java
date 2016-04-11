/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBbroker;
import domen.Predmet;
import domen.Prijava;
import domen.Student;
import java.sql.SQLException;
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
        System.out.println("kontroler");
        return db.vratiSvePredmete();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Prijava> vratiPolozioSa(Predmet p) {
        System.out.println("Kontroler");
        return db.vratiPolozioSa(p);
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Student> vratiSveStudente(){
        return db.vratiSveStudente();
    }

    public void updatePrijave(List<Prijava> listaUpdate) throws SQLException {
        db.updatePrijave(listaUpdate);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
