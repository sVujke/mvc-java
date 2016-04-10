/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Objects;

/**
 *
 * @author vujke
 */
public class Zaposleni {
    
    private String sifraZaposlenog;
    private String ime;
    private String prezime;

    public Zaposleni(String sifraZaposlenog, String ime, String prezime) {
        this.sifraZaposlenog = sifraZaposlenog;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Zaposleni() {
    }

    


    public String getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(String sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
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
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.sifraZaposlenog);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.sifraZaposlenog, other.sifraZaposlenog)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }
    
    
    
    
}
