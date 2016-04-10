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
/**
 *
 * @author vujke
 */
public class DBkonekcija {
    
//        private static DBkonekcija instance; // pravim instancu ove klase zbog singleton-a
//        
        public DBkonekcija(){ // private da bi mogli da kreiramo samo u ovoj klasi
        }
//        
//        public static DBkonekcija getInstance(){ //Kreiram instancu klase DBkonekcija pomocu ove metode
//            if(instance == null){
//                instance = new DBkonekcija();
//                
//            }
//            
//            return instance;e
//        }
                
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pStmt=null;
        ResultSet rs = null;
        
        public void  ucitajDrajver() throws Exception{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver je ucitan");
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBkonekcija.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception("Greska prilikom ucitavanja drajvera"); // ovo sam dodao
            }
            
        }
        
        public Connection konektujSe() throws Exception{
            
            try {
                
                Class.forName("com.mysql.jdbc.Driver");
                String url = Util.url;
                String password = Util.password;
                String username = Util.username;
                
                //conn = DriverManager.getConnection(url,password,username);
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bazag12014?user=root&password=");
            } catch (SQLException ex) {
                Logger.getLogger(DBkonekcija.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception("Doslo je do greske u konekciji sa bazom podataka");
            }
            return conn;
            // blck i statement samo linija ili sve 
        }
        
        public void diskonektujSe() throws Exception{
            if(conn != null){
                try {
                    conn.close();
                    System.out.println("Diskonektovan");
                } catch (SQLException ex) {
                    Logger.getLogger(DBkonekcija.class.getName()).log(Level.SEVERE, null, ex);
                    throw new Exception("Greska kod zatvaranja konekcije");
                }
            }
            
        }
        
        public List<Zadatak> vratiListuZadataka() throws Exception{
            List<Zadatak> zadaci = new ArrayList<Zadatak>();
            
                ucitajDrajver();
                conn = konektujSe();
                
                String upit = "select * from tzadatak join tzaposleni on tzadatak.zaposleni = tzaposleni.sifra";
                
                stmt = conn.createStatement();
                rs = stmt.executeQuery(upit);
                int i = 0;
                while(rs.next()){
                    
                   String sifra = rs.getString("SifraZadatka");
                   Date datum = rs.getDate("datum");
                   String naziv = rs.getString("naziv");
                   String opis = rs.getString("opis");
                   
                   String sifZap = rs.getString("Sifra");
                   String imeZap = rs.getString("Ime");
                   String prezZap = rs.getString("Prezime");
                   
                   Zaposleni zap = new Zaposleni(sifZap, imeZap, prezZap);
                   
                   
                   Zadatak z = new Zadatak(sifra, datum, naziv, opis, zap);
                   i++;
                   
                   zadaci.add(z);
                }
                
                diskonektujSe();
            
                 
            
            
            return zadaci;
        }
        
        public List<Zaposleni> vratiListuZaposlenih() throws Exception{
            List<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
            ucitajDrajver();
            conn = konektujSe();
            
            stmt = conn.createStatement();
            
            String upit = "select * from tzaposleni";
            
            rs = stmt.executeQuery(upit);
            
            while(rs.next()){
                String sifra = rs.getString("Sifra");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                
                Zaposleni z = new Zaposleni(sifra, ime, prezime);
                
                zaposleni.add(z);
            }
                    
            return zaposleni;
        }
        
       public void sacuvajZadatke(Zadatak zadatak){
            try {
                ucitajDrajver();
                conn = konektujSe();
                
                String upit = ""
                    + "insert into tzadatak "
                    + "(SifraZadatka, naziv, opis, datum, zaposleni) "
                    +
                    "values "
                    +"(?,?,?,?,?)";
                PreparedStatement pStmt = conn.prepareStatement(upit);
                
                //rs = pStmt.executeQuery();
                
                pStmt.setString(1, zadatak.getSifraZadatka());
                
                pStmt.setDate(4, new Date(zadatak.getDatum().getTime()));
                pStmt.setString(2, zadatak.getNaziv());
                pStmt.setString(3, zadatak.getOpis());
                pStmt.setString(5, zadatak.getZaposleni().getSifra());
                
                pStmt.executeUpdate();
                    
                
                diskonektujSe();
                
            } catch (Exception ex) {
                Logger.getLogger(DBkonekcija.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    
}
