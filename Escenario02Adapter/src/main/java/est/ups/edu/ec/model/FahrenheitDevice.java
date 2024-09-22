/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.model;

/**
 *
 * @author edisson
 */
public class FahrenheitDevice {
    
    private double temperatureInFahrenheit;

    public FahrenheitDevice(double temperatureInFahrenheit) {
        this.temperatureInFahrenheit = temperatureInFahrenheit;
    }

    // Método específico para obtener la temperatura en Fahrenheit
    public double getTemperatureInFahrenheit() {
        return temperatureInFahrenheit;
    }
}
