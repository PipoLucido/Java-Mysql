/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import Auto.Auto;
import Auto.MotorizadoExeption;
import DAO.AutoDAOsql;
import DAO.AutoDAOtxt;
import DAO.DAO;
import DAO.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* AUTODAO TXT */
        /*
        try {
            Auto auto;
            auto = new Auto(
                    "ee4456ZZ891234567", // VIN
                    "Mejorrrr", // Marca
                    "Saludos", // Modelo
                    "djakf;ldsjafe", // Patente
                    new MiCalendario(10, 1, 3638)); // Fecha de fabricacion

            AutoDAOtxt pruebatxt;
            pruebatxt = new AutoDAOtxt("dao.txt");

            pruebatxt.insertar(auto);
            //pruebatxt.eliminar("034456ZZ891234567");
            //pruebatxt.modificar(auto, "034456ZZ891234567");

        } catch (MotorizadoExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MiCalendarioException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
         */


        /* AUTODAO SQL */
        try {
            String URL = "jdbc:mysql://localhost:3306/universidad";
            String USERNAME = "root";
            String PASSWORD = "1234";

            DAO daosql = new AutoDAOsql(URL, USERNAME, PASSWORD);

            Auto auto = new Auto(
                    "343456ZZ891234567", // VIN
                    "Rolon", // Marca
                    "PULENTA", // Modelo
                    "9863", // Patente
                    new MiCalendario(10, 5, 2077), // Fecha de fabricacion
                    2019, // Anio de disenio
                    70000.65); // Precio

            daosql.insertar(auto);
            //daosql.modificar(auto, auto.getVin());
            //daosql.eliminar(auto.getVin());

        } catch (MotorizadoExeption | MiCalendarioException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
