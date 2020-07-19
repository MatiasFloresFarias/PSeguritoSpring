package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.ReporteAccidente;

public interface IReporteAccidente {
	
	public int crearReporteAccidente(ReporteAccidente reporteaccidente);
	public List<ReporteAccidente> leerReporteAccidente();
	public int actualizarReporteAccidente(ReporteAccidente reporteaccidente);
	public int eliminarReporteAccidente(int idreporteaccidente);
	public ReporteAccidente obtenerReporteAccidente(int idreporteaccidente);
}
