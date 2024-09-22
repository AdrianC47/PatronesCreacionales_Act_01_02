/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.model;

/**
 *
 * @author edisson
 */
public class Archivo extends ArchivoSistema{
    
    private int tamano;

     public Archivo(String nombre, int tamano) {
        super(nombre);
        this.tamano = tamano;
    }

    @Override
    public int getTamano() {
        return tamano;
    }
    
}
