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
public class Polozio {
    private String brPrijave;
    private String ocena;
    private Predmet predmet;
    private Student student;

    public Polozio(String brPrijave, String ocena, Predmet predmet, Student student) {
        this.brPrijave = brPrijave;
        this.ocena = ocena;
        this.predmet = predmet;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBrPrijave() {
        return brPrijave;
    }

    public void setBrPrijave(String brPrijave) {
        this.brPrijave = brPrijave;
    }

    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }
    
    
}
