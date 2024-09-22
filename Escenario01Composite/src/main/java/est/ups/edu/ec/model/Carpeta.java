/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edisson
 */
public class Carpeta extends ArchivoSistema{
    
    private List<ArchivoSistema> elementos = new ArrayList<>();
    
    public Carpeta(String nombre) {
        super(nombre);
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
    public int getTamano() {
        return elementos.stream().mapToInt(ArchivoSistema::getTamano).sum();
    }
    
}
