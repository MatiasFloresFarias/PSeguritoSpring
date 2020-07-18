package cl.awake.psegurito.bean;

public class DetalleFactura {
	
	private int id_detallefactura;
	private String nombre;
	private int precio;
	private int cantidad;
	private int id_factura; //FK

	
	//Constructures//
	
	public DetalleFactura() {
		super();
	}

	public DetalleFactura(String nombre, int precio, int cantidad, int id_factura) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.id_factura = id_factura;
	}
	
	public DetalleFactura(int id_detallefactura, String nombre, int precio, int cantidad, int id_factura) {
		super();
		this.id_detallefactura = id_detallefactura;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.id_factura = id_factura;
	}


	public DetalleFactura(int id_detallefactura) {
		super();
		this.id_detallefactura = id_detallefactura;
	}
	
	
	//Getters & Setters//
	
	public int getId_detallefactura() {
		return id_detallefactura;
	}

	public void setId_detallefactura(int id_detallefactura) {
		this.id_detallefactura = id_detallefactura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}
	
	//To String//
	
	@Override
	public String toString() {
		return "DetalleFactura [id_detallefactura=" + id_detallefactura + ", nombre=" + nombre + ", precio=" + precio
				+ ", cantidad=" + cantidad + ", id_factura=" + id_factura + "]";
	}
	
	public double calcularTotal() { 
    	return precio * cantidad;
    	}
}
	
