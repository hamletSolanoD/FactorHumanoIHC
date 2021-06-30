package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.xml.soap.Text;


import ElementosPersonalizados.BotonesEnCascada;
import ElementosPersonalizados.PanelGuia;
import ElementosPersonalizados.SonidoClip;
import PaquetePrincipal.Constantes;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class PrincipioGESTAL extends JFrame implements ActionListener{
	SonidoClip MenuAudio =  new SonidoClip("/Gestalt.wav");
	SonidoClip similitud =  new SonidoClip("/similitud.wav");
	SonidoClip cercania =  new SonidoClip("/cercania.wav");
	SonidoClip continuidad =  new SonidoClip("/conti.wav");
	SonidoClip figura =  new SonidoClip("/figura.wav");
	SonidoClip proxi =  new SonidoClip("/proximidad.wav");

	
	private void PararAudios() {
		
		similitud.stop();
		MenuAudio.stop();
		cercania.stop();
		continuidad.stop();
		figura.stop();
		proxi.stop();
		
	}
	
	@Override
	public void dispose() {
		PararAudios();
		super.dispose();
		
	}
	
	
	public PrincipioGESTAL() {
	rootPane.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
		

			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				MenuAudio.stop();
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
		setBounds(0, 0, (int)(Constantes.ComputadoraWidth/4)*3, (int)(Constantes.ComputadoraHeight/4)*3);
		getContentPane().setLayout(new BorderLayout(0, 0));
		PanelGuia panelGuia = new PanelGuia(this);
		panelGuia.setBackground(Constantes.ColorFondo);
		getContentPane().add(panelGuia,BorderLayout.SOUTH);
		
		JPanel PanelBotones = new JPanel(new GridLayout(0, 1, 1,1));
		PanelBotones.setBackground(Constantes.ColorFondo);
		String[] Palabras = {"Similitud","Cercan\u00eda","Continuidad","Figura y fondo","Proximidad"};
		BotonesEnCascada botones = new BotonesEnCascada(Palabras, this, new Font("",2,Constantes.PantallaSize.width/50), new Color(0.34f,0.23f,0.563f,1));
		botones.setComponentsInJPanel(PanelBotones);
		getContentPane().add(PanelBotones, BorderLayout.CENTER);
		
		Component horizontalStrut = Box.createHorizontalStrut(270);
		getContentPane().add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(270);
		getContentPane().add(horizontalStrut_1, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Constantes.ColorFondo);
		getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Constantes.ColorFondo);
		try {
			lblNewLabel.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/GESTALT.png")).getScaledInstance(500, 300,java.awt.Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		
		
		Component verticalStrut = Box.createVerticalStrut(103);
		panel_1.add(verticalStrut, BorderLayout.SOUTH);
		((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Z"),"SIM");
		((JComponent)getRootPane()).getActionMap().put("SIM", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				class Similitud extends JFrame{
					@Override
					public void dispose() {
						PararAudios();
						super.dispose();
					}
					public Similitud() {
						
						PararAudios();
						similitud.loop();
						((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
						((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								 dispose();
							}
						});
						((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"REP");
						((JComponent)getRootPane()).getActionMap().put("REP",new AbstractAction() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								PararAudios();
								similitud.loop();
							}
						});
						setBackground(Constantes.ColorFondo);
						setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						getContentPane().setLayout(new BorderLayout());
						setResizable(false);
						
						////
						JPanel Principal = new JPanel(new BorderLayout());
						Principal.setBackground(Constantes.ColorFondo);

						JPanel este = new JPanel(new GridLayout(0,1,0,0));
						este.setBackground(Constantes.ColorFondo);

						JButton Boton1 = Constantes.BotonRedondeado("Grupo 1");
						JButton Boton2 = Constantes.BotonRedondeado("Grupo 1");
						Boton1.setBackground(new Color(0.34f,0.12f,0.54f,1));
						Boton2.setBackground(new Color(0.34f,0.12f,0.54f,1));

						este.add(Boton1);
						este.add(Boton2);
						Principal.add(este,BorderLayout.EAST);
						
						JLabel Titulo = new JLabel("Similitud​");
						Titulo.setHorizontalAlignment(SwingConstants.CENTER);
						Titulo.setFont(Constantes.Titulos.deriveFont(new Float(getWidth()/10)));
						Principal.add(Titulo,BorderLayout.CENTER);
						
						JPanel South = new JPanel(new GridLayout(1,0,0,0));
						South.setBackground(Constantes.ColorFondo);

						JButton Boton3 =Constantes.BotonRedondeado("Grupo 2");
						JButton Boton4= Constantes.BotonRedondeado("Grupo 2");
						Boton3.setBackground(new Color(0.12f,0.76f,0.34f,1));
						Boton4.setBackground(new Color(0.12f,0.76f,0.34f,1));
						South.add(Boton3);
						South.add(Boton4);;
						Principal.add(South,BorderLayout.SOUTH);
						
						getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
						getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
						getContentPane().add(Principal,BorderLayout.CENTER);
						///
						
						JTextPane  Texto = new JTextPane();
						Texto.setBackground(Constantes.ColorFondo);
						Texto.setText("objetos con similitud son percibidos como grupos");
						Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
						Texto.setEditable(false);
						getContentPane().add(Texto,BorderLayout.SOUTH);
						
						
						setVisible(true);
					}
				}
				 new Similitud();	
			}
		});
		((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("X"),"CER");
		((JComponent)getRootPane()).getActionMap().put("CER", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				class Cercania extends JFrame{
					@Override
					public void dispose() {
						PararAudios();
						super.dispose();
					}
					public Cercania() {
						PararAudios();
						cercania.loop();
						((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
						((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								 dispose();
							}
						});
						((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"rep");
						((JComponent)getRootPane()).getActionMap().put("rep", new AbstractAction() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								PararAudios();
								cercania.loop();
							}
						});
						setBackground(Constantes.ColorFondo);
						setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						getContentPane().setLayout(new BorderLayout());
						setResizable(false);
						
						JPanel Principal = new JPanel(new BorderLayout());
						Principal.setBackground(Constantes.ColorFondo);
						////
						JLabel imagen  = new JLabel();
						imagen.setHorizontalAlignment(SwingConstants.CENTER);
						try {
							imagen.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/Cercania.png"))));
							Principal.add(imagen,BorderLayout.CENTER);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						///
						getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
						getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
						getContentPane().add(Principal,BorderLayout.CENTER);
						
						
						JLabel titulo = new JLabel("Cercan\u00eda");
						titulo.setFont(Constantes.Titulos);
						titulo.setHorizontalAlignment(SwingConstants.CENTER);
						getContentPane().add(titulo,BorderLayout.NORTH);
						
						JTextPane  Texto = new JTextPane();
						Texto.setBackground(Constantes.ColorFondo);
						Texto.setText("A pesar de que un objeto este separado de otro si sigue algun cierto patron consistente y la separacion no es muy extensa se omiten estos vac\u00edos y se entiende el conjunto como un solo objeto.​");					
						Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/5)));
						Texto.setEditable(false);
						getContentPane().add(Texto,BorderLayout.SOUTH);
						
						
						setVisible(true);
					}
				}
				 new Cercania();	
			}
		});
		((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("C"),"Cont");
		((JComponent)getRootPane()).getActionMap().put("Cont", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					class Continuidad extends JFrame{
						@Override
						public void dispose() {
							PararAudios(); 
							super.dispose();
							
						}
						public Continuidad() {
							PararAudios();
							continuidad.loop();
							
							((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
							((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									 dispose();
								}
							});

								((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"rep");
								((JComponent)getRootPane()).getActionMap().put("rep", new AbstractAction() {
									@Override
									public void actionPerformed(ActionEvent arg0) {
										PararAudios();
										continuidad.loop();
									}
								});
							setBackground(Constantes.ColorFondo);
							setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
							this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							getContentPane().setLayout(new BorderLayout());
							setResizable(false);
							
							JPanel Principal = new JPanel(new BorderLayout());
							Principal.setBackground(Constantes.ColorFondo);

							////
							JLabel imagen  = new JLabel();
							imagen.setHorizontalAlignment(SwingConstants.CENTER);
							try {
								imagen.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/Continuidad.png"))));
								Principal.add(imagen,BorderLayout.CENTER);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
							///
							getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
							getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
							getContentPane().add(Principal,BorderLayout.CENTER);
							
							
							JLabel titulo = new JLabel("Continuidad");
							titulo.setFont(Constantes.Titulos);
							titulo.setHorizontalAlignment(SwingConstants.CENTER);
							getContentPane().add(titulo,BorderLayout.NORTH);
							
							JTextPane  Texto = new JTextPane();
							Texto.setBackground(Constantes.ColorFondo);
							Texto.setText("Cuando algun objeto a pesar de estar separado sigue alguna cierta direccion marcada se entiende como parte de un mismo conjunto.​​");					
							Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
							Texto.setEditable(false);
							getContentPane().add(Texto,BorderLayout.SOUTH);
							
							
							setVisible(true);
						}
					}
					 new Continuidad();	
			}
		});
		
		
		((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("V"),"Figura");
		((JComponent)getRootPane()).getActionMap().put("Figura", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				class Figura extends JFrame {
					public void dispose() {
						PararAudios();
						super.dispose();
					}
					public Figura() {
						PararAudios();
						figura.loop();
						((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
						((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								 dispose();
							}
						});
						((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"rep");
						((JComponent)getRootPane()).getActionMap().put("rep", new AbstractAction() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								PararAudios();
								figura.loop();
							}
						});
						setBackground(Constantes.ColorFondo);
						setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 4*(Constantes.ComputadoraHeight/8));
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						getContentPane().setLayout(new BorderLayout());
						setResizable(true);
						
						JPanel Principal = new JPanel(new BorderLayout());
						Principal.setBackground(Constantes.ColorFondo);

						////
						JLabel imagen  = new JLabel();
						imagen.setHorizontalAlignment(SwingConstants.CENTER);
						try {
							imagen.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/Figura y fondo.jpg"))));
							Principal.add(imagen,BorderLayout.CENTER);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						///
						getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
						getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
						getContentPane().add(Principal,BorderLayout.CENTER);
						
						
						JLabel titulo = new JLabel("Figura y fondo");
						titulo.setFont(Constantes.Titulos);
						titulo.setHorizontalAlignment(SwingConstants.CENTER);
						getContentPane().add(titulo,BorderLayout.NORTH);
						
						JTextPane  Texto = new JTextPane();
						Texto.setBackground(Constantes.ColorFondo);
						Texto.setText("eparar los objetos del fondo para percibir diferentes figuras o interpretaciones.\nayuda a resaltar mejor el objetivo.​​​");					
						Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
						Texto.setEditable(false);
						getContentPane().add(Texto,BorderLayout.SOUTH);
						
						
						setVisible(true);
					}
				}
				 new Figura();	
				
					
			}
		});
		((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("B"),"PROXIMI");
		((JComponent)getRootPane()).getActionMap().put("PROXIMI", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				class proximidad extends JFrame{
					public void dispose() {
						PararAudios();
						super.dispose();
					}
					public proximidad() {
						PararAudios();
						proxi.loop();
						((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
						((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								 dispose();
							}
						});
						
						((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"REP");
						((JComponent)getRootPane()).getActionMap().put("REP", new AbstractAction() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								PararAudios();
								proxi.loop();
							}
						});
						
						setBackground(Constantes.ColorFondo);
						setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						getContentPane().setLayout(new BorderLayout());
						setResizable(false);
						
						JPanel Principal = new JPanel(new BorderLayout());
						////
						JPanel gridPrincipal = new JPanel(new GridLayout(1,0,0,0));
						gridPrincipal.setBackground(Constantes.ColorFondo);
						Principal.setBackground(Constantes.ColorFondo);

						JPanel panel1 = new JPanel(new GridLayout(0,1,0,0));
						panel1.setBackground(Constantes.ColorFondo);

						BotonesEnCascada botones1 = new BotonesEnCascada("Grupo 1", null,new Font("",2,Constantes.PantallaSize.width/50), new Color(0.345f,0.45f,0.645f,1));
						botones1.setComponentsInJPanel(panel1);
						JPanel panel2 = new JPanel(new GridLayout(0,1,0,0));
						panel2.setBackground(Constantes.ColorFondo);

						panel2.add(Box.createHorizontalStrut(40));
						JPanel panel3 = new JPanel(new GridLayout(0,1,0,0));
						panel3.setBackground(Constantes.ColorFondo);
						BotonesEnCascada botones2 = new BotonesEnCascada("Grupo 2", null,new Font("",2,Constantes.PantallaSize.width/50), new Color(0.65f,0.45f,0.23f,1));
						botones2.setComponentsInJPanel(panel3);
						gridPrincipal.add(panel1);
						gridPrincipal.add(panel2);
						gridPrincipal.add(panel3);
						Principal.add(gridPrincipal,BorderLayout.CENTER);
						
						///
						getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
						getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
						getContentPane().add(Principal,BorderLayout.CENTER);
						
						
						JLabel titulo = new JLabel("Proximidad");
						titulo.setFont(Constantes.Titulos);
						titulo.setHorizontalAlignment(SwingConstants.CENTER);
						getContentPane().add(titulo,BorderLayout.NORTH);
						
						JTextPane  Texto = new JTextPane();
						Texto.setBackground(Constantes.ColorFondo);
						Texto.setText("Objetos separados si estan lo suficiente juntos se perciben en el mismo grupo a pesar de ser diferentes en diseño ​");					
						Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
						Texto.setEditable(false);
						getContentPane().add(Texto,BorderLayout.SOUTH);
						
						
						setVisible(true);
					}
				}
				 new proximidad();	
				
			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("D"),"SIG");
		((JComponent)this.rootPane).getActionMap().put("SIG", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Memorias(); dispose();	}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("A"),"ANT");
		((JComponent)this.rootPane).getActionMap().put("ANT", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 new PercepcionDeTiempo();  dispose();	}
		});
		setVisible(true);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand()) {
		case "Similitud":
			class Similitud extends JFrame{
				public Similitud() {
					((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
					((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							 dispose();
						}
					});
					setBackground(Constantes.ColorFondo);
					setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					getContentPane().setLayout(new BorderLayout());
					setResizable(false);
					
					////
					JPanel Principal = new JPanel(new BorderLayout());
					Principal.setBackground(Constantes.ColorFondo);

					JPanel este = new JPanel(new GridLayout(0,1,0,0));
					este.setBackground(Constantes.ColorFondo);

					JButton Boton1 = Constantes.BotonRedondeado("Grupo 1");
					JButton Boton2 = Constantes.BotonRedondeado("Grupo 1");
					Boton1.setBackground(new Color(0.34f,0.12f,0.54f,1));
					Boton2.setBackground(new Color(0.34f,0.12f,0.54f,1));

					este.add(Boton1);
					este.add(Boton2);
					Principal.add(este,BorderLayout.EAST);
					
					JLabel Titulo = new JLabel("Similitud​");
					Titulo.setHorizontalAlignment(SwingConstants.CENTER);
					Titulo.setFont(Constantes.Titulos.deriveFont(new Float(getWidth()/10)));
					Principal.add(Titulo,BorderLayout.CENTER);
					
					JPanel South = new JPanel(new GridLayout(1,0,0,0));
					South.setBackground(Constantes.ColorFondo);

					JButton Boton3 =Constantes.BotonRedondeado("Grupo 2");
					JButton Boton4= Constantes.BotonRedondeado("Grupo 2");
					Boton3.setBackground(new Color(0.12f,0.76f,0.34f,1));
					Boton4.setBackground(new Color(0.12f,0.76f,0.34f,1));
					South.add(Boton3);
					South.add(Boton4);;
					Principal.add(South,BorderLayout.SOUTH);
					
					getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
					getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
					getContentPane().add(Principal,BorderLayout.CENTER);
					///
					
					JTextPane  Texto = new JTextPane();
					Texto.setBackground(Constantes.ColorFondo);
					Texto.setText("objetos con similitud son percibidos como grupos");
					Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
					Texto.setEditable(false);
					getContentPane().add(Texto,BorderLayout.SOUTH);
					
					
					setVisible(true);
				}
			}
			 new Similitud();	
			break;
		case "Cercan\u00eda":
			class Cercania extends JFrame{
				public Cercania() {
					((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
					((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							 dispose();
						}
					});
					setBackground(Constantes.ColorFondo);
					setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					getContentPane().setLayout(new BorderLayout());
					setResizable(false);
					
					JPanel Principal = new JPanel(new BorderLayout());
					Principal.setBackground(Constantes.ColorFondo);
					////
					JLabel imagen  = new JLabel();
					imagen.setHorizontalAlignment(SwingConstants.CENTER);
					try {
						imagen.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/Cercania.png"))));
						Principal.add(imagen,BorderLayout.CENTER);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					///
					getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
					getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
					getContentPane().add(Principal,BorderLayout.CENTER);
					
					
					JLabel titulo = new JLabel("Cercan\u00eda");
					titulo.setFont(Constantes.Titulos);
					titulo.setHorizontalAlignment(SwingConstants.CENTER);
					getContentPane().add(titulo,BorderLayout.NORTH);
					
					JTextPane  Texto = new JTextPane();
					Texto.setBackground(Constantes.ColorFondo);
					Texto.setText("A pesar de que un objeto este separado de otro si sigue algun cierto patron consistente y la separacion no es muy extensa se omiten estos vac\u00edos y se entiende el conjunto como un solo objeto.​");					
					Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/5)));
					Texto.setEditable(false);
					getContentPane().add(Texto,BorderLayout.SOUTH);
					
					
					setVisible(true);
				}
			}
			 new Cercania();	
			
			break;
		case "Continuidad":
			
			class Continuidad extends JFrame{
				public Continuidad() {
					((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
					((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							 dispose();
						}
					});
					setBackground(Constantes.ColorFondo);
					setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					getContentPane().setLayout(new BorderLayout());
					setResizable(false);
					
					JPanel Principal = new JPanel(new BorderLayout());
					Principal.setBackground(Constantes.ColorFondo);

					////
					JLabel imagen  = new JLabel();
					imagen.setHorizontalAlignment(SwingConstants.CENTER);
					try {
						imagen.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/Continuidad.png"))));
						Principal.add(imagen,BorderLayout.CENTER);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					///
					getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
					getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
					getContentPane().add(Principal,BorderLayout.CENTER);
					
					
					JLabel titulo = new JLabel("Continuidad");
					titulo.setFont(Constantes.Titulos);
					titulo.setHorizontalAlignment(SwingConstants.CENTER);
					getContentPane().add(titulo,BorderLayout.NORTH);
					
					JTextPane  Texto = new JTextPane();
					Texto.setBackground(Constantes.ColorFondo);
					Texto.setText("Cuando algun objeto a pesar de estar separado sigue alguna cierta direccion marcada se entiende como parte de un mismo conjunto.​​");					
					Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
					Texto.setEditable(false);
					getContentPane().add(Texto,BorderLayout.SOUTH);
					
					
					setVisible(true);
				}
			}
			 new Continuidad();	
			
			break;
		case "Figura y fondo":
			class Figura extends JFrame {
			public Figura() {
				((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
				((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						 dispose();
					}
				});
				setBackground(Constantes.ColorFondo);
				setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 4*(Constantes.ComputadoraHeight/8));
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				getContentPane().setLayout(new BorderLayout());
				setResizable(true);
				
				JPanel Principal = new JPanel(new BorderLayout());
				Principal.setBackground(Constantes.ColorFondo);

				////
				JLabel imagen  = new JLabel();
				imagen.setHorizontalAlignment(SwingConstants.CENTER);
				try {
					imagen.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("/Figura y fondo.jpg"))));
					Principal.add(imagen,BorderLayout.CENTER);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				///
				getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
				getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
				getContentPane().add(Principal,BorderLayout.CENTER);
				
				
				JLabel titulo = new JLabel("Figura y fondo");
				titulo.setFont(Constantes.Titulos);
				titulo.setHorizontalAlignment(SwingConstants.CENTER);
				getContentPane().add(titulo,BorderLayout.NORTH);
				
				JTextPane  Texto = new JTextPane();
				Texto.setBackground(Constantes.ColorFondo);
				Texto.setText("eparar los objetos del fondo para percibir diferentes figuras o interpretaciones.\nayuda a resaltar mejor el objetivo.​​​");					
				Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
				Texto.setEditable(false);
				getContentPane().add(Texto,BorderLayout.SOUTH);
				
				
				setVisible(true);
			}
		}
		 new Figura();	
		
			
			break;
		case "Proximidad": 
			class proximidad extends JFrame{
				public proximidad() {
					((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
					((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							 dispose();
						}
					});
					setBackground(Constantes.ColorFondo);
					setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					getContentPane().setLayout(new BorderLayout());
					setResizable(false);
					
					JPanel Principal = new JPanel(new BorderLayout());
					////
					JPanel gridPrincipal = new JPanel(new GridLayout(1,0,0,0));
					gridPrincipal.setBackground(Constantes.ColorFondo);
					Principal.setBackground(Constantes.ColorFondo);

					JPanel panel1 = new JPanel(new GridLayout(0,1,0,0));
					panel1.setBackground(Constantes.ColorFondo);

					BotonesEnCascada botones1 = new BotonesEnCascada("Grupo 1", null,new Font("",2,Constantes.PantallaSize.width/50), new Color(0.345f,0.45f,0.645f,1));
					botones1.setComponentsInJPanel(panel1);
					JPanel panel2 = new JPanel(new GridLayout(0,1,0,0));
					panel2.setBackground(Constantes.ColorFondo);

					panel2.add(Box.createHorizontalStrut(40));
					JPanel panel3 = new JPanel(new GridLayout(0,1,0,0));
					panel3.setBackground(Constantes.ColorFondo);
					BotonesEnCascada botones2 = new BotonesEnCascada("Grupo 2", null,new Font("",2,Constantes.PantallaSize.width/50), new Color(0.65f,0.45f,0.23f,1));
					botones2.setComponentsInJPanel(panel3);
					gridPrincipal.add(panel1);
					gridPrincipal.add(panel2);
					gridPrincipal.add(panel3);
					Principal.add(gridPrincipal,BorderLayout.CENTER);
					
					///
					getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.WEST);
					getContentPane().add(Box.createHorizontalStrut(40),BorderLayout.EAST);
					getContentPane().add(Principal,BorderLayout.CENTER);
					
					
					JLabel titulo = new JLabel("Proximidad");
					titulo.setFont(Constantes.Titulos);
					titulo.setHorizontalAlignment(SwingConstants.CENTER);
					getContentPane().add(titulo,BorderLayout.NORTH);
					
					JTextPane  Texto = new JTextPane();
					Texto.setBackground(Constantes.ColorFondo);
					Texto.setText("Objetos separados si estan lo suficiente juntos se perciben en el mismo grupo a pesar de ser diferentes en diseño ​");					
					Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
					Texto.setEditable(false);
					getContentPane().add(Texto,BorderLayout.SOUTH);
					
					
					setVisible(true);
				}
			}
			 new proximidad();	
			
			
			break;
		case "Anterior": new PercepcionDeTiempo();  dispose(); break;
		case "Siguiente": new Memorias(); dispose(); break;
		case "Inicio": try {
			new Portada();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} dispose(); break;
		}
	}

}
