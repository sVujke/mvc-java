/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Predmet;
import domen.Prijava;
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
    
    public void  ucitajDrajver() throws Exception{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver je ucitan");
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception("Greska prilikom ucitavanja drajvera"); // ovo sam dodao
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
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Greska pri konektovanju");
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
                    throw new Exception("Greska kod zatvaranja konekcije");
                }
            }
            
        }

    public List<Predmet> vratiSvePredmete() {
        List<Predmet> predmeti = new ArrayList<Predmet>();
        try {
            ResultSet rs;
            Statement stmt;
            
            ucitajDrajver();
            conn = konektujSe();
            
            String upit = "select * from tpredmet";
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(upit);
            
            while(rs.next()){
                String sifra = rs.getString("SifraPredmeta");
                String naziv = rs.getString("Naziv");
                
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
    
    public List<Student> vratiSveStudente() {
        List<Student> studenti = new ArrayList<Student>();
        try {
            ResultSet rs;
            Statement stmt;
            
            ucitajDrajver();
            conn = konektujSe();
            
            String upit = "select * from tstudent";
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(upit);
            
            while(rs.next()){
                String index = rs.getString("BrIndeksa");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                Student stud = new Student(index, ime, prezime);
                studenti.add(stud);
                
               
            }
            
             diskonektujSe();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return studenti;
    }

    public List<Prijava> vratiPolozioSa(Predmet p) {
        List<Prijava> prijave = new ArrayList<Prijava>();
        String upit;
            Statement stmt;
            ResultSet rs;
        try {
            
            if(p.getSifraPredmeta().equals("-1")){
                upit = "select tprijava.*,tpredmet.*,tstudent.*"
                        + " from tprijava "
                        + "join tpredmet on tprijava.SifraPredmeta = tpredmet.SifraPredmeta "
   
                        + "join tstudent on tprijava.BrIndexa = tstudent.BrIndeksa";
            } else{
                upit = "select tprijava.*,tpredmet.*,tstudent.*"
                        + " from tprijava "
                        + "join tpredmet on tprijava.SifraPredmeta = tpredmet.SifraPredmeta "
                        
                        + "join tstudent  on tprijava.BrIndexa = tstudent.BrIndeksa"
                        + " "
                        + "where tpredmet.SifraPredmeta="+p.getSifraPredmeta();
                
            }
            
            ucitajDrajver();
            conn = konektujSe();
            
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery(upit);
            while(rs.next()){
               String index = rs.getString("BrIndexa");
               String sifPred = rs.getString("SifraPredmeta");
               Date datum = rs.getDate("Datum");
               String ocena = rs.getString("Ocena");
                String naziv =rs.getString("Naziv");
                //rs.getString("BrIndeksa");
                String ime =rs.getString("Ime");
                String prezime =rs.getString("Prezime");
                
                Student s = new Student(index, ime, prezime);
                Predmet pred = new Predmet(sifPred, naziv);
                Prijava pr = new Prijava(s, pred, datum, ocena);
                
                prijave.add(pr);
            }
            diskonektujSe();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(prijave.size());
        return prijave;
    }

    public void updatePrijave(List<Prijava> listaUpdate) throws SQLException {
        try {
            String upit1;
            String upit2;
            PreparedStatement pstmt;
            Statement stmt;
            ResultSet rs;
            
            ucitajDrajver();
            conn = konektujSe();
            conn.setAutoCommit(false);
            
            upit1 = "delete from tprijava";
            
            stmt = conn.createStatement();
            stmt.executeUpdate(upit1);
            
            upit2 = "insert into tprijava"
                    + " "
                    + "(BrIndexa, SifraPredmeta, Datum, Ocena) values"
                    + " (?,?,?,?)";
            
            pstmt = conn.prepareStatement(upit2);
            
            
            for (Prijava listItem : listaUpdate) {
                
                pstmt.setString(1, listItem.getStudent().getBrIndexa());
                pstmt.setString(2, listItem.getPredmet().getSifraPredmeta());
                pstmt.setDate(3, new Date(listItem.getDatum().getTime()));
                pstmt.setString(4, listItem.getOcena());
            }
            
            pstmt.executeUpdate();
            conn.commit();
            diskonektujSe();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
            conn.rollback();
        }
    }
}
