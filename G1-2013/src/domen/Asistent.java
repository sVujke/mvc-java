/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author vujke
 */
public class Asistent {
    private int SifraAsistenta;
    private String ime;
    private String prezime;
    private String titula;
    private Predmet predmet;
    //private List<StavkaRacuna> stavkeRacuna = new ArrayList<StavkaRacuna>();

    public int getSifraAsistenta() {
        return SifraAsistenta;
    }

    public void setSifraAsistenta(int SifraAsistenta) {
        this.SifraAsistenta = SifraAsistenta;
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

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

   
}
