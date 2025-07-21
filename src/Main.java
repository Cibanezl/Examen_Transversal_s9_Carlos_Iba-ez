

import modelo.*;
import servicio.*;
import util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlotaManager manager = new FlotaManager();
        HiloCarga hilo = new HiloCarga(manager);
        hilo.start();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                1. Agregar Vehiculo
                2. Listar Vehiculos
                3. Mostrar Boletas
                4. Ver arriendos ≥ 7 dias
                5. Guardar en archivo
                0. Salir
            """);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Tipo (1. Carga, 2. Pasajeros): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Patente: ");
                    String pat = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Días arriendo: ");
                    int dias = sc.nextInt();

                    if (tipo == 1) {
                        System.out.print("Capacidad carga: ");
                        int cap = sc.nextInt();
                        manager.agregarVehiculo(new VehiculoCarga(pat, marca, dias, cap));
                    } else {
                        System.out.print("Máx pasajeros: ");
                        int max = sc.nextInt();
                        manager.agregarVehiculo(new VehiculoPasajeros(pat, marca, dias, max));
                    }
                }
                case 2 -> manager.listarVehiculos();
                case 3 -> manager.mostrarBoletas();
                case 4 -> System.out.println("Arriendos largos: " + manager.contarArriendosLargos());
                case 5 -> ArchivoHelper.guardarEnArchivo("vehiculos.txt", manager);
            }
        } while (opcion != 0);

        System.out.println("¡Hasta luego!");
    }
}

