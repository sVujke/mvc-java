/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Asistent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

    public void sacuvajAsistente(List<Asistent> asistenti) throws Exception {
        
        try {
            ucitajDriver();
            conn = konektujSe();
            List<Asistent> asistents = new ArrayList<Asistent>(asistenti);
            
            String upit = "insert into tasistent "
                    + "(SifraAsistenta, Ime, Prezime, Titula, PredmetID) values"
                    + " (?,?,?,?,?) ";
            
            pStmt = conn.prepareStatement(upit);
            
            for (Asistent asistent : asistents) {
                pStmt.setInt(1, asistent.getSifraAsistenta());
                pStmt.setString(2, asistent.getIme());
                pStmt.setString(3, asistent.getPrezime());
                pStmt.setString(4, asistent.getTitula());
                pStmt.setInt(5, asistent.getPredmet().getSfiraPredmeta());
                
                pStmt.addBatch();
            }
            pStmt.executeBatch();
            diskonektujSe();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(, ex);
            throw new Exception(ex.getMessage());
        }
        
    }
    
    
}
