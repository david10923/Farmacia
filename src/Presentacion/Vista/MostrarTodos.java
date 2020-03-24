package Presentacion.Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MostrarTodos extends JPanel {
	
	public MostrarTodos(){
		super();
		initMostrarTodos();
		
	}
	
	public void initMostrarTodos(){		
		
		this.setLayout(new GridLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "MostrarTodos",
				TitledBorder.LEFT, TitledBorder.TOP));		
		
		this.setPreferredSize(new Dimension(350, 275));		
		
		this.setVisible(true);
		
	}

}
