/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.model;

/**
 *
 * @author adrian
 */
public class Pdf extends ArchivoSistema{
    
    private String firma;

    public Pdf(String nombre, int tamano) {
        super(nombre, tamano);
    }

    
    public Pdf(String firma, String nombre, int tamano) {
        super(nombre, tamano);
        this.firma = firma;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

 
    @Override
    public int calcularTamano() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
