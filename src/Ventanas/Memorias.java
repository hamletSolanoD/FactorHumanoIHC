package Ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;


import ElementosPersonalizados.PanelGuia;
import ElementosPersonalizados.SonidoClip;
import PaquetePrincipal.Constantes;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Memorias extends JFrame  implements ActionListener{
	SonidoClip MenuAudio =  new SonidoClip("/MemoriasMenuAudio.wav");
	SonidoClip MemoriaSensorial =  new SonidoClip("/sensorial.wav");
	SonidoClip memoriaCorto =  new SonidoClip("/trabajo.wav");
	SonidoClip Largo =  new SonidoClip("/largoplazo.wav");

	private void PararAudios() {
		MenuAudio.stop();
		MemoriaSensorial.stop();
		Largo.stop();	
		memoriaCorto.stop();
	}

	
	public void dispose() {
		PararAudios();
		super.dispose();
	}
	private JPanel contentPane;
	public Memorias() {
	rootPane.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
		
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				PararAudios();
				MenuAudio.loop();

			}
		});
		PararAudios();
		MenuAudio.loop();
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("S"),"Inicio");
		((JComponent)this.rootPane).getActionMap().put("Inicio", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					new Portada();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} dispose();	}
		});
		getContentPane().setBackground(Constantes.ColorFondo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0 ,2*(Constantes.ComputadoraWidth/3), 3*(Constantes.ComputadoraHeight/4));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("COGNICIÓN​");
		lblNewLabel.setForeground(Constantes.ColorTitulos);
		lblNewLabel.setFont(Constantes.Titulos);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Constantes.ColorFondo);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut_1 = Box.createVerticalStrut(108);
		panel.add(verticalStrut_1, BorderLayout.NORTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut = Box.createVerticalStrut(163);
		panel.add(verticalStrut, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Constantes.ColorFondo);
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = Constantes.BotonRedondeado("Pasado");
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("Z"),"Pasado");
		((JComponent)this.rootPane).getActionMap().put("Pasado", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PararAudios();
					MemoriaSensorial.loop();
				Plantilla_Ventanas plantilla = 	new Plantilla_Ventanas("MEMORIA SENSORIAL","La memoria sensorial sirve como una memoria de buffer que almacena por mil\u00e8simas de segundo las percepciones de est\u00edmulos externos, muy vol\u00e1tiles, que esperan ser pasados a la memoria de corto plazo y poder ser analizados por el proceso central.​\n\n"
							+ "este tipo de memoria representa el inicio de la transmisi\u00f3n de entrada y suele ser r\u00e1pida y muy variable, para su verdadero impacto se necesitan est\u00edmulos elevados y contundentes.​",ImageIO.read(this.getClass().getResource("/sensorial.jpg")),"");
				
				((JComponent)plantilla.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"REP");
				((JComponent)plantilla.getRootPane()).getActionMap().put("REP",new AbstractAction() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						PararAudios();
						MemoriaSensorial.loop();
					}
				});
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					}
		});
		btnNewButton.setText("SENSORIAL");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("SENSORIAL");
		panel_1.add(btnNewButton);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2);
		
		JButton btnNewButton_1_1 = Constantes.BotonRedondeado("Presente");
		btnNewButton_1_1.setText("CORTO");
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("X"),"CORTO");
		((JComponent)this.rootPane).getActionMap().put("CORTO", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PararAudios();
					memoriaCorto.loop();
				Plantilla_Ventanas p =	new Plantilla_Ventanas("MEMORIA DE TRABAJO​","Una combinaci\u00f3n entre percepci\u00f3n y atenci\u00f3n a lo realizado, "
							+ "vol\u00e1til y de baja capacidad, nos permite tener el intermedio de saber que estamos haciendo, "
							+ "pero no el razonarlo por completo; nos permite desarrollar alguna actividad, pero terminando cada"
							+ " parte de ella ser\u00e1 f\u00e1cilmente eliminada.​\n\nMemoria que nos permite enfocarnos en ciertas actividades, "
							+ "pero es r\u00e1pidamente intercambiable entre ellas.\n\n"
							+ "Al ser una memoria de f\u00e1cil procesamiento m\u00e1s automatizada que realmente premeditada el objetivo es que el usuario pueda interactuar lo m\u00e1s f\u00e1cilmente posible con ella en nuestras aplicaciones siendo casi completamente impulsivo la interacci\u00f3n y as\u00ed disminuyendo la fatiga intelectual y provocando mayor satisfacci\u00f3n en la experiencia.​​",ImageIO.read(this.getClass().getResource("/corto.png")),"​");
				
				((JComponent)p.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"rep");
				((JComponent)p.getRootPane()).getActionMap().put("rep",new AbstractAction() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						PararAudios();
						memoriaCorto.loop();
					}
				});
				}
				catch(Exception e) {
					}
				}
				
			});
				
		btnNewButton_1_1.addActionListener(this);
		btnNewButton_1_1.setActionCommand("TRABAJO");
		panel_1.add(btnNewButton_1_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3);
		
		JButton btnNewButton_1 = Constantes.BotonRedondeado("Futuro");
		btnNewButton_1.setText("LARGO");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("LARGO");
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("C"),"LAR");
		((JComponent)this.rootPane).getActionMap().put("LAR", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PararAudios();
					Largo.loop();
					Plantilla_Ventanas p =	new Plantilla_Ventanas("MEMORIA A LARGO PLAZO","Memoria procesada despu\u00e8s del anterior seguimiento, se considera el resumen de todo el razonamiento y sensaci\u00f3n anterior; llega a ser demasiado personal y altamente influenciable por las emociones, est\u00e1 sujeta a las idealizaciones y corrupci\u00f3n de la verdad conforme pasa el tiempo.\n\nEs completamente variable en todo sujeto y por lo tanto es poco confiable el juicio de una sola persona; igualmente es dif\u00edcil de satisfacer el recuerdo a largo plazo de todos.​\n\nEl objetivo de toda interfaz es ser recordada como positiva y agradable, el mayor deseo de todo desarrollador seria poder haber desarrollado algo que la gente disfrute con positividad y hasta sea capaz de recomendar con emoci\u00f3n.​\n\nPor tanto, para lograr este \u00f9ltimo objetivo es necesario el desglose de todas las secciones anteriores para al finalizar el cliente se encuentre satisfecho.",ImageIO.read(this.getClass().getResource("/largo.png")),"");
					((JComponent)p.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"rep");
					((JComponent)p.getRootPane()).getActionMap().put("rep",new AbstractAction() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							PararAudios();
							Largo.loop();
						}
					});
				
				
				
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					}
		});
		panel_1.add(btnNewButton_1);
		
		
		PanelGuia panelguia = new PanelGuia(this);
		getContentPane().add(panelguia,BorderLayout.SOUTH);
		
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("A"),"ANTE");
		((JComponent)this.rootPane).getActionMap().put("ANTE", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new PrincipioGESTAL();  dispose(); 
					}
		});
		
		
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("D"),"DESP");
		((JComponent)this.rootPane).getActionMap().put("DESP", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CarDeApoyo();  dispose();
					}
		});
		
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Anterior": new PrincipioGESTAL();  dispose(); break;
		case "Siguiente": new CarDeApoyo();  dispose(); break;
		case "SENSORIAL": 
			try {
				new Plantilla_Ventanas("MEMORIA SENSORIAL","La memoria sensorial sirve como una memoria de buffer que almacena por mil\u00e8simas de segundo las percepciones de est\u00edmulos externos, muy vol\u00e1tiles, que esperan ser pasados a la memoria de corto plazo y poder ser analizados por el proceso central.​\n\n"
						+ "este tipo de memoria representa el inicio de la transmisi\u00f3n de entrada y suele ser r\u00e1pida y muy variable, para su verdadero impacto se necesitan est\u00edmulos elevados y contundentes.​",ImageIO.read(this.getClass().getResource("/sensorial.jpg")),"");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
		case "TRABAJO":
			try {
				new Plantilla_Ventanas("MEMORIA DE TRABAJO​","Una combinaci\u00f3n entre percepci\u00f3n y atenci\u00f3n a lo realizado, "
						+ "vol\u00e1til y de baja capacidad, nos permite tener el intermedio de saber que estamos haciendo, "
						+ "pero no el razonarlo por completo; nos permite desarrollar alguna actividad, pero terminando cada"
						+ " parte de ella ser\u00e1 f\u00e1cilmente eliminada.​\n\nMemoria que nos permite enfocarnos en ciertas actividades, "
						+ "pero es r\u00e1pidamente intercambiable entre ellas.\n\n"
						+ "Al ser una memoria de f\u00e1cil procesamiento m\u00e1s automatizada que realmente premeditada el objetivo es que el usuario pueda interactuar lo m\u00e1s f\u00e1cilmente posible con ella en nuestras aplicaciones siendo casi completamente impulsivo la interacci\u00f3n y as\u00ed disminuyendo la fatiga intelectual y provocando mayor satisfacci\u00f3n en la experiencia.​​",ImageIO.read(this.getClass().getResource("/corto.png")),"​");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
		case "LARGO": 
			try {
				new Plantilla_Ventanas("MEMORIA A LARGO PLAZO","Memoria procesada despu\u00e8s del anterior seguimiento, se considera el resumen de todo el razonamiento y sensaci\u00f3n anterior; llega a ser demasiado personal y altamente influenciable por las emociones, est\u00e1 sujeta a las idealizaciones y corrupci\u00f3n de la verdad conforme pasa el tiempo.\n\nEs completamente variable en todo sujeto y por lo tanto es poco confiable el juicio de una sola persona; igualmente es dif\u00edcil de satisfacer el recuerdo a largo plazo de todos.​\n\nEl objetivo de toda interfaz es ser recordada como positiva y agradable, el mayor deseo de todo desarrollador seria poder haber desarrollado algo que la gente disfrute con positividad y hasta sea capaz de recomendar con emoci\u00f3n.​\n\nPor tanto, para lograr este \u00f9ltimo objetivo es necesario el desglose de todas las secciones anteriores para al finalizar el cliente se encuentre satisfecho.",ImageIO.read(this.getClass().getResource("/largo.png")),"");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Inicio": try {
			new Portada();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} dispose(); break;
		
		
		}
	}

}
