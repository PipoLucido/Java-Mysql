/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Auto.Auto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/* @author Rodrigo */
public class AutoDAOsql extends DAO<Auto, String> {

    public static Connection getConection(String URL, String USERNAME, String PASSWORD) {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion exitosa!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }

    public AutoDAOsql(String URL, String USERNAME, String PASSWORD) throws DAOException {

        setUrl(URL);
        setUsername(USERNAME);
        setPassword(PASSWORD);
        this.con = getConection(this.URL, this.USERNAME, this.PASSWORD); //CREA LA CONECCION 
    }

    String URL;
    String USERNAME;
    String PASSWORD;
    Connection con;

    public final void setUrl(String url) throws DAOException {

        this.URL = url;

    }

    public final void setUsername(String user) throws DAOException {

        this.USERNAME = user;

    }

    public final void setPassword(String pass) throws DAOException {

        this.PASSWORD = pass;

    }

    @Override
    public void insertar(Auto entidad) throws DAOException {

        try {

            PreparedStatement ps;

            ps = this.con.prepareStatement("INSERT INTO autos (VIN, PATENTE, FECHA_FAB, PRECIO, MARCA, AÑO) VALUES (?,?,?,?,?,?) ");

            ps.setString(1, entidad.getVin());
            ps.setString(2, entidad.getPatente());
            ps.setString(3, "" + entidad.getFechaFab() + "");
            ps.setDouble(4, entidad.getPrecio());
            ps.setString(5, entidad.getMarca());
            ps.setInt(6, entidad.getAnio());

            ps.execute();

            // this.con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void modificar(Auto entidad, String keyVin) throws DAOException {

        try {

            PreparedStatement ps;

            //  NO TENEMOS PRECIO EN LA ENTIDAD | TAMPOCO GET AÑO
            ps = this.con.prepareStatement("UPDATE autos SET  PATENTE=?, FECHA_FAB=?, PRECIO=?, MARCA=?, AÑO=?   WHERE VIN=?");  //ORDEN A MYSQL

            ps.setString(1, entidad.getPatente());
            ps.setString(2, "" + entidad.getFechaFab() + "");
            ps.setDouble(3, entidad.getPrecio());
            ps.setString(4, entidad.getMarca());
            ps.setInt(5, entidad.getAnio());

            ps.setString(6, keyVin);

            ps.execute(); //EJECUTAR ORDER

            // this.con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void eliminar(String vinKey) throws DAOException {

        try {

            PreparedStatement ps;

            ps = this.con.prepareStatement("DELETE from autos WHERE VIN=? ");  //ORDEN A MYSQL

            ps.setString(1, vinKey);

            ps.execute();    //EJECUTAR ORDER

            //this.con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public Auto buscar(String clave) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Auto> listar() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
