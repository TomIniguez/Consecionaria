package controladores;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.ModeloVista1;
import modelo.Propulsion;
import modelo.Vehiculo;

public class ControladorVehiculos {
	
	public static void seleccionarVehiculo(ModeloVista1 modelo, JComboBox<String> comboVehiculos, JTable tablaVehiculos) {
		
		DefaultTableModel modeloTablaVehiculos = new DefaultTableModel();
		Object[] titulos = {"Patente", "Estado", "Velocidad Nominal", "Velocidad Maxima", "Precio Compra", "Precio Venta"};
		modeloTablaVehiculos.setColumnIdentifiers(titulos);
		
		int indiceCombo = comboVehiculos.getSelectedIndex();
		List<Vehiculo> vehiculoSeleccionado;
		
		if(indiceCombo == 0) {
			vehiculoSeleccionado = modelo.getAuto().getAutos();
		}else if(indiceCombo == 1) {
			vehiculoSeleccionado = modelo.getMoto().getMotos();
		}else {
			vehiculoSeleccionado = modelo.getCuatriciclo().getCuatris();
		}
		
		for(Vehiculo v: vehiculoSeleccionado) {
			Object[] fila = new Object[6];
			fila[0] = v.getPatente();
			fila[1] = v.getEstado();
			fila[2] = v.getVelocidadNominal();
			if(v instanceof Propulsion) {
				Propulsion p = (Propulsion)v;
				fila[3] = p.velocidadMaxima();
			}
			fila[4] = v.getPrecioCompra();
			fila[5] = v.getPrecioVenta();
			modeloTablaVehiculos.addRow(fila);
		}
		
		tablaVehiculos.setModel(modeloTablaVehiculos);
		tablaVehiculos.validate();
	}

}
