/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.model;

/**
 *
 * @author edisson
 */
public class CelsiusDevice implements ITemperatureDevice  {
    
   private double temperature;

    public CelsiusDevice(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getTemperatureInCelsius() {
        return temperature;
    } 
}
