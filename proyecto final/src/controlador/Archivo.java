/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author HeroD
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import modelo.Tarjeta;

public class Archivo implements Serializable {

    ObjectInputStream ois;
    File archivo;
    ObjectOutputStream oos;
    ArrayList<Tarjeta> estructura = null;

    public void guardarArchivo(ArrayList estructura1, String nombreArchivo) {
        archivo = new File(nombreArchivo);

        //GUARDAR DATOS EN EL ARCHIVO
        try {
            oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            oos.writeObject(estructura1);
            oos.flush();
            oos.close();
        } catch (IOException e) {
        }
    }

    public ArrayList leerArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        //EXTRAER DATOS DESDE EL ARCHIVO
        try {
            ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
            estructura = (ArrayList<Tarjeta>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return estructura;
    }
}