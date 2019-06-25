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
import java.sql.Date;
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
            dao = new AutoDAOsql(URL, USERNAME, PASSWORD);
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        Calendar fechaX;
        Auto auto;

        fechaX = new MiCalendario(10, 5, 2077);
        
        auto = new Auto(
                "343456ZZ891234567", // VIN
                "Rolon", // Marca
                "PULENTA", // Modelo
                "9863", // Patente
                fechaX, // Fecha de fabricacion
                2019, // Anio de disenio
                70000.65); // Precio
        
        //Insertar(auto, dao);
        //Modificar(auto, dao);
        Eliminar(auto, dao);
    }

    public static void Insertar(Auto auto, DAO dao) {
        try {
            dao.insertar(auto);
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Modificar(Auto auto, DAO dao) {
        try {
            dao.modificar(auto, auto.getVin());
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Eliminar(Auto auto, DAO dao) {
        try {
            dao.eliminar(auto.getVin());
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
