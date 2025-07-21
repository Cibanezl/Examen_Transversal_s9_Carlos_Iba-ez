
package modelo;

import interfaces.Facturable;

public class VehiculoPasajeros extends Vehiculo implements Facturable {
    private int maxPasajeros;

    public VehiculoPasajeros() {}

    public VehiculoPasajeros(String patente, String marca, int dias, int maxPasajeros) {
        super(patente, marca, dias);
        this.maxPasajeros = maxPasajeros;
    }

    public int getMaxPasajeros() { return maxPasajeros; }
    public void setMaxPasajeros(int maxPasajeros) { this.maxPasajeros = maxPasajeros; }

    @Override
    public void mostrarDatos() {
        System.out.println("Pasajeros - Patente: " + patente + ", Marca: " + marca + ", Días: " + diasArriendo + ", Máx pasajeros: " + maxPasajeros);
    }

    @Override
    public double calcularBoleta() {
        double total = diasArriendo * 80;
        return total * (1 + IVA) * (1 - DESCUENTO_PASAJEROS);
    }
}

