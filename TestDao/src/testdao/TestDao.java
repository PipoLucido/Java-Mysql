/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Auto.Auto;
import Auto.MotorizadoExeption;
import DAO.AutoDAOsql;
import DAO.DAO;
import DAO.DAOExeption;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */






public class TestDao {


    /**
     * @param args the command line arguments
     * @throws Auto.MotorizadoExeption
     * @throws testdao.MiCalendarioException
     */
    public static void main(String[] args) throws MotorizadoExeption, MiCalendarioException {
        
        
        String URL = "jdbc:mysql://localhost:3306/universidad";
        String USERNAME = "root";
        String PASSWORD = "1234";
        
        DAO dao;
         try {
            
            dao = new AutoDAOsql(URL,USERNAME,PASSWORD);
            
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        
        Calendar fechaX;
        Auto autito;
       
        
        /*
        //INSERTA
        fechaX = new MiCalendario(10, 3, 2009);
        autito = new Auto("123456G7891234567", "chevy","cheto","4646",fechaX);
        
        try {
            dao.insertar(autito);
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        /*
        //MODIFICA
        fechaX = new MiCalendario(9, 1, 2022);
        autito = new Auto("123456G7891234567", "Chevr", "Fuego", "4850", fechaX);

        try {
            dao.modificar(autito,autito.getVin());
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        //ELIMINA 
        
        
        fechaX = new MiCalendario(12, 8, 2012);
        autito = new Auto("123456G7891234567", "Ford#", "model", "4850", fechaX);

        try {
            dao.eliminar(autito.getVin());
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
