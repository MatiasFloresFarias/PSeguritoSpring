package cl.awake.psegurito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.awake.psegurito.DAO.AsesoriaDAO;
import cl.awake.psegurito.bean.Asesoria;

@Controller
public class AsesoriaController {
	@Autowired
	AsesoriaDAO asesoriadao;
	
	//metodo listar 
	@RequestMapping("/listadoasesoria")
	public String ListarAsesoria(Model m) {
		List<Asesoria> listaasesoria = asesoriadao.leerAsesoria();
		m.addAttribute("listadoasesoria",listaasesoria);
		return "asesoriaCliente";		
	}
	
	

}
