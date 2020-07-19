package cl.awake.psegurito.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.awake.psegurito.IDAO.IFactura;
import cl.awake.psegurito.bean.Factura;

public class FacturaDAO implements IFactura {
	
	JdbcTemplate template;
	
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;
	
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public int crearFactura(Factura fac) {
		String sql = "INSERT INTO factura(fechacobro, fechavencimiento, extras, impuestos, subtotal, total, cliente_id_cliente) values (TO_DATE('" + fac.getFechadecobro() + "','dd/mm/yyyy'), TO_DATE('" + fac.getFechaVencimiento() + "','dd/mm/yyyy'),'" + fac.getExtras() + "','" + fac.getImpuestos() + "','" + fac.getSubtotal() + "','" + fac.getTotal() + "','" + fac.getCliente().getId_cliente() + "')";
		return template.update(sql);
	}

	@Override
	public List<Factura> leerFactura() {
		return template.query("select id_factura, fechacobro, fechaVencimiento, extras, impuestos, subtotal, total, cliente_id_cliente FROM factura", new RowMapper<Factura>() {
			public Factura mapRow(ResultSet rs, int row)throws SQLException {  
				
				Factura c = new Factura(); 		
				c.setId_factura(rs.getInt("id_factura"));
				c.setFechadecobro(rs.getString("fechacobro"));
				c.setFechaVencimiento(rs.getString("fechaVencimiento"));
				c.setExtras(rs.getInt("extras"));
				c.setImpuestos(rs.getInt("impuestos"));
				c.setSubtotal(rs.getInt("subtotal"));
				c.setTotal(rs.getInt("total"));
				c.setCliente(clientedao.obtenerCliente(rs.getInt("cliente_id_cliente")));
				
				return c; 	
				
			}
		});
	}
		

	@Override
	public int actualizarFactura(Factura fac) {
		String sql = "update factura set fechacobro = TO_DATE('" + fac.getFechadecobro() + "','dd/mm/yyyy'), fechavencimiento = TO_DATE('" + fac.getFechaVencimiento() + "', 'dd/mm/yyyy'), extras = '" + fac.getExtras() +"', impuestos= '" + fac.getImpuestos() +"', subtotal= '" + fac.getSubtotal() +"', total= '" + fac.getTotal() + "', cliente_id_cliente = '" + fac.getCliente().getId_cliente() + "' where id_factura = '" + fac.getId_factura() + "'";
		return template.update(sql);
	}

	@Override
	public int eliminarFactura(int id_factura) {
		String sql = "delete from factura where id_factura = " + id_factura;
		return template.update(sql);
	}

	@Override
	public Factura obtenerFactura(int id_factura) {
	    String sql="SELECT id_factura, fechacobro, fechavencimiento, extras, impuestos, subtotal, total, cliente_id_cliente FROM factura WHERE id_factura=?";
	    return template.queryForObject(sql, new Object[]{id_factura},(rs, rowNum) ->
        new Factura(
				rs.getInt("id_factura"),
				rs.getString("fechacobro"),
				rs.getString("fechavencimiento"),
				rs.getInt("extras"),
				rs.getInt("impuestos"),
				rs.getInt("subtotal"),
				rs.getInt("total"),
				clientedao.obtenerCliente(rs.getInt("cliente_id_cliente"))	
        ));
	}

}
