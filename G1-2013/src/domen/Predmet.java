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
public class Predmet {
    private int sifraPredmeta;
    private String naziv;
    private int semestar;
    private int brBodova;
   // Asistent asistent

    public Predmet(int sifraPredmeta, String naziv, int semestar, int brBodova) {
        this.sifraPredmeta = sifraPredmeta;
        this.naziv = naziv;
        this.semestar = semestar;
        this.brBodova = brBodova;
    }
    
    

    public int getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(int sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    public int getBrBodova() {
        return brBodova;
    }

    public void setBrBodova(int brBodova) {
        this.brBodova = brBodova;
    }

    @Override
    public String toString() {
        return naziv;
    //return "Predmet{" + "sifraPredmeta=" + sifraPredmeta + ", naziv=" + naziv + ", semestar=" + semestar + ", brBodova=" + brBodova + '}';
    }
}
