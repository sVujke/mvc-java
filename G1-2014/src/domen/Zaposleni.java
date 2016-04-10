/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author vujke
 */
public class Zaposleni {
    
    //private int id; 
    private String sifra;
    private String ime;
    private String prezime;

    public Zaposleni( String sifra, String ime, String prezime) {
        //this.id = id;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
    }

    // CTRL+SHIFT+C da zakomentarise multi linije :) 
    
    

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;//super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
