package cl.awake.psegurito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.awake.psegurito.DAO.ClienteDAO;
import cl.awake.psegurito.DAO.FacturaDAO;
import cl.awake.psegurito.bean.Factura;

@Controller
public class DetalleFacturaController {
	
	@Autowired
	@Qualifier("daofactura")
	FacturaDAO facturadao;
	
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;
	
	
	// metodo listar
	@RequestMapping("/listadoFactura")
	public String ListarFactura(Model m) {
		List<Factura> listafactura = facturadao.leerFactura();
		m.addAttribute("listadofactura", listafactura);
		return "#";
	}


}
