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
    //
    public static void main(String[] args) {
        // TODO code application logic here
        int cantEmp = 0;
        String nEmpleado = "";
        String sEmpleado = "";
        String tEmpleado = "";
        String ePCarro;
        String ePVacaciones;
        int horasExtras=0;
        String tRegalias=""; 
        Empleados[] emp;
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cuantos Empleados va a ingresar?");
        cantEmp = teclado.nextInt();
        emp = new Empleados[cantEmp];
        int salir = 0;
        teclado.nextLine();
        do {
            System.out.println("Ingrese Nombre");
            nEmpleado = teclado.nextLine();
            System.out.println("Ingrese Sueldo");
            sEmpleado = teclado.nextLine();
            System.out.println("Es Gerente (G) / Operario (O)");
            tEmpleado = teclado.nextLine();
            int contador=0;
            
            if ("G".equalsIgnoreCase(tEmpleado)) {
                boolean tienecarro = false;
                boolean vacacionesPagadas = false;
                System.out.println("¿La empresa paga su carro? (SI / NO)");
                ePCarro = teclado.nextLine();
                if ("SI".equalsIgnoreCase(ePCarro)) {
                    tienecarro = true;
                } else if ("NO".equalsIgnoreCase(ePCarro)) {
                    tienecarro = false;
                } else {
                    System.out.println("Dato ingresado incorrectamente.");
                }
                System.out.println("¿La empresa paga sus vacaciones? (SI / NO)");
                ePVacaciones = teclado.nextLine();
                if ("SI".equalsIgnoreCase(ePVacaciones)) {
                    vacacionesPagadas = true;
                } else if ("NO".equalsIgnoreCase(ePVacaciones)) {
                    vacacionesPagadas = false;
                } else {
                    System.out.println("Dato ingresado incorrectamente.");
                }
                emp[contador]=new Gerente(tienecarro,vacacionesPagadas,nEmpleado,sEmpleado);
            } else if ("O".equalsIgnoreCase(tEmpleado)) {
                boolean regalias = false;
                System.out.println("Cuantas horas extras tiene:");
                horasExtras=teclado.nextInt();
                System.out.println("Tiene regalias (SI/NO)");
                tRegalias=teclado.nextLine();
                if("SI".equalsIgnoreCase(tRegalias)){
                   regalias=true; 
                }else if("NO".equalsIgnoreCase(tRegalias)){
                   regalias=false;
                }
                emp[contador]=new Operario(horasExtras,regalias,nEmpleado,sEmpleado);
            } else {
                System.out.println("Dato ingresado incorrectamente.");
            }
            contador++;
        } while (salir != 1);
        
        //imprimimos los sueldos de los empleados---
        System.out.println("Sueldos");
        for(int i=0; i<emp.length;i++){
            System.out.println("Nombre: "+emp[i].getNombre()+"----Sueldo:" +emp[i].getSueldo());
        }
        
       for(int i=0; i<emp.length;i++){
           if(emp[i] instanceof Operario){
               Operario tmp = (Operario) emp[i];
               if(tmp.getHoraExtra() >=1){
                   System.out.println(tmp.getNombre() + "tiene "+ tmp.getHoraExtra()+ "horas extra");
               }
            }
       }
    }
}
