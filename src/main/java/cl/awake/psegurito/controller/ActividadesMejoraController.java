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

import cl.awake.psegurito.DAO.ActividadesMejoraDAO;
import cl.awake.psegurito.DAO.ClienteDAO;
import cl.awake.psegurito.DAO.ProfesionalDAO;
import cl.awake.psegurito.bean.ActividadesMejora;
import cl.awake.psegurito.bean.Asesoria;
import cl.awake.psegurito.bean.Cliente;
import cl.awake.psegurito.bean.Profesional;

@Controller
public class ActividadesMejoraController {
	@Autowired
	@Qualifier("daoactividadmejora")
	ActividadesMejoraDAO actividadmejoradao;
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
		return "actividadMejoraCliente";//Verlista
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
		
		return "actividadMejoraProfesional";//Editable
		
	}
	
	@RequestMapping(value = "/guardaractividadmejora", method = RequestMethod.POST)
	public String nuevaactividadmejora(ActividadesMejora actividadesMejora) {
		actividadmejoradao.crearActividadesMejora(actividadesMejora);
		return "redirect:/nuevaactividadmejora.do";
	}
	
	@RequestMapping("/eliminaractividadmejora/{id}")
	public String deleteactividadmejora(@PathVariable int id) {
		actividadmejoradao.eliminarActividadesMejora(id);
		return "redirect:/nuevaactividadmejora.do";
	}
	
	@RequestMapping(value = "/editaractividadmejora/{id}")
	public String edit(@PathVariable int id, Model m) {
		ActividadesMejora actividadmejora = actividadmejoradao.obtenerActividadesMejora(id);
		
		//Tranforma fechaInicio para que se vea en el formato sql
		String fechainicio1 = actividadmejora.getFechaInicio();
		LocalDateTime datetime = LocalDateTime.parse(fechainicio1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechainicio = datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		actividadmejora.setFechaInicio(fechainicio);
		
		//Lo mismo con fechaTermino
		String fechatermino1 = actividadmejora.getFechaTermino();
		LocalDateTime datetime1 = LocalDateTime.parse(fechatermino1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String fechatermino = datetime1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		actividadmejora.setFechaTermino(fechatermino);
		
		System.out.println(actividadmejora.getProfesional());
		//Lista profesionales
		List<Profesional> listaprofesional = profesionaldao.leerProfesional();
		m.addAttribute("listadoprofesional", listaprofesional);
		//Lista clientes
		List<Cliente> listacliente =  clientedao.leerCliente();
		m.addAttribute("listadocliente",listacliente);
		
		m.addAttribute("command", actividadmejora);
		return "actividadMejoraEditar";
	}
	
	@RequestMapping(value = "/guardareditactividadmejora", method = RequestMethod.POST)
	public String editsave(ActividadesMejora actividadesmejora) {
		actividadmejoradao.actualizarActividadesMejora(actividadesmejora);
		return "redirect:/nuevaactividadmejora.do";
	}
	
}
