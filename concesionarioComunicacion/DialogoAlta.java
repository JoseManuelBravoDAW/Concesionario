package concesionarioComunicacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionarioNegocio.Color;
import concesionarioNegocio.Marca;
import concesionarioNegocio.Modelo;
import exceptions.CocheNoExisteException;
import exceptions.CocheYaExisteException;
import exceptions.ColorNoValidoException;
import exceptions.MatriculaNoValidaException;
import exceptions.ModeloNoValidoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAlta extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected JTextField txtMatricula;
	protected ButtonGroup bg;
	protected JRadioButton rdbtnRojo;
	protected JRadioButton rdbtnAzul;
	protected JRadioButton rdbtnPlateado;
	protected JComboBox<Modelo> comboBoxModelo;
	protected JComboBox<String> comboBoxMarca;
	protected JButton okButton;
	protected JButton cancelButton;
	
	

	/**
	 * Create the dialog.
	 */
	public DialogoAlta() {
		setTitle("Crear coche");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setBounds(25, 55, 89, 14);
		contentPanel.add(lblMatrcula);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(82, 52, 86, 20);
		contentPanel.add(txtMatricula);
		txtMatricula.setColumns(10);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(26, 100, 46, 14);
		contentPanel.add(lblColor);

		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBounds(78, 96, 60, 23);
		contentPanel.add(rdbtnRojo);

		rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(161, 96, 60, 23);
		contentPanel.add(rdbtnAzul);

		rdbtnPlateado = new JRadioButton("Plateado");
		rdbtnPlateado.setBounds(235, 96, 75, 23);
		contentPanel.add(rdbtnPlateado);

		bg = new ButtonGroup();

		bg.add(rdbtnRojo);
		bg.add(rdbtnAzul);
		bg.add(rdbtnPlateado);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(26, 144, 46, 14);
		contentPanel.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(26, 189, 46, 14);
		contentPanel.add(lblModelo);

		Modelo[] ArrayModelosBMW = { Modelo.SERIE1, Modelo.SERIE2, Modelo.SERIE3, Modelo.SERIE5 };

		DefaultComboBoxModel<Modelo> modelosBMW = new DefaultComboBoxModel<Modelo>(ArrayModelosBMW);

		Modelo[] ArrayModelosSEAT = { Modelo.CORDOBA, Modelo.IBIZA, Modelo.TOLEDO };

		DefaultComboBoxModel<Modelo> modelosSEAT = new DefaultComboBoxModel<Modelo>(ArrayModelosSEAT);

		comboBoxModelo = new JComboBox<Modelo>();
		;
		comboBoxModelo.setBounds(82, 185, 130, 22);
		contentPanel.add(comboBoxModelo);
		comboBoxModelo.setModel(modelosSEAT);

		comboBoxMarca = new JComboBox(Marca.values());

		comboBoxMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBoxMarca.getSelectedItem() == Marca.BMW) {

					comboBoxModelo.setModel(modelosBMW);

				}

				if (comboBoxMarca.getSelectedItem() == Marca.SEAT) {

					comboBoxModelo.setModel(modelosSEAT);

				}

			}
		});
		comboBoxMarca.setBounds(82, 140, 75, 22);
		contentPanel.add(comboBoxMarca);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("A\u00F1adir");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							accionBotonIzquierda();
						} catch (CocheNoExisteException e1) {
							JOptionPane.showMessageDialog(contentPanel, "No existe ningun coche con esa matrícula en el concesionario.", "Coche no existe",
									JOptionPane.WARNING_MESSAGE);
						} catch (MatriculaNoValidaException e1) {
							JOptionPane.showMessageDialog(contentPanel,
									"Esa matrícula no es válida. \n\nUna matrícula válida consta\n de 4 números y 3 letras en\n mayúscula, sin incluir\n vocales, ñ ni ll",
									"Matrícula no válida", JOptionPane.WARNING_MESSAGE);
						}catch (CocheYaExisteException e1) {
							JOptionPane.showMessageDialog(contentPanel, "Ya existe un coche con esa matrícula.", "Coche ya existe",
									JOptionPane.WARNING_MESSAGE);
						} catch (ModeloNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel, "Modelo de coche no válido", "Modelo no válido",
									JOptionPane.WARNING_MESSAGE);
						}catch (ColorNoValidoException e1) {
							JOptionPane.showMessageDialog(contentPanel, "No has elegido un color válido.", "Color no válido",
									JOptionPane.WARNING_MESSAGE);
						}

					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Atras");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						accionBotonDerecha();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	

	protected void accionBotonIzquierda() throws CocheNoExisteException, MatriculaNoValidaException, CocheYaExisteException, ModeloNoValidoException, ColorNoValidoException {
		Color color = null;

		if (rdbtnRojo.isSelected())
			color = Color.ROJO;
		if (rdbtnAzul.isSelected())
			color = Color.AZUL;
		if (rdbtnPlateado.isSelected())
			color = Color.PLATA;

		
			ConcesionarioGUI.concesionario.anadirCoche((Modelo) comboBoxModelo.getSelectedItem(), color,
					txtMatricula.getText());
			txtMatricula.setText("");
			JOptionPane.showMessageDialog(contentPanel, "Coche dado de alta con éxito.", "Alta",
					JOptionPane.INFORMATION_MESSAGE);
			bg.clearSelection();

		
	}
	
	protected void accionBotonDerecha() {
		setVisible(false);
	}
}
