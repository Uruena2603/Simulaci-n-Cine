/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Reservas;
import modelo.Sillas;

/**
 *
 * @author HeroD
 */
public interface Controlador  {
    
    public abstract boolean crearTarjeta(String cedula, String nombre);
    public abstract boolean crearReserva(String cedula, String nombre, ArrayList<Sillas> silla);
    public abstract ArrayList<Sillas> eliminarReserva(String cedula);
    public abstract boolean recargarTarjeta(String cedula,String nombre, int saldo);
    public abstract ArrayList<Reservas> infoReseva ();
    public abstract ArrayList<Sillas>  pagoE(int saldo, String cedula, String nombre);
    public abstract  ArrayList<Sillas> pagoF(int saldo, String cedula, String nombre);
    public abstract int Caja();
   
}
    
 
