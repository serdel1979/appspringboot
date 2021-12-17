package com.sergio.empleos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.empleos.model.Vacante;
import com.sergio.empleos.service.IVacanteService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
		@Autowired
		private IVacanteService serviceVacantes;
		
		@GetMapping("/delete")
	    public String eliminar(@RequestParam("id") int idVacante, Model model) {
	    	System.out.println("Ide parametro recibido = "+idVacante);
	    	model.addAttribute("id",idVacante);
	    	return "vacantes/mensaje";
	    }
		

		@GetMapping("/view/{id}")
		public String verDetalle(@PathVariable("id") int idVacante, Model model) {
			
			Vacante vacante = serviceVacantes.buscarPorId(idVacante);
			
			
			model.addAttribute("vacante", vacante);
			
			
			//buscar el detalle en la bd
			return "detalle";
		}
}
