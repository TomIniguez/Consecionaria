package modelo;



public class Consecionaria {
	
	private Stock stock;
	
	public Consecionaria() {
		stock=new Stock();
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		if(stock.contarStock(vehiculo)<2) {
			stock.agregarVehiculo(vehiculo);
			System.out.println("Se agrego el vehiculo "+vehiculo.getClass().getSimpleName());
		}else {
			System.out.println("No se agrego el vehiculo "+vehiculo.getClass().getSimpleName());
		}
	}
	
	
	public void imprimirVelocidadMaxima() {
		this.stock.imprimirVelocidadMaxima();
	}

	public Stock getStock() {
		return stock;
	}
}
