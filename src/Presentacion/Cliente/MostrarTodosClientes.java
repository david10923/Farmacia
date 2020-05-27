package Presentacion.Cliente;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Negocio.Cliente.TCliente;
import Presentacion.Vista.MostrarTodos;

@SuppressWarnings("serial")
public class MostrarTodosClientes extends MostrarTodos{

	private String [] columnas = {"CODIGO", "DNI", "TARJETA_SANITARIA", "NOMBRE", "ESTADO"};
	private List<Object> clientes;
	AbstractTableModel table;
	
	public MostrarTodosClientes(String nameId, List<Object> l) {
		super(nameId);
		clientes = l;

		init();
		
	}


	
	public void init() {
		table = new AbstractTableModel() {
			
			@Override
			public Object getValueAt(int fila, int columna) {
				Object o = null;
				
				switch (columna) {
				case 0:
					o = ((TCliente) clientes.get(fila)).getCodigo();
					break;
				case 1:
					o = ((TCliente) clientes.get(fila)).getDni();
					break;
				case 2:
					o = ((TCliente) clientes.get(fila)).getTarjetaSanitaria();
					break;
				case 3:
					o = ((TCliente) clientes.get(fila)).getNombre();
					break;
				case 4:
					o = ((TCliente) clientes.get(fila)).isEstado();
					break;
				
				}
				return o;
			}
			
			@Override
			public int getRowCount() {
				
				return clientes == null ? 0 : clientes.size();
			}
			
			@Override
			public int getColumnCount() {
				
				return columnas.length;
			}
			
			@Override
			public String getColumnName(int column) {
				
				return columnas[column];
			}
		};
		super.table = new JTable(table);
		anchoColumna();
		super.table.setShowGrid(false);
		super.table.setIntercellSpacing(new Dimension(0,0));
		super.table.setVisible(true);
		this.add(new JScrollPane(super.table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	}
	
	public void anchoColumna() {
		super.table.getColumnModel().getColumn(0).setPreferredWidth(20);
		super.table.getColumnModel().getColumn(1).setPreferredWidth(100);
		super.table.getColumnModel().getColumn(2).setPreferredWidth(100);
		super.table.getColumnModel().getColumn(3).setPreferredWidth(100);
		super.table.getColumnModel().getColumn(4).setPreferredWidth(30);
	}
	

	@SuppressWarnings("unchecked")
	public void update(Object l) {
		
		clientes = (List<Object>) l;
		table.fireTableDataChanged();
	}
	
	

}
