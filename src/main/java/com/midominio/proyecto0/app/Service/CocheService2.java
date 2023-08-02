package com.midominio.proyecto0.app.Service;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.midominio.proyecto0.app.Model.Coche;

@Primary
@Service
public class CocheService2 implements ICocheService{

	
	private ArrayList<Coche> lista;
	
	
	public CocheService2() {
		lista= new ArrayList<>();
		
		lista.add( new Coche("F","FORD","FOCUS"));
		lista.add(new Coche("4133D","RENAULD","CAPTUR"));
		lista.add(new Coche("6433G","MERCEDES","CLASE-E"));
		lista.add(new Coche("2133T","FORD","MUSTANG"));
		lista.add(new Coche("9113J","TOYOTA","COROLLA"));
	
		
	}

	@Override
	public ArrayList<Coche> listar() {
		return lista;
	}
	
	@Override
	public Coche porMatricula(String matricula) throws CocheNoExisteException{
		
		Coche c1 = new Coche(matricula);
		
		
			if(!(lista.contains(c1))) {
				throw new CocheNoExisteException("Coche no encontrado");
			}
		
		
		for (Coche coche : lista) {
			if(coche.getMatricula().equalsIgnoreCase(matricula)) {
				
				return coche;
			}
		}
		return null;
	}
	
}
