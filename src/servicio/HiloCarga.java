package servicio;

import util.ArchivoHelper;

public class HiloCarga extends Thread {
    private FlotaManager manager;

    public HiloCarga(FlotaManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        ArchivoHelper.cargarDesdeArchivo("vehiculos.txt", manager);
        System.out.println("Datos cargados por el hilo.");
    }
}

