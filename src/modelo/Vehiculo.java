
package modelo;

public abstract class Vehiculo {
    protected String patente;
    protected String marca;
    protected int diasArriendo;

    public Vehiculo() {}

    public Vehiculo(String patente, String marca, int diasArriendo) {
        this.patente = patente;
        this.marca = marca;
        this.diasArriendo = diasArriendo;
    }

    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getDiasArriendo() { return diasArriendo; }
    public void setDiasArriendo(int diasArriendo) { this.diasArriendo = diasArriendo; }

    public abstract void mostrarDatos();
}

