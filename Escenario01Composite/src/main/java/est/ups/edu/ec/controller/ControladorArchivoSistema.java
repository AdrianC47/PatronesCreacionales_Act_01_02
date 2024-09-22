/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.controller;


import est.ups.edu.ec.model.Archivo;
import est.ups.edu.ec.model.ArchivoSistema;
import est.ups.edu.ec.model.Carpeta;
import est.ups.edu.ec.view.VistaArchivoSistema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edisson
 */
public class ControladorArchivoSistema{
    
    private List<ArchivoSistema> sistemaArchivos;
    private VistaArchivoSistema vista;

    public ControladorArchivoSistema(VistaArchivoSistema vista) {
        this.sistemaArchivos = new ArrayList<>();
        this.vista = vista;
    }
    
    
    public void agregarArchivo(String nombre, int tamano, String carpetaPadre) {
        Archivo archivo = new Archivo(nombre, tamano);

        if (carpetaPadre == null) {
            sistemaArchivos.add(archivo);
        } else {
            Carpeta carpeta = buscarCarpeta(carpetaPadre);
            if (carpeta != null) {
                carpeta.add(archivo);
            } else {
                System.out.println("Carpeta no encontrada");
            }
        }
    }
    
    public void agregarCarpeta(String nombre, String carpetaPadre) {
        Carpeta carpeta = new Carpeta(nombre);

        if (carpetaPadre == null) {
            sistemaArchivos.add(carpeta);
        } else {
            Carpeta carpetaExistente = buscarCarpeta(carpetaPadre);
            if (carpetaExistente != null) {
                carpetaExistente.add(carpeta);
            } else {
                System.out.println("Carpeta no encontrada");
            }
        }
    }
    
     public Carpeta buscarCarpeta(String nombre) {
        for (ArchivoSistema elemento : sistemaArchivos) {
            if (elemento instanceof Carpeta && elemento.getNombre().equals(nombre)) {
                return (Carpeta) elemento;
            }
            if (elemento instanceof Carpeta) {
                Carpeta carpetaEncontrada = buscarCarpetaEnSubcarpeta((Carpeta) elemento, nombre);
                if (carpetaEncontrada != null) {
                    return carpetaEncontrada;
                }
            }
        }
        return null;
    }
     
     
         private Carpeta buscarCarpetaEnSubcarpeta(Carpeta carpeta, String nombre) {
        for (ArchivoSistema subElemento : carpeta.getElementos()) {
            if (subElemento instanceof Carpeta && subElemento.getNombre().equals(nombre)) {
                return (Carpeta) subElemento;
            }
            if (subElemento instanceof Carpeta) {
                Carpeta carpetaEncontrada = buscarCarpetaEnSubcarpeta((Carpeta) subElemento, nombre);
                if (carpetaEncontrada != null) {
                    return carpetaEncontrada;
                }
            }
        }
        return null;
    }
         
         
    public void mostrarEstructura() {
        vista.mostrarJerarquia(sistemaArchivos);
    }
}
