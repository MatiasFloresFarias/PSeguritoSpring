package cl.awake.psegurito.bean;

public class Cliente {
	
    private int id_cliente;
    private String nombreEmpresa;
    private String rut;
    private String fechaRegistro;
    
    
    
    public Cliente(int id_cliente, String nombreEmpresa, String rut, String fechaRegistro) {
    	this.id_cliente = id_cliente;
        this.nombreEmpresa = nombreEmpresa;
        this.rut = rut;
        this.fechaRegistro = fechaRegistro;
    }



    public Cliente(String nombreEmpresa, String rut, String fechaRegistro) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.rut = rut;
		this.fechaRegistro = fechaRegistro;
	}



	public Cliente() {
        super();
    }


    public Cliente(int id_cliente) {
		super();
		this.id_cliente = id_cliente;
	}

    
	public int getId_cliente() {
		return id_cliente;
	}



	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}



	public String getNombreEmpresa() {
        return nombreEmpresa;
    }



    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }



    public String getRut() {
        return rut;
    }



    public void setRut(String rut) {
        this.rut = rut;
    }



    public String getFechaRegistro() {
        return fechaRegistro;
    }



    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }



    @Override
    public String toString() {
        return "Cliente [id=" + id_cliente + ", nombreEmpresa=" + nombreEmpresa + ", rut=" + rut + ", fechaRegistro="
                + fechaRegistro + "]";
    }
    
    
    
   
}

