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
public class Student {
    private String godinaUpisa;
    private String brIndexa;
    private String ime;
    private String prezime;
    private String godina;

    public Student(String godinaUpisa, String brIndexa, String ime, String prezime, String godina) {
        this.godinaUpisa = godinaUpisa;
        this.brIndexa = brIndexa;
        this.ime = ime;
        this.prezime = prezime;
        this.godina = godina;
    }
    
    

    public String getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(String godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public String getBrIndexa() {
        return brIndexa;
    }

    public void setBrIndexa(String brIndexa) {
        this.brIndexa = brIndexa;
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

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }
}
