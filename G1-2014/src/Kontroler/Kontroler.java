/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import db.DBkonekcija;
import domen.Zadatak;
import domen.Zaposleni;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vujke
 */
public class Kontroler {
    private static Kontroler instance;
    private DBkonekcija db;
    
    public static Kontroler vratiInstancuKontrolera(){
        if(instance == null){
           instance = new Kontroler();
        }
        
        return instance; 
    }
    
    private Kontroler() {
       db = new DBkonekcija(); //ovo sad ne radi jer sam napravio ud DBKon private
    }
    
    public void sacuvajZadatak(Zadatak z){
        
    }
    
    public List<Zadatak> vratiListuZadataka(){
        // poziva metodu iz db 
        List<Zadatak> zadaci = new ArrayList<Zadatak>(); 
        return zadaci;
    }
    
    public List<Zaposleni> vratiListuZaposlenih() throws Exception{
        //List<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
        return db.vratiListuZaposlenih();
        
    }

    public void sacuvaj(List<Zadatak> listaZadataka) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (Zadatak zadatak : listaZadataka) {
           db.sacuvajZadatke(zadatak); 
        }
            
    }
    
    
}
