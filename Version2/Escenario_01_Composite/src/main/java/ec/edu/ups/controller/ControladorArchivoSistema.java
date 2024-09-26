/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controller;

import ec.edu.ups.model.ArchivoSistema;
import ec.edu.ups.model.Carpeta;
import ec.edu.ups.model.Pdf;
import java.util.List;

/**
 *
 * @author adrian
 */
public class ControladorArchivoSistema {

    private List<ArchivoSistema> sistemaArchivos;

    public ControladorArchivoSistema(List<ArchivoSistema> sistemaArchivos) {
        this.sistemaArchivos = sistemaArchivos;
    }

    public List<ArchivoSistema> getSistemaArchivos() {
        return sistemaArchivos;
    }

    public void setSistemaArchivos(List<ArchivoSistema> sistemaArchivos) {
        this.sistemaArchivos = sistemaArchivos;
    }

    public void agregarArchivo(String nombre, int tamano, String carpetaPadre) {
        Pdf pdf = new Pdf(nombre, tamano);

        if (carpetaPadre == null) {
            sistemaArchivos.add(pdf);
        } else {
            Carpeta carpeta = buscarCarpeta(carpetaPadre);
            if (carpeta != null) {
                carpeta.add(pdf);
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
}
