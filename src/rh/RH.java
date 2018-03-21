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
        int sEmpleado = 0;
        String tEmpleado = "";
        String ePCarro;
        String ePVacaciones;
        int horasExtras = 0;
        String tRegalias = "";
        int contador = 0;
        Empleados[] emp = null;
        Scanner teclado = new Scanner(System.in);
        System.out.println("********************************************************************************************");
        System.out.println("*                                   EMPLEADOS JSARMIENTO©                                  *");
        System.out.println("*******************************                             ********************************");
        int opcion=0;
        do {
            System.out.println("1)Insertar Empleados");
            System.out.println("2)Salir");
            opcion = teclado.nextInt();
            try {
                System.out.println("¿Cuantos Empleados va a ingresar?");
                System.out.print(" ");
                cantEmp = teclado.nextInt();
                emp = new Empleados[cantEmp];
                int salir = 0;
                teclado.nextLine();
                boolean wenttocatch = false;
                do {
                    System.out.println();
                    System.out.println("Ingrese Nombre del empleado");
                    System.out.print(" ");
                    nEmpleado = teclado.nextLine();
                    do {
                        System.out.println();
                        System.out.println("Ingrese el Sueldo que recibe el empleado");
                        System.out.print(" ");
                        if (teclado.hasNextInt()) {
                            sEmpleado = teclado.nextInt();
                            wenttocatch = true;
                        } else {
                            teclado.nextLine();
                            System.out.println();
                            System.out.print(" ");
                            System.out.println("\033[31mIngreso un valor incorrecto         >Solo # Enteros");
                        }

                    } while (!wenttocatch);
                    teclado.nextLine();//formatear el int
                    System.out.println();
                    System.out.println("Es Gerente (G) || Operario (O)");
                    System.out.print(" ");
                    tEmpleado = teclado.nextLine();
                    if ("G".equalsIgnoreCase(tEmpleado)) {
                        boolean tienecarro = false;
                        boolean vacacionesPagadas = false;
                        System.out.println();
                        System.out.println("¿La empresa paga su carro? (S/N)");
                        System.out.print(" ");
                        ePCarro = teclado.nextLine();
                        if ("S".equalsIgnoreCase(ePCarro)) {
                            tienecarro = true;
                        } else if ("N".equalsIgnoreCase(ePCarro)) {
                            tienecarro = false;
                        } else {
                            System.out.println("Dato ingresado incorrectamente.");
                        }
                        System.out.println();
                        System.out.println("¿La empresa paga sus vacaciones? (S/N)");
                        System.out.print(" ");
                        ePVacaciones = teclado.nextLine();
                        if ("S".equalsIgnoreCase(ePVacaciones)) {
                            vacacionesPagadas = true;
                        } else if ("N".equalsIgnoreCase(ePVacaciones)) {
                            vacacionesPagadas = false;
                        } else {
                            System.out.println("\033[31mDato ingresado incorrectamente.");
                        }
                        emp[contador] = new Gerente(tienecarro, vacacionesPagadas, nEmpleado, sEmpleado);
                    } else if ("O".equalsIgnoreCase(tEmpleado)) {
                        boolean regalias = false;
                        System.out.println();
                        do {
                            System.out.println("Cuantas horas extras tiene:");
                            System.out.print(" ");
                            if (teclado.hasNextInt()) {
                                horasExtras = teclado.nextInt();
                                wenttocatch = true;
                            } else {
                                wenttocatch = false;
                                teclado.nextLine();
                                System.out.println();
                                System.out.print(" ");
                                System.out.println("\033[31mIngreso un valor incorrecto         >Solo # Enteros");
                            }

                        } while (!wenttocatch);
                        //teclado.nextLine();
                        System.out.println();
                        System.out.println("Tiene regalias (S/N)");
                        System.out.print(" ");
                        tRegalias = teclado.nextLine();
                        if ("S".equalsIgnoreCase(tRegalias)) {
                            regalias = true;
                        } else if ("N".equalsIgnoreCase(tRegalias)) {
                            regalias = false;
                        }
                        emp[contador] = new Operario(horasExtras, regalias, nEmpleado, sEmpleado);
                    } else {
                        System.out.println("\033[31mDato ingresado incorrectamente.");
                    }
                    contador++;
                } while (contador != cantEmp);
            } catch (Exception e) {
                System.out.println("\033[31mHa sucedido algo extraño...");
            }

            //imprimimos los sueldos de los empleados---
            System.out.println();
            System.out.println("Empleados y Sueldo");
            System.out.println("-----------------------------------------------------------------");
            for (int i = 0; i < emp.length; i++) {
                System.out.println("Nombre: " + emp[i].getNombre() + " ---- Sueldo: " + emp[i].getSueldo());
            }
            System.out.println("-----------------------------------------------------------------");

            //imprimimos los beneficios de los gerentes---
            System.out.println();
            System.out.println("Beneficios de los Gerentes");
            System.out.println("-----------------------------------------------------------------");
            for (int i = 0; i < emp.length; i++) {
                if (emp[i] instanceof Gerente) {
                    Gerente tmp = (Gerente) emp[i];
                    System.out.println("Nombre: " + emp[i].getNombre() + "\nLa empresa le Brinda Carro: " + tmp.isTienecarro() + "\nLa empresa le pagara sus vacaciones: " + tmp.isVacacionesPagadas());
                    System.out.println("________________");
                }
            }
            System.out.println("-----------------------------------------------------------------");

            //imprimimos los beneficios de los Operarios.
            System.out.println();
            System.out.println("Beneficios de los Operarios");
            System.out.println("-----------------------------------------------------------------");
            for (int i = 0; i < emp.length; i++) {
                if (emp[i] instanceof Operario) {
                    Operario tmp = (Operario) emp[i];
                    if (tmp.getHoraExtra() >= 1) {
                        System.out.println("Nombre: " + tmp.getNombre() + "\nTiene Regalias: " + tmp.isRegalias());
                        System.out.println("________________");
                    }
                }
            }
            System.out.println("-----------------------------------------------------------------");

            //imprimir las horas extras de los operarios. 
            System.out.println();
            System.out.println("Horas extras de Operarios");
            System.out.println("-----------------------------------------------------------------");
            for (int i = 0; i < emp.length; i++) {
                if (emp[i] instanceof Operario) {
                    Operario tmp = (Operario) emp[i];
                    if (tmp.getHoraExtra() >= 1) {
                        System.out.println(tmp.getNombre() + " tiene " + tmp.getHoraExtra() + " horas extras");
                    }
                }
            }
            System.out.println("-----------------------------------------------------------------");

            //Pago total de empleados:
            System.out.println();
            System.out.println("Pago total de Empleados");
            System.out.println("-----------------------------------------------------------------");
            int salarioGerente = 0;
            int salarioOperario = 0;
            for (int i = 0; i < emp.length; i++) {
                if (emp[i] instanceof Gerente) {
                    Gerente ger = (Gerente) emp[i];
                    salarioGerente = salarioGerente + emp[i].getSueldo();
                    System.out.println("Nombre: " + emp[i].getNombre() + "\nSueldo: " + emp[i].getSueldo());
                    System.out.println("Posee Carro: " + ger.isTienecarro() + "\nVacaciones Pagadas " + ger.isVacacionesPagadas());
                    System.out.println("________________");
                }
                if (emp[i] instanceof Operario) {
                    //Operario
                    Operario ope = (Operario) emp[i];
                    salarioOperario = salarioOperario + emp[i].getSueldo();
                    System.out.println("Nombre: " + emp[i].getNombre() + "\nSueldo: " + emp[i].getSueldo());
                    System.out.println("Horas Extra " + ope.getHoraExtra() + "\nTiene Regalias " + ope.isRegalias());
                    System.out.println("________________");
                }
            }
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Total Salario de empleados");
            System.out.println(salarioGerente + salarioOperario);
        } while (opcion != 2);
    }

}
