package com.midominio.proyecto0.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midominio.proyecto0.app.Service.CocheNoExisteException;
import com.midominio.proyecto0.app.Service.ICocheService;

@RequestMapping("/coches")
@Controller
public class CocheController {

	@Value("Ejercicio Coches")
	private String pestana;
	
	@Autowired
	@Qualifier("cocheServicio1")
	private ICocheService servicioCoches;
	
	
	@GetMapping({ "/{matricula}" })
	public String ejemplo01(
			@PathVariable String matricula,
			Model model) throws CocheNoExisteException {
		
		model.addAttribute("pestana", pestana);
		model.addAttribute("titulo", "Datos del coche");
		model.addAttribute("coche", servicioCoches.porMatricula(matricula));
		return "coches/un-coche";
	}
	
	
	@GetMapping("/listado")
	public String ejemplo02(Model model) {
		
		model.addAttribute("pestana", pestana);
		model.addAttribute("titulo", "Lista de coches");
		model.addAttribute("lista", servicioCoches.listar());
		return "coches/un-coche";
	}
	
	
}
