package cl.awake.psegurito.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cl.awake.psegurito.IDAO.ICapacitacion;
import cl.awake.psegurito.bean.Capacitacion;

@Repository ("daocapacitacion")
public class CapacitacionDAO implements ICapacitacion {

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
    public int crearCapacitacion(Capacitacion capacitacion) {
        String sql = "insert into capacitaciones (fechayhora, tema, contenido, profesional_id_profesional, cliente_id_cliente) values (TO_DATE('" + capacitacion.getFechayhora() + "','dd/mm/yyyy hh24:mi'),'" + capacitacion.getTema() + "','" + capacitacion.getContenido() + "','" + capacitacion.getProfesional().getId_profesional() + "','" + capacitacion.getCliente().getId_cliente() + "')";
        return template.update(sql);
    }


    @Override
    public List<Capacitacion> leerCapacitacion() {         
            return template.query("SELECT id_capacitacion, fechayhora, tema, contenido, profesional_id_profesional, cliente_id_cliente FROM capacitaciones",new RowMapper<Capacitacion>(){    
                public Capacitacion mapRow(ResultSet rs, int row) throws SQLException {   
          
                                Capacitacion c = new Capacitacion();
                                c.setId_capacitacion(rs.getInt("id_capacitacion"));
                                c.setFechayhora(rs.getString("fechayhora"));
                                c.setTema(rs.getString("tema"));
                                c.setContenido(rs.getString("contenido"));
                                c.setProfesional(profesionaldao.obtenerProfesional(rs.getInt("profesional_id_profesional")));
                                c.setCliente(clientedao.obtenerCliente(rs.getInt("cliente_id_cliente")));                       
                    return c;
                }    
            });    
        }


    @Override
    public int actualizarCapacitacion(Capacitacion capacitacion) {
            
            String sql = "update capacitaciones set fechayhora = TO_DATE('" + capacitacion.getFechayhora() + "','dd/mm/yyyy hh24:mi'), tema = '" + capacitacion.getTema() + "', contenido = '" + capacitacion.getContenido() + "', profesional_id_profesional = '" + capacitacion.getProfesional().getId_profesional() + "', cliente_id_cliente = '" + capacitacion.getCliente().getId_cliente() + "' where id_capacitacion = '" + capacitacion.getId_capacitacion() + "'";
            return template.update(sql);
    }
    
    @Override
    public Capacitacion obtenerCapacitacion(int idcapacitacion) {
        String sql="SELECT id_capacitacion, fechayhora, tema, contenido, profesional_id_profesional , cliente_id_cliente FROM capacitaciones WHERE id_capacitacion=?";
        return template.queryForObject(sql, new Object[]{idcapacitacion},(rs, rowNum) ->
    new Capacitacion(
                            rs.getInt("id_capacitacion"),
                            rs.getString("fechayhora"),
                            rs.getString("tema"),
                            rs.getString("contenido"),
                            profesionaldao.obtenerProfesional(rs.getInt("profesional_id_profesional")),
                            clientedao.obtenerCliente(rs.getInt("cliente_id_cliente"))      
    ));
    }

    @Override
    public int eliminarCapacitacion(int idcapacitacion) {
            String sql = "delete from capacitaciones where id_capacitacion = " + idcapacitacion;
            return template.update(sql);
    }
}

   

   