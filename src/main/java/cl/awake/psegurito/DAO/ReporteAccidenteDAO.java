package cl.awake.psegurito.DAO;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cl.awake.psegurito.IDAO.IReporteAccidente;
import cl.awake.psegurito.bean.ReporteAccidente;

@Repository("daoreporteaccidente")
public class ReporteAccidenteDAO implements IReporteAccidente {

	JdbcTemplate template;
	
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public int crearReporteAccidente(ReporteAccidente reporte) {
		String sql = "INSERT INTO reporteaccidente (fecha,direccion,labor,descripcion,cliente_id_cliente) VALUES (TO_DATE('"+reporte.getFecha()+"', 'dd/mm/yyyy'),'"+ reporte.getDireccion()+"','"+reporte.getLabor()+"','"+reporte.getDescripcion()+"', '"+reporte.getCliente().getId_cliente()+"')";  
		return template.update(sql);
	}

	@Override
	public List<ReporteAccidente> leerReporteAccidente() {
	    return template.query("SELECT id_reporte, fecha, direccion, labor, descripcion, cliente_id_cliente FROM reporteaccidente",new RowMapper<ReporteAccidente>(){    
	        public ReporteAccidente mapRow(ResultSet rs, int row) throws SQLException {   
	  
				ReporteAccidente c = new ReporteAccidente();
				c.setIdReporteAccidente(rs.getInt("id_reporte"));
				c.setFecha(rs.getString("fecha"));
				c.setDireccion(rs.getString("direccion"));
				c.setLabor(rs.getString("labor"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setCliente(clientedao.obtenerCliente(rs.getInt("cliente_id_cliente")));			
	            return c;
	        }    
	    });    
	}

	@Override
	public int actualizarReporteAccidente(ReporteAccidente reporte) {
		String sql = "update reporteaccidente set fecha = TO_DATE('" + reporte.getFecha() + "','dd/mm/yyyy'), direccion = '" + reporte.getDireccion() + "', labor = '" + reporte.getLabor() + "', descripcion = '" + reporte.getDescripcion() + "', cliente_id_cliente = '" + reporte.getCliente().getId_cliente() + "' WHERE id_reporte = '" + reporte.getIdReporteAccidente() + "'";
		return template.update(sql);
	}

	@Override
	public int eliminarReporteAccidente(int idreporteaccidente) {
		String sql = "delete from reporteaccidente where id_reporte = " + idreporteaccidente;
		return template.update(sql);
	}

	@Override
	public ReporteAccidente obtenerReporteAccidente(int idreporteaccidente) {
	    String sql="SELECT id_reporte, fecha, direccion, labor, descripcion , cliente_id_cliente FROM reporteaccidente WHERE id_reporte=?";
	    return template.queryForObject(sql, new Object[]{idreporteaccidente},(rs, rowNum) ->
        new ReporteAccidente(
				rs.getInt("id_reporte"),
				rs.getString("fecha"),
				rs.getString("direccion"),
				rs.getString("labor"),
				rs.getString("descripcion"),
				clientedao.obtenerCliente(rs.getInt("cliente_id_cliente"))	
        ));
	}

}
