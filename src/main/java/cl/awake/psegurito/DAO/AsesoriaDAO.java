package cl.awake.psegurito.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	public int crearAsesoria(Asesoria asesoria) {
		String sql = "insert into asesorias (fechayhora, motivo, detalle, profesional_id_profesional, cliente_id_cliente) values (TO_DATE('" + asesoria.getFechayhora() + "','dd/mm/yyyy hh24:mi'),'" + asesoria.getMotivo() + "','" + asesoria.getDetalle() + "','" + asesoria.getId_profesional() + "','" + asesoria.getId_cliente() + "')";
		return template.update(sql);
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
	public int actualizarAsesoria(Asesoria asesoria) {
		
		String sql = "update asesorias set fechayhora = TO_DATE('" + asesoria.getFechayhora() + "','dd/mm/yyyy hh24:mi'), motivo = '" + asesoria.getMotivo() + "', detalle = '" + asesoria.getDetalle() + "', profesional_id_profesional = '" + asesoria.getId_profesional() + "', cliente_id_cliente = '" + asesoria.getId_cliente() + "' where id_asesoria = '" + asesoria.getId_asesoria() + "'";
		return template.update(sql);
	}

	@Override
	public Asesoria obtenerAsesoria(int idasesoria) {
	    String sql="select * from asesorias where id_asesoria=?";
	    return template.queryForObject(sql, new Object[]{idasesoria},new BeanPropertyRowMapper<Asesoria>(Asesoria.class));
	}

	@Override
	public int eliminarAsesoria(int idasesoria) {
		String sql = "delete from asesorias where id_asesoria = " + idasesoria;
		return template.update(sql);
	}

}
