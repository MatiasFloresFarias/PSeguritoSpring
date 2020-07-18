package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.ActividadesMejora;


public interface IActividadesMejora {
	
	public int crearActividadesMejora(ActividadesMejora actividadesMejora);
	public List<ActividadesMejora> leerActividadesMejora();
	public int actualizarActividadesMejora(ActividadesMejora actividadesMejora);
	public int eliminarActividadesMejora(int idActividadMejora);
	public ActividadesMejora obtenerActividadesMejora(int idActividadMejora);
	
}
