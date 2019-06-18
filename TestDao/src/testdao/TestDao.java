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
import DAO.AutoDAOtxt;
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

    
    public static final String URL = "jdbc:mysql://localhost:3306/escuela";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";

 


public static Connection getConection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion exitosa!");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
      

    /**
     * @param args the command line arguments
     * @throws Auto.MotorizadoExeption
     * @throws testdao.MiCalendarioException
     */
    public static void main(String[] args) throws MotorizadoExeption, MiCalendarioException {
        
        //MYSQL////////////////////
        
        
        //CONSULTA A BASE DE DATOS este codigo va en los metodos de la clase DAO (MODIFICAR DAO PARA QUE DISPONGA DE ESTAS FUNCIONALIDADES EN SUS METODOS ELIMINAR INSERTAR Y MODIFICAR)
        try {
            Connection con = null;
            con = getConection();

            PreparedStatement ps;
            ResultSet res;

            ps = con.prepareStatement("SELECT * FROM persona");
            res = ps.executeQuery();

            //ps PREPARA la solicitud (ENTRE LOS PARENTECIS VA LA ORDER A MYSQL)
            //res envia y recive respuesta de MYSQL con ps.executeQuery()
            
            if (res.next()) {
                System.out.println(res.getString("nombre"));
            } else {
                System.out.println("no data");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        
        ///////////////////MYSQL//
        
        DAO dao;
        
        
        Calendar fechaX;
        Auto fiat;
        
        //LOS PARAMETROS QUE SE LE PASAN A LOS METODOS DE AQUI ABAJO CAMBIAN, YA NO SE PASA SOLO UNA ENTIDAD TMB SE PASA UNA KEY, EN ESTE CASO LA KEY DEBE SER UN STRING(o no) Y ES EL VIN
        //A PARTIR DE ESO SE BUSCA EN LA BASE DE DATOS LA TABLA QUE CONTENGA ESA KEY Y SE PROCEDE A BORRAR O MODIFICAR, PARA INSERTAR SE PASA SOLO LA ENTIDAD Y SE AGREGA AL FINAL EN LA BD
        
        
        /*
        //ESCRIBE
        fechaX = new MiCalendario(10, 3, 2009);
        fiat = new Auto("123456G7891234567", "chevy","cheto","4646",fechaX);
        
        try {
            dao.insertar(fiat);
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        /*
        //MODIFICA
        fechaX = new MiCalendario(9, 1, 2022);
        fiat = new Auto("323456G323456G789", "Chevr", "Fuego", "4850", fechaX);

        try {
            dao.modificar(fiat);
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        //ELIMINA 
        /*
        
        fechaX = new MiCalendario(12, 8, 2012);
        fiat = new Auto("3234888323456G789", "Ford#", "model", "4850", fechaX);

        try {
            dao.eliminar(fiat.getVin());
        } catch (DAOExeption ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
    }
    
}
