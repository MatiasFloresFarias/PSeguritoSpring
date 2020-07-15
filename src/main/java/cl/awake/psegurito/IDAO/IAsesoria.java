package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.Asesoria;



public interface IAsesoria {
	
	public int crearAsesoria(Asesoria asesoria);
	public List<Asesoria> leerAsesoria();
	public int actualizarAsesoria(Asesoria asesoria);
	public int eliminarAsesoria(int idasesoria);
	public Asesoria obtenerAsesoria(int idasesoria);

}
