package cl.awake.psegurito.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.IDAO.IProfesional;
import cl.awake.psegurito.bean.Profesional;

@Repository("daoprofesional")
public class ProfesionalDAO implements IProfesional {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int crearProfesional(Profesional profesional) {
		String sql = "INSERT INTO profesional(nombre, apellido, correo, telefono, cargo) values ('" + profesional.getNombre() + "','" + profesional.getApellido() + "','" + profesional.getCorreo() + "','" + profesional.getTelefono() + "')";
		return template.update(sql);
	}

	@Override
	public List<Profesional> leerProfesional() {		 
		    return template.query("select * from profesional",new RowMapper<Profesional>(){    
		        public Profesional mapRow(ResultSet rs, int row) throws SQLException {   
		  
					Profesional p = new Profesional();
					p.setId_profesional(rs.getInt("id_profesional"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setCorreo(rs.getString("correo"));
					p.setTelefono(rs.getString("telefono"));
					p.setCargo(rs.getString("cargo"));
					p.setNombreyapellido();
		            return p;
		        }    
		    });    
		}


	@Override
	public int actualizarProfesional(Profesional profesional) {
		
		String sql = "update profesional set nombre = '" + profesional.getNombre() + "', apellido = '" + profesional.getApellido() + "', correo = '" + profesional.getCorreo() + "', telefono = '" + profesional.getTelefono() + "', cargo = '" + profesional.getCargo() + "' where id_asesoria = '" + profesional.getId_profesional() + "'";
		return template.update(sql);
	}

	@Override
	public Profesional obtenerProfesional(int idprofesional) {
	    String sql="SELECT id_profesional, nombre, apellido, correo, telefono, cargo FROM profesional WHERE id_profesional=?";
	    return template.queryForObject(sql, new Object[]{idprofesional},new BeanPropertyRowMapper<Profesional>(Profesional.class));
	}

	@Override
	public int eliminarProfesional(int idprofesional) {
		String sql = "delete from profesional where id_profesional = " + idprofesional;
		return template.update(sql);
	}

}
