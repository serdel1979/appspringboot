package com.sergio.empleos.service;

import java.util.List;

import com.sergio.empleos.model.Vacante;

public interface IVacanteService {

	List<Vacante> buscarTodos();
	Vacante buscarPorId(Integer idVacante);	
	
}
