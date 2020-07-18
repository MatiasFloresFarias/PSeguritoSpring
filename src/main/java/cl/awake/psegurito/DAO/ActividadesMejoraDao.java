package cl.awake.psegurito.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cl.awake.psegurito.IDAO.IActividadesMejora;
import cl.awake.psegurito.bean.ActividadesMejora;

@Repository("daoactividadesmejora")
public class ActividadesMejoraDao implements IActividadesMejora{
	
	
	JdbcTemplate template;
	@Autowired
	@Qualifier("daoprofesional")
	ProfesionalDAO profesionaldao;
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public int crearActividadesMejora(ActividadesMejora actividadesMejora) {
		String sql = "insert into actividadesmejora (nombre, fechainicio, fechatermino, estado, detalle, profesional_id_profesional, cliente_id_cliente) values '"+ actividadesMejora.getNombre()+"', (TO_DATE('"+ actividadesMejora.getFechaInicio()+"','dd/mm/yyyy hh24:mi'), (TO_DATE('"+actividadesMejora.getFechaTermino()+"','dd/mm/yyyy hh24:mi'), '"+actividadesMejora.getEstado()+"', '"+actividadesMejora.getDetalle()+"', '"+actividadesMejora.getProfesional().getId_profesional()+"', '"+actividadesMejora.getCliente().getId_cliente()+"')";
		return template.update(sql);
	}

	@Override
	public List<ActividadesMejora> leerActividadesMejora() {
		return template.query("SELECT idactividadmejora, nombre, fechainicio, fechatermino, estado, detalle, profesiona_id_profesional, cliente_id_cliente FROM actividadesmejora", new RowMapper<ActividadesMejora>() {
			public ActividadesMejora mapRow(ResultSet rs, int row) throws SQLException{
				ActividadesMejora c = new ActividadesMejora();
				c.setIdActividadMejora(rs.getInt("idactividadmejora"));
				c.setNombre(rs.getString("nombre"));
				c.setFechaInicio(rs.getString("fechainicio"));
				c.setFechaTermino(rs.getString("fechatermino"));
				c.setEstado(rs.getString("estado"));
				c.setDetalle(rs.getString("detalle"));
				c.setProfesional(profesionaldao.obtenerProfesional(rs.getInt("profesional_id_profesional")));
				c.setCliente(clientedao.obtenerCliente(rs.getInt("cliente_id_cliente")));
				return c;
			}
		});
	}

	@Override
	public int actualizarActividadesMejora(ActividadesMejora actividadesMejora) {
		String sql = "update actividadesmejora set nombre = '"+ actividadesMejora.getNombre()+"', fehcainicio = (TO_DATE('"+ actividadesMejora.getFechaInicio()+"','dd/mm/yyyy hh24:mi'), fechatermino =  (TO_DATE('"+actividadesMejora.getFechaTermino()+"','dd/mm/yyyy hh24:mi'), estado = '"+actividadesMejora.getEstado()+"', detalle = '"+actividadesMejora.getDetalle()+"', profesional_id_profesional = '"+actividadesMejora.getProfesional().getId_profesional()+"', cliente_id_cliente = '"+actividadesMejora.getCliente().getId_cliente()+"' where idactividadmejora = '"+actividadesMejora.getIdActividadMejora()+"'";
		return template.update(sql);
	}

	@Override
	public int eliminarActividadesMejora(int idActividadMejora) {
		String sql = "delete from actividadesmejora where idactividadmejora = "+ idActividadMejora;
		return template.update(sql);
	}

	@Override
	public ActividadesMejora obtenerActividadesMejora(int idActividadMejora) {
		String sql = "SELECT idactividadmejora, nombre, fechainicio, fechatermino, estado, detalle, profesional_id_profesional , cliente_id_cliente FROM actividadesmejora WHERE idactividadmejora=?";
		return template.queryForObject(sql, new Object[] {idActividadMejora},(rs, rowNum) ->
				new ActividadesMejora(
						rs.getInt("idactividadmejora"),
						rs.getString("nombre"),
						rs.getString("fechainicio"),
						rs.getString("fechatermino"),
						rs.getString("estado"),
						rs.getString("detalle"),
						profesionaldao.obtenerProfesional(rs.getInt("profesional_id_profesional")),
						clientedao.obtenerCliente(rs.getInt("cliente_id_cliente"))
						));
	}

}
