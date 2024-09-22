/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.view;

import est.ups.edu.ec.controller.ControladorArchivoSistema;
import est.ups.edu.ec.model.ArchivoSistema;
import est.ups.edu.ec.model.Carpeta;
import java.util.List;

import java.util.Scanner;

/**
 *
 * @author edisson
 */
public class VistaArchivoSistema {
    
     private ControladorArchivoSistema controlador;
    private Scanner scanner;
    
    
    public VistaArchivoSistema() {
        this.controlador = new ControladorArchivoSistema(this);
        this.scanner = new Scanner(System.in);
    }
    
     public void iniciar() {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar carpeta");
            System.out.println("2. Agregar archivo");
            System.out.println("3. Mostrar estructura de archivos");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    agregarCarpeta();
                    break;
                case 2:
                    agregarArchivo();
                    break;
                case 3:
                    controlador.mostrarEstructura();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    
    
       private void agregarCarpeta() {
        System.out.print("Ingrese el nombre de la carpeta: ");
        String nombreCarpeta = scanner.nextLine();

        System.out.print("Ingrese el nombre de la carpeta padre (dejar vacío si es raíz): ");
        String carpetaPadre = scanner.nextLine();
        if (carpetaPadre.isEmpty()) {
            controlador.agregarCarpeta(nombreCarpeta, null);
        } else {
            controlador.agregarCarpeta(nombreCarpeta, carpetaPadre);
        }
    }
       
       
       private void agregarArchivo() {
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();

        System.out.print("Ingrese el tamaño del archivo (en KB): ");
        int tamano = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        System.out.print("Ingrese el nombre de la carpeta padre (dejar vacío si es raíz): ");
        String carpetaPadre = scanner.nextLine();
        if (carpetaPadre.isEmpty()) {
            controlador.agregarArchivo(nombreArchivo, tamano, null);
        } else {
            controlador.agregarArchivo(nombreArchivo, tamano, carpetaPadre);
        }
    }
       
       
       public void mostrarElemento(ArchivoSistema elemento, int nivel) {
        String indentacion = " ".repeat(nivel * 2);
        System.out.println(indentacion + elemento.getNombre() + " (" + elemento.getTamano() + " KB)");

        if (elemento instanceof Carpeta) {
            for (ArchivoSistema subElemento : ((Carpeta) elemento).getElementos()) {
                mostrarElemento(subElemento, nivel + 1);
            }
        }
    }
       
       public void mostrarJerarquia(List<ArchivoSistema> elementos) {
        for (ArchivoSistema elemento : elementos) {
            mostrarElemento(elemento, 0);
        }
    }
    
       
       public static void main(String[] args) {
        VistaArchivoSistema vista = new VistaArchivoSistema();
        vista.iniciar();
    }
    
}
