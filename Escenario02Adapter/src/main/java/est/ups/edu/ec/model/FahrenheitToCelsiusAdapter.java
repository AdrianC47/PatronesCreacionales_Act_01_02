/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.model;

/**
 *
 * @author edisson
 */
public class FahrenheitToCelsiusAdapter implements ITemperatureDevice{

    
    private FahrenheitDevice fahrenheitDevice;
    
    public FahrenheitToCelsiusAdapter(FahrenheitDevice fahrenheitDevice) {
        this.fahrenheitDevice = fahrenheitDevice;
    }

    @Override
    public double getTemperatureInCelsius() {
        // Convertir de Fahrenheit a Celsius
        return (fahrenheitDevice.getTemperatureInFahrenheit() - 32) * 5.0 / 9.0;
    }
    
}
