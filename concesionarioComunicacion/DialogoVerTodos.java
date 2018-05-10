package concesionarioComunicacion;

import java.util.ListIterator;

import concesionarioNegocio.Coche;

public class DialogoVerTodos extends DialogoVer {

	ListIterator<Coche> coches;
	private boolean atrasHaSidoPulsado = false;
	private boolean adelanteHaSidoPulsado = false;

	public DialogoVerTodos() {
		super();
		setTitle("Ver todos");
		coches = ConcesionarioGUI.concesionario.ListIterator();
		txtMatricula.setEditable(false);
		okButton.setText("<");
		cancelButton.setText(">");
		okButton.setEnabled(false);
		if (ConcesionarioGUI.concesionario.contar() == 0)
			cancelButton.setEnabled(false);
		else {
			Coche c = coches.next();
			
			txtMatricula.setText(c.getMatricula());

			switch (c.getColor()) {

			case ROJO:
				rdbtnRojo.setSelected(true);
				break;
			case AZUL:
				rdbtnAzul.setSelected(true);
				break;
			case PLATA:
				rdbtnPlateado.setSelected(true);
				break;
				}

			comboBoxMarca.setSelectedItem(c.getModelo().getMarca());
			comboBoxModelo.setSelectedItem(c.getModelo());
			
			if (!coches.hasNext())
				cancelButton.setEnabled(false);

			}
		
		

	}

	@Override
	protected void accionBotonIzquierda() {
		
		atrasHaSidoPulsado = true;
		
		cancelButton.setEnabled(true);
		
		Coche c;
		
		if(!coches.hasNext() || adelanteHaSidoPulsado) {
			coches.previous();
			c = coches.previous();
			if(adelanteHaSidoPulsado)
				adelanteHaSidoPulsado = false;
		}
		else
			c = coches.previous();

		txtMatricula.setText(c.getMatricula());
			
		switch (c.getColor()) {

		case ROJO:
			rdbtnRojo.setSelected(true);
			break;
		case AZUL:
			rdbtnAzul.setSelected(true);
			break;
		case PLATA:
			rdbtnPlateado.setSelected(true);
			break;
		}

		comboBoxMarca.setSelectedItem(c.getModelo().getMarca());
		comboBoxModelo.setSelectedItem(c.getModelo());
			
		if (!coches.hasPrevious())
			okButton.setEnabled(false);
		

	}

	@Override
	protected void accionBotonDerecha() {

		adelanteHaSidoPulsado = true;
		
		okButton.setEnabled(true);
		
		Coche c;
		
		if(!coches.hasPrevious() || atrasHaSidoPulsado) {
			coches.next();
			c = coches.next();
			if(atrasHaSidoPulsado)
				atrasHaSidoPulsado = false;
		}
		else
			c = coches.next();
			
		txtMatricula.setText(c.getMatricula());

		switch (c.getColor()) {

		case ROJO:
			rdbtnRojo.setSelected(true);
			break;
		case AZUL:
			rdbtnAzul.setSelected(true);
			break;
		case PLATA:
			rdbtnPlateado.setSelected(true);
			break;
			}

		comboBoxMarca.setSelectedItem(c.getModelo().getMarca());
		comboBoxModelo.setSelectedItem(c.getModelo());
			
		if (!coches.hasNext())
			cancelButton.setEnabled(false);

		}

	
}
