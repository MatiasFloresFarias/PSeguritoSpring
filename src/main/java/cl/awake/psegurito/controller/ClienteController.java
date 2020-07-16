package cl.awake.psegurito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.awake.psegurito.DAO.ClienteDAO;
import cl.awake.psegurito.bean.Cliente;

public class ClienteController {
	@Autowired
	ClienteDAO clientedao;
	
	//metodo listar 
	@RequestMapping("/listadocliente")
	public String ListarCliente(Model m) {
		List<Cliente> listacliente = clientedao.leerCliente();
		m.addAttribute("listadocliente",listacliente);
		return "clienteCliente";		
	}
	
	@RequestMapping("/nuevocliente")
	public String crearcliente(Model m) {
		m.addAttribute("command",new Cliente());
		return "cliente";
	}
	
    @RequestMapping(value="/guardarcliente", method = RequestMethod.POST)
    public String nuevocliente(Cliente cliente){
        clientedao.crearCliente(cliente);
        return "redirect:/listadocliente";
    }
	
	@RequestMapping("/eliminarcliente/{id}")
    public String deletecliente(@PathVariable int id) {
    	clientedao.eliminarCliente(id);
        return "redirect:/listadocliente";
    }
	
    @RequestMapping(value="/editarcliente/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Cliente cliente=clientedao.obtenerCliente(id);
        m.addAttribute("command",cliente);
        return "clienteEditar";
    }

    @RequestMapping(value="/guardareditcliente", method = RequestMethod.POST)    
    public String editsave(Cliente cliente){
        clientedao.actualizarCliente(cliente);
        return "redirect:/listadocliente";
    }
  

}
