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
public class Tarjeta extends Cliente implements Serializable {
    
    private int saldo;

    public Tarjeta(int saldo) {
        this.saldo = 0;
    }

    public Tarjeta(String cedula, String nombre, int saldo) {
        super(cedula, nombre);
        this.saldo = saldo;
    }

    public Tarjeta() {
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "saldo=" + saldo + '}';
    }
    
}
