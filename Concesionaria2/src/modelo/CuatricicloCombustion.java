package modelo;

public class CuatricicloCombustion extends Cuatriciclo implements PropulsionCombustion{

	@Override
	public double velocidadMaxima() {
		// TODO Auto-generated method stub
		return this.velocidadNominal*1;
	}

}
