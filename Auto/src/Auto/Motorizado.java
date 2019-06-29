/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auto;

import java.util.Calendar;

/* @author Rodrigo */
public class Motorizado {

    public static final int VIN_LENGTH = 17;
    public static final int MARCA_LENGTH = 20;
    public static final int MODELO_LENGTH = 30;
    public static final int PATENTE_LENGTH = 7;

    private String vin;
    private String marca;
    private String modelo;
    private String patente;
    private Calendar fechaFab;

    public Motorizado() {
    }

    public Motorizado(String vin) throws MotorizadoExeption {
        setVin(vin);
    }

    public Motorizado(String vin, Calendar fechaFab) throws MotorizadoExeption {
        setVin(vin);
        setFechaFab(fechaFab);
    }

    // Constructor completo
    public Motorizado(String vin, String marca, String modelo, String patente, Calendar fechaFab) throws MotorizadoExeption {
        setVin(vin);
        setMarca(marca);
        setModelo(modelo);
        setPatente(patente);
        setFechaFab(fechaFab);
    }

    public String getVin() {
        return vin;
    }

    public final void setVin(String vin) throws MotorizadoExeption {
        if (vin == null || vin.trim().isEmpty()) {
            throw new MotorizadoExeption("El VIN no puede ser vacio");
            //para lanzar exeption hay que agregar throws
        }

        if (vin.length() != VIN_LENGTH) {
            throw new MotorizadoExeption("El VIN debe contener " + VIN_LENGTH + " caracteres");
        }
        this.vin = vin;
    }

    public final String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        if (marca.length() > MARCA_LENGTH) {
            marca = marca.substring(0, MARCA_LENGTH);
        }
        this.marca = marca;
    }

    public final String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        if (modelo.length() > MODELO_LENGTH) {
            modelo = modelo.substring(0, MODELO_LENGTH);
        }
        this.modelo = modelo;
    }

    public final String getPatente() {
        return patente;
    }

    public final void setPatente(String patente) {
        if (patente.length() > PATENTE_LENGTH) {
            patente = patente.substring(0, PATENTE_LENGTH);
        }
        this.patente = patente;
    }

    public final Calendar getFechaFab() {
        return fechaFab;
    }

    public final void setFechaFab(Calendar fechaFab) {
        this.fechaFab = fechaFab;
    }
}
