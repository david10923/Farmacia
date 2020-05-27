package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;



import Main.Main;
import Negocio.Cliente.TCliente;
import Negocio.Factura.TCarrito;
import Negocio.Factura.TContiene;
import Negocio.Factura.TFactura;
import Negocio.Factura.TFacturaConProductos;
import Negocio.Laboratorio.TLaboratorio;
import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Cliente.GUICliente;
import Presentacion.Factura.GUIFactura;
import Presentacion.Laboratorio.GUILaboratorio;
import Presentacion.Producto.GUIProducto;
import Presentacion.Trabajador.GUITrabajador;
import Presentacion.Vista.GUIFarmacia;
import Presentacion.Vista.IGUI;
import Presentacion.Vista.VistaGeneral;

public class ControllerImp extends Controller {

	private IGUI gui;
	private GUIFarmacia farmacia;

	public ControllerImp() {
		
		farmacia = new GUIFarmacia(Main.name);
		List<Object> guis = new ArrayList<>();

		guis.add(new VistaGeneral());
		guis.add(new GUICliente());
		guis.add(new GUITrabajador());
		guis.add(new GUILaboratorio());
		guis.add(new GUIProducto());
		guis.add(new GUIFactura());
		farmacia.initTabs(guis);

	}

	@SuppressWarnings("null")
	@Override
	public void action(Object data, Integer event) {
		String ms;
		int id;
		
		String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
		String telefonoRegexp = "^[0-9]{9}$";

		gui = farmacia.getIGUI(event / 100);

		switch (event) {
		case Evento.ALTA_CLIENTE: {
			

			TCliente tCliente = (TCliente) data;
			if(tCliente == null) {
				gui.actualizar("No has introducido datos", Evento.DATOS_INCORRECTOS_CLIENTE);
			}else if (Pattern.matches(dniRegexp, tCliente.getDni())){
				
				int res = SAAbstractFactory.getInstance().createSACliente().create(tCliente);

				if (res > 0) {
					gui.actualizar(res, Evento.RES_ALTA_CLIENTE_OK);
				} else if (res == 0) {
					gui.actualizar(res, Evento.RES_REACTIVAR_CLIENTE_OK);
				} else {
					gui.actualizar(null, Evento.RES_ALTA_CLIENTE_FAILED);
				}
				
			}else{			
				gui.actualizar("Los datos son incorrectos ",Evento.DATOS_INCORRECTOS_CLIENTE);				
			}

			
			break;

		}
		case Evento.BAJA_CLIENTE: {

			String dni_cliente = (String) data;
			
			if(Pattern.matches(dniRegexp,dni_cliente)){

			int res = SAAbstractFactory.getInstance().createSACliente().delete(dni_cliente);

			if (res > 0) {
				gui.actualizar(res, Evento.RES_BAJA_CLIENTE_OK);
			} else {
				gui.actualizar(null, Evento.RES_BAJA_CLIENTE_FAILED);
			}
			}
			else{
				gui.actualizar("Los datos introducidos no son correctos",Evento.DATOS_INCORRECTOS_CLIENTE);	
			}

			break;

		}
		case Evento.MODIFICAR_CLIENTE: {

			TCliente tCliente = (TCliente) data;
			if(tCliente == null) {
				gui.actualizar("No has introducido datos", Evento.DATOS_INCORRECTOS_CLIENTE);
			}else if(Pattern.matches(dniRegexp,tCliente.getDni())){
				int res = SAAbstractFactory.getInstance().createSACliente().update(tCliente);

				if (res > 0) {
					gui.actualizar(res, Evento.RES_MODIFICAR_CLIENTE_OK);
				} else {
					gui.actualizar(null, Evento.RES_MODIFICAR_CLIENTE_FAILED);
				}	
			}
			else{
				gui.actualizar("Los datos introducidos no son correctos",Evento.DATOS_INCORRECTOS_CLIENTE);		
			}

			

			break;

		}
		case Evento.MOSTRAR_CLIENTE: {

			id = (Integer) data;
			TCliente t = (TCliente) (SAAbstractFactory.getInstance().createSACliente().readById(id));

			if (t != null) {
				gui.actualizar(t, Evento.RES_MOSTRAR_CLIENTE_OK);
			} 
			break;
		}
		case Evento.MOSTRAR_TODOS_CLIENTES: {

			List<TCliente> aux = SAAbstractFactory.getInstance().createSACliente().readAll();

			if (aux != null) {
				gui.actualizar(aux, Evento.RES_MOSTRAR_TODOS_CLIENTES_OK);
			}
			break;
		}
		case Evento.ALTA_TRABAJADOR: {
			TTrabajador tTrabajador = (TTrabajador) data;
			
			if(tTrabajador == null) {
				gui.actualizar("No has introducido datos", Evento.DATOS_INCORRECTOS_TRABAJADOR);
			}else if(Pattern.matches(dniRegexp,tTrabajador.getDni()) && Pattern.matches(telefonoRegexp,tTrabajador.getTelefono())){
				
				int res = SAAbstractFactory.getInstance().createSATrabajador().create(tTrabajador);

				if (res > 0) {
					gui.actualizar(res, Evento.RES_ALTA_TRABAJADOR_OK);
				} else if (res == 0) {
					gui.actualizar(res, Evento.RES_REACTIVAR_TRABAJADOR_OK);
				} else {
					gui.actualizar(null, Evento.RES_ALTA_TRABAJADOR_FAILED);
				}
			}
			else{
				gui.actualizar("Los datos introducidos no son correctos",Evento.DATOS_INCORRECTOS_TRABAJADOR);	
			}
			break;
		}
		case Evento.BAJA_TRABAJADOR: {

			String dni_trabajador = (String) data;
			
			if(Pattern.matches(dniRegexp,dni_trabajador)){
				int res = SAAbstractFactory.getInstance().createSATrabajador().delete(dni_trabajador);

				if (res > 0) {
					gui.actualizar(res, Evento.RES_BAJA_TRABAJADOR_OK);
				} else {
					gui.actualizar(null, Evento.RES_BAJA_TRABAJADOR_FAILED);
				}
			}
			else{
				gui.actualizar("Los datos introducidos no son correctos",Evento.DATOS_INCORRECTOS_TRABAJADOR);
			}

			
			break;
		}
		case Evento.MODIFICAR_TRABAJADOR: {

			TTrabajador tTrabajador = (TTrabajador) data;
			
			if(Pattern.matches(dniRegexp,tTrabajador.getDni()) && Pattern.matches(telefonoRegexp,tTrabajador.getTelefono())){
				int res = SAAbstractFactory.getInstance().createSATrabajador().update(tTrabajador);

				if (res > 0) {
					gui.actualizar(res, Evento.RES_MODIFICAR_TRABAJADOR_OK);
				} else {
					gui.actualizar(null, Evento.RES_MODIFICAR_TRABAJADOR_FAILED);
				}
				
			}else{
				gui.actualizar("Los datos introducidos no son correctos ", Evento.DATOS_INCORRECTOS_TRABAJADOR);
			}
			break;

		}
		case Evento.MOSTRAR_TRABAJADOR: {
			id = (Integer) data;
			TTrabajador t = (TTrabajador) (SAAbstractFactory.getInstance().createSATrabajador().readById(id));

			if (t != null) {
				gui.actualizar(t, Evento.RES_MOSTRAR_TRABAJADOR_OK);
			} else {

			}

			break;
		}
		case Evento.MOSTRAR_TODOS_TRABAJADORES: {
			List<TTrabajador> aux = SAAbstractFactory.getInstance().createSATrabajador().readAll();

			if (aux != null) {
				gui.actualizar(aux, Evento.RES_MOSTRAR_TODOS_TRABAJADORES_OK);
			} else {

			}
			break;
		}
		case Evento.ALTA_LABORATORIO: {
			TLaboratorio tLaboratorio = (TLaboratorio) data;
			
			if(tLaboratorio == null){				
				gui.actualizar("No has introducido datos", Evento.DATOS_INCORRECTOS_LABORATORIO);
			}else if(Pattern.matches(telefonoRegexp,tLaboratorio.getTelefono())){
				
				int res = SAAbstractFactory.getInstance().createSALaboratorio().create(tLaboratorio);

				if (res > 0) {
					gui.actualizar(res, Evento.RES_ALTA_LABORATORIO_OK);
				} else if (res == 0) {
					gui.actualizar(res, Evento.RES_REACTIVAR_LABORATORIO_OK);
				} else {
					gui.actualizar("Los datos introducidos no son correctos", Evento.RES_ALTA_LABORATORIO_FAILED);
				}
				
			}else{
				gui.actualizar(null, Evento.DATOS_INCORRECTOS_LABORATORIO);
			}
			break;
		}
		case Evento.BAJA_LABORATORIO: {

			int idTrabajador = (Integer) data;

			int res = SAAbstractFactory.getInstance().createSALaboratorio().delete(idTrabajador);

			if (res > 0) {
				gui.actualizar(res, Evento.RES_BAJA_LABORATORIO_OK);
			} else {
				gui.actualizar(null, Evento.RES_BAJA_LABORATORIO_FAILED);
			}

			break;
		}
		case Evento.MODIFICAR_LABORATORIO: {

			TLaboratorio tLaboratorio = (TLaboratorio) data;
			
			if(tLaboratorio == null ){
				gui.actualizar("No has introducido datos", Evento.DATOS_INCORRECTOS_LABORATORIO);
			}
			else if(Pattern.matches(telefonoRegexp,tLaboratorio.getTelefono())){
				int res = SAAbstractFactory.getInstance().createSALaboratorio().update(tLaboratorio);

				if (res > 0) {
					gui.actualizar(res, Evento.RES_MODIFICAR_LABORATORIO_OK);
				} else {
					gui.actualizar(null, Evento.RES_MODIFICAR_LABORATORIO_FAILED);
				}
				
			}else{
				gui.actualizar("Los datos introducidos no son correctos", Evento.DATOS_INCORRECTOS_LABORATORIO);
			}

			break;

		}
		case Evento.MOSTRAR_LABORATORIO: {

			id = (Integer) data;
			TLaboratorio t = (TLaboratorio) (SAAbstractFactory.getInstance().createSALaboratorio().readById(id));

			if (t != null) {
				gui.actualizar(t, Evento.RES_MOSTRAR_LABORATORIO_OK);
			} else {
				gui.actualizar(t, Evento.RES_MOSTRAR_LABORATORIO_FAILED);
			}
			break;

		}
		case Evento.MOSTRAR_TODOS_LABORATORIOS: {
			List<TLaboratorio> aux = SAAbstractFactory.getInstance().createSALaboratorio().readAll();

			if (aux != null) {
				gui.actualizar(aux, Evento.RES_MOSTRAR_TODOS_LABORATORIOS_OK);
			} else {
				gui.actualizar(aux, Evento.RES_MOSTRAR_TODOS_LABORATORIOS_FAILED);
			}
			break;
		}

		case Evento.MOSTRAR_TODOS_PRODUCTOS_LABORATORIO:
			
			int idLabPro = (int) data;
			
			String sProList = SAAbstractFactory.getInstance().createSALaboratorio().readProductosLaboratorio(idLabPro);
			
			if (sProList != "") {
				gui.actualizar(sProList, Evento.RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_OK);
			} else {
				gui.actualizar(null, Evento.RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_FAIL);
			}
			
			break;
		
		case Evento.ALTA_PRODUCTO: {
			TProducto tProducto = (TProducto) data;
		
			if(tProducto == null){
				gui.actualizar("No has introducido datos",Evento.DATOS_INCORRECTOS_PRODUCTO);
				
			}else{
				int res = SAAbstractFactory.getInstance().createSAProducto().create(tProducto);
				
				if (res > 0) {
					gui.actualizar(res, Evento.RES_ALTA_PRODUCTO_OK);
				} else if (res == 0) {
					gui.actualizar(res, Evento.RES_REACTIVAR_PRODUCTO_OK);				
				} else {
					gui.actualizar(null, Evento.RES_ALTA_PRODUCTO_FAILED);
				}

			}
			break;
		}
		case Evento.BAJA_PRODUCTO: {

			int idProducto = (Integer) data;
			
			
			int res = SAAbstractFactory.getInstance().createSAProducto().delete(idProducto);

			if (res > 0) {
				gui.actualizar(res, Evento.RES_BAJA_PRODUCTO_OK);
			} else {
				gui.actualizar(null, Evento.RES_BAJA_PRODUCTO_FAILED);
			}

			break;
		}
		case Evento.MODIFICAR_PRODUCTO: {

			TProducto tProducto = (TProducto) data;

			int res = SAAbstractFactory.getInstance().createSAProducto().update(tProducto);

			if (res > 0) {
				gui.actualizar(res, Evento.RES_MODIFICAR_PRODUCTO_OK);
			} else {
				gui.actualizar(null, Evento.RES_MODIFICAR_PRODUCTO_FAILED);
			}

			break;

		}
		case Evento.MOSTRAR_PRODUCTO: {

			id = (Integer) data;
			TProducto tProducto = (TProducto) (SAAbstractFactory.getInstance().createSAProducto().read(id));

			if (tProducto != null) {
				gui.actualizar(tProducto, Evento.RES_MOSTRAR_PRODUCTO_OK);
			} else {
				gui.actualizar(tProducto, Evento.RES_MOSTRAR_PRODUCTO_FAILED);
			}
			break;

		}
		case Evento.MOSTRAR_TODOS_PRODUCTOS: {
			List<TProducto> aux = SAAbstractFactory.getInstance().createSAProducto().readAll();

			if (aux != null) {
				gui.actualizar(aux, Evento.RES_MOSTRAR_TODOS_PRODUCTOS_OK);
			} else {
				gui.actualizar(aux, Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FAILED);
			}
			break;
		}
		case Evento.BAJA_PRODUCTOS_POR_LABORATORIO:
			
			int idBaja = SAAbstractFactory.getInstance().createSAProducto().bajaTodosProductosLaboratorio((int)data);
			
			if (idBaja != 0) {
				gui.actualizar(idBaja, Evento.RES_BAJA_PRODUCTOS_POR_LABORATORIO_OK);
			} else {
				gui.actualizar(idBaja, Evento.RES_BAJA_PRODUCTOS_POR_LABORATORIO_FAIL);
			}
			
			break;
			
		case Evento.REACTIVAR_PRODUCTOS_LABORATORIO:
			
			int idReact = SAAbstractFactory.getInstance().createSAProducto().reactivarProductoslaboratorio((int)data);
			
			if (idReact != 0) {
				gui.actualizar(idReact, Evento.RES_REACTIVAR_PRODUCTOS_LABORATORIO_OK);
			} else {
				gui.actualizar(idReact, Evento.RES_REACTIVAR_PRODUCTOS_LABORATORIO_FAIL);
			}
			
			
			break;
		case Evento.CREAR_FACTURA: {
			
			TFactura factura = (TFactura) data;	
			
			TCarrito carrito = SAAbstractFactory.getInstance().createSAFactura().create(factura);
			
			if (carrito != null) {
				gui.actualizar(carrito, Evento.ANADIR_PRODUCTOS_FACTURA);		
			}else {
				
			}

			break;
		}
		case Evento.CERRAR_FACTURA:{
			TCarrito carrito = (TCarrito) data ; 
			
			int ok = SAAbstractFactory.getInstance().createSAFactura().cerrarFactura(carrito); 
			
			if (ok > 0) {
				gui.actualizar(ok, Evento.RES_CERRAR_FACTURA_OK);
			}else {
				gui.actualizar(null, Evento.RES_CERRAR_FACTURA_FAIL);
			}
			
			break;
		}
		
		case Evento.BAJA_FACTURA: {

			int idFactura = (Integer) data;

			int res = SAAbstractFactory.getInstance().createSAFactura().delete(idFactura);

			
			if (res > 0) {
				gui.actualizar(res, Evento.RES_BAJA_FACTURA_OK);
			} else {
				gui.actualizar(null, Evento.RES_BAJA_FACTURA_FAILED);
			}
			

			break;
		}
		case Evento.MODIFICAR_FACTURA: {
			

			@SuppressWarnings("unchecked")
			List<TContiene> contienes =  (List<TContiene>) data;

			int res = SAAbstractFactory.getInstance().createSAFactura().update(contienes);

			if (res > 0) {
				gui.actualizar(res, Evento.RES_MODIFICAR_FACTURA_OK);
			} else {
				gui.actualizar(null, Evento.RES_MODIFICAR_FACTURA_FAILED);
			}
			

			break;

		}
		case Evento.MOSTRAR_FACTURA: {

			id = (Integer) data;
			TCarrito t = (TCarrito) (SAAbstractFactory.getInstance().createSAFactura().read(id));
			
			if (t != null) {
				gui.actualizar(t.gettFactura(), Evento.RES_MOSTRAR_FACTURA_OK);
			} else {
				gui.actualizar(t.gettFactura(), Evento.RES_MOSTRAR_FACTURA_FAILED);
			}
			break;
		

		}
		case Evento.MOSTRAR_TODOS_PRODUCTOS_FACTURA: 
			id  = (Integer) data ; 
			
			TFacturaConProductos p = (TFacturaConProductos) (SAAbstractFactory.getInstance().createSAFactura().readFacturaConProductos(id));			

			if (p != null) {
				gui.actualizar(p, Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_OK);
			} else {
				gui.actualizar(p, Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_FAILED);
			}
			
			break;
		case Evento.MOSTRAR_TODOS_FACTURAS: 
			
			List<TFactura> aux = SAAbstractFactory.getInstance().createSAFactura().readAll();

			if (aux != null) {
				gui.actualizar(aux, Evento.RES_MOSTRAR_TODOS_FACTURAS_OK);
			} else {

			}
			
			break;
			
		case Evento.DATOS_INCORRECTOS_CLIENTE : 
			
			ms = (String) data;
			
			gui.actualizar(ms, Evento.DATOS_INCORRECTOS_CLIENTE);

			
			break; 
		
		case Evento.DATOS_INCORRECTOS_TRABAJADOR : 
			
			ms = (String) data;
			
			gui.actualizar(ms, Evento.DATOS_INCORRECTOS_TRABAJADOR);

			
			break;
		case Evento.DATOS_INCORRECTOS_LABORATORIO : 
			ms = (String) data;
			gui.actualizar(ms, Evento.DATOS_INCORRECTOS_LABORATORIO);

			
			break; 
		case Evento.DATOS_INCORRECTOS_PRODUCTO : 
			ms = (String) data;
			gui.actualizar(ms, Evento.DATOS_INCORRECTOS_PRODUCTO);

			
			break; 
		case Evento.DATOS_INCORRECTOS_FACTURA : 
			ms = (String) data;
			gui.actualizar(ms, Evento.DATOS_INCORRECTOS_FACTURA);

			
			break; 
		
		
		}

	}

}
