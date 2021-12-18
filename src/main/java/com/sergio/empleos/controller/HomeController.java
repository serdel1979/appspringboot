package com.sergio.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sergio.empleos.model.Vacante;
import com.sergio.empleos.service.IVacanteService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacanteService serviceVacantes;

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodos();
		model.addAttribute("vacantes", lista);

		return "tabla";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de Sistemas");
		vacante.setDescripcion("Para cambiar toners en la Facultad de Artes");
		vacante.setFecha(new Date());
		vacante.setSalario(200000.0);
		model.addAttribute("vacante", vacante);

		return "detalle";

	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero en Sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");

		model.addAttribute("empleos", lista);
		return "listado";

	}

	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodos();
		model.addAttribute("vacantes", lista);


		return "Home";

	}

	
		

}
