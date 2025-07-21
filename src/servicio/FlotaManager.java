
package servicio;

import modelo.*;
import java.util.*;

public class FlotaManager {
    private List<Vehiculo> flota = Collections.synchronizedList(new ArrayList<>());

    public boolean agregarVehiculo(Vehiculo v) {
        for (Vehiculo veh : flota) {
            if (veh.getPatente().equalsIgnoreCase(v.getPatente())) return false;
        }
        flota.add(v);
        return true;
    }

    public void listarVehiculos() {
        for (Vehiculo v : flota) v.mostrarDatos();
    }

    public void mostrarBoletas() {
        for (Vehiculo v : flota) {
            if (v instanceof interfaces.Facturable f) {
                System.out.println("Patente: " + v.getPatente() + " → Total: $" + f.calcularBoleta());
            }
        }
    }

    public int contarArriendosLargos() {
        int count = 0;
        for (Vehiculo v : flota) {
            if (v.getDiasArriendo() >= 7) count++;
        }
        return count;
    }

    public List<Vehiculo> getFlota() {
        return flota;
    }
}

