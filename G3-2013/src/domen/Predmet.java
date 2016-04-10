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
    private int sfiraPredmeta;
    private String Naziv;
    private int semestar;
    private int espb;

    public Predmet(int sfiraPredmeta, String Naziv, int semestar, int espb) {
        this.sfiraPredmeta = sfiraPredmeta;
        this.Naziv = Naziv;
        this.semestar = semestar;
        this.espb = espb;
    }

    
    public int getSfiraPredmeta() {
        return sfiraPredmeta;
    }

    public void setSfiraPredmeta(int sfiraPredmeta) {
        this.sfiraPredmeta = sfiraPredmeta;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }
}
