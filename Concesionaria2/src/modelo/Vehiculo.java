package modelo;

public abstract class Vehiculo {

	static int contador=0;
	protected double velocidadNominal;
	private int patente;
	private double precioCompra, precioVenta;
	private boolean usado;
	
	public Vehiculo() {
		patente=contador;
		contador++;
	}

	public int getPatente() {
		return patente;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public boolean isUsado() {
		return usado;
	}
	
	public String getEstado() {
		if(this.usado == true) {
			return "Usado";
		}else {
			return "Nuevo";
		}
	}

	public double getVelocidadNominal() {
		return velocidadNominal;
	}
	
}
