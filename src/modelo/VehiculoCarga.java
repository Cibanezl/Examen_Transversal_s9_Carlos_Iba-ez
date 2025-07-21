
package modelo;

import interfaces.Facturable;

public class VehiculoCarga extends Vehiculo implements Facturable {
    private int capacidadCarga;

    public VehiculoCarga() {}

    public VehiculoCarga(String patente, String marca, int dias, int capacidadCarga) {
        super(patente, marca, dias);
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(int capacidadCarga) { this.capacidadCarga = capacidadCarga; }

    @Override
    public void mostrarDatos() {
        System.out.println("Carga - Patente: " + patente + ", Marca: " + marca + ", Días: " + diasArriendo + ", Capacidad: " + capacidadCarga);
    }

    @Override
    public double calcularBoleta() {
        double total = diasArriendo * 100;
        return total * (1 + IVA) * (1 - DESCUENTO_CARGA);
    }
}

