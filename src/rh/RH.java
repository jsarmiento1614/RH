/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh;

import java.util.Scanner;

/**
 *
 * @author Alumnos
 */
public class RH {

    /**
     * @param args the command line arguments
     */
    //Notas: Guardar los datos en un array empleados.
    public static void main(String[] args) {
        // TODO code application logic here
        int cantEmp = 0;
        String nEmpleado = "";
        double sEmpleado = 0;
        String tEmpleado = "";
        Empleados[] emp;
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cuantos Empleados va a ingresar?");
        cantEmp = teclado.nextInt();
        emp = new Empleados[cantEmp];
        int salir = 0;
        String ePCarro;
        String ePVacaciones;
        do {
            System.out.println("Ingrese Nombre");
            nEmpleado = teclado.nextLine();
            System.out.println("Ingrese Sueldo");
            sEmpleado = teclado.nextDouble();
            System.out.println("Es Gerente (G) / Operario (O)");
            tEmpleado = teclado.nextLine();
            if ("G".equalsIgnoreCase(tEmpleado)) {
                boolean pCarro;
                boolean pVacaciones;
                System.out.println("¿La empresa paga su carro? (SI / NO)");
                ePCarro = teclado.nextLine();
                if ("SI".equalsIgnoreCase(ePCarro)) {
                    pCarro = true;
                } else if ("NO".equalsIgnoreCase(ePCarro)) {
                    pCarro = false;
                } else {
                    System.out.println("Dato ingresado incorrectamente.");
                }
                System.out.println("¿La empresa paga sus vacaciones? (SI / NO)");
                ePVacaciones = teclado.nextLine();
                if ("SI".equalsIgnoreCase(ePVacaciones)) {
                    pVacaciones = true;
                } else if ("NO".equalsIgnoreCase(ePVacaciones)) {
                    pVacaciones = false;
                } else {
                    System.out.println("Dato ingresado incorrectamente.");
                }
                
             //Empleados[cantEmp]=new Empleados(pCarro,pVacaciones);
            } else if ("O".equalsIgnoreCase(tEmpleado)) {

            } else {
                System.out.println("Dato ingresado incorrectamente.");
            }
        } while (salir != 1);

    }
}
