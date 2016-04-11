/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author vujke
 */
public class Prijava {
    private Student student;
    private Predmet predmet;
    private Date datum;
    private String ocena;

    public Prijava(Student student, Predmet predmet, Date datum, String ocena) {
        this.student = student;
        this.predmet = predmet;
        this.datum = datum;
        this.ocena = ocena;
    }
    
    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getOcena() {
        return ocena;
    }
    
    public void setOcena(String ocena){
        this.ocena = ocena;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Prijava other = (Prijava) obj;
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.predmet, other.predmet)) {
            return false;
        }
        return true;
    }

   
    
}
