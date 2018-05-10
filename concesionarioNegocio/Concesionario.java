package concesionarioNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

import exceptions.CocheNoExisteException;
import exceptions.CocheYaExisteException;
import exceptions.ColorNoValidoException;
import exceptions.MatriculaNoValidaException;
import exceptions.ModeloNoValidoException;

public class Concesionario implements Serializable{

	private ArrayList<Coche> concesionario;
	
	public Concesionario(){
		concesionario = new ArrayList<Coche>();
		Modificacion.resetear();
	}
	
	public void anadirCoche(Modelo modelo, Color color, String matricula) throws CocheYaExisteException, ModeloNoValidoException, ColorNoValidoException, MatriculaNoValidaException {
		
		Coche coche = new Coche(modelo, color, matricula);
		
		if(concesionario.contains(coche))
			throw new CocheYaExisteException("\nEse coche ya existe.");
		else {
			concesionario.add(coche);
			Modificacion.setModificado(true);
		}
			

	}
	
	public void eliminarCoche(String matricula) throws CocheNoExisteException, MatriculaNoValidaException {
		
		Coche coche = new Coche(matricula);
		
		if(concesionario.contains(coche)) {
			concesionario.remove(coche);
			Modificacion.setModificado(true);
		}else 
			throw new CocheNoExisteException("\nEse coche no existe.");
	}
	
	public Coche getCoche(String matricula) throws CocheNoExisteException, MatriculaNoValidaException {
		
		try {
			return concesionario.get(concesionario.indexOf(new Coche(matricula)));
		} catch (IndexOutOfBoundsException e) {
			throw new CocheNoExisteException("\nEse coche no existe.");
		}
		
	
	}
	
	public int contar() {
		return concesionario.size();
	}
	
	public String mostrarPorColor(Color color) {
		
		String s = "";
		
		for(Coche c : concesionario) {
			if(c.getColor() == color)
				s += c + "\n";
				
		}
		
		if(s.equals(""))
			return "\nNo hay coches de este color...";
		
		return s;
	}
	
	public ListIterator<Coche> getListIteratorPorColor(Color color){
		
		ArrayList<Coche> coches = new ArrayList<>();
		
		for(Coche c : concesionario) {
			if(c.getColor() == color)
				coches.add(c);
		}
		
		return coches.listIterator();
	}
	
	public String mostrarConcesionario() {
		
		String s = "";
		
		if(!concesionario.isEmpty()) {
			s = "\n-COCHES EN EL CONCESIONARIO-\n";
			for(Coche c : concesionario) {
				s += c + "\n";
			}
		}else
			s = "\nEl concesionario está vacío...";
		
		
		return s;
	}

	
	public ListIterator<Coche> ListIterator() {
		
		return concesionario.listIterator();
	}
	
	
	
	
}
