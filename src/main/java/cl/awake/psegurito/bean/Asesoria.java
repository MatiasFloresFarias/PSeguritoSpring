package cl.awake.psegurito.bean;

public class Asesoria {
	//atribrutos 
	 
	private int id_asesoria;
	private String fechayhora;
	private String motivo;
	private String detalle;
//	private int id_profesional;
//	private int id_cliente;
//	private String profesional;
//	private String cliente;
	private Profesional profesional;
	private Cliente cliente;
	
	public Asesoria() {
		
	}
	
	public Asesoria(int id_asesoria, String fechayhora, String motivo, String detalle,
			// int id_profesional,int id_cliente, String profesional, String cliente
			Profesional profesional, Cliente cliente) {
		this.id_asesoria = id_asesoria;
		this.fechayhora = fechayhora;
		this.motivo = motivo;
		this.detalle = detalle;
//		this.id_profesional = id_profesional;
//		this.id_cliente = id_cliente;
//		this.profesional = profesional;
//		this.cliente = cliente;
		this.profesional = profesional;
		this.cliente = cliente;
	}

	public int getId_asesoria() {
		return id_asesoria;
	}

	public void setId_asesoria(int id_asesoria) {
		this.id_asesoria = id_asesoria;
	}

	public String getFechayhora() {
		return fechayhora;
	}

	public void setFechayhora(String fechayhora) {
		this.fechayhora = fechayhora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

//	public int getId_profesional() {
//		return id_profesional;
//	}
//
//	public void setId_profesional(int id_profesional) {
//		this.id_profesional = id_profesional;
//	}
//
//	public int getId_cliente() {
//		return id_cliente;
//	}
//
//	public void setId_cliente(int id_cliente) {
//		this.id_cliente = id_cliente;
//	}
//
//	public String getProfesional() {
//		return profesional;
//	}
//
//	public void setProfesional(String profesional) {
//		this.profesional = profesional;
//	}
//
//	public String getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(String cliente) {
//		this.cliente = cliente;
//	}
	
	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

//	@Override
//	public String toString() {
//		return "Asesoria [id_asesoria=" + id_asesoria + ", fechayhora=" + fechayhora + ", motivo=" + motivo
//				+ ", detalle=" + detalle + ", id_profesional=" + id_profesional + ", id_cliente=" + id_cliente
//				+ ", profesional=" + profesional + ", cliente=" + cliente + "]";
//	}
//	
	

}
