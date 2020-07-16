package cl.awake.psegurito.IDAO;

import java.util.List;

import cl.awake.psegurito.bean.Profesional;

public interface IProfesional {
	
	public int crearProfesional(Profesional profesional);
	public List<Profesional> leerProfesional();
	public int actualizarProfesional(Profesional profesional);
	public int eliminarProfesional(int idprofesional);
	public Profesional obtenerProfesional(int idprofesional);

}

