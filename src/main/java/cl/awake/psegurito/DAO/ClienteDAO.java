package cl.awake.psegurito.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import cl.awake.psegurito.IDAO.ICliente;
import cl.awake.psegurito.bean.Cliente;


@Service("daocliente")
public class ClienteDAO implements ICliente {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int crearCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente(nombreempresa, rutempresa, fecharegistro) values ('" + cliente.getNombreEmpresa()+ "','" + cliente.getRut() +"', TO_DATE('"+ cliente.getFechaRegistro() +"', 'dd/mm/yyyy'))"; 
		return template.update(sql);
	}

	@Override
	public List<Cliente> leerCliente() {		 
		    return template.query("select * from cliente",new RowMapper<Cliente>(){    
		        public Cliente mapRow(ResultSet rs, int row) throws SQLException {   
		  
					Cliente p = new Cliente();
					p.setId_cliente(rs.getInt("id_cliente"));
					p.setNombreEmpresa(rs.getString("nombreempresa"));
					p.setRut(rs.getString("rutempresa"));
					p.setFechaRegistro(rs.getString("fecharegistro"));
		            return p;
		        }    
		    });    
		}


	@Override
	public int actualizarCliente(Cliente cliente) {
		
		String sql = "update cliente set nombreempresa = '" + cliente.getNombreEmpresa() + "', rutempresa = '" + cliente.getRut() + "', fecharegistro = TO_DATE('" + cliente.getFechaRegistro() +"','dd/mm/yyyy'), where id_cliente = '" + cliente.getId_cliente() + "'";
		return template.update(sql);
	}

	@Override
	public Cliente obtenerCliente(int idcliente) {
	    String sql="SELECT id_cliente, nombreempresa, rutempresa, fecharegistro FROM cliente WHERE id_cliente=?";
	    return template.queryForObject(sql, new Object[]{idcliente},new BeanPropertyRowMapper<Cliente>(Cliente.class));
	}

	@Override
	public int eliminarCliente(int idcliente) {
		String sql = "delete from cliente where id_cliente = " + idcliente;
		return template.update(sql);
	}

}

