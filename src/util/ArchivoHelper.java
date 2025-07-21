
package util;

import modelo.*;
import servicio.FlotaManager;

import java.io.*;

public class ArchivoHelper {
    public static void cargarDesdeArchivo(String nombreArchivo, FlotaManager manager) {
    try {
        File archivo = new File(System.getProperty("user.dir") + File.separator + nombreArchivo);
        System.out.println("Ruta del archivo: " + archivo.getAbsolutePath());

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue; // Evitar líneas vacías

            String[] datos = linea.split(",");
            if (datos.length < 5) {
                System.out.println("Línea inválida: " + linea); // Aviso si falta algo
                continue;
            }

            String tipo = datos[0].trim();
            String patente = datos[1].trim();
            String marca = datos[2].trim();
            int dias = Integer.parseInt(datos[3].trim());

            if (tipo.equals("CARGA")) {
                int capacidad = Integer.parseInt(datos[4].trim());
                manager.agregarVehiculo(new VehiculoCarga(patente, marca, dias, capacidad));
            } else if (tipo.equals("PASAJEROS")) {
                int maxPasajeros = Integer.parseInt(datos[4].trim());
                manager.agregarVehiculo(new VehiculoPasajeros(patente, marca, dias, maxPasajeros));
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer archivo: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error de formato numérico: " + e.getMessage());
    }
}

    public static void guardarEnArchivo(String nombreArchivo, FlotaManager manager) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Vehiculo v : manager.getFlota()) {
                String linea = "";
                if (v instanceof VehiculoCarga vc) {
                    linea = "CARGA," + vc.getPatente() + "," + vc.getMarca() + "," + vc.getDiasArriendo() + "," + vc.getCapacidadCarga();
                } else if (v instanceof VehiculoPasajeros vp) {
                    linea = "PASAJEROS," + vp.getPatente() + "," + vp.getMarca() + "," + vp.getDiasArriendo() + "," + vp.getMaxPasajeros();
                }
                bw.write(linea);
                bw.newLine();
            }   
        } catch (IOException e) {
            System.out.println("Error al escribir archivo: " + e.getMessage());
        }
    }
}

