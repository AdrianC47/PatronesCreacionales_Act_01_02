/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrian
 */
public class Carpeta extends ArchivoSistema{
    
    private List<ArchivoSistema> elementos = new ArrayList<>();

    public Carpeta(String nombre, int tamano) {
        super(nombre, tamano);
    }
    
    public void add(ArchivoSistema elemento) {
        elementos.add(elemento);
    }

    public void delete(ArchivoSistema elemento) {
        elementos.remove(elemento);
    }
    
     public List<ArchivoSistema> getElementos() {
        return elementos;
    }
    @Override
    public int calcularTamano() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
