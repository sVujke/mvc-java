/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Asistent;
import domen.Predmet;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Util;
import java.util.List;

/**
 *
 * @author vujke
 */
public class DBBroker {
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    
    
    public void ucitajDriver() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drajver je ucitan");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw  new Exception("Greska pri ucitavanju drivera");
        }
     }
    
    public Connection konektujSe() throws Exception{
        
        try {
            String url = Util.url;
            String user = Util.username;
            String password = Util.password;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Konektovan!");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greska pri konektovanju");
        }
        
        return conn;
    }
    
    public void diskonektujSe() throws Exception{
        try {
            conn.close();
            System.out.println("Diskonektovan!!");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greska u zatvaranju konekcije");
        }
    }
    
    public List<Predmet> vratiSvePredmete(){
        List<Predmet> predmeti = new ArrayList<Predmet>();
        try {
            ucitajDriver();
            conn = konektujSe();
            
            String upit = "select * from tpredmet";
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery(upit);
            
            while (rs.next()) {                
               int sifraPredmeta =  rs.getInt("Sifra");
               String nazivPredmeta = rs.getString("NazivPredmeta");
               int semestar = rs.getInt("Semestar");
               int brBodova =  rs.getInt("BrojBodova");
               
               Predmet p = new Predmet(sifraPredmeta, nazivPredmeta, semestar, brBodova);
               
               predmeti.add(p);
                
            }
            
            diskonektujSe();
        } catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return predmeti;
    }
    
    public void sacuvajAsistente(List<Asistent> asistenti){
        try {
            ucitajDriver();
            conn = konektujSe();
            
            String upit = "insert into tasistent (Sifra,Ime,Prezime,Titula,PredmetID) values (?,?,?,?,?)";
            
            pStmt = conn.prepareStatement(upit);
            
            for (Asistent asistent : asistenti) {
                pStmt.setInt(1, asistent.getSifraAsistenta());
                pStmt.setString(2, asistent.getIme());
                pStmt.setString(3, asistent.getPrezime());
                pStmt.setString(4, asistent.getTitula());
                
                pStmt.setInt(5, asistent.getPredmet().getSifraPredmeta());
                
            
                pStmt.executeUpdate();
            }
            
            
            
            diskonektujSe();
        } catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
