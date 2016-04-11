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
public class Predmet {
    String sifraPredmeta;
    String naziv;

    public Predmet(String sifraPredmeta, String naziv) {
        this.sifraPredmeta = sifraPredmeta;
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    } 
    

    public String getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(String sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Predmet other = (Predmet) obj;
        if (!Objects.equals(this.sifraPredmeta, other.sifraPredmeta)) {
            return false;
        }
        return true;
    }
}
