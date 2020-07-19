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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.awake.psegurito.DAO.ClienteDAO;
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
	
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;
	
	
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
	public String nuevodetallefactura(DetalleFactura detallefactura, RedirectAttributes redirectAttrs) {
		detallefacturadao.crearDetalleFactura(detallefactura);
		int id = detallefactura.getFactura().getId_factura();

        //actualizar valores en factura
        Factura factura = new Factura();
//        FacturaDAO facturadao = new FacturaDAO();
        factura = facturadao.obtenerFactura(id);
		// transformo las fechas pa q se vean en el mismo formato q acepta sql
		String fechayhora1 = factura.getFechadecobro();
		LocalDateTime datetime = LocalDateTime.parse(fechayhora1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		factura.setFechadecobro(fechayhora);
		
		String fechayhora2 = factura.getFechaVencimiento();
		LocalDateTime datetime2 = LocalDateTime.parse(fechayhora2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora3 = datetime2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		factura.setFechaVencimiento(fechayhora3);
        
        factura.setItems(detallefacturadao.leerDetalleFactura(id));
        factura.setSubtotal((int)factura.calcularSubtotal());
        System.out.println(factura.getSubtotal());
        factura.setImpuestos((int)factura.calcularIVA());
        factura.setTotal((int)factura.calcularTotal());
        facturadao.actualizarFactura(factura);
        redirectAttrs.addAttribute("id", id);
        return "redirect:/nuevodetallefactura/{id}";
	}
	
	@RequestMapping("/eliminardetallefactura/{id}/{id_factura}")
	public String deletedetallefactura(@PathVariable int id, @PathVariable int id_factura, RedirectAttributes redirectAttrs) {
		detallefacturadao.eliminarDetalleFactura(id);
        //actualizar valores en factura
        Factura factura = new Factura();
//        FacturaDAO facturadao = new FacturaDAO();
        factura = facturadao.obtenerFactura(id_factura);
		// transformo las fechas pa q se vean en el mismo formato q acepta sql
		String fechayhora1 = factura.getFechadecobro();
		LocalDateTime datetime = LocalDateTime.parse(fechayhora1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		factura.setFechadecobro(fechayhora);
		
		String fechayhora2 = factura.getFechaVencimiento();
		LocalDateTime datetime2 = LocalDateTime.parse(fechayhora2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora3 = datetime2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		factura.setFechaVencimiento(fechayhora3);
        
        factura.setItems(detallefacturadao.leerDetalleFactura(id_factura));
        factura.setSubtotal((int)factura.calcularSubtotal());
        System.out.println(factura.getSubtotal());
        factura.setImpuestos((int)factura.calcularIVA());
        factura.setTotal((int)factura.calcularTotal());
        facturadao.actualizarFactura(factura);
		
		
		redirectAttrs.addAttribute("id", id);
		redirectAttrs.addAttribute("idfactura", id_factura);
		return "redirect:/nuevodetallefactura/{idfactura}.do";
	}
	
	@RequestMapping(value = "/editardetallefactura/{id}/{id_factura}")
	public String edit(@PathVariable int id, @PathVariable int id_factura, Model m) {
		DetalleFactura detallefactura = detallefacturadao.obtenerDetalleFactura(id);		
		
		m.addAttribute("command", detallefactura);
		m.addAttribute("id_factura", id_factura);
		return "detalleFacturaEditar";
	}

	@RequestMapping(value = "/guardareditdetallefactura", method = RequestMethod.POST)
	public String editsave(DetalleFactura detallefactura, RedirectAttributes redirectAttrs) {
		detallefacturadao.actualizarDetalleFactura(detallefactura);
		
		int id_factura = detallefactura.getFactura().getId_factura();
        //actualizar valores en factura
        Factura factura = new Factura();
//        FacturaDAO facturadao = new FacturaDAO();
        factura = facturadao.obtenerFactura(id_factura);
		// transformo las fechas pa q se vean en el mismo formato q acepta sql
		String fechayhora1 = factura.getFechadecobro();
		LocalDateTime datetime = LocalDateTime.parse(fechayhora1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		factura.setFechadecobro(fechayhora);
		
		String fechayhora2 = factura.getFechaVencimiento();
		LocalDateTime datetime2 = LocalDateTime.parse(fechayhora2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora3 = datetime2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		factura.setFechaVencimiento(fechayhora3);
        
        factura.setItems(detallefacturadao.leerDetalleFactura(id_factura));
        factura.setSubtotal((int)factura.calcularSubtotal());
        System.out.println(factura.getSubtotal());
        factura.setImpuestos((int)factura.calcularIVA());
        factura.setTotal((int)factura.calcularTotal());
        facturadao.actualizarFactura(factura);
		
		redirectAttrs.addAttribute("idfactura", id_factura);
		
		return "redirect:/nuevodetallefactura/{idfactura}.do";
	}
	
	
}