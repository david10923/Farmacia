package Presentacion.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class OperationsPanel extends JPanel {

	private JButton altaBoton;
	private JButton bajaBoton;
	private JButton modificarBoton;
	private JComboBox <Object> seleccionarBox;
	
	public OperationsPanel() {
		super();
		initOperationPanel();
	}
	
	
	
	public void initOperationPanel() {
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Operations",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		this.setVisible(true);
		altaBoton      = new JButton("DAR DE ALTA");
		bajaBoton      = new JButton("DAR DE BAJA");
		modificarBoton = new JButton("MODIFICAR");
		seleccionarBox = new JComboBox();
		this.seleccionarBox.setSize(300, 200);
		
		this.add(Box.createVerticalGlue());
		this.add(Box.createRigidArea(new Dimension(10, 1)));
		
		altaBoton.setAlignmentX(Component.CENTER_ALIGNMENT);
		altaBoton.setSize(new Dimension(100, 50));
		altaBoton.setVisible(true);
		
		bajaBoton.setAlignmentX(Component.CENTER_ALIGNMENT);
		bajaBoton.setSize(new Dimension(100, 50));
		bajaBoton.setVisible(true);
		
		
		this.add(altaBoton);
		this.add(bajaBoton);
		this.add(modificarBoton);
		this.add(seleccionarBox);
		
	}
	
}

