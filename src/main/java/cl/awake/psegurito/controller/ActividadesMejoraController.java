package cl.awake.psegurito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.awake.psegurito.DAO.ActividadesMejoraDao;
import cl.awake.psegurito.DAO.ClienteDAO;
import cl.awake.psegurito.DAO.ProfesionalDAO;
import cl.awake.psegurito.bean.ActividadesMejora;
import cl.awake.psegurito.bean.Cliente;
import cl.awake.psegurito.bean.Profesional;

@Controller
public class ActividadesMejoraController {
	@Autowired
	@Qualifier("daoactividadmejora")
	ActividadesMejoraDao actividadmejoradao;
	@Autowired
	@Qualifier("daoprofesional")
	ProfesionalDAO profesionaldao;
	@Autowired
	@Qualifier("daocliente")
	ClienteDAO clientedao;
	
	//Listar
	@RequestMapping("/listadoactividadesmejora")
	public String listarActividadesMejora(Model m) {
		List<ActividadesMejora> listaactividadesmejora = actividadmejoradao.leerActividadesMejora();
		m.addAttribute("listadoactividadesmejora",listaactividadesmejora);
		return "actividadesMejoraVista";//Verlista
	}
	
	//Crear
	@RequestMapping("/nuevaactividadmejora")
	public String crearactividadmejora(Model m) {
		m.addAttribute("command", new ActividadesMejora());
		//lista actividades
		List<ActividadesMejora> listaactividadesmejora = actividadmejoradao.leerActividadesMejora();
		m.addAttribute("listadoactividadesmejora",listaactividadesmejora);
		
		//lista profesionales
		List<Profesional> listaprofesional = profesionaldao.leerProfesional();
		m.addAttribute("listadoprofesional", listaprofesional);
		
		//lista clientes
		List<Cliente> listacliente = clientedao.leerCliente();
		m.addAttribute("listadocliente", listacliente);
		
		return "actividadesMejoraCRUD";//Editable
		
	}
	
	@RequestMapping(value = "/guardarasesoria", method = RequestMethod.POST)
	public String nuevaactividadmejora(ActividadesMejora actividadesMejora) {
		actividadmejoradao.crearActividadesMejora(actividadesMejora);
		return "redirect:/nuevaactividadmejora.do";
	}
	
	
	
}
