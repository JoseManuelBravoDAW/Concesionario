package concesionarioComunicacion;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import concesionarioNegocio.Concesionario;
import concesionarioNegocio.Modificacion;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class ConcesionarioGUI {

	private JFrame frmConcesionario;
	static Concesionario concesionario = new Concesionario();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcesionarioGUI window = new ConcesionarioGUI();
					window.frmConcesionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	/**
	 * Create the application.
	 */
	public ConcesionarioGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConcesionario = new JFrame();
		frmConcesionario.setTitle("Concesionario - " + Modificacion.getNombreFichero());
		frmConcesionario.setResizable(false);
		frmConcesionario.setBounds(100, 100, 450, 300);
		frmConcesionario.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		frmConcesionario.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent we) {
			    
				  if(!Modificacion.isModificado()) {
					  System.exit(0);
				  }
				  else {
					  int opcion = JOptionPane.showConfirmDialog(frmConcesionario, "¿Desea guardar los cambios hechos a " + Modificacion.getNombreFichero() + "?", "Hay cambios sin guardar", JOptionPane.YES_NO_CANCEL_OPTION);
						
						switch(opcion) {
						
						case JOptionPane.OK_OPTION:
							
							guardar();
							System.exit(0);
							
							break;
							
						case JOptionPane.NO_OPTION:
							
							System.exit(0);
							
							break;
							
						}
				  }
			    
			  }
			});
		
		
		JMenuBar menuBar = new JMenuBar();
		frmConcesionario.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!Modificacion.isModificado()) {
					concesionario = new Concesionario();
					frmConcesionario.setTitle("Concesionario - " + Modificacion.getNombreFichero());
				}
				else {
					
					int opcion = JOptionPane.showConfirmDialog(frmConcesionario, "¿Desea guardar los cambios hechos a " + Modificacion.getNombreFichero() + "?", "Hay cambios sin guardar", JOptionPane.YES_NO_CANCEL_OPTION);
					
					switch(opcion) {
					
					case JOptionPane.OK_OPTION:
						
						guardar();
						concesionario = new Concesionario();
						frmConcesionario.setTitle("Concesionario - " + Modificacion.getNombreFichero());
						
						break;
						
					case JOptionPane.NO_OPTION:
						
						concesionario = new Concesionario();
						
						break;
						
					}
				}
				
			}
		});
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
				
				fc.setFileFilter(new ObjFilter());
				
				int returnVal = fc.showOpenDialog(frmConcesionario);
				
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					
					try {
						concesionario = Modificacion.leer(fc.getSelectedFile().getName(), fc.getSelectedFile().getCanonicalPath());
						frmConcesionario.setTitle(Modificacion.getNombreFichero());
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
				}
			}
		});
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				guardar();
				
				
				
			}
		});
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				guardarComo();
				
			}

		});
		mnArchivo.add(mntmGuardarComo);
		
		JMenu mnCoches = new JMenu("Coches");
		menuBar.add(mnCoches);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DialogoAlta dialog = new DialogoAlta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		mnCoches.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DialogoBaja db = new DialogoBaja();
				db.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				db.setVisible(true);
				
			}
		});
		mnCoches.add(mntmBaja);
		
		JMenuItem mntmVer = new JMenuItem("Ver");
		mntmVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DialogoVer dv = new DialogoVer();
				dv.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dv.setVisible(true);
				
				
			}
		});
		mnCoches.add(mntmVer);
		
		JMenuItem mntmVerPorColor = new JMenuItem("Ver por color");
		mntmVerPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DialogoVerPorColor dvc = new DialogoVerPorColor();
				dvc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dvc.setVisible(true);
				
			}
		});
		mnCoches.add(mntmVerPorColor);
		
		JMenuItem mntmVerTodos = new JMenuItem("Ver todos");
		mntmVerTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DialogoVerTodos dvt = new DialogoVerTodos();
				dvt.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dvt.setVisible(true);
				
			}
		});
		mnCoches.add(mntmVerTodos);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ver la ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DialogoAyuda dialog = new DialogoAyuda();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
				
			}
		});
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(frmConcesionario, "Creado por José Manuel Bravo Martínez\nMayo de 2018\nIES Gran Capitán", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		mnAyuda.add(mntmAcercaDe);
		frmConcesionario.getContentPane().setLayout(null);
	}
	
	private void guardarComo() {
		JFileChooser fc = new JFileChooser();
		
		fc.setFileFilter(new ObjFilter());
		
		int returnVal = fc.showSaveDialog(frmConcesionario);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			
			try {
				Modificacion.escribir(concesionario, fc.getSelectedFile().getName() ,fc.getSelectedFile().getCanonicalPath());
				frmConcesionario.setTitle(Modificacion.getNombreFichero());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}



	private void guardar() {
		if(!Modificacion.getNombreFichero().equals("Sin título")) {
			try {
				Modificacion.escribir(concesionario, Modificacion.getNombreFichero(), Modificacion.getUbicacionFichero());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			guardarComo();
		}
	}
}
