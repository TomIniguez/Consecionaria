package modelo;

public class AutoElectrico extends Auto implements PropulsionElectrica{

	@Override
	public double velocidadMaxima() {
		return this.velocidadNominal*0.6;
	}

}
