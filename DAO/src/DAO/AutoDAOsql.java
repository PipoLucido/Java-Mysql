/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Auto.Auto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo
 */
public class AutoDAOsql extends DAO<Auto, String> {

    
   public static Connection getConection(String URL,String USERNAME,String PASSWORD) {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion exitosa!");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public AutoDAOsql(String URL,String USERNAME,String PASSWORD) throws DAOExeption {
        
      setUrl(URL);
      setUsername(USERNAME);
      setPassword(PASSWORD);
 
    }

    
     String URL ;
     String USERNAME ;
     String PASSWORD;
    
    
        public final void setUrl(String url) throws DAOExeption {
        
         this.URL = url;
        
        }
        
        public final void setUsername(String user) throws DAOExeption {
        
         this.USERNAME = user;
        
        }
        
        public final void setPassword(String pass) throws DAOExeption {
        
         this.PASSWORD = pass;
        
        }
    
    
    @Override
    public void insertar(Auto entidad) throws DAOExeption {
        
            Connection con = null;
        
        try {
            
            con = getConection(URL,USERNAME,PASSWORD);
            
            PreparedStatement ps;
            
            //  NO TENEMOS PRECIO EN LA ENTIDAD | TAMPOCO GET AÑO
           
            ps = con.prepareStatement("INSERT INTO autos VALUES (\""+entidad.getVin()+"\", \""+entidad.getPatente()+"\",'"+entidad.getFechaFab()+"',4666,'"+entidad.getMarca()+"', 1996)");  //ORDEN A MYSQL

            ps.execute();

            con.close();
            } catch (Exception e) {
            System.out.println(e);
        }
                  
    }

    @Override
    public void modificar(Auto entidad,String keyVin) throws DAOExeption {
        
            Connection con = null;
        
        try {
            
            con = getConection(URL,USERNAME,PASSWORD);
            
            PreparedStatement ps;
            
            //  NO TENEMOS PRECIO EN LA ENTIDAD | TAMPOCO GET AÑO
           
            ps = con.prepareStatement("UPDATE autos SET PATENTE=\"1111\" WHERE VIN=\""+keyVin+"\"");  //ORDEN A MYSQL

            ps.execute();    //EJECUTAR ORDER

            con.close();
            } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(String vinKey) throws DAOExeption {
        Connection con = null;
        
        try {
            
            con = getConection(URL,USERNAME,PASSWORD);
            
            PreparedStatement ps;
           
            ps = con.prepareStatement("DELETE from autos WHERE VIN=\""+vinKey+"\" ");  //ORDEN A MYSQL

            ps.execute();    //EJECUTAR ORDER

            con.close();
            } catch (Exception e) {
            System.out.println(e);
        }
      
    }

    @Override
    public Auto buscar(String clave) throws DAOExeption {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Auto> listar() throws DAOExeption {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
