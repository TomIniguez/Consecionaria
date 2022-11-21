package modelo;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private List<Vehiculo> vehiculos;
	private List<Vehiculo> autos;
	private List<Vehiculo> motos;
	private List<Vehiculo> cuatris;
	
	public Stock() {
		vehiculos=new ArrayList<Vehiculo>();
		autos = new ArrayList<Vehiculo>();
		motos = new ArrayList<Vehiculo>();
		cuatris = new ArrayList<Vehiculo>();
	}
	
	public int contarStock(Vehiculo vehiculo) {
		int contador = 0;
		for(Vehiculo v:vehiculos) {
			if(v.getClass().getSimpleName() == vehiculo.getClass().getSimpleName()) {
				contador++;
			}
		}
		if(contador < 2) {
			System.out.println("No hay vehículos de la clase " + vehiculo.getClass().getSimpleName());
		}else {
			System.out.println("La cantidad de vehículos de la clase " + vehiculo.getClass().getSimpleName() + " es " + contador);
		}
		return contador;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
		if(vehiculo.getClass().getSimpleName().startsWith("Auto")) {
			this.autos.add(vehiculo);
		}else if(vehiculo.getClass().getSimpleName().startsWith("Moto")) {
			this.motos.add(vehiculo);
		}else {
			this.cuatris.add(vehiculo);
		}
	}
	
	public void imprimirVelocidadMaxima() {
		for(Vehiculo v:vehiculos) {
			if(v instanceof Propulsion) {
				Propulsion p = (Propulsion)v;
				System.out.println(p.getClass().getSimpleName()+" "+p.velocidadMaxima());
			}
		}
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public List<Vehiculo> getAutos() {
		return autos;
	}

	public List<Vehiculo> getMotos() {
		return motos;
	}

	public List<Vehiculo> getCuatris() {
		return cuatris;
	}
	
}
