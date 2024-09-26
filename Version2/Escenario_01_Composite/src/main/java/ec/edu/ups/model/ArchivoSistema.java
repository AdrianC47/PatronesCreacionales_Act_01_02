/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.model;

/**
 *
 * @author adrian
 */
public abstract class ArchivoSistema {
    
    private String nombre;
    private int tamano;

    public ArchivoSistema(String nombre, int tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
    }

    public abstract int calcularTamano();
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
}
