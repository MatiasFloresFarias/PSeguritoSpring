package cl.awake.psegurito.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cl.awake.psegurito.IDAO.iDetalleFactura;
import cl.awake.psegurito.bean.DetalleFactura;

@Repository("daodetallefactura")
public class DetalleFacturaDAO implements iDetalleFactura {
	JdbcTemplate template;
	
	@Autowired
	@Qualifier("daofactura")
	FacturaDAO facturadao;
	
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public int crearDetalleFactura(DetalleFactura detallefac) {
		String sql = "INSERT INTO detallefactura(nombre, precio, cantidad, factura_id_factura) values ('" + detallefac.getNombre() + "','" + detallefac.getPrecio() +"','" + detallefac.getCantidad() + "','"  + detallefac.getFactura().getId_factura() + "')";
		return template.update(sql);
	}

	@Override
	public List<DetalleFactura> leerDetalleFactura(int id_factura) {
		return template.query("select id_detallefactura, nombre, precio, cantidad, factura_id_factura FROM detallefactura WHERE factura_id_factura=" + id_factura, new RowMapper<DetalleFactura>() {
			public DetalleFactura mapRow(ResultSet rs, int row)throws SQLException {  
				
				DetalleFactura c = new DetalleFactura(); 		
				c.setId_detallefactura(rs.getInt("id_detallefactura"));
				c.setNombre(rs.getString("nombre"));
				c.setPrecio(rs.getInt("precio"));
				c.setCantidad(rs.getInt("cantidad"));
				c.setFactura(facturadao.obtenerFactura(rs.getInt("factura_id_factura")));
				return c; 	
				
			}
		});
	}
		

	@Override
	public int actualizarDetalleFactura(DetalleFactura detallefac) {
		String sql = "update detallefactura set nombre = '" + detallefac.getNombre() + "', precio = '" + detallefac.getPrecio() + "', cantidad = '" + detallefac.getCantidad() + "' WHERE id_detallefactura = '" + detallefac.getId_detallefactura() + "'";
		return template.update(sql);
	}

	@Override
	public int eliminarDetalleFactura(int id_detallefactura) {
		String sql = "delete from detallefactura where id_detallefactura = " + id_detallefactura;
		return template.update(sql);
	}

	@Override
	public DetalleFactura obtenerDetalleFactura(int id_detallefactura) {
	    String sql="SELECT id_detallefactura, nombre, precio, cantidad, factura_id_factura FROM detallefactura WHERE id_detallefactura=?";
	    return template.queryForObject(sql, new Object[]{id_detallefactura},(rs, rowNum) ->
        new DetalleFactura(
				rs.getInt("id_detallefactura"),
				rs.getString("nombre"),
				rs.getInt("precio"),
				rs.getInt("cantidad"),
				facturadao.obtenerFactura(rs.getInt("factura_id_factura"))	
        ));
	}

}
