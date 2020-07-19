package cl.awake.psegurito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.awake.psegurito.DAO.DetalleFacturaDAO;
import cl.awake.psegurito.DAO.FacturaDAO;
import cl.awake.psegurito.bean.DetalleFactura;
import cl.awake.psegurito.bean.Factura;

@Controller
public class DetalleFacturaController {
	
	@Autowired
	@Qualifier("daodetallefactura")
	DetalleFacturaDAO detallefacturadao;
	
	@Autowired
	@Qualifier("daofactura")
	FacturaDAO facturadao;
	
	
	// metodo listar
	@RequestMapping("/listadodetallefactura/{id}")
	public String ListarDetalleFactura(@PathVariable int id, Model m) {
		List<DetalleFactura> listadetallefactura = detallefacturadao.leerDetalleFactura(id);
		m.addAttribute("listadodetallefactura", listadetallefactura);
		return "detalleFacturaCliente";
	}
	
	@RequestMapping("/nuevodetallefactura/{id}")
	public String creardetallefactura(@PathVariable int id, Model m) {
		m.addAttribute("command", new DetalleFactura());
		//lista detallefactura
		List<DetalleFactura> listadetallefactura = detallefacturadao.leerDetalleFactura(id);
		m.addAttribute("listadodetallefactura", listadetallefactura);
		m.addAttribute("id_factura",id);
		  
		return "detalleFacturaAdministrador";
	}

	@RequestMapping(value = "/guardardetallefactura", method = RequestMethod.POST)
	public String nuevodetallefactura(DetalleFactura detallefactura) {
		detallefacturadao.crearDetalleFactura(detallefactura);
		
//        //actualizar valores en factura
//        Factura factura = new Factura();
//        FacturaDAO facturadao = new FacturaDAO();
//        factura = facturadao.obtenerFactura(detallefactura.getFactura().getId_factura());
//        System.out.println(factura.getId_factura());
//        factura.setItems(detallefacturadao.leerDetalleFactura(detallefactura.getFactura().getId_factura()));
//        System.out.println(factura.getItems());
//        factura.setSubtotal((int)factura.calcularSubtotal());
//        factura.setImpuestos((int)factura.calcularIVA());
//        factura.setTotal((int)factura.calcularTotal());
//        facturadao.actualizarFactura(factura);
		
		
		return "redirect:/nuevodetallefactura/{id}.do";
	}
	
	@RequestMapping("/eliminardetallefactura/{id}")
	public String deletedetallefactura(@PathVariable int id) {
		detallefacturadao.eliminarDetalleFactura(id);
		return "redirect:/nuevodetallefactura/{id}.do";
	}
	
	@RequestMapping(value = "/editardetallefactura/{id}")
	public String edit(@PathVariable int id, Model m) {
		DetalleFactura detallefactura = detallefacturadao.obtenerDetalleFactura(id);		
		
		//lista factura
		List<Factura> listafactura = facturadao.leerFactura();
		m.addAttribute("listadofactura", listafactura);
		
		m.addAttribute("command", detallefactura);
		return "detalleFacturaEditar";
	}

	@RequestMapping(value = "/guardareditdetallefactura", method = RequestMethod.POST)
	public String editsave(DetalleFactura detallefactura) {
		detallefacturadao.actualizarDetalleFactura(detallefactura);
		return "redirect:/nuevodetallefactura/{id}.do";
	}
	
	
}