package cl.awake.psegurito.bean;

public class Capacitacion {
     
    //atributos
    private int id_capacitacion;
    private String fechayhora;
    private String tema;
    private String contenido;
    private Profesional profesional;
    private Cliente cliente;
    
    
    
    public Capacitacion() {
    }
    


    public Capacitacion(int id_capacitacion, String fechayhora, String tema, String contenido, Profesional profesional,
            Cliente cliente) {
        this.id_capacitacion = id_capacitacion;
        this.fechayhora = fechayhora;
        this.tema = tema;
        this.contenido = contenido;
        this.profesional = profesional;
        this.cliente = cliente;
    }


    public int getId_capacitacion() {
        return id_capacitacion;
    }


    public void setId_capacitacion(int id_capacitacion) {
        this.id_capacitacion = id_capacitacion;
    }


    public String getFechayhora() {
        return fechayhora;
    }


    public void setFechayhora(String fechayhora) {
        this.fechayhora = fechayhora;
    }


    public String getTema() {
        return tema;
    }


    public void setTema(String tema) {
        this.tema = tema;
    }


    public String getContenido() {
        return contenido;
    }


    public void setContenido(String contenido) {
        this.contenido = contenido;
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
        return "Capacitacion [id_capacitacion=" + id_capacitacion + ", fechayhora=" + fechayhora + ", tema=" + tema
                + ", contenido=" + contenido + ", profesional=" + profesional + ", cliente=" + cliente + "]";
    }
    
    

}
