package Controller;

public class Evento {
	
	
	
	
	
	///////////////////////////////////CLIENTE/////////////////////////////// 
	public static final int ALTA_CLIENTE= 100; 
	public static final int BAJA_CLIENTE= 101; 
	public static final int MODIFICAR_CLIENTE = 102;
	public static final int MOSTRAR_CLIENTE = 103; 
	public static final int MOSTRAR_TODOS_CLIENTES = 104; 
	public static final int RES_ALTA_CLIENTE_OK =105; 
	public static final int RES_ALTA_CLIENTE_FAILED= -105;
	public static final int RES_BAJA_CLIENTE_OK=106;
	public static final int RES_BAJA_CLIENTE_FAILED = -106;
	public static final int RES_MODIFICAR_CLIENTE_OK = 107;
	public static final int RES_MODIFICAR_CLIENTE_FAILED= -107;
	public static final int RES_MOSTRAR_CLIENTE_OK=108;
	public static final int	RES_MOSTRAR_CLIENTE_FAILED =-108;
	public static final int RES_MOSTRAR_TODOS_CLIENTES_OK=109;
	public static final int	RES_MOSTRAR_TODOS_CLIENTES_FAILED =-109;
	public static final int RES_REACTIVAR_CLIENTE_OK = 110;
	public static final int DATOS_INCORRECTOS_CLIENTE = 120;
	//////////////////////////////////////////////////////////////////////////
	public static final int ALTA_TRABAJADOR= 200; 
	public static final int BAJA_TRABAJADOR= 201; 
	public static final int MODIFICAR_TRABAJADOR = 202;
	public static final int MOSTRAR_TRABAJADOR = 203; 
	public static final int MOSTRAR_TODOS_TRABAJADORES = 204; 
	public static final int RES_ALTA_TRABAJADOR_OK =205; 
	public static final int RES_ALTA_TRABAJADOR_FAILED= -205;
	public static final int RES_BAJA_TRABAJADOR_OK=206;
	public static final int RES_BAJA_TRABAJADOR_FAILED = -206;
	public static final int RES_MODIFICAR_TRABAJADOR_OK = 207;
	public static final int RES_MODIFICAR_TRABAJADOR_FAILED= -207;
	public static final int RES_MOSTRAR_TRABAJADOR_OK=208;
	public static final int	RES_MOSTRAR_TRABAJADOR_FAILED =-208;
	public static final int RES_MOSTRAR_TODOS_TRABAJADORES_OK=209;
	public static final int	RES_MOSTRAR_TODOS_TRABAJADORES_FAILED =-209;
	public static final int RES_REACTIVAR_TRABAJADOR_OK = 210;
	public static final int DATOS_INCORRECTOS_TRABAJADOR = 220;
	/////////////////////////////////////////////////////////////////////////
	public static final int ALTA_LABORATORIO= 300; 
	public static final int BAJA_LABORATORIO= 301; 
	public static final int MODIFICAR_LABORATORIO = 302;
	public static final int MOSTRAR_LABORATORIO = 303; 
	public static final int MOSTRAR_TODOS_LABORATORIOS = 304; 
	public static final int RES_ALTA_LABORATORIO_OK =305; 
	public static final int RES_ALTA_LABORATORIO_FAILED= -305;
	public static final int RES_BAJA_LABORATORIO_OK=306;
	public static final int RES_BAJA_LABORATORIO_FAILED = -306;
	public static final int RES_MODIFICAR_LABORATORIO_OK = 307;
	public static final int RES_MODIFICAR_LABORATORIO_FAILED= -307;
	public static final int RES_MOSTRAR_LABORATORIO_OK=308;
	public static final int	RES_MOSTRAR_LABORATORIO_FAILED =-308;
	public static final int RES_MOSTRAR_TODOS_LABORATORIOS_OK=309;
	public static final int	RES_MOSTRAR_TODOS_LABORATORIOS_FAILED =-309;
	public static final int RES_REACTIVAR_LABORATORIO_OK = 310;
	public static final int MOSTRAR_TODOS_PRODUCTOS_LABORATORIO = 311;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_OK = 312;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_FAIL = 313;
	public static final int DATOS_INCORRECTOS_LABORATORIO = 320;
	public static final int REACTIVAR_PRODUCTOS_LABORATORIO = 314;
	public static final int RES_REACTIVAR_PRODUCTOS_LABORATORIO_OK = 315;
	public static final int RES_REACTIVAR_PRODUCTOS_LABORATORIO_FAIL = 316;
	/////////////////////////////////////////////////////////////////////////
	public static final int ALTA_PRODUCTO= 400; 
	public static final int BAJA_PRODUCTO= 401; 
	public static final int MODIFICAR_PRODUCTO = 402;
	public static final int MOSTRAR_PRODUCTO = 403; 
	public static final int MOSTRAR_TODOS_PRODUCTOS = 404; 
	public static final int BAJA_PRODUCTOS_POR_LABORATORIO = 411;
	public static final int RES_BAJA_PRODUCTOS_POR_LABORATORIO_OK = 412;
	public static final int RES_BAJA_PRODUCTOS_POR_LABORATORIO_FAIL = 413;


	public static final int RES_ALTA_PRODUCTO_OK =405; 
	public static final int RES_ALTA_PRODUCTO_FAILED= -405;
	public static final int RES_BAJA_PRODUCTO_OK=406;
	public static final int RES_BAJA_PRODUCTO_FAILED = -406;
	public static final int RES_MODIFICAR_PRODUCTO_OK = 407;
	public static final int RES_MODIFICAR_PRODUCTO_FAILED= -407;
	public static final int RES_MOSTRAR_PRODUCTO_OK=408;
	public static final int	RES_MOSTRAR_PRODUCTO_FAILED =-408;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_OK=409;
	public static final int	RES_MOSTRAR_TODOS_PRODUCTOS_FAILED =-409;
	public static final int RES_REACTIVAR_PRODUCTO_OK = 410;
	public static final int DATOS_INCORRECTOS_PRODUCTO = 420;
	/////////////////////////////////////////////////////////////////////////
	public static final int CREAR_FACTURA= 500; 
	public static final int BAJA_FACTURA= 501; 
	public static final int MODIFICAR_FACTURA = 502;
	public static final int MOSTRAR_FACTURA = 503; 
	public static final int MOSTRAR_TODOS_FACTURAS = 504; 
	public static final int RES_ALTA_FACTURA_OK =505; 
	public static final int RES_ALTA_FACTURA_FAILED= -505;
	public static final int RES_BAJA_FACTURA_OK=506;
	public static final int RES_BAJA_FACTURA_FAILED = -506;
	public static final int RES_MODIFICAR_FACTURA_OK = 507;
	public static final int RES_MODIFICAR_FACTURA_FAILED= -507;
	public static final int RES_MOSTRAR_FACTURA_OK=508;
	public static final int	RES_MOSTRAR_FACTURA_FAILED =-508;
	public static final int RES_MOSTRAR_TODOS_FACTURAS_OK=509;
	public static final int	RES_MOSTRAR_TODOS_FACTURAS_FAILED =-509;
	public static final int RES_REACTIVAR_FACTURA_OK = 510;
	
	public static final int MOSTRAR_TODOS_PRODUCTOS_FACTURA= 514;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_OK = 515;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_FAILED = -510;
	public static final int DATOS_INCORRECTOS_FACTURA = 520;

	public static final int ANADIR_PRODUCTOS_FACTURA = 511;
	public static final int ELIMINAR_PRODUCTOS_FACTURA = 512;
	public static final int CERRAR_FACTURA = 513;
	public static final int RES_CERRAR_FACTURA_OK = 521;
	public static final int RES_CERRAR_FACTURA_FAIL = 522;
	
	
	
	
	
	
}
