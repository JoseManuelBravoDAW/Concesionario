package concesionarioNegocio;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.ColorNoValidoException;
import exceptions.MatriculaNoValidaException;
import exceptions.ModeloNoValidoException;

public class Coche implements Serializable{

	private static final Pattern pattern = Pattern.compile("\\d{4}[ -]?[B-Z&&[^ÑQEIOU]]{3}");
	
	private Modelo modelo;
	private Color color;
	private String matricula;
	
	Coche(Modelo modelo, Color color, String matricula) throws ModeloNoValidoException, ColorNoValidoException, MatriculaNoValidaException{
		
		setModelo(modelo);
		setColor(color);
		setMatricula(matricula);
	}
	
	Coche(String matricula) throws MatriculaNoValidaException{
		setMatricula(matricula);
	}

	public Modelo getModelo() {
		return modelo;
	}

	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		
		if(modelo == null)
			throw new ModeloNoValidoException("\nEl modelo no es válido.");
		else
			this.modelo = modelo;
	}

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) throws ColorNoValidoException {
		
		if(color == null)
			throw new ColorNoValidoException("\nEl color no es válido.");
		else 
			this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) throws MatriculaNoValidaException{
		
		Matcher matcher = pattern.matcher(matricula.trim());
		
		if(matcher.matches()) {
			matricula = matricula.replace("-", "");
			matricula = matricula.replace(" ", "");
			this.matricula = matricula;
		}
		else
			throw new MatriculaNoValidaException("\nLa matrícula no es válida.");
	}
	
	public String toString() {
		return modelo + ", " + color + ", " + matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
}
