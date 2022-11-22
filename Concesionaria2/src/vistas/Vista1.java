package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorVehiculos;
import modelo.ModeloVista1;
import modelo.Propulsion;
import modelo.Vehiculo;

public class Vista1 extends JFrame{
	
	JComboBox<String> comboVehiculos = new JComboBox<String>();
	JTable tablaVehiculos = new JTable();
	
	JTextField campoCambiarEstado , campoEliminar;
	
	public Vista1(ModeloVista1 modelo) {
		this.setVisible(true);
		this.setBounds(500, 200, 600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Consecionaria ABM");
		this.setLayout(new BorderLayout());
		// Seleccionar tipo de vehiculo
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(0, 6));
		
		comboVehiculos.addItem("Autos");
		comboVehiculos.addItem("Motos");
		comboVehiculos.addItem("Cuatriciclos");
		
		panelSuperior.add(new JLabel("Stock"));
		panelSuperior.add(comboVehiculos);
		this.add(panelSuperior,BorderLayout.NORTH);
		// Tabla en el centro de la ventana
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
		
		//Panel para hacer modificaciones
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new GridLayout(3,3));
		
		JLabel lableEliminar = new JLabel("Indique el numero de la fila a eliminar (empieza en 0)");
		panelInferior.add(lableEliminar);
		
		Container contModificar = new Container();
		contModificar.setLayout(new GridLayout(1,2));
		JLabel labelNombre = new JLabel("Eliminar vehiculo");
		campoEliminar = new JTextField();
		contModificar.add(labelNombre);
		contModificar.add(campoEliminar);
		
		panelInferior.add(contModificar);
		
		
		Container contBotones=new Container();
		contBotones.setLayout(new GridLayout(1,2));
		
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
		
		/*CONSTRUCCION DEL BOTON ACEPTAR*/
		JButton btnAceptar=new JButton("Aceptar");
		
		/*CLASE INTERNA*/
		class HandlerBtnAceptar implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String patente = campoEliminar.getText();
				modeloTablaVehiculos.removeRow(Integer.parseInt(patente));
			}
		}
		
		/*INSTANCIACION DEL MANEJADOR*/
		HandlerBtnAceptar handlerBtnAceptar=new HandlerBtnAceptar();
		
		/*ASIGNACION DEL MANEJADOR AL BOTON*/
		btnAceptar.addActionListener(handlerBtnAceptar);
		
		contBotones.add(btnAceptar);
		
		panelInferior.add(contBotones);
		this.add(panelInferior, BorderLayout.SOUTH);
		
	}
}
