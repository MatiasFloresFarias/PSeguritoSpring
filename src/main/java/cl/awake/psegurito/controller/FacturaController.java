package cl.awake.psegurito.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.awake.psegurito.DAO.ClienteDAO;
import cl.awake.psegurito.DAO.FacturaDAO;
import cl.awake.psegurito.bean.Asesoria;
import cl.awake.psegurito.bean.Cliente;
import cl.awake.psegurito.bean.Factura;
import cl.awake.psegurito.bean.Profesional;

@Controller
public class FacturaController {
	private static final Logger logger = LogManager.getLogger("MyFile");
	
	@Autowired
	@Qualifier("daofactura")
	FacturaDAO facturadao;
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;
	
	// metodo listar
	@RequestMapping("/listadofactura")
	public String ListarFactura(Model m) {
		//Log4J
	      logger.trace("Trace Message!");
	      logger.debug("Debug Message!");
	      logger.info("Info Message!");
	      logger.warn("Warn Message!");
	      logger.error("Error Message!");
	      logger.fatal("Fatal Message!");
		List<Factura> listafactura = facturadao.leerFactura();
		m.addAttribute("listadofactura", listafactura);
		return "facturaCliente";
	}
	
	@RequestMapping("/nuevafactura")
	public String crearfactura(Model m) {
		m.addAttribute("command", new Factura());
		//lista factura
		List<Factura> listafactura = facturadao.leerFactura();
		m.addAttribute("listadofactura", listafactura);
		
		//lista clientes
		List<Cliente> listacliente = clientedao.leerCliente();
		m.addAttribute("listadocliente", listacliente);
		
		return "facturaAdministrador";
	}

	@RequestMapping(value = "/guardarfactura", method = RequestMethod.POST)
	public String nuevafactura(Factura factura) {
		facturadao.crearFactura(factura);
		return "redirect:/nuevafactura.do";
	}
	
	@RequestMapping("/eliminarfactura/{id}")
	public String deletefactura(@PathVariable int id) {
		facturadao.eliminarFactura(id);
		return "redirect:/nuevafactura.do";
	}
	
	@RequestMapping(value = "/editarfactura/{id}")
	public String edit(@PathVariable int id, Model m) {
		Factura factura = facturadao.obtenerFactura(id);
		
		// transformo las fechas pa q se vean en el mismo formato q acepta sql
		String fechayhora1 = factura.getFechadecobro();
		LocalDateTime datetime = LocalDateTime.parse(fechayhora1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		factura.setFechadecobro(fechayhora);
		
		String fechayhora2 = factura.getFechaVencimiento();
		LocalDateTime datetime2 = LocalDateTime.parse(fechayhora2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora3 = datetime2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		factura.setFechaVencimiento(fechayhora3);
		
		//lista clientes
		List<Cliente> listacliente = clientedao.leerCliente();
		m.addAttribute("listadocliente", listacliente);
		
		m.addAttribute("command", factura);
		return "facturaEditar";
	}

	@RequestMapping(value = "/guardareditfactura", method = RequestMethod.POST)
	public String editsave(Factura factura) {
		facturadao.actualizarFactura(factura);
		return "redirect:/nuevafactura.do";
	}
	
	
}
