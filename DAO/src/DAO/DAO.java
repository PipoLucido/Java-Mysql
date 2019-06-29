/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Rodrigo
 * @param <T> tIPO DE DATO GENERICO
 * @param <K> tIPO DE DATO KEY
 */
public abstract class DAO<T,K>/*datosGenericos entre <datoGnerico>*/ {
    public abstract void insertar(T entidad) throws DAOException;
    public abstract void modificar(T entidad,K clave) throws DAOException;
    public abstract void eliminar(K clave) throws DAOException; /*elimina objeto de la clave*/
    public abstract T buscar(K clave) throws DAOException; /*buscar objeto clave*/
    public abstract List<T> listar() throws DAOException;/*busca todo devuelve una lista de T*/
    
    @Override
    public String toString() {
        return super.toString();
    }
}
