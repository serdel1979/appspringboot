package com.sergio.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sergio.empleos.model.Vacante;

@Controller
public class HomeController {

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
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
		/*
		 * model.addAttribute("mensaje", "Bienvenidos a Empleos App!!!");
		 * model.addAttribute("fecha", new Date());
		 */

		String nombre = "Auxiliar de contable";
		Date fechaPub = new Date();
		double salario = 90000.0;
		boolean vigente = true;

		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);

		return "Home";

	}

	private List<Vacante> getVacantes() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();

		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Analista en Tic");
			vacante1.setDescripcion("Empresa de sistema para Programacion y analisis de sistemas");
			vacante1.setFecha(sdf.parse("09-12-2018"));
			vacante1.setSalario(200000.5);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");

			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Recolector");
			vacante2.setDescripcion("Empresa necesita recolectar urgente");
			vacante2.setFecha(sdf.parse("09-12-2020"));
			vacante2.setSalario(200000.5);
			vacante2.setDestacado(1);
			vacante2.setImagen("empresa2.png");

			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Panificador");
			vacante3.setDescripcion("Panificados carlos");
			vacante3.setFecha(sdf.parse("09-12-2021"));
			vacante3.setSalario(200000.5);
			vacante3.setDestacado(1);
			vacante3.setImagen("empresa3.png");

			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Frutero");
			vacante4.setDescripcion("Para juntar frutas");
			vacante4.setFecha(sdf.parse("09-12-2019"));
			vacante4.setSalario(2004400.5);
			vacante4.setDestacado(0);
			vacante4.setImagen("empresa4.png");

			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lista;
	}

}
