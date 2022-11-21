package vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorVehiculos;
import modelo.ModeloVista1;
import modelo.Propulsion;
import modelo.Vehiculo;

public class Vista1 extends JFrame{
	
	JComboBox<String> comboVehiculos = new JComboBox<String>();
	JTable tablaVehiculos = new JTable();
	
	public Vista1(ModeloVista1 modelo) {
		this.setVisible(true);
		this.setBounds(500, 200, 600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Consecionaria ABM");
		this.setLayout(new BorderLayout());
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(0, 6));
		
		comboVehiculos.addItem("Autos");
		comboVehiculos.addItem("Motos");
		comboVehiculos.addItem("Cuatriciclos");
		
		panelSuperior.add(new JLabel("Stock"));
		panelSuperior.add(comboVehiculos);
		this.add(panelSuperior,BorderLayout.NORTH);
		
		JPanel panelCentral=new JPanel();
		panelCentral.setLayout(new BorderLayout());
		
		this.add(panelCentral,BorderLayout.CENTER);
		
		DefaultTableModel modeloTablaVehiculos = new DefaultTableModel();
		Object[] titulos = {"Patente", "Estado", "Velocidad Nominal","Velocidad Maxima", "Precio Compra", "Precio Venta"};
		modeloTablaVehiculos.setColumnIdentifiers(titulos);
		for(Vehiculo v: modelo.getAuto().getAutos()) {
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
		JScrollPane scrollTabla=new JScrollPane(tablaVehiculos);
		
		panelCentral.add(scrollTabla,BorderLayout.CENTER);
		
		/*-------Se crea la clase interna que implementa el Listener-----*/
		class ManejadorCombo implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent e) {
				ControladorVehiculos.seleccionarVehiculo(modelo, comboVehiculos, tablaVehiculos);
			}       
		}
		
		/*-------Se instancia un objeto de la clase interna-----*/
		ManejadorCombo manejadorCombo=new ManejadorCombo();
		
		/*-------Se agrega el manejador al componente-----*/
		comboVehiculos.addItemListener(manejadorCombo);
	}

}
