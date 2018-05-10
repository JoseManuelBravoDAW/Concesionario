package concesionarioComunicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import concesionarioNegocio.Coche;
import concesionarioNegocio.Color;

public class DialogoVerPorColor extends DialogoVer {

	ListIterator<Coche> coches;
	private boolean atrasHaSidoPulsado = false;
	private boolean adelanteHaSidoPulsado = false;

	public DialogoVerPorColor() {
		super();
		setTitle("Ver por color");
		txtMatricula.setEditable(false);
		okButton.setText("<");
		okButton.setEnabled(false);
		cancelButton.setText(">");
		cancelButton.setEnabled(false);
		rdbtnRojo.setEnabled(true);
		rdbtnAzul.setEnabled(true);
		rdbtnPlateado.setEnabled(true);
		
		rdbtnRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				atrasHaSidoPulsado = false;
				adelanteHaSidoPulsado = false;
				
				coches = ConcesionarioGUI.concesionario.getListIteratorPorColor(Color.ROJO);

				if (!coches.hasPrevious() && !coches.hasNext()) {
					txtMatricula.setText("No hay coches");
					cancelButton.setEnabled(false);
				} else {
					Coche c = coches.next();
					txtMatricula.setText(c.getMatricula());
					comboBoxMarca.setSelectedItem(c.getModelo().getMarca());
					comboBoxModelo.setSelectedItem(c.getModelo());
				}

				if (coches.hasNext())
					cancelButton.setEnabled(true);
				else
					cancelButton.setEnabled(false);
				
				okButton.setEnabled(false);
			}
		});

		rdbtnAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				atrasHaSidoPulsado = false;
				adelanteHaSidoPulsado = false;
				
				coches = ConcesionarioGUI.concesionario.getListIteratorPorColor(Color.AZUL);

				if (!coches.hasPrevious() && !coches.hasNext()) {
					txtMatricula.setText("No hay coches");
					cancelButton.setEnabled(false);
				} else {
					Coche c = coches.next();
					txtMatricula.setText(c.getMatricula());
					comboBoxMarca.setSelectedItem(c.getModelo().getMarca());
					comboBoxModelo.setSelectedItem(c.getModelo());
				}
				if (coches.hasNext())
					cancelButton.setEnabled(true);
				else
					cancelButton.setEnabled(false);
				
				okButton.setEnabled(false);
			}
		});

		rdbtnPlateado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				atrasHaSidoPulsado = false;
				adelanteHaSidoPulsado = false;
				
				coches = ConcesionarioGUI.concesionario.getListIteratorPorColor(Color.PLATA);

				if (!coches.hasPrevious() && !coches.hasNext()) {
					txtMatricula.setText("No hay coches");
					cancelButton.setEnabled(false);
				} else {
					Coche c = coches.next();
					txtMatricula.setText(c.getMatricula());
					comboBoxMarca.setSelectedItem(c.getModelo().getMarca());
					comboBoxModelo.setSelectedItem(c.getModelo());
				}
				if (coches.hasNext())
					cancelButton.setEnabled(true);
				else
					cancelButton.setEnabled(false);
				
				okButton.setEnabled(false);
			}
		});
	}

	@Override
	protected void accionBotonIzquierda() {

		atrasHaSidoPulsado = true;
		cancelButton.setEnabled(true);

		Coche c;

		if (!coches.hasNext() || adelanteHaSidoPulsado) {
			coches.previous();
			c = coches.previous();
			if (adelanteHaSidoPulsado)
				adelanteHaSidoPulsado = false;
		} else
			c = coches.previous();
		
		
		txtMatricula.setText(c.getMatricula());
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

		if (!coches.hasPrevious() || atrasHaSidoPulsado) {
			coches.next();
			c = coches.next();
			if (atrasHaSidoPulsado)
				atrasHaSidoPulsado = false;
		} else
			c = coches.next();

		txtMatricula.setText(c.getMatricula());
		comboBoxMarca.setSelectedItem(c.getModelo().getMarca());
		comboBoxModelo.setSelectedItem(c.getModelo());

		if (!coches.hasNext())
			cancelButton.setEnabled(false);

	}

}
