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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emili
 */
public class AutoDAOtxt extends DAO<Auto, String> {

    private String path;
    private RandomAccessFile raf;

    public AutoDAOtxt() {
    }

    public AutoDAOtxt(String path) throws DAOException {
        this.path = path;
        File file = new File(path);
        try {
            raf = new RandomAccessFile(file, "rws");
        } catch (FileNotFoundException ex) {
            throw new DAOException("El archivo no existe //==> " + ex);
        }
    }

    @Override
    public void insertar(Auto entidad) throws DAOException {

        String line;

        try {
            raf.seek(0);
            while ((line = raf.readLine()) != null) {

                if (line.length() >= Auto.VIN_LENGTH + 2) {

                    line = line.substring(2, 2 + Auto.VIN_LENGTH);

                    if (line.equals(entidad.getVin())) {
                        System.out.print("Clave duplicada: " + line + "\n");
                        raf.close();
                        return;
                    }
                }
            }
            raf.seek(raf.length());
            raf.writeBytes("A|" + entidad.toString() + "\n");
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(AutoDAOtxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Auto entidad, String clave) throws DAOException {
        if (clave.length() != Auto.VIN_LENGTH) {
            throw new DAOException("Clave inválida\n");
        }

        String line;
        String vin;
        int count = 0;

        try {
            raf.seek(0);
            while ((line = raf.readLine()) != null) {
                if (line.length() >= Auto.VIN_LENGTH + 2) {

                    vin = line.substring(2, 2 + Auto.VIN_LENGTH);

                    if (vin.equals(clave)) {
                        // Coincidencia!!
                        raf.seek(count + ((count == 0) ? 0 : 1) + 2);
                        raf.writeBytes(entidad.toString());
                        raf.close();
                        return;
                    }
                }
                count += line.length() + 1;
            }
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(AutoDAOtxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(String clave) throws DAOException {

        if (clave.length() != Auto.VIN_LENGTH) {
            throw new DAOException("Clave inválida\n");
        }

        String line;
        String vin;
        int count = 0;

        try {
            raf.seek(0);
            while ((line = raf.readLine()) != null) {
                if (line.length() >= Auto.VIN_LENGTH + 2) {

                    vin = line.substring(2, 2 + Auto.VIN_LENGTH);

                    if (vin.equals(clave)) {
                        // Coincidencia!!
                        raf.seek(count + ((count == 0) ? 0 : 1));
                        raf.writeBytes("B");
                        raf.close();
                        return;
                    }
                }
                count += line.length() + 1;
            }
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(AutoDAOtxt.class.getName()).log(Level.SEVERE, null, ex);
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
