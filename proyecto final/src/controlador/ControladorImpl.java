package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Tarjeta;
import modelo.Reservas;
import modelo.Sillas;

public class ControladorImpl implements Controlador, Serializable {

    static ArrayList<Tarjeta> tar = new ArrayList<Tarjeta>();
    static ArrayList<Reservas> res = new ArrayList<Reservas>();
    static Archivo archT = new Archivo();
    static Archivo archR = new Archivo();
    static Sillas silla = new Sillas();

//***METODOS TARJETAS***//
    @Override
    public boolean crearTarjeta(String cedula, String nombre) {
        try {
            Tarjeta temp;
            temp = buscarTarjeta(cedula);
            if (temp == null) {
                Tarjeta aux = new Tarjeta(cedula, nombre, 100000);
                tar.add(aux);
                archT.guardarArchivo(tar, "tarjetas");
                JOptionPane.showMessageDialog(null, "TARJETA CREADA EXITOSAMENTE",
                        "VENTANA TARJETAS", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }//IF
            else {
                JOptionPane.showMessageDialog(null, "SU TARJETA YA EXISTE",
                        "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            //}//ELSE
        }//TRY
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ALGO PASO",
                    "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
            return false;
        }//CATCH
    }//CREAR TARJETA

    @Override
    public boolean recargarTarjeta(String cedula, String nombre, int saldo) {
        int aux = 0;

        try {
            Tarjeta temp;
            temp = buscarTarjeta(cedula);
            if (temp != null) {
                if (saldo >= 100000) {
                    aux = temp.getSaldo() + saldo;
                    temp.setSaldo(aux);
                    archT.guardarArchivo(tar, "tarjetas");
                    JOptionPane.showMessageDialog(null, "TARJETA RECARGADA EXITOSAMENTE",
                            "VENTANA TARJETAS", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }//IF 2   
                else {
                    JOptionPane.showMessageDialog(null, "LA RECARGA DEBE SER POR UN MINIMO DE $100000",
                            "VENTANA TARJETAS", JOptionPane.ERROR_MESSAGE);
                    return false;
                }//ELSE
            }//IF 1
            JOptionPane.showMessageDialog(null, "HUBO UN ERROR INTENTALO DE NUEVO",
                    "VENTANA TARJETAS", JOptionPane.ERROR_MESSAGE);
            return false;
        }//TRY
        catch (Exception e) {
            return false;
        }//CACTH
    }//RECARGAR TARJETA

    public Tarjeta buscarTarjeta(String ced) {
        try {
            ArrayList<Tarjeta> x = archT.leerArchivo("tarjetas");
            //tar = archT.leerArchivo("tarjetas");

            if (x == null) {
                return null;
            }
            tar = x;
            for (Tarjeta i : tar) {
                if (i.getCedula().equals(ced)) {
                    return i;
                }//IF
            }//FOR
        }//TRY
        catch (Exception e) {
            return null;
        }//CATCH
        return null;
    }//BUSCAR TARJETA

    //***METODOS TARJETAS***//
    //***METODOS RESERVAS***//
    @Override
    public boolean crearReserva(String cedula, String nombre, ArrayList<Sillas> sillas) {
        try {
            Reservas temp;
            temp = buscarReserva(cedula);
            if (temp == null) {
                Reservas aux = new Reservas(cedula, nombre, sillas);
                res.add(aux);
                archR.guardarArchivo(res, "reservas");
                JOptionPane.showMessageDialog(null, "RESERVA CREADA EXITOSAMENTE",
                        "VENTANA MENU", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }//IF
            else {
                JOptionPane.showMessageDialog(null, "SU TARJETA YA EXISTE",
                        "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
                return false;
            }//ELSE
        }//TRY 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN ERROR CREANDO RESERVA",
                    "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
            return false;
        }//CATCH
    }//CREAR RESERVA

    @Override
    public ArrayList<Sillas> eliminarReserva(String cedula) {
        Reservas temp;
        temp = buscarReserva(cedula);
        if (temp != null) {
            ArrayList<Sillas> sillas = temp.getSilla();
            res.remove(temp);
            archR.guardarArchivo(res, "reservas");
            JOptionPane.showMessageDialog(null, "RESERVA ELIMINADA EXITOSAMENTE",
                    "VENTANA MENU", JOptionPane.INFORMATION_MESSAGE);
            return sillas;
        }//IF
        JOptionPane.showMessageDialog(null, "HUBO UN ERROR AL ELIMINAR LA RESERVA",
                "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
        return new ArrayList<Sillas>();
    }//ELIMINAR RESERVAs

    public Reservas buscarReserva(String ced) {
        try {
            ArrayList<Reservas> x = archR.leerArchivo("reservas");
            if (x == null) {
                return null;
            }//IF
            res = x;
            for (Reservas i : res) {
                if (i.getCedula().equals(ced)) {
                    return i;
                }//IF
            }//FOR
        }//TRY
        catch (Exception e) {
            return null;
        }//CATCH
        return null;
    }//BUSCAR RESERVA

    @Override
    public ArrayList<Reservas> infoReseva() {
        return (ArrayList<Reservas>) archR.leerArchivo("reservas");
    }

    //***METODOS RESERVAS***//
    //***METODOS DE PAGOS***//
    @Override
    public ArrayList<Sillas> pagoE(int saldo, String cedula, String nombre) {
        int precio = 0;

        try {
            Reservas temp;
            temp = buscarReserva(cedula);
            if (temp != null) {
                ArrayList<Sillas> sillas = temp.getSilla();
                if (silla.getColumna() > 10) {
                    precio = 25000;
                    if (saldo >= precio) {
                        JOptionPane.showMessageDialog(null, "RESERVA PAGADA EXITOSAMENTE",
                                "VENTANA MENU", JOptionPane.INFORMATION_MESSAGE);
                        return sillas;
                    }//IF 3
                    else {
                        JOptionPane.showMessageDialog(null, "EL SALDO NO ES SUFICIENTE",
                                "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
                    }//ELSE 3
                }//IF 2
                else if (silla.getColumna() < 10) {
                    precio = 15000;

                    if (saldo >= precio) {
                        JOptionPane.showMessageDialog(null, "RESERVA PAGADA EXITOSAMENTE",
                                "VENTANA MENU", JOptionPane.INFORMATION_MESSAGE);
                        return sillas;
                    }//IF 4
                    else {
                        JOptionPane.showMessageDialog(null, "EL SALDO NO ES SUFICIENTE",
                                "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
                    }//ELSE 4

                }//ELSE 2            
            }//IF 1
            else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO LA RESERVA",
                        "VENTANA MENU", JOptionPane.ERROR_MESSAGE);

            }
        }//TRY
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN ERRROR AL PAGAR LA RESERVA",
                    "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
            return null;
        }//CACTH
        return null;
    }//PAGO EFECTIVO

    @Override
    public ArrayList<Sillas> pagoF(int saldo, String cedula, String nombre) {

        int precio = 0;

        try {
            Reservas temp;
            Tarjeta temp1;
            temp = buscarReserva(cedula);
            temp1 = buscarTarjeta(cedula);
            if (temp != null && temp1 != null) {
                ArrayList<Sillas> sillas = temp.getSilla();
                saldo = temp1.getSaldo();
                if (silla.getColumna() > 10) {
                    precio = 25000;
                    if (saldo >= precio) {
                        JOptionPane.showMessageDialog(null, "RESERVA PAGADA EXITOSAMENTE",
                                "VENTANA MENU", JOptionPane.INFORMATION_MESSAGE);
                        saldo = saldo - precio;
                        temp1.setSaldo(saldo);
                        archT.guardarArchivo(tar, "tarjetas");
                        return sillas;
                    }//IF 3
                    else {
                        JOptionPane.showMessageDialog(null, "EL SALDO NO ES SUFICIENTE",
                                "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
                    }//ELSE 3
                }//IF 2
                else if (silla.getColumna() < 10) {
                    precio = 15000;

                    if (saldo >= precio) {
                        JOptionPane.showMessageDialog(null, "RESERVA PAGADA EXITOSAMENTE",
                                "VENTANA MENU", JOptionPane.INFORMATION_MESSAGE);
                        saldo = saldo - precio;
                        temp1.setSaldo(saldo);
                        archT.guardarArchivo(tar, "tarjetas");
                        return sillas;
                    }//IF 4
                    else {
                        JOptionPane.showMessageDialog(null, "EL SALDO NO ES SUFICIENTE",
                                "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
                    }//ELSE 4

                }//ELSE 2            
            }//IF 1
            else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO LA RESERVA O USTED NO POSEE TARJETA",
                        "VENTANA MENU", JOptionPane.ERROR_MESSAGE);

            }
        }//TRY
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN ERRROR AL PAGAR LA RESERVA",
                    "VENTANA MENU", JOptionPane.ERROR_MESSAGE);
            return null;
        }//CACTH
        return null;
    }//PAGO CON TARJETA

    @Override
    public int Caja() {
        return 0;
    }//CAJA

    //***METODOS DE PAGOS***//
}//CONTROLADORIMPL
