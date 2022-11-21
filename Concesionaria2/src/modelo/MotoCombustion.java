package modelo;

public class MotoCombustion extends Moto implements PropulsionCombustion{

	@Override
	public double velocidadMaxima() {
		
		return this.velocidadNominal*1;
	}

}
