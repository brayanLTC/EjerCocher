package com.midominio.proyecto0.app.Service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.midominio.proyecto0.app.Model.Coche;


@Service("cocheServicio1")
public class CocheService1 implements ICocheService{

	private ArrayList<Coche> lista;
	
	
	public CocheService1() {
		lista= new ArrayList<>();
		
		lista.add( new Coche("F","FORD","FOCUS"));
		lista.add(new Coche("4133D","RENAULD","CAPTUR"));
		lista.add(new Coche("6433G","MERCEDES","CLASE-E"));
		lista.add(new Coche("2133T","FORD","MUSTANG"));
		lista.add(new Coche("9113J","TOYOTA","COROLLA"));
		lista.add(new Coche("5284P","MERCEDES","CLASE-G"));
		lista.add(new Coche("8255L","FORD","FIESTA"));
		lista.add(new Coche("1235N","KIA","CEED"));
		lista.add(new Coche("5312M","MERCEDES","CLASE-C"));
		lista.add(new Coche("7351W","TOYOTA","YARIS"));
		
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
