/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh;

/**
 *
 * @author Alumnos
 */
public class Operario extends Empleados {
    private int horaExtra;
    private boolean regalias;

    public Operario(int horaExtra, boolean regalias, String nombre, String Sueldo) {
        super(nombre, Sueldo);
        this.horaExtra = horaExtra;
        this.regalias = regalias;
    }

    public int getHoraExtra() {
        return horaExtra;
    }

    public boolean isRegalias() {
        return regalias;
    }

 
}
