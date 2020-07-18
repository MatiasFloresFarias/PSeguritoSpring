package cl.awake.psegurito.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.awake.psegurito.DAO.ClienteDAO;
import cl.awake.psegurito.bean.Cliente;
@Controller
public class ClienteController {
	@Autowired
	ClienteDAO clientedao;
	
//	//metodo listar 
//	@RequestMapping("/cliente")
//	public String ListarCliente(Model m) {
//		List<Cliente> listacliente = clientedao.leerCliente();
//		m.addAttribute("listadocliente",listacliente);
//		return "cliente";		
//	}
	
	@RequestMapping("/cliente")
	public String crearcliente(Model m) {
		List<Cliente> listacliente = clientedao.leerCliente();
		m.addAttribute("listadocliente",listacliente);
		m.addAttribute("command",new Cliente());
		return "cliente";
	}
	
    @RequestMapping(value="/guardarcliente", method = RequestMethod.POST)
    public String nuevocliente(Cliente cliente){
        clientedao.crearCliente(cliente);
        return "redirect:/cliente.do";
    }
	
	@RequestMapping("/eliminarcliente/{id}")
    public String deletecliente(@PathVariable int id) {
    	clientedao.eliminarCliente(id);
        return "redirect:/cliente.do";
    }
	
    @RequestMapping(value="/editarcliente/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Cliente cliente=clientedao.obtenerCliente(id);
        
		// transformo las fechas pa q se vean en el mismo formato q acepta sql
		String fechayhora1 = cliente.getFechaRegistro();
		LocalDateTime datetime = LocalDateTime.parse(fechayhora1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		cliente.setFechaRegistro(fechayhora);
        
        m.addAttribute("command",cliente);
        return "clienteEditar";
    }

    @RequestMapping(value="/guardareditcliente", method = RequestMethod.POST)    
    public String editsave(Cliente cliente){
        clientedao.actualizarCliente(cliente);
        return "redirect:/cliente.do";
    }
  

}
