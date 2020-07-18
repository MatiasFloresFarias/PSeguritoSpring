package cl.awake.psegurito.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.awake.psegurito.IDAO.iFactura;
import cl.awake.psegurito.bean.Factura;

public class FacturaDAO implements iFactura {
	
	JdbcTemplate template;
	
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;
	
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public boolean crearFactura(Factura fac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Factura> leerFactura() {
		return template.query("select fechadecobro, fechaVencimiento, extras, impuestos, subtotal, total, cliente_id_cliente", new RowMapper<Factura>() {
			public Factura mapRow(ResultSet rs, int row)throws SQLException {  
				
				Factura c = new Factura(); 				
				c.setFechadecobro(rs.getString("fechacobro"));
				c.setFechaVencimiento(rs.getString("fechaVencimiento"));
				c.setExtras(rs.getInt("extras"));
				c.setImpuestos(rs.getInt("impuesto"));
				c.setSubtotal(rs.getInt("subtotal"));
				c.setTotal(rs.getInt("total"));
				c.setCliente(clientedao.obtenerCliente(rs.getInt("cliente_id_cliente")));
				
				return c; 	
				
			}
		});
	}
		

	@Override
	public boolean actualizarFactura(Factura fac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarFactura(Factura fac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Factura obtenerFactura(int id_factura) {
		// TODO Auto-generated method stub
		return null;
	}

}
