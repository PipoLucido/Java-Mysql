/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auto;

import java.util.Calendar;

/**
 *
 * @author Rodrigo
 */
public class Motorizado {

    public final int vin_length = 17;
    private String vin;
    private Calendar fechaFab;
    protected String marca;
    protected String modelo;
    protected String patente;

    public Motorizado() {
    }

    //constructor motorizado
    /* public Motorizado(String vin,Calendar fechaFab) throws MotorizadoExeption{
        setVin(vin);
        setFechaFab(fechaFab);
    }*/
    public Motorizado(String vin, String marca, String modelo, String patente, Calendar fechaFab) throws MotorizadoExeption {
        setVin(vin);
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
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

        if (vin.length() != vin_length) {
            throw new MotorizadoExeption("El VIN debe contener " + vin_length + " caracteres");
        }
        this.vin = vin;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Calendar getFechaFab() {
        return fechaFab;
    }

    public final void setFechaFab(Calendar fechaFab) {
        this.fechaFab = fechaFab;
    }

}
