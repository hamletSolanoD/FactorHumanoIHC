package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import ElementosPersonalizados.PanelGuia;
import ElementosPersonalizados.SonidoClip;
import PaquetePrincipal.Constantes;
import javax.swing.JLabel;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;

public class Introduccion extends JFrame implements ActionListener {
	SonidoClip MenuAudio =  new SonidoClip("/IntroduccionMenuAudioReal.wav");
	SonidoClip psicologiainterfaces =  new SonidoClip("/psicologiaintefaces.wav");
	SonidoClip objetivoInterfaces =  new SonidoClip("/objetivo-interfaces.wav");
	SonidoClip personasProcesadores =  new SonidoClip("/percompro.wav");
			
	private void pararReproducciones() {
		MenuAudio.stop();
		psicologiainterfaces.stop();
		objetivoInterfaces.stop();
		personasProcesadores.stop();
	}


	public void dispose() {
		
		pararReproducciones();
		super.dispose();
	}
	public Introduccion() {
	rootPane.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				

			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				pararReproducciones();
				MenuAudio.loop();
			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("E"),"REPRODUCIR");
		((JComponent)this.rootPane).getActionMap().put("REPRODUCIR", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			pararReproducciones();
			MenuAudio.loop();
			
				
			}
		});
		getContentPane().setBackground(Constantes.ColorFondo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0 ,9*(Constantes.ComputadoraWidth/10), 3*(Constantes.ComputadoraHeight/4));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Constantes.ColorFondo);
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("INTRODUCCION");
		lblNewLabel.setForeground(Constantes.ColorTitulos);
		lblNewLabel.setFont(Constantes.Titulos);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Constantes.ColorFondo);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Constantes.ColorFondo);
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = Constantes.BotonRedondeado("Psicolog\u00eda de Interfaces" );
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(18f));
		btnNewButton.setActionCommand("1");
		panel_2.add(btnNewButton);
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("Z"),"PSI");
		((JComponent)this.rootPane).getActionMap().put("PSI", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pararReproducciones();
				psicologiainterfaces.loop();
				// TODO Auto-generated method stub
				try {
				Plantilla_Ventanas C = 	new Plantilla_Ventanas("PSICOLOGÍA DE DISEÑO DE INTERFACES​","Las personas no desean esforzarse m\u00e1s de lo necesario en algo que no les interesa.​\n\n"
							+ "Las personas pueden tener limitaciones.​\n\n"
							+ "Las personas son propensas a cometer errores o malinterpretar la informaci\u00f3n​\n\n"
							+ "Las personas crean prejuicios a primera vista​\n\n"
							+ "Las personas son sensibles y con gran capacidad de relacionar pensamientos con experiencia.​\n\n",ImageIO.read(getClass().getResource("/psinter.png")),"");
				
				((JComponent)C.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"PSICOLO");
				((JComponent)C.getRootPane()).getActionMap().put("PSICOLO", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						pararReproducciones();
						psicologiainterfaces.loop();
					}
				});
				
				
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		
		
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_2);
		
		JButton btnNewButton_1 = Constantes.BotonRedondeado("Objetivo Interfaces");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("2");
		btnNewButton_1.setFont(btnNewButton.getFont().deriveFont(18f));
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("X"),"INTER");
		((JComponent)this.rootPane).getActionMap().put("INTER", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					pararReproducciones();

					objetivoInterfaces.loop();
					Plantilla_Ventanas p = new Plantilla_Ventanas("OBJETIVO DE LAS INTERFACES","El objetivo de toda interfaz es la provocar la mejor experiencia para el usuario. Siendo as\u00ed una forma de poder quedarse gravado pasando por los procesos sensoriales (memoria sensorial) , memoria a corto plazo y quedar como algo placentero en la memoria a largo plazo​",ImageIO.read(getClass().getResource("/UX.png")),"");
					((JComponent)p.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"PSICOLO");
					((JComponent)p.getRootPane()).getActionMap().put("PSICOLO", new AbstractAction() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							pararReproducciones();
							objetivoInterfaces.loop();
						}
					});
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		

		panel_2.add(btnNewButton_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_3);
		
		JButton btnNewButton_2 = Constantes.BotonRedondeado("Personas / Procesadores ");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setFont(btnNewButton.getFont().deriveFont(18f));
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("C"),"PERSON");
		((JComponent)this.rootPane).getActionMap().put("PERSON", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					pararReproducciones();

					personasProcesadores.loop();
					Plantilla_Ventanas p =  new Plantilla_Ventanas("PERSONAS COMO PROCESADORES DE INFORMACIÓN​","A una r\u00e1pida simplificaci\u00f3n se puede reconstruir a cada usuario como una m\u00e1quina que procesa informaci\u00f3n, de esta forma nos es m\u00e1s f\u00e1cil apuntar a cada objetivo de su experiencia.​",ImageIO.read(getClass().getResource("/PersonasComoProcesadores.png")),"");
					((JComponent)p.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"PSICOLO");
					((JComponent)p.getRootPane()).getActionMap().put("PSICOLO", new AbstractAction() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							pararReproducciones();
							personasProcesadores.loop();
						}
					});
				
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
			
				}
			}
		});
		btnNewButton_2.setActionCommand("3");
		panel_2.add(btnNewButton_2);
		
		Component verticalStrut_3 = Box.createVerticalStrut(93);
		panel_1.add(verticalStrut_3, BorderLayout.NORTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1_1, BorderLayout.WEST);
		
		Component verticalStrut_2 = Box.createVerticalStrut(171);
		panel_1.add(verticalStrut_2, BorderLayout.SOUTH);
		
		
		PanelGuia panelguia = new PanelGuia(this);
		getContentPane().add(panelguia,BorderLayout.SOUTH);		
		
		
		
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("A"),"ANTERIOR");
		((JComponent)this.rootPane).getActionMap().put("ANTERIOR", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 try {
						new Portada();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  pararReproducciones(); dispose();
				
			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("D"),"SIG");
		((JComponent)this.rootPane).getActionMap().put("SIG", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SistemasDeEntradaYSalida();  pararReproducciones(); dispose();
			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("S"),"INC");
		((JComponent)this.rootPane).getActionMap().put("INC", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					new Portada();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  pararReproducciones(); dispose();
			}
		});
	
	setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()){
		case "1" :
			try {
				 new Plantilla_Ventanas("PSICOLOGÍA DE DISEÑO DE INTERFACES​","Las personas no desean esforzarse m\u00e1s de lo necesario en algo que no les interesa.​\n\n"
						+ "Las personas pueden tener limitaciones.​\n\n"
						+ "Las personas son propensas a cometer errores o malinterpretar la informaci\u00f3n​\n\n"
						+ "Las personas crean prejuicios a primera vista​\n\n"
						+ "Las personas son sensibles y con gran capacidad de relacionar pensamientos con experiencia.​\n\n",ImageIO.read(getClass().getResource("/psinter.png")),"");
			
			
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			break;
		case "2" :
			
			try {
				new Plantilla_Ventanas("OBJETIVO DE LAS INTERFACES","El objetivo de toda interfaz es la provocar la mejor experiencia para el usuario. Siendo as\u00ed una forma de poder quedarse gravado pasando por los procesos sensoriales (memoria sensorial) , memoria a corto plazo y quedar como algo placentero en la memoria a largo plazo​",ImageIO.read(getClass().getResource("/UX.png")),"");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "3" :
			
			try {
				new Plantilla_Ventanas("PERSONAS COMO PROCESADORES DE INFORMACIÓN​","A una r\u00e1pida simplificaci\u00f3n se puede reconstruir a cada usuario como una m\u00e1quina que procesa informaci\u00f3n, de esta forma nos es m\u00e1s f\u00e1cil apuntar a cada objetivo de su experiencia.​",ImageIO.read(getClass().getResource("/PersonasComoProcesadores.png")),"");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
		
			}
			break;
		case "Siguiente" : new SistemasDeEntradaYSalida();  pararReproducciones(); dispose();break;
		case "Anterior" : try {
				new Portada();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  pararReproducciones(); dispose();break;

		case "Inicio": try {
				new Portada();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  pararReproducciones(); dispose(); break;
		
		}
	}


}
