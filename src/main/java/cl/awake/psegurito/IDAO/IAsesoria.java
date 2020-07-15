package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.Asesoria;



public interface IAsesoria {
	
	public boolean crearAsesoria(Asesoria asesoria);
	public List<Asesoria> leerAsesoria();
	public boolean actualizarAsesoria(Asesoria asesoria);
	public boolean eliminarAsesoria(int idasesoria);
	public Asesoria obtenerAsesoria(int idasesoria);

}
