package cl.awake.psegurito.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.awake.psegurito.DAO.CapacitacionDAO;
import cl.awake.psegurito.DAO.ClienteDAO;
import cl.awake.psegurito.DAO.ProfesionalDAO;
import cl.awake.psegurito.bean.Capacitacion;
import cl.awake.psegurito.bean.Cliente;
import cl.awake.psegurito.bean.Profesional;

@Controller
public class CapacitacionController {
    
    @Autowired
    @Qualifier("daocapacitacion")
    CapacitacionDAO capacitaciondao;
    @Autowired
    @Qualifier("daoprofesional")
    ProfesionalDAO profesionaldao;
    @Autowired
    @Qualifier("daocliente")
    ClienteDAO clientedao;
    
    @RequestMapping("/listadocapacitacion")
    public String ListarCapacitacion(Model m) {

            List<Capacitacion> listacapacitacion = capacitaciondao.leerCapacitacion();
            m.addAttribute("listadocapacitacion", listacapacitacion);
            return "capacitacionCliente";
}
    @RequestMapping("/nuevacapacitacion")
    public String crearcapacitacion(Model m) {
            m.addAttribute("command", new Capacitacion());
        
            List<Capacitacion> listacapacitacion = capacitaciondao.leerCapacitacion();
            m.addAttribute("listadocapacitacion", listacapacitacion);
            
            //lista profesionales
            List<Profesional> listaprofesional = profesionaldao.leerProfesional();
            m.addAttribute("listadoprofesional", listaprofesional);
            //lista clientes
            List<Cliente> listacliente = clientedao.leerCliente();
            m.addAttribute("listadocliente", listacliente);
            
            return "capacitacionProfesional";
}
    @RequestMapping(value = "/guardarcapacitacion", method = RequestMethod.POST)
    public String nuevacapacitacion(Capacitacion capacitacion) {
            capacitaciondao.crearCapacitacion(capacitacion);
            return "redirect:/nuevacapacitacion.do";
    }
    
    @RequestMapping("/eliminarcapacitacion/{id}")
    public String deletecapacitacion(@PathVariable int id) {
            capacitaciondao.eliminarCapacitacion(id);
            return "redirect:/nuevacapacitacion.do";
    }

    @RequestMapping(value = "/editarcapacitacion/{id}")
    public String edit(@PathVariable int id, Model m) {
            Capacitacion capacitacion = capacitaciondao.obtenerCapacitacion(id);

            String fechayhora1 = capacitacion.getFechayhora();
            LocalDateTime datetime = LocalDateTime.parse(fechayhora1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String fechayhora = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            capacitacion.setFechayhora(fechayhora);
            
            
            System.out.println(capacitacion.getProfesional());
            //lista profesionales
            List<Profesional> listaprofesional = profesionaldao.leerProfesional();
            m.addAttribute("listadoprofesional", listaprofesional);
            //lista clientes
            List<Cliente> listacliente = clientedao.leerCliente();
            m.addAttribute("listadocliente", listacliente);
            
            m.addAttribute("command", capacitacion);
            return "capacitacionEditar";
    }

    @RequestMapping(value = "/guardareditcapacitacion", method = RequestMethod.POST)
    public String editsave(Capacitacion capacitacion) {
            capacitaciondao.actualizarCapacitacion(capacitacion);
            return "redirect:/nuevacapacitacion.do";
    }

}


