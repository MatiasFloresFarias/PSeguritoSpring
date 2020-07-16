package cl.awake.psegurito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.awake.psegurito.DAO.ProfesionalDAO;
import cl.awake.psegurito.bean.Profesional;

@Controller
public class ProfesionalController {
	@Autowired
	ProfesionalDAO profesionaldao;
	
	//metodo listar 
	@RequestMapping("/listadoprofesional")
	public String ListarProfesional(Model m) {
		List<Profesional> listaprofesional = profesionaldao.leerProfesional();
		m.addAttribute("listadoprofesional",listaprofesional);
		return "profesionalCliente";		
	}
	
	@RequestMapping("/nuevoprofesional")
	public String crearprofesional(Model m) {
		m.addAttribute("command",new Profesional());
		return "profesional";
	}
	
    @RequestMapping(value="/guardarprofesional", method = RequestMethod.POST)
    public String nuevoprofesional(Profesional profesional){
        profesionaldao.crearProfesional(profesional);
        return "redirect:/listadoprofesional";
    }
	
	@RequestMapping("/eliminarprofesional/{id}")
    public String deleteprofesional(@PathVariable int id) {
    	profesionaldao.eliminarProfesional(id);
        return "redirect:/listadoprofesional";
    }
	
    @RequestMapping(value="/editarprofesional/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Profesional profesional=profesionaldao.obtenerProfesional(id);
        m.addAttribute("command",profesional);
        return "profesionalEditar";
    }

    @RequestMapping(value="/guardareditprofesional", method = RequestMethod.POST)    
    public String editsave(Profesional profesional){
        profesionaldao.actualizarProfesional(profesional);
        return "redirect:/listadoprofesional";
    }
  

}
