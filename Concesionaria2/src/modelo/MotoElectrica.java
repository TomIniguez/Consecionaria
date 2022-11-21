package modelo;

public class MotoElectrica extends Moto implements PropulsionElectrica{

	@Override
	public double velocidadMaxima() {
		
		return this.velocidadNominal*0.6;
	}

}
