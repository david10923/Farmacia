package Presentacion.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Negocio.Cliente.TCliente;

public abstract class  MostrarTodos extends JPanel {
	
	private String nameId;
	
	protected JTable table;
	
	public MostrarTodos(String nameId){
		super();
		this.nameId = nameId;
		initMostrarTodos();
		
	}
	
	public void initMostrarTodos(){		
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "MostrarTodos",
				TitledBorder.LEFT, TitledBorder.TOP));		
		
		this.setPreferredSize(new Dimension(775, 250));		
		

		
		this.setVisible(true);
		
	}

	
	public abstract void update(Object l);
	
	
}
