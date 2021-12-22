package com.sergio.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sergio.empleos.model.Vacante;

@Service
public class VacanteServiceImpl implements IVacanteService {

	private List<Vacante> lista = null;

	public VacanteServiceImpl() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();

		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Analista en Tic");
			vacante1.setDescripcion("Empresa de sistema Programacion y analisis de sistemas");
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

	}

	@Override
	public List<Vacante> buscarTodos() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {

		for (Vacante v : lista) {
			if (v.getId() == idVacante)
				return v;
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		vacante.setId(this.lista.size()+1);
		lista.add(vacante);		
	}

}
