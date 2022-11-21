package modelo;

public class AutoCombustionGasoil extends AutoCombustion implements PropulsionCombustion{
	
	@Override
	public double velocidadMaxima() {
		return this.velocidadNominal*0.8;
	}

}
