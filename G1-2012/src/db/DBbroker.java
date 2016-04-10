/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Polozio;
import domen.Predmet;
import domen.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Util;

/**
 *
 * @author vujke
 */
public class DBbroker {
    
    Connection conn;
    Statement stmt;
    PreparedStatement pStmt;
    ResultSet rs;
    
    public void ucitajDriver() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ucitan");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception();
        }
    }
    
    public Connection konektujSe() throws Exception{
        try {
            String url = Util.url;
            String user = Util.username;
            String password = Util.password;
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception();
        }
        return conn;
    }
    
    public void diskonektujSe() throws Exception{
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception();
            }
        }
    }

    public List<Predmet> vratiSvePredmete() {
        List<Predmet> predmeti = new ArrayList<Predmet>();
        try {
            //List<Predmet> predmeti = new ArrayList<Predmet>();
            ucitajDriver();
            System.out.println("Driver pa kon");
            conn = konektujSe();
            System.out.println("kon");
            stmt = conn.createStatement();
            
            String upit = "select * from tpredmet";
            
            rs = stmt.executeQuery(upit);
            
            while (rs.next()) {                
                String sifra = rs.getString("SifraPredmeta");
                String naziv =rs.getString("NazivPredmeta");
                
                Predmet p = new Predmet(sifra, naziv);
                predmeti.add(p);
            }
            
            diskonektujSe();
           
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
         return predmeti;
    }

    public List<Polozio> vratiSaPolozenim(Predmet p) {
        List<Polozio> polozili = new ArrayList<Polozio>();
        try {
            
            ucitajDriver();
            //System.out.println("Driver pa kon");
            conn = konektujSe();
               //System.out.println(" kon"); 
            String upit = "select * from tpolozio join "
                    + "tstudent on tpolozio.GodinaUpisa = tstudent.GodinaUpisa"
                    + " and tpolozio.BrojIndexa = tstudent.BrojIndexa"
                    + " where SifraPredmeta="+p.getSifraPredmeta();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery(upit);
            
            while (rs.next()) {                
               String brPrijave =  rs.getString("BrojPrijave");
               String godUpisa = rs.getString("GodinaUpisa");
               String index = rs.getString("BrojIndexa");
               //String sifraPredmeta = rs.getString("SifraPredmeta");
               String ocena = rs.getString("Ocena");
               String ime = rs.getString("Ime");
               String prezime = rs.getString("Prezime");
               String godina = rs.getString("Godina");
               
               
               Student student = new Student(godUpisa, index, ime, prezime, godina);
               Polozio pol = new Polozio(brPrijave, ocena, p, student);
               
               polozili.add(pol);
            }
            
            diskonektujSe();
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return polozili;
    }

    public void obrisiPrijavu(Polozio polozio) {
        try {
            ucitajDriver();
            conn = konektujSe();
            
           //Polozio p = polozio;
            
            String upit = "delete from tpolozio where BrojPrijave="+polozio.getBrPrijave();
            
            stmt = conn.createStatement();
            stmt.executeUpdate(upit);
            diskonektujSe();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
