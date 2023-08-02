package com.midominio.proyecto0.app.Service;

import java.util.ArrayList;


import org.springframework.stereotype.Service;

import com.midominio.proyecto0.app.Model.Coche;

@Service("cocheServicio2")
public interface ICocheService {

	public ArrayList<Coche> listar();
	
	
	public Coche porMatricula(String matricula) throws CocheNoExisteException;
	
	
}
