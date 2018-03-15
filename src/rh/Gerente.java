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
public class Gerente extends Empleados{
    private boolean tienecarro;
    private boolean vacacionesPagadas;

    public Gerente(boolean tienecarro, boolean vacacionesPagadas, String nombre, String Sueldo) {
        super(nombre, Sueldo);
        this.tienecarro = tienecarro;
        this.vacacionesPagadas = vacacionesPagadas;
    }

   

    
    
}
