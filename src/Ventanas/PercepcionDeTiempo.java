package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import ElementosPersonalizados.PanelGuia;
import ElementosPersonalizados.SonidoClip;
import PaquetePrincipal.Constantes;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class PercepcionDeTiempo extends JFrame implements ActionListener {

	SonidoClip MenuAudio =  new SonidoClip("/percepcionTiempoMenuAudio.wav");
	SonidoClip Pasado =  new SonidoClip("/experienciaConLaPercepcionDelPasado.wav");
	SonidoClip Presente =  new SonidoClip("/perpresente.wav");
	SonidoClip Futuro =  new SonidoClip("/ExperienciaConLaPercepcionDelFuturo.wav");

	private void PararAudios() {		
		MenuAudio.stop();
		Pasado.stop();
		Presente.stop();
		Futuro.stop();
	}
	public void dispose() {
		PararAudios();
		super.dispose();
	}
	class pasado extends JFrame{
		public void dispose() {
			PararAudios();
			super.dispose();
		}
		public pasado() {
			PararAudios();
			Pasado.loop();
				((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
				((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						 PararAudios();
						 dispose();
					
					}
				});
				((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"REP");
				((JComponent)getRootPane()).getActionMap().put("REP", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						 PararAudios();
						 Pasado.loop();
					
					}
				});
			setBounds(0, 0, 2*(Constantes.ComputadoraWidth/3), 3*(Constantes.ComputadoraHeight/4));
			getContentPane().setLayout(new BorderLayout());
		JDesktopPane panelPrincipal = new JDesktopPane();
		panelPrincipal.setLayout(null);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		
	
			Plantilla_Ventanas Plantilla;
			try {
				Plantilla = new Plantilla_Ventanas();
				Plantilla.setVisible(false);
				panelPrincipal.add(Plantilla.getPlantillaInJInternalFrame(
						"EXPERIENCIA CON LA PERCEPCIÓN DEL PASADO​", "La previa experiencia o el estudio previo de las experiencias comunes en el usuario es un punto de partida indispensable para el desarrollo de interfaces.\n\n\n Un usuario acostumbrado a ciertas simbolog\u00edas, colores y mec\u00e1nicas con otros programas esperara realizar las mismas acciones en nuestras aplicaciones por tanto es recomendable seguir alg\u00f9n cierto est\u00e1ndar.​\n\n\nDe igual forma si el objetivo es implementar alguna interacci\u00f3n nueva es importante entrenar al usuario en ella para acostumbrarlo y no cambiar abruptamente este comportamiento.​\n\n\n Un claro ejemplo es la ventana actual en uso, siendo est\u00e1 facilmente manipulada por la experiencia con otros programas​\n\nUn buen ejemplo es el uso de esta ventana facil de manipular por la previa experiencia.",ImageIO.read(getClass().getResource("/pasado.png"))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		setVisible(true);
		}

	} 
	public PercepcionDeTiempo() {
		
	rootPane.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			
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
		getContentPane().setBackground(Constantes.ColorFondo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0 ,2*(Constantes.ComputadoraWidth/3), 3*(Constantes.ComputadoraHeight/4));
		getContentPane().setLayout(new BorderLayout(0, 0));
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
		JLabel lblNewLabel = new JLabel("PERCEPCI\u00D3N DE TIEMPO");
		lblNewLabel.setForeground(Constantes.ColorTitulos);
		lblNewLabel.setFont(Constantes.Titulos);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Constantes.ColorFondo);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut_1 = Box.createVerticalStrut(67);
		panel.add(verticalStrut_1, BorderLayout.NORTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut = Box.createVerticalStrut(143);
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
				new pasado();
			
				
			}
		});
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("Pasado");
		panel_1.add(btnNewButton);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2);
		
		JButton btnNewButton_1_1 = Constantes.BotonRedondeado("Presente");
		btnNewButton_1_1.addActionListener(this);
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("X"),"PRES");
		((JComponent)this.rootPane).getActionMap().put("PRES", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PararAudios();
					Presente.loop();
					Plantilla_Ventanas v =new Plantilla_Ventanas("EXPER1ENC14 CON L4 PERCEPC1ÓN DEL PRE5EN7E​", "La percepc1\u00f3n del pre5ente 5e f0rma c0n la 1ntr0ducc1\u00f3n del c0ntext0 ante una 1dea nueva. " + 
							"51 la percepc1\u00f3n del c0ntext0 expl1ca un amb1ente d1ferente al de5ead0, e5 re5p0n5ab1l1dad del de5arr0llad0r dar una c0rrecta expl1cac1\u00f3n del amb1ente "
							+ "a5\u00ed el u5uar10 nunca 5e enc0ntrar\u00e1 c0nfund1d0 p0r una amb1güedad en el d15eñ0.​\n\n\n Un claro ejemplo acaba de ser la facilidad para leer el texto aun siendo modificado.",ImageIO.read(getClass().getResource("/presente.png")) ,"" );
					((JComponent)v.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"rep");
					((JComponent)v.getRootPane()).getActionMap().put("rep",new AbstractAction() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							PararAudios();
							Presente.loop();
						}
					});
					((JComponent)v.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"CER");
					((JComponent)v.getRootPane()).getActionMap().put("CER",new AbstractAction() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							PararAudios();
							v.dispose();
						}
					});
						
						
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		});
		btnNewButton_1_1.setActionCommand("Presente");
		panel_1.add(btnNewButton_1_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3);
		
		JButton btnNewButton_1 = Constantes.BotonRedondeado("futuro");
		btnNewButton_1.addActionListener(this);
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("C"),"FUT");
		((JComponent)this.rootPane).getActionMap().put("FUT", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PararAudios();
					Futuro.loop();
				Plantilla_Ventanas j =	new Plantilla_Ventanas("EXPERIENCIA CON LA PERCEPCIÓN DEL FUTURO","El usuario normalmente se enfoca o va predispuesto \u00f9nicamente en enfocarse en lo que va buscando e ignorar las dem\u00e1s advertencias de la interfaz.​\n\n\nPor tanto, es considerado una buena pr\u00e1ctica el resaltar la informaci\u00f3n m\u00e1s importante que el usuario no tiene planeado ingresar, pero de una forma no invasiva; El objetivo es no ser agresivo con la informaci\u00f3n, pero si resaltarla lo suficiente para llamar su atenci\u00f3n y no pasar desapercibido. ​\n\n\nEs trabajo del desarrollador guiar esta experiencia de usuario y no dejar ning\u00f9n elemento sin su relativa importancia.​\n\n"
							+ "Un claro ejemplo puede ser la distribuci\u00f3n de esta ventana",ImageIO.read(this.getClass().getResource("/PercepcionDelFuturo.png")),"");
			
				((JComponent)j.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"rep");
				((JComponent)j.getRootPane()).getActionMap().put("rep",new AbstractAction() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						PararAudios();
						Futuro.loop();
					}
				});
				((JComponent)j.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"CER");
				((JComponent)j.getRootPane()).getActionMap().put("CER",new AbstractAction() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						PararAudios();
						j.dispose();
					}
				});
				
				
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
		});
		btnNewButton_1.setActionCommand("Futuro");
		panel_1.add(btnNewButton_1);
		
		
		PanelGuia panelguia = new PanelGuia(this);
		panelguia.setBackground(Constantes.ColorFondo);
		getContentPane().add(panelguia,BorderLayout.SOUTH);
		setVisible(true);
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("A"),"ANT");
		((JComponent)this.rootPane).getActionMap().put("ANT", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 new SistemasDeEntradaYSalida();  dispose();	
				}
		});((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("D"),"SIG");
		((JComponent)this.rootPane).getActionMap().put("SIG", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 new PrincipioGESTAL();  dispose(); 
				}
		});
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand()) {
		case "Pasado" :  
			new pasado(); break;
		case "Presente": 
			try {
				PararAudios();
				Presente.loop();
				Plantilla_Ventanas v =new Plantilla_Ventanas("EXPER1ENC14 CON L4 PERCEPC1ÓN DEL PRE5EN7E​", "La percepc1\u00f3n del pre5ente 5e f0rma c0n la 1ntr0ducc1\u00f3n del c0ntext0 ante una 1dea nueva. " + 
						"51 la percepc1\u00f3n del c0ntext0 expl1ca un amb1ente d1ferente al de5ead0, e5 re5p0n5ab1l1dad del de5arr0llad0r dar una c0rrecta expl1cac1\u00f3n del amb1ente "
						+ "a5\u00ed el u5uar10 nunca 5e enc0ntrar\u00e1 c0nfund1d0 p0r una amb1güedad en el d15eñ0.​\n\n\n Un claro ejemplo acaba de ser la facilidad para leer el texto aun siendo modificado.",ImageIO.read(getClass().getResource("/presente.png")) ,"" );
				((JComponent)v.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"rep");
				((JComponent)v.getRootPane()).getActionMap().put("rep",new AbstractAction() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						PararAudios();
						Presente.loop();
					}
				});
				((JComponent)v.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"CER");
				((JComponent)v.getRootPane()).getActionMap().put("CER",new AbstractAction() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						PararAudios();
						v.dispose();
					}
				});
					
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "Futuro": 
			try {
				PararAudios();
				Futuro.loop();
			Plantilla_Ventanas j =	new Plantilla_Ventanas("EXPERIENCIA CON LA PERCEPCIÓN DEL FUTURO","El usuario normalmente se enfoca o va predispuesto \u00f9nicamente en enfocarse en lo que va buscando e ignorar las dem\u00e1s advertencias de la interfaz.​\n\n\nPor tanto, es considerado una buena pr\u00e1ctica el resaltar la informaci\u00f3n m\u00e1s importante que el usuario no tiene planeado ingresar, pero de una forma no invasiva; El objetivo es no ser agresivo con la informaci\u00f3n, pero si resaltarla lo suficiente para llamar su atenci\u00f3n y no pasar desapercibido. ​\n\n\nEs trabajo del desarrollador guiar esta experiencia de usuario y no dejar ning\u00f9n elemento sin su relativa importancia.​\n\n"
						+ "Un claro ejemplo puede ser la distribuci\u00f3n de esta ventana",ImageIO.read(this.getClass().getResource("/PercepcionDelFuturo.png")),"");
		
			((JComponent)j.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("E"),"rep");
			((JComponent)j.getRootPane()).getActionMap().put("rep",new AbstractAction() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					PararAudios();
					Futuro.loop();
				}
			});
			((JComponent)j.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"CER");
			((JComponent)j.getRootPane()).getActionMap().put("CER",new AbstractAction() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					PararAudios();
					j.dispose();
				}
			});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		case "Anterior": new SistemasDeEntradaYSalida();  dispose(); break;
		case "Siguiente": new PrincipioGESTAL();  dispose(); break;
		case "Inicio": try {
			new Portada();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} dispose(); break;
		}
	}

}
