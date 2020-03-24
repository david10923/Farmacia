package Presentacion.Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MostrarUno extends JPanel{
	
	public MostrarUno(){
		super();
		initMostrarUno();
	}
	
	
	public void initMostrarUno(){
		
		
		this.setLayout(new GridLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "MostrarUno",
				TitledBorder.LEFT, TitledBorder.TOP));		
		
		this.setPreferredSize(new Dimension(350,275));		
		
		this.setVisible(true);
		
		
	}

}
