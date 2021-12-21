package com.sergio.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		System.out.println("Ide parametro recibido = " + idVacante);
		model.addAttribute("id", idVacante);
		return "vacantes/mensaje";
	}

	@GetMapping("/crear")
	public String crear() {
		return "vacantes/formVacante";
	}

	@PostMapping("/guardar")
	public String guardar(Vacante vacante) {

		//System.out.println("Datos recibidos " + vacante.toString());
		this.serviceVacantes.guardar(vacante);

		return "vacantes/listaVacantes";
	}

	/*
	 * public String guardar(@RequestParam("nombre") String
	 * nombre, @RequestParam("descripcion") String descripcion,
	 * 
	 * @RequestParam("categoria") String categoria, @RequestParam("estatus") String
	 * estatus,
	 * 
	 * @RequestParam("fecha") String fecha, @RequestParam("destacado") int
	 * destacado,
	 * 
	 * @RequestParam("salario") double salario, @RequestParam("detalles") String
	 * detalle) {
	 * 
	 * System.out.println("Nombre "+nombre);
	 * System.out.println("Descripcion "+descripcion);
	 * System.out.println("Categoria "+categoria);
	 * System.out.println("Estado "+estatus); System.out.println("Fecha"+fecha);
	 * System.out.println("Destacado "+destacado);
	 * System.out.println("Salario "+salario);
	 * System.out.println("Detalle "+detalle);
	 * 
	 * return "vacantes/listaVacantes"; }
	 */

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		// buscar el detalle en la bd
		return "detalle";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
