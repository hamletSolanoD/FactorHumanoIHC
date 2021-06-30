package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import ElementosPersonalizados.BotonesEnCascada;
import ElementosPersonalizados.SonidoClip;
import PaquetePrincipal.Constantes;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;

import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class Vista extends JFrame implements ActionListener {
	private ArrayList<JFrame> Ventanas = new ArrayList<JFrame>();
	private ArrayList<SonidoClip> VentanasAudios = new ArrayList<SonidoClip>();

	SonidoClip Inicio = new SonidoClip("/SistemaVisualInicio.wav");	
	SonidoClip SistemaVisual = new SonidoClip("/funcVisual.wav");
	SonidoClip InterfazCaracteriasticas = new SonidoClip("/VistaInterfazCaracteristicas.wav");	
	SonidoClip Daltonismo = new SonidoClip("/VistaDaltonismo.wav");
	SonidoClip RecoDeSistemaVisualclip = new SonidoClip("/VistaRecoSistemaVisual.wav");
	
	SonidoClip brillo =new SonidoClip("/brillo.wav");
	SonidoClip palidos =new SonidoClip("/VistaColoresPalidos.wav");
	SonidoClip separacion =new SonidoClip("/separaci.wav");
	SonidoClip tama =new SonidoClip("/elTamanio.wav");


	//SonidoClip Inicio = new SonidoClip("resources/prueba1.wav");

	private void pararAudios() {
		brillo.stop();
		palidos.stop();
		separacion.stop();
		tama.stop();
		RecoDeSistemaVisualclip.stop();
		
		Inicio.stop();
		SistemaVisual.stop();
		InterfazCaracteriasticas.stop();
		Daltonismo.stop();

	}

	public void dispose() {
		pararAudios();
		super.dispose();
	}
	
	private void AgregarComportamientoAVentanas() {
		
		for(JFrame j : Ventanas) {
			((JComponent)j.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
			((JComponent)j.getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					pararAudios();
					 j.dispose();
				}
			});
	
		((JComponent)j.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("A"),"Anterior");
		((JComponent)j.getRootPane()).getActionMap().put("Anterior", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Ventanas.get(Actual).setVisible(false);
				 Ventanas.get(Actual > 0 ?  Actual= Actual-1: Actual).setVisible(true);
				 pararAudios();
				 VentanasAudios.get(Actual).loop();
				 
			}
		});
		((JComponent)j.getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("D"),"SIG");
		((JComponent)j.getRootPane()).getActionMap().put("SIG", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Ventanas.get(Actual).setVisible(false);
				 Ventanas.get(Actual < (Ventanas.size()-1) ?  Actual= Actual+1: Actual).setVisible(true);
				 pararAudios();
				 VentanasAudios.get(Actual).loop();
			}
		});
		}
	}
	private int Actual;
	public Vista() throws IOException {
		getRootPane().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				pararAudios();
				Inicio.loop();
			}
		});
		pararAudios();
		Inicio.loop();
		getContentPane().setBackground(Constantes.ColorFondo);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0 ,2*(Constantes.ComputadoraWidth/5), 3*(Constantes.ComputadoraHeight/6));
		getContentPane().setLayout(new BorderLayout(0, 0));
		//Agregar Ventanas
		
		Ventanas.add(this);
		VentanasAudios.add(Inicio);
		
		
		Ventanas.add(new Plantilla_Ventanas("FUNCIÓN DEL SISTEMA VISUAL", 
					"Captaci\u00f3n de los est\u00edmulos del espectro visible y su transformaci\u00f3n al sistema nervioso para ser procesado\n\n"
					, ImageIO.read(this.getClass().getResource("/Visual1.png")),"", this));
		VentanasAudios.add(SistemaVisual);

		Ventanas.add(new CarPerVisualInter(this));
		VentanasAudios.add(InterfazCaracteriasticas);

		Ventanas.add(new Daltonismo(this));
		VentanasAudios.add(Daltonismo);

		Ventanas.add(new RecoDeSistemaVisual(this));
		VentanasAudios.add(RecoDeSistemaVisualclip);

		
		JLabel lblNewLabel = new JLabel("SISTEMA VISUAL\u200B");
		lblNewLabel.setFont(Constantes.Titulos);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		Component verticalStrut = Box.createVerticalStrut(169);
		getContentPane().add(verticalStrut, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(176);
		getContentPane().add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(175);
		getContentPane().add(horizontalStrut_1, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panel.setBackground(Constantes.ColorFondo);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = Constantes.BotonRedondeado("Comenzar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Ventanas.get(0).setVisible(false);
				Ventanas.get(1).setVisible(true);
				Actual = 1;
			}
		});
		
		
		panel.add(btnNewButton, BorderLayout.CENTER);
		
		Component verticalStrut_1 = Box.createVerticalStrut(77);
		panel.add(verticalStrut_1, BorderLayout.NORTH);
		AgregarComportamientoAVentanas();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand()) {
		case "Anterior": 
			Ventanas.get(Actual).setVisible(false);
		   Ventanas.get(Actual > 0 ?  Actual= Actual-1: Actual).setVisible(true);;
			break;
		case "Siguiente": 
			Ventanas.get(Actual).setVisible(false);
		   Ventanas.get(Actual < (Ventanas.size()-1) ?  Actual= Actual+1: Actual).setVisible(true);;
			break;
		case "Inicio": 
			Ventanas.get(Actual).setVisible(false);
			Ventanas.get(0).setVisible(true);
			break;
		}
	}
	public class Daltonismo extends JFrame implements ChangeListener{
		JColorChooser JColorChooser;
		JButton ColorNormal = new JButton("Normal");
		JButton Colorprotanopia = new JButton("Protanopia");
		JButton Colordeuteranopia = new JButton("Deuteranopia");
		JButton Colortritanopia = new JButton("Tritanopia");
		
		public Daltonismo(ActionListener Padre){
			pararAudios();
			getContentPane().setBackground(Constantes.ColorFondo);
			setBounds(0, 0, (int)(Constantes.ComputadoraWidth/4)*3, (int)(Constantes.ComputadoraHeight/4)*3);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			getContentPane().setLayout(new BorderLayout());
		{
			JPanel JPanel_Botones = new JPanel();
			JPanel_Botones.setBackground(Constantes.ColorFondo);
			getContentPane().add(JPanel_Botones, BorderLayout.SOUTH);
			JPanel_Botones.setLayout(new GridLayout(1, 0, 0, 0));
			
			JButton Btn_Anterior = new JButton("Articulo Anterior");
			Btn_Anterior.setFont(new Font("Tahoma", Font.BOLD, 21));
			Btn_Anterior.setForeground(new Color(164, 36, 59));
			Btn_Anterior.setActionCommand("Anterior");
			Btn_Anterior.addActionListener(Padre);
			JPanel_Botones.add(Btn_Anterior);
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			JPanel_Botones.add(horizontalStrut_1);
			
			JButton Btn_Inicio = new JButton("Inicio");
			Btn_Inicio.setFont(new Font("Tahoma", Font.BOLD, 21));
			Btn_Inicio.setForeground(new Color(164, 36, 59));
			Btn_Inicio.setActionCommand("Inicio");
			Btn_Inicio.addActionListener(Padre);
			JPanel_Botones.add(Btn_Inicio);
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			JPanel_Botones.add(horizontalStrut);
			
			JButton Btn_Siguiente = new JButton("Articulo Siguiente");
			Btn_Siguiente.setFont(new Font("Tahoma", Font.BOLD, 21));
			Btn_Siguiente.setForeground(new Color(164, 36, 59));
			Btn_Siguiente.setActionCommand("Siguiente");
			Btn_Siguiente.addActionListener(Padre);
			JPanel_Botones.add(Btn_Siguiente);
			}
		
		JPanel centro  = new JPanel(new BorderLayout());
		centro.setBackground(Constantes.ColorFondo);
		 	JColorChooser  = new JColorChooser();
		 	JColorChooser.setBackground(Constantes.ColorFondo);
		 	centro.add(JColorChooser, BorderLayout.NORTH);
		 	JPanel panel  = new JPanel();
		 	panel.setBackground(Constantes.ColorFondo);
	        JColorChooser.setPreviewPanel(panel);
	        
	        
	        JColorChooser.getSelectionModel().addChangeListener(this);
	        JPanel MuestraColores = new JPanel(new GridLayout(1,0,0,0));
	        MuestraColores.setBackground(Constantes.ColorFondo);
	        
	        ColorNormal.setForeground(Color.white);
	        MuestraColores.add(ColorNormal);
	        Colordeuteranopia.setForeground(Color.white);
	        MuestraColores.add(Colordeuteranopia);
	        Colorprotanopia.setForeground(Color.white);
	        MuestraColores.add(Colorprotanopia);
	        Colortritanopia.setForeground(Color.white);
	        MuestraColores.add(Colortritanopia);
	        centro.add(MuestraColores,BorderLayout.CENTER);
	        
	        getContentPane().add(centro,BorderLayout.CENTER);
	        
		setVisible(false);
		}
		private void CambiarColores() {
			ColorNormal.setBackground(JColorChooser.getColor());
			Colordeuteranopia.setBackground(new Color(JColorChooser.getColor().getRed(),JColorChooser.getColor().getGreen()/4,JColorChooser.getColor().getBlue()));
			Colorprotanopia.setBackground(new Color(JColorChooser.getColor().getRed()/4,JColorChooser.getColor().getGreen(),JColorChooser.getColor().getBlue()));
			Colortritanopia.setBackground(new Color(JColorChooser.getColor().getRed(),JColorChooser.getColor().getGreen(),JColorChooser.getColor().getBlue()/4));	
		}
		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			CambiarColores();
		}
		
	
		
		
		
	}
	class brillo extends JFrame{
		public void dispose() {
			pararAudios();
			super.dispose();
		}
			public brillo() {
				pararAudios();
				brillo.loop();
				((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
				((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						 dispose();
					}
				});
				getContentPane().setBackground(Constantes.ColorFondo);
				setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				getContentPane().setLayout(new BorderLayout());
				setResizable(false);
				JPanel Principal = new JPanel(new BorderLayout());
				Principal.setBackground(Constantes.ColorFondo);
				try {
					Principal.add(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/Brillo.png")).getScaledInstance(8*(getWidth()/10), 8*(getWidth()/10),Image.SCALE_SMOOTH))), BorderLayout.CENTER);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				getContentPane().add(Principal,BorderLayout.CENTER);
				
				
				JLabel Titulo = new JLabel("Contraste de brillo y colores​");
				Titulo.setFont(Constantes.Titulos.deriveFont(new Float(getWidth()/30)));
				getContentPane().add(Titulo,BorderLayout.NORTH);
				
				
				JTextPane  Texto = new JTextPane();
				Texto.setBackground(Constantes.ColorFondo);
				Texto.setText("Dependiendo del fondo con el que se contrastan los colores puede parecer alguna tonalidad m\u00e1s brillante que otra");
				Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
				Texto.setEditable(false);
				getContentPane().add(Texto,BorderLayout.SOUTH);
				
				
				setVisible(true);
			}
		}
	 class Palidos extends JFrame{
			public void dispose() {
				pararAudios();
				super.dispose();
			}
			public Palidos() {
				pararAudios();
				palidos.loop();
				((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
				((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						 dispose();
					}
				});
				getContentPane().setBackground(Constantes.ColorFondo);
				setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				getContentPane().setLayout(new BorderLayout());
				setResizable(false);
				JPanel Principal = new JPanel(new BorderLayout());
				Principal.setBackground(Constantes.ColorFondo);
				try {
					Principal.add(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/Palidos.png")).getScaledInstance(6*(getWidth()/10), 6*(getWidth()/10),Image.SCALE_SMOOTH))), BorderLayout.CENTER);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				getContentPane().add(Principal,BorderLayout.CENTER);
				
				
				JLabel Titulo = new JLabel("Colores Palidos​");
				Titulo.setFont(Constantes.Titulos.deriveFont(new Float(getWidth()/30)));
				getContentPane().add(Titulo,BorderLayout.NORTH);
				
				JTextPane  Texto = new JTextPane();
				Texto.setBackground(Constantes.ColorFondo);
				Texto.setText("Los colores p\u00e1lidos son normalmente excluidos. No es recomendable poner objetos que planean ser visibles con estas tonalidades.");
				Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
				Texto.setEditable(false);
				getContentPane().add(Texto,BorderLayout.SOUTH);
				
				
				setVisible(true);
			}
		}
	 class separacion extends JFrame{
			public void dispose() {
				pararAudios();
				super.dispose();
			}
			public separacion() {
				pararAudios();
				separacion.loop();
				((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
				((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						 dispose();
					}
				});
				getContentPane().setBackground(Constantes.ColorFondo);
				setBounds(0,0 ,7*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				getContentPane().setLayout(new BorderLayout());
				setResizable(false);
				JPanel Principal = new JPanel(new GridLayout(1,0,0,0));
				Principal.setBackground(Constantes.ColorFondo);
				
				JButton btn1 = new JButton();
				btn1.setBackground(new Color(0.23f,0.65f,0.23f,1));
				Principal.add(btn1);
				
				Principal.add(Box.createHorizontalStrut(176));
				
				JButton btn2 = new JButton();
				btn2.setBackground(new Color(0.33f,0.55f,0.33f,1));
				Principal.add(btn2);
				
				
				
				getContentPane().add(Principal,BorderLayout.CENTER);
				
				
				JLabel Titulo = new JLabel("La separaci\u00f3n dificulta la distinci\u00f3n de colores​");
				Titulo.setFont(Constantes.Titulos.deriveFont(new Float(getWidth()/30)));
				getContentPane().add(Titulo,BorderLayout.NORTH);
				
				JTextPane  Texto = new JTextPane();
				Texto.setBackground(Constantes.ColorFondo);
				Texto.setText("Al separar objetos de similar color nuestra memoria le resulta m\u00e1s complicado distinguir si eran diferentes o no.");
				Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
				Texto.setEditable(false);
				getContentPane().add(Texto,BorderLayout.SOUTH);
				
				
				setVisible(true);
			}
		}
	 class Tam extends JFrame{
			public void dispose() {
				pararAudios();
				super.dispose();
			}
			
			public Tam() {
				pararAudios();
				tama.loop();
				((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
				((JComponent)getRootPane()).getActionMap().put("cerrar", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						 dispose();
					}
				});
				getContentPane().setBackground(Constantes.ColorFondo);
				setBounds(0,0 ,3*(Constantes.ComputadoraWidth/8), 3*(Constantes.ComputadoraHeight/8));
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				getContentPane().setLayout(new BorderLayout());
				setResizable(false);
				JPanel Principal = new JPanel(new BorderLayout());
				Principal.setBackground(Constantes.ColorFondo);
				try {
					Principal.add(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/Tam.png")).getScaledInstance(4*(getWidth()/10), 4*(getWidth()/10),Image.SCALE_SMOOTH))), BorderLayout.CENTER);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				getContentPane().add(Principal,BorderLayout.CENTER);
				
				
				JLabel Titulo = new JLabel("El tamaño dificulta la distinci\u00f3n de colores​");
				Titulo.setFont(Constantes.Titulos.deriveFont(new Float(getWidth()/30)));
				getContentPane().add(Titulo,BorderLayout.NORTH);
				
				JTextPane  Texto = new JTextPane();
				Texto.setBackground(Constantes.ColorFondo);
				Texto.setText("Dependiendo del tamaño del objeto puede ser mas complicadoo percibir ciertas tonalidades.");
				Texto.setFont(new Font("",1, getWidth()/(Texto.getText().length()/3)));
				Texto.setEditable(false);
				getContentPane().add(Texto,BorderLayout.SOUTH);
				
				
				setVisible(true);
			}
		}
	
	 
	 public class CarPerVisualInter extends JFrame implements  ActionListener{
	

	public CarPerVisualInter(ActionListener Padre) {
	getRootPane().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				pararAudios();
				InterfazCaracteriasticas.loop();
			}
		});
		setBounds(0, 0, (int)(Constantes.ComputadoraWidth/4)*3, (int)(Constantes.ComputadoraHeight/4)*3);
		getContentPane().setLayout(new BorderLayout());
		
		{
			JPanel JPanel_Botones = new JPanel();
			JPanel_Botones.setBackground(Constantes.ColorFondo);
			getContentPane().add(JPanel_Botones, BorderLayout.SOUTH);
			JPanel_Botones.setLayout(new GridLayout(1, 0, 0, 0));
			
			JButton Btn_Anterior = new JButton("Articulo Anterior");
			Btn_Anterior.setFont(new Font("Tahoma", Font.BOLD, 21));
			Btn_Anterior.setForeground(new Color(164, 36, 59));
			Btn_Anterior.setActionCommand("Anterior");
			Btn_Anterior.addActionListener(Padre);
			JPanel_Botones.add(Btn_Anterior);
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			JPanel_Botones.add(horizontalStrut_1);
			
			JButton Btn_Inicio = new JButton("Inicio");
			Btn_Inicio.setFont(new Font("Tahoma", Font.BOLD, 21));
			Btn_Inicio.setForeground(new Color(164, 36, 59));
			Btn_Inicio.setActionCommand("Inicio");
			Btn_Inicio.addActionListener(Padre);
			JPanel_Botones.add(Btn_Inicio);
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			JPanel_Botones.add(horizontalStrut);
			
			JButton Btn_Siguiente = new JButton("Articulo Siguiente");
			Btn_Siguiente.setFont(new Font("Tahoma", Font.BOLD, 21));
			Btn_Siguiente.setForeground(new Color(164, 36, 59));
			Btn_Siguiente.setActionCommand("Siguiente");
			Btn_Siguiente.addActionListener(Padre);
			JPanel_Botones.add(Btn_Siguiente);
			}
		
		
		
		JPanel Principal = new JPanel();
		Principal.setBackground(Constantes.ColorFondo);
		Principal.setLayout(new GridLayout(0,1,0,0));
		getContentPane().add(Principal,BorderLayout.CENTER);
		
		String[] Caracteristicas = {"Brillo" , "Colores Palidos", "Tamaño", "Separaci\u00f3n"};
		((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("Z"),"brillo");
		((JComponent)getRootPane()).getActionMap().put("brillo", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					 new brillo();
			}
		});	((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("X"),"Colores");
		((JComponent)getRootPane()).getActionMap().put("Colores", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 new Palidos();
				
			}
		});	((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("C"),"TAM");
		((JComponent)getRootPane()).getActionMap().put("TAM", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 new Tam();
			}
		});	((JComponent)getRootPane()).getInputMap().put(KeyStroke.getKeyStroke("V"),"SEP");
		((JComponent)getRootPane()).getActionMap().put("SEP", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			 new separacion();
			}
		});
		
		BotonesEnCascada caracteristicas = new BotonesEnCascada(Caracteristicas, this, new Font("",2,Constantes.PantallaSize.width/50), new Color(0.34f,0.236f,0.763f,1)) ;
		caracteristicas.setComponentsInJPanel(Principal);
	
		
		
		setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Brillo": 
			 new brillo();
			
			break;
		case "Colores Palidos":  
			new Palidos();
		break;
		case "Tamaño" :
			
			 new Tam();
			break;
		case "Separaci\u00f3n": 
			 new separacion();	
			break;
		
		
		
		
		}
	}
	
}
public class RecoDeSistemaVisual extends JFrame implements ActionListener{
	public RecoDeSistemaVisual (ActionListener Padre) {
	setBounds(0, 0, (int)(Constantes.ComputadoraWidth/4)*3, (int)(Constantes.ComputadoraHeight/4)*3);
	getContentPane().setLayout(new BorderLayout());
	{
		getContentPane().setBackground(Constantes.ColorFondo);
		JPanel JPanel_Botones = new JPanel();
		JPanel_Botones.setBackground(Constantes.ColorFondo);
		getContentPane().add(JPanel_Botones, BorderLayout.SOUTH);
		JPanel_Botones.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		JButton Btn_Anterior = new JButton("Articulo Anterior");
		Btn_Anterior.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Anterior.setForeground(new Color(164, 36, 59));
		Btn_Anterior.setActionCommand("Anterior");
		Btn_Anterior.addActionListener(Padre);
		JPanel_Botones.add(Btn_Anterior);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut_1);
		
		JButton Btn_Inicio = new JButton("Inicio");
		Btn_Inicio.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Inicio.setForeground(new Color(164, 36, 59));
		Btn_Inicio.setActionCommand("Inicio");
		Btn_Inicio.addActionListener(Padre);
		JPanel_Botones.add(Btn_Inicio);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut);
		
		JButton Btn_Siguiente = new JButton("Articulo Siguiente");
		Btn_Siguiente.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Siguiente.setForeground(new Color(164, 36, 59));
		Btn_Siguiente.setActionCommand("Siguiente");
		Btn_Siguiente.addActionListener(Padre);
		JPanel_Botones.add(Btn_Siguiente);
		}
	
	
	
	JPanel Principal = new JPanel();
	Principal.setBackground(Constantes.ColorFondo);
	Principal.setLayout(new GridLayout(0,1,0,0));
	getContentPane().add(Principal,BorderLayout.CENTER);
	
	String[] Caracteristicas = {"Tonalidad, Saturaci\u00f3n y Luminosidad.​" , "Colorometria y Simbologia​", "Personas con Limitaciones Visuales.", "Guiar Experiencia","Colores Claros con Fuertes.​"};
	BotonesEnCascada caracteristicas = new BotonesEnCascada(Caracteristicas, this, new Font("",2,Constantes.PantallaSize.width/50), new Color(0.34f,0.236f,0.763f,1)) ;
	caracteristicas.setComponentsInJPanel(Principal);
	
	
	
	setVisible(false);
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

}
