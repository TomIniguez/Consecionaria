package modelo;

public class AutoCombustion extends Auto implements PropulsionCombustion{

	@Override
	public double velocidadMaxima() {
		return this.velocidadNominal*1;
	}

}
