/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auto;

import java.util.Calendar;

/* @author Rodrigo */
public class Motorizado {

    public final int vin_length = 17;
    public final int marca_length = 20;
    public final int modelo_length = 30;
    public final int patente_length = 7;
    
    private String vin;
    private Calendar fechaFab;
    private String marca;
    private String modelo;
    private String patente;

    public Motorizado() {}
    
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

        if (vin.length() != vin_length) {
            throw new MotorizadoExeption("El VIN debe contener " + vin_length + " caracteres");
        }
        this.vin = vin;
    }

    public final String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        if (marca.length() > marca_length)
            marca = marca.substring(marca_length);
        this.marca = marca;
    }

    public final String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        if (modelo.length() > modelo_length)
            modelo = modelo.substring(modelo_length);
        this.modelo = modelo;
    }

    public final String getPatente() {
        return patente;
    }

    public final void setPatente(String patente) {
        if (patente.length() > patente_length)
            patente = patente.substring(patente_length);
        this.patente = patente;
    }

    public final Calendar getFechaFab() {
        return fechaFab;
    }

    public final void setFechaFab(Calendar fechaFab) {
        this.fechaFab = fechaFab;
    }
}
