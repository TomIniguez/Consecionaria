package controladores;

import modelo.AutoCombustion;
import modelo.AutoElectrico;
import modelo.Consecionaria;
import modelo.Cuatriciclo;
import modelo.CuatricicloCombustion;
import modelo.CuatricicloElectrico;
import modelo.ModeloVista1;
import modelo.MotoCombustion;
import modelo.MotoElectrica;
import vistas.Vista1;

public class Principal {
	
	public static void main(String []args) {
		
		Consecionaria consecionaria=new Consecionaria();
		
		consecionaria.agregarVehiculo(new AutoElectrico());
		consecionaria.agregarVehiculo(new AutoElectrico());
		consecionaria.agregarVehiculo(new AutoElectrico());
		consecionaria.agregarVehiculo(new AutoCombustion());
		consecionaria.agregarVehiculo(new MotoElectrica());
		consecionaria.agregarVehiculo(new MotoCombustion());
		consecionaria.agregarVehiculo(new MotoCombustion());
		consecionaria.agregarVehiculo(new MotoCombustion());
		consecionaria.agregarVehiculo(new CuatricicloElectrico());
		consecionaria.agregarVehiculo(new CuatricicloCombustion());
		
		consecionaria.imprimirVelocidadMaxima();
		
		ModeloVista1 modelo = new ModeloVista1();
		modelo.setAuto(consecionaria.getStock());
		modelo.setMoto(consecionaria.getStock());
		modelo.setCuatriciclo(consecionaria.getStock());
		
		Vista1 abm = new Vista1(modelo);
		abm.setVisible(true);
	
		
	}

}
