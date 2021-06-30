package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ElementosPersonalizados.BotonesEnCascada;
import ElementosPersonalizados.PanelGuia;
import ElementosPersonalizados.SonidoClip;
import PaquetePrincipal.Constantes;
import javax.swing.JLabel;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

public class SistemasDeEntradaYSalida extends JFrame implements ActionListener, FocusListener{ 
	SonidoClip MenuAudio =  new SonidoClip("/SistemasDeEntradaYSalidaMenuAudio.wav");
	SonidoClip PercepcionTactil =  new SonidoClip("/percepciontactil.wav");
	SonidoClip Gusto =  new SonidoClip("/nodesarrollado.wav");
	SonidoClip Olfato=  new SonidoClip("/perOlfa.wav");
	
	private void pararAudios() {
		MenuAudio.stop();
		PercepcionTactil.stop();
		Gusto.stop();
		Olfato.stop();
		
	}
	public void dispose() {
		pararAudios();
		super.dispose();
		
	}

	public SistemasDeEntradaYSalida() {
		this.rootPane.addFocusListener(this);
		MenuAudio.loop();
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("S"),"INC");
		((JComponent)this.rootPane).getActionMap().put("INC", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pararAudios();
				
				// TODO Auto-generated method stub
				try {
					new Portada();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} dispose();
			}
		});
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0 ,2*(Constantes.ComputadoraWidth/3), 3*(Constantes.ComputadoraHeight/4));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().setBackground(Constantes.ColorFondo);
		panel.setBackground(Constantes.ColorFondo);
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("SISTEMAS DE ENTRADA Y SALIDA");
		lblNewLabel.setFont(Constantes.Titulos);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);
		
	
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		getContentPane().add(horizontalStrut_2, BorderLayout.WEST);
		
		
		PanelGuia panelGuia = new PanelGuia(this);
		getContentPane().add(panelGuia, BorderLayout.SOUTH);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		getContentPane().add(horizontalStrut_3, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Constantes.ColorFondo);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Constantes.ColorFondo);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		String[] PalabrasEntradas = {"Vista","O\u00eddo","Tacto","Gusto","Olfato"};
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("Z"),"Vista");
		((JComponent)this.rootPane).getActionMap().put("Vista", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					pararAudios();
	
					new Vista();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
	
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("X"),"OIDO");
		((JComponent)this.rootPane).getActionMap().put("OIDO", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			//LO QUE HACE AHORITA
				
			}
		});
	
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("C"),"TACT");
		((JComponent)this.rootPane).getActionMap().put("TACT", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 try {
					 pararAudios();
					 PercepcionTactil.play();
						JFrame j = new Plantilla_Ventanas("PERCEPCIÓN TÁCTIL", "Principal canal de informaci\u00f3n representado todo estimulo t\u00e8rmico, de presi\u00f3n y dolor.​ " + 
								"Detectan est\u00edmulos como vibraciones, transmiten gestos como selecci\u00f3n de objetos y permiten una adecuada comunicaci\u00f3n sin mayor estorbo de hardware aparatoso extra.​\n\n "
								+ "Parte del sistema t\u00e1ctil, actualmente no desarrollado en amplitud; pero con posible futuro en la realidad inmersiva, representan alguno de los est\u00edmulos m\u00e1s notorios y "
								+ "menos utilizados",ImageIO.read(this.getClass().getResource("/Tactil.png")), "");
						((JComponent)j.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"REP");
						((JComponent)j.getRootPane()).getActionMap().put("REP",new AbstractAction() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								pararAudios();
								 PercepcionTactil.play();
							}
						});
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					} 
			}
		});
	
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("V"),"GUST");
		((JComponent)this.rootPane).getActionMap().put("GUST", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pararAudios();
				Gusto.play();
				JFrame gusto = 	new JFrame();
				
				((JComponent)gusto.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
				((JComponent)gusto.getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						pararAudios();
						gusto.dispose();
					}
				});
				
				gusto.setBackground(Constantes.ColorFondo);
				gusto.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				gusto.setBounds(0,0,getWidth()/2, getHeight()/3);
				gusto.getContentPane().setLayout(new BorderLayout());
				JLabel referencia = new JLabel("NO DESARROLLADO");
				
				referencia.setFont(Constantes.Titulos);
				gusto.add(referencia);
				gusto.setVisible(true);
					
			}
		});
	
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("B"),"OLF");
		((JComponent)this.rootPane).getActionMap().put("OLF", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					pararAudios();
					Olfato.play();
					Plantilla_Ventanas plantilla_Ventanas=  new Plantilla_Ventanas("PERCEPCIÓN OLFATIVA", "Canal de percepci\u00f3n poco implementada en el desarrollo de interfaces; pero ampliamente explotable puesto que representar\u00eda una emulaci\u00f3n m\u00e1s avanzada en el sentido de experiencia de usuario.​\n\n\n El canal olfativo puede llegar a ser muy variable y necesita ser mejor estudiado puesto que puede representar diferentes experiencias dependiendo el usuario.​", ImageIO.read(getClass().getResource("/Olfativa.png")), "");
					
					((JComponent)plantilla_Ventanas.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"REP");
					((JComponent)plantilla_Ventanas.getRootPane()).getActionMap().put("REP", new AbstractAction() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							pararAudios();
							Olfato.play();
						}
					});
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	

	
		BotonesEnCascada Entradas = new BotonesEnCascada(PalabrasEntradas, this, new Font("",2,Constantes.PantallaSize.width/50), new Color(0.34f,0.23f,0.563f,1));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Constantes.ColorFondo);
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel lblNewLabel_1 = new JLabel("Sistemas De Entrada");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("",3,Constantes.PantallaSize.width/40));
		panel_4.add(lblNewLabel_1);
		Entradas.setComponentsInJPanel(panel_4);
		
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_4, BorderLayout.WEST);
		
		Component verticalStrut_3 = Box.createVerticalStrut(78);
		panel_2.add(verticalStrut_3, BorderLayout.NORTH);
		
		Component verticalStrut_4 = Box.createVerticalStrut(71);
		panel_2.add(verticalStrut_4, BorderLayout.SOUTH);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_5, BorderLayout.EAST);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Constantes.ColorFondo);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Constantes.ColorFondo);
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Sistemas De Salida");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 48));
		panel_5.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Extremidades");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 48));
		panel_5.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Miembros");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 48));
		panel_5.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Ojos");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 48));
		panel_5.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Cabeza\u200B");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 48));
		panel_5.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sistema Vocal");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 48));
		panel_5.add(lblNewLabel_1_1_1_1);
		
		Component verticalStrut_3_1 = Box.createVerticalStrut(78);
		panel_3.add(verticalStrut_3_1, BorderLayout.NORTH);
		
		Component verticalStrut_4_1 = Box.createVerticalStrut(71);
		panel_3.add(verticalStrut_4_1, BorderLayout.SOUTH);
		
		Component horizontalStrut_5_1 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_5_1, BorderLayout.WEST);
		
		Component horizontalStrut_5_2 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_5_2, BorderLayout.EAST);
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("D"),"SIG");
		((JComponent)this.rootPane).getActionMap().put("SIG", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
		 new PercepcionDeTiempo();  dispose(); pararAudios();
			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("A"),"ANTER");
		((JComponent)this.rootPane).getActionMap().put("ANTER", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			new Introduccion(); dispose(); pararAudios();
			}
		});
		
	setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Vista": try {
				new Vista();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} break;
		case "O\u00eddo": break;	
		case "Tacto": try {
				new Plantilla_Ventanas("PERCEPCIÓN TÁCTIL", "Principal canal de informaci\u00f3n representado todo estimulo t\u00e8rmico, de presi\u00f3n y dolor.​ " + 
						"Detectan est\u00edmulos como vibraciones, transmiten gestos como selecci\u00f3n de objetos y permiten una adecuada comunicaci\u00f3n sin mayor estorbo de hardware aparatoso extra.​\n\n "
						+ "Parte del sistema t\u00e1ctil, actualmente no desarrollado en amplitud; pero con posible futuro en la realidad inmersiva, representan alguno de los est\u00edmulos m\u00e1s notorios y "
						+ "menos utilizados",ImageIO.read(this.getClass().getResource("/Tactil.png")), "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			} break;	
		case "Gusto": 
		JFrame gusto = 	new JFrame();
	
		gusto.setBackground(Constantes.ColorFondo);
		gusto.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		((JComponent)gusto.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
		((JComponent)gusto.getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gusto.dispose();
			}
		});
		gusto.setBounds(0,0,getWidth()/2, getHeight()/3);
		gusto.getContentPane().setLayout(new BorderLayout());
		JLabel referencia = new JLabel("NO DESARROLLADO");
		referencia.setFont(Constantes.Titulos);
		gusto.add(referencia);
		gusto.setVisible(true);
			break;
		
		case "Olfato":
			try {
				new Plantilla_Ventanas("PERCEPCIÓN OLFATIVA", "Canal de percepci\u00f3n poco implementada en el desarrollo de interfaces; pero ampliamente explotable puesto que representar\u00eda una emulaci\u00f3n m\u00e1s avanzada en el sentido de experiencia de usuario.​\n\n\n El canal olfativo puede llegar a ser muy variable y necesita ser mejor estudiado puesto que puede representar diferentes experiencias dependiendo el usuario.​", ImageIO.read(getClass().getResource("/Olfativa.png")), "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Siguiente": new PercepcionDeTiempo(); pararAudios(); dispose(); break;
		case "Anterior": new  Introduccion(); pararAudios(); dispose(); break;
		case "Inicio": try {
			new Portada();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} dispose();pararAudios(); break;
		}
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		pararAudios();
		MenuAudio.loop();
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
