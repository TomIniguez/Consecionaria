package modelo;

public class CuatricicloCombustionGasoil extends CuatricicloCombustion implements PropulsionCombustion{
	
	@Override
	public double velocidadMaxima() {
		// TODO Auto-generated method stub
		return this.velocidadNominal*0.8;
	}

}
