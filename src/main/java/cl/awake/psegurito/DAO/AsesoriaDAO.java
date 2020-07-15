package cl.awake.psegurito.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.awake.psegurito.IDAO.IAsesoria;
import cl.awake.psegurito.bean.Asesoria;

public class AsesoriaDAO implements IAsesoria {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public boolean crearAsesoria(Asesoria asesoria) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Asesoria> leerAsesoria() {		 
		    return template.query("SELECT id_asesoria, fechayhora, motivo, detalle, profesional_id_profesional, cliente_id_cliente, nombre || ' ' || apellido as profesional, nombreempresa as cliente FROM asesorias INNER JOIN profesional ON profesional_id_profesional=id_profesional INNER JOIN cliente ON cliente_id_cliente=id_cliente",new RowMapper<Asesoria>(){    
		        public Asesoria mapRow(ResultSet rs, int row) throws SQLException {   
		  
					Asesoria c = new Asesoria();
					c.setId_asesoria(rs.getInt("id_asesoria"));
					c.setFechayhora(rs.getString("fechayhora"));
					c.setMotivo(rs.getString("motivo"));
					c.setDetalle(rs.getString("detalle"));
					c.setId_profesional(rs.getInt("profesional_id_profesional"));
					c.setId_cliente(rs.getInt("cliente_id_cliente"));
					c.setProfesional(rs.getString("profesional"));
					c.setCliente(rs.getString("cliente"));			
		            return c;
		        }    
		    });    
		}


	@Override
	public boolean actualizarAsesoria(Asesoria asesoria) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarAsesoria(Asesoria asesoria) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Asesoria obtenerAsesoria(int idasesoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
