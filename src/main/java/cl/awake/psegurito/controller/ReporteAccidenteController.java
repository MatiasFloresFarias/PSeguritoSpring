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

import cl.awake.psegurito.DAO.ClienteDAO;
import cl.awake.psegurito.DAO.ReporteAccidenteDAO;
import cl.awake.psegurito.bean.Cliente;
import cl.awake.psegurito.bean.ReporteAccidente;

@Controller
public class ReporteAccidenteController {
	@Autowired
	@Qualifier("daoreporteaccidente")
	ReporteAccidenteDAO reporteaccidentedao;
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;

	// metodo listar
	@RequestMapping("/listadoreporteaccidente")
	public String ListarReporteAccidente(Model m) {
		List<ReporteAccidente> listareporteaccidente = reporteaccidentedao.leerReporteAccidente();
		m.addAttribute("listadoreporteaccidente", listareporteaccidente);
		return "reporteAccidenteProfesional";
	}

	@RequestMapping("/nuevoreporteaccidente")
	public String crearReporteAccidente(Model m) {
		m.addAttribute("command", new ReporteAccidente());
		//lista reporte accidente
		List<ReporteAccidente> listareporteaccidente = reporteaccidentedao.leerReporteAccidente();
		m.addAttribute("listadoreporteaccidente", listareporteaccidente);
		
		//lista clientes
		List<Cliente> listacliente = clientedao.leerCliente();
		m.addAttribute("listadocliente", listacliente);
		
		return "reporteAccidenteCliente";
	}

	@RequestMapping(value = "/guardarreporteaccidente", method = RequestMethod.POST)
	public String nuevoReporteAccidente(ReporteAccidente reporteaccidente) {
		reporteaccidentedao.crearReporteAccidente(reporteaccidente);
		return "redirect:/nuevoreporteaccidente.do";
	}

	@RequestMapping("/eliminarreporteaccidente/{id}")
	public String deleteReporteAccidente(@PathVariable int id) {
		reporteaccidentedao.eliminarReporteAccidente(id);
		return "redirect:/nuevoreporteaccidente.do";
	}

	@RequestMapping(value = "/editarreporteaccidente/{id}")
	public String edit(@PathVariable int id, Model m) {
		ReporteAccidente reporteaccidente = reporteaccidentedao.obtenerReporteAccidente(id);
		
		// transformo las fechas pa q se vean en el mismo formato q acepta sql
		String fechayhora1 = reporteaccidente.getFecha();
		LocalDateTime datetime = LocalDateTime.parse(fechayhora1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		reporteaccidente.setFecha(fechayhora);

		//lista clientes
		List<Cliente> listacliente = clientedao.leerCliente();
		m.addAttribute("listadocliente", listacliente);
		
		m.addAttribute("command", reporteaccidente);
		return "reporteAccidenteEditar";
	}

	@RequestMapping(value = "/guardareditreporteaccidente", method = RequestMethod.POST)
	public String editsave(ReporteAccidente reporteaccidente) {
		reporteaccidentedao.actualizarReporteAccidente(reporteaccidente);
		return "redirect:/nuevoreporteaccidente.do";
	}

}
