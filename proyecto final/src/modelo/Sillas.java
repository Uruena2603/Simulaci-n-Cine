/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author HeroD
 */
public class Sillas extends Cliente implements Serializable {
   
    private int fila;
    private int columna;
    private boolean disponibilidad;

    public Sillas(int fila, int columna, boolean disponibilidad) {
        this.fila = fila;
        this.columna = columna;
        this.disponibilidad = disponibilidad;
    }
    
     public Sillas() {
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Sillas{" + "disponibilidad=" + disponibilidad + '}';
    }
    
}
