package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.Capacitacion;

public interface ICapacitacion {


    public int crearCapacitacion(Capacitacion capacitacion);
    public List<Capacitacion> leerCapacitacion();
    public int actualizarCapacitacion(Capacitacion capacitacion);
    public int eliminarCapacitacion(int idcapacitacion);
    public Capacitacion obtenerCapacitacion(int idcapacitacion);
}
