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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Util;

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
            System.out.println("DRIVER ucitan");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("grska driver");
            
        }
    }
    
    public Connection konektujSe() throws Exception{
        try {
            String url = Util.url;
            String user = Util.username;
            String password = Util.password;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Konektovano");
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("fail KONEKCIJA");
        }
        
        return conn;
    }
    
    public void diskonektujSe() throws Exception{
        try {
            conn.close();
            System.out.println("Diskonektovano");
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("fail DISKONEKCIJA");
        }
    }
    
    public List<Predmet> vratiSvePredmete() throws Exception{
        List<Predmet> predmeti = new ArrayList<Predmet>();
        try {
            ucitajDriver();
            conn = konektujSe();
            
            String upit = "select * from tpredmet";
                       // System.out.println("pre stmt");

            stmt = conn.createStatement();
                       // System.out.println("posle stmt");

                       // System.out.println("pre rs");

            rs = stmt.executeQuery(upit);
            //System.out.println("posle rs");
            while (rs.next()) {                
                int sifra = rs.getInt("Sifra");
                String naziv = rs.getString("Naziv");
                //System.out.println(sifra);
                int semestar = rs.getInt("Semestar");
                int espb = rs.getInt("EspbBodova");
                
                Predmet p = new Predmet(sifra, naziv, semestar, espb);
                predmeti.add(p);
            }
            
            diskonektujSe();
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Ne radi vratiSvePredmete");
        }
        
        return predmeti;
        
    }

    public void sacuvajAsistente(ArrayList<Asistent> asistenti) {
        List<Asistent> asistents = asistenti;
        try {
            
            ucitajDriver();
            conn = konektujSe();
            
            String sql = "insert into tasistent "
                    + " (Sifra, Ime, Prezime, Titula, PredmetID) "
                    + "values"
                    + "(?,?,?,?,?)"; 
            pStmt = conn.prepareStatement(sql);
            
            for (Asistent asistent : asistents) {
                pStmt.setInt(1, asistent.getSifraAsistenta());
                pStmt.setString(2, asistent.getIme());
                pStmt.setString(3, asistent.getPrezime());
                pStmt.setString(4, asistent.getTitula());
                pStmt.setInt(5, asistent.getPredmet().getSifraPredmeta());
                
                pStmt.addBatch();
            }
            
            pStmt.executeBatch();
            
            diskonektujSe();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
