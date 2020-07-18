package cl.awake.psegurito.bean;

public class ActividadesMejora {
	
	private int idActividadMejora;
	private String nombre;
	private String fechaInicio;
	private String fechaTermino;
	private String Estado;
	private String Detalle;
	private Profesional profesional;
	private Cliente cliente;
	
	public ActividadesMejora() {
		
	}

	public ActividadesMejora(int idActividadMejora, String nombre, String fechaInicio, String fechaTermino,
			String estado, String detalle, Profesional profesional, Cliente cliente) {
		super();
		this.idActividadMejora = idActividadMejora;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		Estado = estado;
		Detalle = detalle;
		this.profesional = profesional;
		this.cliente = cliente;
	}

	public ActividadesMejora(String nombre, String fechaInicio, String fechaTermino, String estado, String detalle,
			Profesional profesional, Cliente cliente) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		Estado = estado;
		Detalle = detalle;
		this.profesional = profesional;
		this.cliente = cliente;
	}

	public int getIdActividadMejora() {
		return idActividadMejora;
	}

	public void setIdActividadMejora(int idActividadMejora) {
		this.idActividadMejora = idActividadMejora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

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

	@Override
	public String toString() {
		return "ActividadesMejora [idActividadMejora=" + idActividadMejora + ", nombre=" + nombre + ", fechaInicio="
				+ fechaInicio + ", fechaTermino=" + fechaTermino + ", Estado=" + Estado + ", Detalle=" + Detalle
				+ ", profesional=" + profesional + ", cliente=" + cliente + "]";
	}

	
	
	
}
