/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.view;

import est.ups.edu.ec.controller.TemperatureController;
import est.ups.edu.ec.model.CelsiusDevice;
import est.ups.edu.ec.model.FahrenheitDevice;
import est.ups.edu.ec.model.FahrenheitToCelsiusAdapter;
import est.ups.edu.ec.model.ITemperatureDevice;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author edisson
 */
public class TemperatureView {
    public static void main(String[] args) {
        TemperatureController controller = new TemperatureController();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Agregar dispositivo en Celsius");
            System.out.println("2. Agregar dispositivo en Fahrenheit");
            System.out.println("3. Consultar todas las temperaturas");
            System.out.println("4. Salir");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese la temperatura en Celsius: ");
                    double celsiusTemp = scanner.nextDouble();
                    ITemperatureDevice celsiusDevice = new CelsiusDevice(celsiusTemp);
                    controller.addDeviceTemperature(celsiusDevice);
                    break;
                case 2:
                    System.out.print("Ingrese la temperatura en Fahrenheit: ");
                    double fahrenheitTemp = scanner.nextDouble();
                    FahrenheitDevice fahrenheitDevice = new FahrenheitDevice(fahrenheitTemp);
                    ITemperatureDevice fahrenheitAdapter = new FahrenheitToCelsiusAdapter(fahrenheitDevice);
                    controller.addDeviceTemperature(fahrenheitAdapter);
                    break;
                case 3:
                    List<Double> temperatures = controller.getTemperatures();
                    System.out.println("Temperaturas en Celsius:");
                    for (double temp : temperatures) {
                        System.out.println(temp + " °C");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (option != 4);

        scanner.close();
    }
}
