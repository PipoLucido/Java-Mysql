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
public class Auto extends Motorizado {
    
    private Double precio;
    private Integer anio;
    
    public Auto() {
        super();
    }

    public Auto(String vin, String marca, String modelo, String patente, Calendar fechaFab, Integer anio, Double precio) throws MotorizadoExeption {
        //Auto("123456G7891234567", "fiat","modelo","4646",fechaX);
        super(vin, marca, modelo, patente, fechaFab);
        this.precio = precio;
        this.anio = anio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
