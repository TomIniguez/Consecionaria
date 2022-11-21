package modelo;

public class MotoCombustionGasoil extends MotoCombustion implements PropulsionCombustion{
	
	@Override
	public double velocidadMaxima() {
		
		return this.velocidadNominal*0.8;
	}

}
