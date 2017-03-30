/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Estudiante
 */
public class Main {
    public static int menu(){
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("1. Agregar" + "2. Listar"+"3. Nomina"+"4.Nombre del Prpgramdor"+"5.Salir");
        opcion = teclado.nextInt();
        return opcion;
    }
    public static void main(String[] args) {
        int opcion = 1;
        Empresa empresa = new Empresa();
        Scanner teclado = new Scanner(System.in);
        do{
            opcion = menu();
            switch (opcion){
                case 1:
                    System.out.println("Ingresar nombre del empleado");
                    String nombre = teclado.nextLine();
                    System.out.println("Tipo de empleado 1.programdor 2. arquitecto");
                    int tipo = teclado.nextInt();
                    Empleado empleado=null;
                    if (tipo == 1){
                        empleado = new Programador(nombre);}
                    else if (tipo == 2){
                        empleado = new Arquitecto(nombre);    
                    }
                    break;
                case 2:
                    ArrayList<Empleado> empleados = empresa.ListarEmpleado();
                    for (int i=0; i<empleados.size(); i++){
                        Empleado e= empleados.get(i);
                        if ( e instanceof Programador)
                            System.out.println(e.getNombre()+"Programador");
                        else
                            System.out.println(e.getNombre()+"Arquitecto");
                        }
                    break;
                case 3:
                    double nomina = empresa.calcularNomna();
                    System.out.println("Nomina: "+nomina);
                    break;
                case 4:
                    double nominaprogramador = empresa.calcularnominaprogramadores();
                    System.out.println("nomiba: "+ nominaprogramador);
                    break;
                case 5:
                    System.out.println("Hasta pronto");
                    break;
                default:
                        System.out.println("Invaldo");
            }       
        }
        while(opcion != 5);
}
}