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

import cl.awake.psegurito.DAO.AsesoriaDAO;
import cl.awake.psegurito.DAO.ClienteDAO;
import cl.awake.psegurito.DAO.ProfesionalDAO;
import cl.awake.psegurito.bean.Asesoria;
import cl.awake.psegurito.bean.Cliente;
import cl.awake.psegurito.bean.Profesional;


@Controller
public class AsesoriaController {
	@Autowired
	@Qualifier("daoasesoria")
	AsesoriaDAO asesoriadao;
	@Autowired
	@Qualifier("daoprofesional")
	ProfesionalDAO profesionaldao;
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;

	// metodo listar
	@RequestMapping("/listadoasesoria")
	public String ListarAsesoria(Model m) {
		List<Asesoria> listaasesoria = asesoriadao.leerAsesoria();
		m.addAttribute("listadoasesoria", listaasesoria);
		return "asesoriaCliente";
	}

	@RequestMapping("/nuevaasesoria")
	public String crearasesoria(Model m) {
		m.addAttribute("command", new Asesoria());
		
		//lista profesionales
		List<Profesional> listaprofesional = profesionaldao.leerProfesional();
		m.addAttribute("listadoprofesional", listaprofesional);
		//lista clientes
		List<Cliente> listacliente = clientedao.leerCliente();
		m.addAttribute("listadocliente", listacliente);
		
		return "asesoriaProfesional";
	}

	@RequestMapping(value = "/guardarasesoria", method = RequestMethod.POST)
	public String nuevaasesoria(Asesoria asesoria) {
		asesoriadao.crearAsesoria(asesoria);
		return "redirect:/listadoasesoria";
	}

	@RequestMapping("/eliminarasesoria/{id}")
	public String deleteasesoria(@PathVariable int id) {
		asesoriadao.eliminarAsesoria(id);
		return "redirect:/listadoasesoria";
	}

	@RequestMapping(value = "/editarasesoria/{id}")
	public String edit(@PathVariable int id, Model m) {
		Asesoria asesoria = asesoriadao.obtenerAsesoria(id);
		System.out.println(asesoria.getProfesional());
		//lista profesionales
		List<Profesional> listaprofesional = profesionaldao.leerProfesional();
		m.addAttribute("listadoprofesional", listaprofesional);
		//lista clientes
		List<Cliente> listacliente = clientedao.leerCliente();
		m.addAttribute("listadocliente", listacliente);
		
		m.addAttribute("command", asesoria);
		return "asesoriaEditar";
	}

	@RequestMapping(value = "/guardareditasesoria", method = RequestMethod.POST)
	public String editsave(Asesoria asesoria) {

		// transformo las fechas pa q se vean en el mismo formato q acepta sql
		String fechayhora1 = asesoria.getFechayhora();
		LocalDateTime datetime = LocalDateTime.parse(fechayhora1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechayhora = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		asesoria.setFechayhora(fechayhora);

		asesoriadao.actualizarAsesoria(asesoria);
		return "redirect:/listadoasesoria";
	}

}
