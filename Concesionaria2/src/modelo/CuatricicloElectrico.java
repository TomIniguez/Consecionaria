package modelo;

public class CuatricicloElectrico extends Cuatriciclo implements PropulsionElectrica{

	@Override
	public double velocidadMaxima() {
		// TODO Auto-generated method stub
		return this.velocidadNominal*0.6;
	}

}
