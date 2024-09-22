/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.controller;

import est.ups.edu.ec.model.ITemperatureDevice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edisson
 */
public class TemperatureController {
    
    private List<Double> temperatures; 
    
    public TemperatureController() {
        temperatures = new ArrayList<>();
    }

    // Agregar temperatura desde cualquier dispositivo que implemente ITemperatureDevice
    public void addDeviceTemperature(ITemperatureDevice device) {
        temperatures.add(device.getTemperatureInCelsius());
    }

    // Obtener todas las temperaturas almacenadas
    public List<Double> getTemperatures() {
        return temperatures;
    }
    
}
