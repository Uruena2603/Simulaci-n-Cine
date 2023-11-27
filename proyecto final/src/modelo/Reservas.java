/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JToggleButton;

/**
 *
 * @author HeroD
 */
public class Reservas extends Cliente implements Serializable{
    private ArrayList<Sillas> silla;

    public Reservas(ArrayList<Sillas> silla) {
        this.silla = silla;
    }

    public Reservas( String cedula, String nombre, ArrayList<Sillas> silla) {
        super(cedula, nombre);
        this.silla = silla;
    }

    public Reservas() {
    }

    public ArrayList<Sillas> getSilla() {
        return silla;
    }

    public void setSilla(ArrayList<Sillas> silla) {
        this.silla = silla;
    }

    @Override
    public String toString() {
        return "Reservas{" + "silla=" + silla + '}';
    }    
}
