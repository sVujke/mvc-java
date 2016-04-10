/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import domen.Zadatak;
import domen.Zaposleni;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Util;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author vujke
 */
public class DBbroker {
    
    Connection conn = null; 
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    
    
    public void ucitajDriver() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ucitan");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greska prilikom ucitavanja drivera");
        }
        
    }
    
    public Connection konektujSe() throws Exception{
        try {
            String url = Util.url;
            String username = Util.username;
            String password = Util.password;
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Konekcija uspostavljena");
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Doslo je do greske pri konekciji");
        }
        
        return conn;
    }
    
    public void diskonektujSe() throws Exception{
        if(conn != null){
            try {
            conn.close();
                System.out.println("Diskonektovan");
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Doslo je do greske kod zatvaranja konekcije");
        }
        }
        
    }
    
    public List<Zadatak> vratiListuZadataka(){
        List<Zadatak> zadaci = new ArrayList<>();
        try {
            ucitajDriver();
            conn = konektujSe();
            
            
            String upit = "select * from tzadatak join tzaposleni on tzadatak.zaposleni = tzaposleni.SifraZaposlenog";
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(upit);
            
            while(rs.next()){
                String sifraZadatka = rs.getString("SifraZadatka");
                Date datum = rs.getDate("datum");
                String naziv = rs.getString("naziv");
                String opis = rs.getString("opis");
                String sifraZaposlenog = rs.getString("zaposleni");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                
                Zaposleni z = new Zaposleni(sifraZaposlenog, ime, prezime);
                
                Zadatak zad = new Zadatak(sifraZadatka, datum, naziv, opis, z);
                        zadaci.add(zad);
                }
            
            diskonektujSe();
            
            
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return zadaci;
        
    }
    
    public List<Zaposleni> vratiListuZaposlenih(){
        List<Zaposleni> zaposleni = new ArrayList<>();
        try {
            
            ucitajDriver();
            conn = konektujSe();
            
            String upit = "select * from tzaposleni";
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(upit);
            
            while(rs.next()){
                String sif = rs.getString("SifraZaposlenog");
                
                String ime = rs.getString("Ime");
                System.out.println(ime);
                String prezime = rs.getString("Prezime");
                
                Zaposleni z = new Zaposleni(sif, ime, prezime);
                
                zaposleni.add(z);
            }
            diskonektujSe();
            //return zaposleni;
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return zaposleni;
    }
    
    public void obrisiZadatke(){
        try {
            ucitajDriver();
            conn = konektujSe();
            
            String upit = "delete from tzadatak";
            
            stmt = conn.createStatement();
            
            stmt.executeUpdate(upit);
            
            diskonektujSe();
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sacuvajZadatke(List<Zadatak> zadaci){
        try {
            ucitajDriver();
            conn = konektujSe();
            //System.out.println(zadaci.size());
            
            String upit = "insert into tzadatak "
                    + "(SifraZadatka, naziv, opis, datum, zaposleni)"
                    +"values"+
                    "(?,?,?,?,?)";
            
            pStmt = conn.prepareStatement(upit);
            for (Zadatak zadatak : zadaci) {
                pStmt.setString(1, zadatak.getSifraZadatka());
                pStmt.setString(2, zadatak.getNaziv());
                pStmt.setString(3, zadatak.getOpis());
                pStmt.setDate(4, new Date(zadatak.getDatum().getTime()));
                pStmt.setString(5, zadatak.getZaposleni().getSifraZaposlenog());
                
                pStmt.executeUpdate();
            }
            
            //JOptionPane.showMessageDialog(true, "To je to");
            diskonektujSe();
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
