/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.model;

/**
 *
 * @author edisson
 */
public abstract class ArchivoSistema {
    
    protected String nombre;
    
    public ArchivoSistema(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
     public abstract int getTamano();
}
