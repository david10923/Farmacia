package Negocio.Factura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Negocio.Cliente.TCliente;
import Negocio.Producto.TProducto;
import Negocio.Trabajador.TTrabajador;

public class TFacturaConProductos {
	
	private TFactura tFactura;
	private List<TContiene> tContiene;
	private List<TProducto> tProducto;
	private TTrabajador tTrabajador; 
	private TCliente tCliente;
	
	public TFacturaConProductos(TFactura tFactura,List<TContiene> tContiene,List<TProducto> tProducto,TTrabajador tTrabajador,TCliente tCliente){
		this.tCliente = tCliente; 
		this.tTrabajador = tTrabajador;
		this.tContiene = tContiene;
		this.tProducto = tProducto;
		this.tFactura = tFactura;
	}
	
	public TFacturaConProductos(){
		
		tContiene = new ArrayList<TContiene>();
		tProducto = new ArrayList<TProducto>();
		
	}

	public String toString(){ 
		//String act = estado ? "Si" : "No";
		
		StringBuilder aux = new StringBuilder();
		
		for (TProducto tp: tProducto) {
			aux.append(tp.toString() + "\n");
		}
		
		return ("	 CLIENTE: "+"\n"+  tCliente.toString() + "\n" +"	TRABAJADOR:" 
		+ "\n"+  tTrabajador.toString()+ "\n"+ "	FACTURA:" +"\n" +tFactura.toString()+ "\n"+ "	 PRODUCTO:"+ "\n" +aux.toString());
		
	}

	public TFactura gettFactura() {
		return tFactura;
	}

	public void settFactura(TFactura tFactura) {
		this.tFactura = tFactura;
	}

	
	public TTrabajador gettTrabajador() {
		return tTrabajador;
	}

	public List<TContiene> gettContiene() {
		return tContiene;
	}

	public void settContiene(List<TContiene> tContiene) {
		this.tContiene = tContiene;
	}

	public List<TProducto> gettProducto() {
		return tProducto;
	}

	public void settProducto(List<TProducto> tProducto) {
		this.tProducto = tProducto;
	}

	public void settTrabajador(TTrabajador tTrabajador) {
		this.tTrabajador = tTrabajador;
	}

	public TCliente gettCliente() {
		return tCliente;
	}

	public void settCliente(TCliente tCliente) {
		this.tCliente = tCliente;
	}
	

}
