package Ventanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PaquetePrincipal.Constantes;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Component;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

public class Plantilla_Ventanas extends JFrame {// cambiar el nombre de la clase por el nombre del articulo

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color Fondo = new Color(216, 201, 155);
	public Plantilla_Ventanas(String Titulo, String TextoParrafos, Image Imagen,String TextoDataInfo, ActionListener listener) {// cambiar nombre por el nuevo nombre del articulo
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit computadora = getToolkit();
		setBounds(0, 0, (int)(computadora.getScreenSize().getWidth()/4)*3, (int)(computadora.getScreenSize().getHeight()/4)*3);
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
		((JComponent)this.rootPane).getActionMap().put("cerrar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Constantes.ColorSecundario);
		setContentPane(contentPane);
		contentPane.setBackground(Constantes.ColorSecundario);
		
		
		JPanel JPanelTitulo = new JPanel();
		JPanelTitulo.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPanelTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel(Titulo);// Cambiar Titulo
		lblTitulo.setForeground(Constantes.ColorPrimario);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, (int)computadora.getScreenSize().getWidth()/(Titulo.length())));
		JPanelTitulo.add(lblTitulo);
		
		JPanel JPanel_Botones = new JPanel();
		JPanel_Botones.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPanel_Botones, BorderLayout.SOUTH);
		JPanel_Botones.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton Btn_Anterior = Constantes.BotonRedondeado("Articulo Anterior");
		Btn_Anterior.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Anterior.setActionCommand("Anterior");
		Btn_Anterior.addActionListener(listener);
		JPanel_Botones.add(Btn_Anterior);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut_1);
		
		JButton Btn_Inicio = Constantes.BotonRedondeado("Inicio");
		Btn_Inicio.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Inicio.setActionCommand("Inicio");
		Btn_Inicio.addActionListener(listener);
		JPanel_Botones.add(Btn_Inicio);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut);
		
		JButton Btn_Siguiente = Constantes.BotonRedondeado("Articulo Siguiente");
		Btn_Siguiente.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Siguiente.setActionCommand("Siguiente");
		Btn_Siguiente.addActionListener(listener);
		JPanel_Botones.add(Btn_Siguiente);
		
		
		JPanel JPaneContenido = new JPanel();
		JPaneContenido.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPaneContenido, BorderLayout.CENTER);
		JPaneContenido.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		JPanel JPanel_Texto = new JPanel();
		JPaneContenido.add(JPanel_Texto);
		JPanel_Texto.setBackground(Constantes.ColorSecundario);
		JPanel_Texto.setLayout(new BorderLayout());
		
		JScrollPane ScrollViewTexto = new JScrollPane();
		ScrollViewTexto.setSize(JPanel_Texto.getMaximumSize());
		ScrollViewTexto.setBackground(Constantes.ColorSecundario);
		ScrollViewTexto.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel_Texto.add(ScrollViewTexto);
		
		JTextPane Parrafos = new JTextPane();
		Parrafos.setBackground(Constantes.ColorSecundario);
		Parrafos.setForeground(Color.BLACK);
		Parrafos.setFont(new Font("", 0, 20));
		Parrafos.setEditable(false);
		Parrafos.setSize(ScrollViewTexto.getMaximumSize());
		Parrafos.setText(TextoParrafos); /// remplazar con los parrafos 
		ScrollViewTexto.setViewportView(Parrafos);
		
		

		
	
		
		JPanel Ficha = new JPanel();
		Ficha.setBackground(Constantes.ColorSecundario);
		Ficha.setLayout(new BorderLayout());
		Image ImagenPreview = null;		
	//	try {
		//	 ImagenPreview = ImageIO.read(getClass().getResource(Imagen));// Poner nombre del archivo de la imagen 
		//	 ImagenPreview = ImagenPreview.getScaledInstance(computadora.getScreenSize().width/5, computadora.getScreenSize().width/5, Image.SCALE_SMOOTH);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		JLabel label = null;
	
			label = new JLabel( new ImageIcon( Imagen));
	
			
		Ficha.add(label,BorderLayout.NORTH);
		JTextPane Data = new JTextPane();
		Data.setForeground(Color.BLACK);
		Data.setBackground(Constantes.ColorSecundario);
		Data.setFont(new Font("",3,20));
		Data.setEditable(false);
		Data.setText(TextoDataInfo); /// remplazar datos tecnicos 
		Data.setPreferredSize(new Dimension((int)(getWidth()/2),getHeight()));
		Ficha.add(Data);
		
		JScrollPane ScrollViewData = new JScrollPane(Ficha);
		ScrollViewData.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPaneContenido.add(ScrollViewData);		
		
		setVisible(false);
	}

	public Plantilla_Ventanas(String Titulo, Image Imagen1, Image Imagen2,String TextoDataInfo, ActionListener listener) {// cambiar nombre por el nuevo nombre del articulo
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit computadora = getToolkit();
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
		((JComponent)this.rootPane).getActionMap().put("cerrar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
			}
		});
		setBounds(0, 0, (int)(computadora.getScreenSize().getWidth()/4)*3, (int)(computadora.getScreenSize().getHeight()/4)*3);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Constantes.ColorSecundario);
		setContentPane(contentPane);
		
		
		JPanel JPanelTitulo = new JPanel();
		JPanelTitulo.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPanelTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel(Titulo);// Cambiar Titulo
		lblTitulo.setForeground(Constantes.ColorPrimario);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, (int)computadora.getScreenSize().getWidth()/(Titulo.length())));
		JPanelTitulo.add(lblTitulo);
		
		JPanel JPanel_Botones = new JPanel();
		JPanel_Botones.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPanel_Botones, BorderLayout.SOUTH);
		JPanel_Botones.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton Btn_Anterior = Constantes.BotonRedondeado("Articulo Anterior");
		Btn_Anterior.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Anterior.setActionCommand("Anterior");
		Btn_Anterior.addActionListener(listener);
		JPanel_Botones.add(Btn_Anterior);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut_1);
		
		JButton Btn_Inicio = Constantes.BotonRedondeado("Inicio");
		Btn_Inicio.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Inicio.setActionCommand("Inicio");
		Btn_Inicio.addActionListener(listener);
		JPanel_Botones.add(Btn_Inicio);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut);
		
		JButton Btn_Siguiente = Constantes.BotonRedondeado("Articulo Siguiente");
		Btn_Siguiente.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Siguiente.setActionCommand("Siguiente");
		Btn_Siguiente.addActionListener(listener);
		JPanel_Botones.add(Btn_Siguiente);
		
		
		JPanel JPaneContenido = new JPanel();
		contentPane.add(JPaneContenido, BorderLayout.CENTER);
		JPaneContenido.setLayout(new GridLayout(1, 0, 0, 0));

			
		{JPanel Ficha = new JPanel();
		Ficha.setBackground(Constantes.ColorSecundario);
		Ficha.setLayout(new BorderLayout());
		Image ImagenPreview = null;		
	//	try {
		//	 ImagenPreview = ImageIO.read(getClass().getResource(Imagen));// Poner nombre del archivo de la imagen 
		//	 ImagenPreview = ImagenPreview.getScaledInstance(computadora.getScreenSize().width/5, computadora.getScreenSize().width/5, Image.SCALE_SMOOTH);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		JLabel label = null;
	
		label = new JLabel( new ImageIcon( Imagen1.getScaledInstance(4*(getWidth()/10), 4*(getWidth()/10), Image.SCALE_DEFAULT)));
		
	
			
		Ficha.add(label,BorderLayout.NORTH);
		JTextPane Data = new JTextPane();
		Data.setForeground(Color.BLACK);
		Data.setBackground(Constantes.ColorSecundario);
		Data.setFont(new Font("",3,20));
		Data.setEditable(false);
		Data.setText(TextoDataInfo); /// remplazar datos tecnicos 
		Data.setPreferredSize(new Dimension((int)(getWidth()/2),getHeight()));
		Ficha.add(Data);
		
		JScrollPane ScrollViewData = new JScrollPane(Ficha);
		ScrollViewData.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPaneContenido.add(ScrollViewData);		
		}

		{JPanel Ficha2 = new JPanel();
		Ficha2.setBackground(Constantes.ColorSecundario);
		Ficha2.setLayout(new BorderLayout());
		Image ImagenPreview = null;		
	//	try {
		//	 ImagenPreview = ImageIO.read(getClass().getResource(Imagen));// Poner nombre del archivo de la imagen 
		//	 ImagenPreview = ImagenPreview.getScaledInstance(computadora.getScreenSize().width/5, computadora.getScreenSize().width/5, Image.SCALE_SMOOTH);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		JLabel label = null;
	
			label = new JLabel( new ImageIcon( Imagen2.getScaledInstance(4*(getWidth()/10), 4*(getWidth()/10), Image.SCALE_DEFAULT)));
	
			
		Ficha2.add(label,BorderLayout.NORTH);
		JTextPane Data2 = new JTextPane();
		Data2.setForeground(Color.BLACK);
		Data2.setBackground(Constantes.ColorSecundario);
		Data2.setFont(new Font("",3,20));
		Data2.setEditable(false);
		Data2.setText(TextoDataInfo); /// remplazar datos tecnicos 
		Data2.setPreferredSize(new Dimension((int)(getWidth()/2),getHeight()));
		Ficha2.add(Data2);
		
		JScrollPane ScrollViewData = new JScrollPane(Ficha2);
		ScrollViewData.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPaneContenido.add(ScrollViewData);		
		}
		setVisible(false);
	}

	public Plantilla_Ventanas(String Titulo, String TextoParrafos, Image Imagen,String TextoDataInfo) {// cambiar nombre por el nuevo nombre del articulo
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit computadora = getToolkit();
		Plantilla_Ventanas este = this;
		setBounds(0, 0, (int)(computadora.getScreenSize().getWidth()/4)*3, (int)(computadora.getScreenSize().getHeight()/4)*3);
		
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
		((JComponent)this.rootPane).getActionMap().put("cerrar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Constantes.ColorSecundario);
		setContentPane(contentPane);
		
		
		JPanel JPanelTitulo = new JPanel();
		JPanelTitulo.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPanelTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel(Titulo);// Cambiar Titulo
		lblTitulo.setForeground(Constantes.ColorPrimario);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, (int)computadora.getScreenSize().getWidth()/(Titulo.length())));
		JPanelTitulo.add(lblTitulo);
		
		JPanel JPanel_Botones = new JPanel();
		JPanel_Botones.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPanel_Botones, BorderLayout.SOUTH);
		JPanel_Botones.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut_1);
		
		JButton Btn_Inicio = Constantes.BotonRedondeado("Regresar");
		Btn_Inicio.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Inicio.setForeground(Constantes.ColorPrimario);
		Btn_Inicio.setActionCommand("Inicio");
		Btn_Inicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				este.dispose();
			}
		});
		JPanel_Botones.add(Btn_Inicio);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut);
		

		
		
		JPanel JPaneContenido = new JPanel();
		contentPane.add(JPaneContenido, BorderLayout.CENTER);
		JPaneContenido.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		JPanel JPanel_Texto = new JPanel();
		JPaneContenido.add(JPanel_Texto);
		JPanel_Texto.setLayout(new BorderLayout());
		
		JScrollPane ScrollViewTexto = new JScrollPane();
		ScrollViewTexto.setSize(JPanel_Texto.getMaximumSize());
		ScrollViewTexto.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel_Texto.add(ScrollViewTexto);
		
		JTextPane Parrafos = new JTextPane();
		Parrafos.setBackground(Constantes.ColorSecundario);
		Parrafos.setForeground(Color.black);
		Parrafos.setFont(new Font("", 0, 20));
		Parrafos.setEditable(false);
		Parrafos.setSize(ScrollViewTexto.getMaximumSize());
		Parrafos.setText(TextoParrafos); /// remplazar con los parrafos 
		ScrollViewTexto.setViewportView(Parrafos);
		
		

		
	
		
		JPanel Ficha = new JPanel();
		Ficha.setBackground(Constantes.ColorSecundario);
		Ficha.setLayout(new BorderLayout());
		Image ImagenPreview = null;		
	//	try {
		//	 ImagenPreview = ImageIO.read(getClass().getResource(Imagen));// Poner nombre del archivo de la imagen 
		//	 ImagenPreview = ImagenPreview.getScaledInstance(computadora.getScreenSize().width/5, computadora.getScreenSize().width/5, Image.SCALE_SMOOTH);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		JLabel label = null;
	
			label = new JLabel( new ImageIcon( Imagen.getScaledInstance(4*(getWidth()/10), 4*(getWidth()/10), Image.SCALE_DEFAULT)));
	
			
		Ficha.add(label,BorderLayout.CENTER);		
		JScrollPane ScrollViewData = new JScrollPane(Ficha);
		ScrollViewData.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPaneContenido.add(ScrollViewData);		
		
		setVisible(true);
	}
	public Plantilla_Ventanas(String Titulo, String TextoParrafos, Image Imagen,String TextoDataInfo, boolean var) {// cambiar nombre por el nuevo nombre del articulo
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit computadora = getToolkit();
		Plantilla_Ventanas este = this;
		setBounds(0, 0, (int)(computadora.getScreenSize().getWidth()/4)*3, (int)(computadora.getScreenSize().getHeight()/4)*3);
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("Q"),"cerrar");
		((JComponent)this.rootPane).getActionMap().put("cerrar", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Constantes.ColorSecundario);
		setContentPane(contentPane);
		
		
		JPanel JPanelTitulo = new JPanel();
		JPanelTitulo.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPanelTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel(Titulo);// Cambiar Titulo
		lblTitulo.setForeground(Constantes.ColorPrimario);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, (int)computadora.getScreenSize().getWidth()/(Titulo.length())));
		JPanelTitulo.add(lblTitulo);
		
		/*
		JPanel JPanel_Botones = new JPanel();
		JPanel_Botones.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPanel_Botones, BorderLayout.SOUTH);
		JPanel_Botones.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut_1);
		
		JButton Btn_Inicio = new JButton("Regresar");
		Btn_Inicio.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Inicio.setForeground(new Color(164, 36, 59));
		Btn_Inicio.setActionCommand("Inicio");
		Btn_Inicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				este.dispose();
			}
		});
		JPanel_Botones.add(Btn_Inicio);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		JPanel_Botones.add(horizontalStrut);
		*/

		
		
		JPanel JPaneContenido = new JPanel();
		contentPane.add(JPaneContenido, BorderLayout.CENTER);
		JPaneContenido.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		JPanel JPanel_Texto = new JPanel();
		JPaneContenido.add(JPanel_Texto);
		JPanel_Texto.setLayout(new BorderLayout());
		
		JScrollPane ScrollViewTexto = new JScrollPane();
		ScrollViewTexto.setSize(JPanel_Texto.getMaximumSize());
		ScrollViewTexto.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel_Texto.add(ScrollViewTexto);
		
		JTextPane Parrafos = new JTextPane();
		Parrafos.setBackground(Constantes.ColorSecundario);
		Parrafos.setForeground(Color.BLACK);
		Parrafos.setFont(new Font("", 0, 20));
		Parrafos.setEditable(false);
		Parrafos.setSize(ScrollViewTexto.getMaximumSize());
		Parrafos.setText(TextoParrafos); /// remplazar con los parrafos 
		ScrollViewTexto.setViewportView(Parrafos);
		
		

		
	
		
		JPanel Ficha = new JPanel();
		Ficha.setBackground(Constantes.ColorSecundario);
		Ficha.setLayout(new BorderLayout());
		Image ImagenPreview = null;		
	//	try {
		//	 ImagenPreview = ImageIO.read(getClass().getResource(Imagen));// Poner nombre del archivo de la imagen 
		//	 ImagenPreview = ImagenPreview.getScaledInstance(computadora.getScreenSize().width/5, computadora.getScreenSize().width/5, Image.SCALE_SMOOTH);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		JLabel label = null;
	
			label = new JLabel( new ImageIcon( Imagen.getScaledInstance(4*(getWidth()/10), 4*(getWidth()/10), Image.SCALE_DEFAULT)));
	
			
		Ficha.add(label,BorderLayout.CENTER);		
		JScrollPane ScrollViewData = new JScrollPane(Ficha);
		ScrollViewData.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPaneContenido.add(ScrollViewData);		
		
		setVisible(true);
	}
	public Plantilla_Ventanas() {
		// TODO Auto-generated constructor stub
	}
	

	public JInternalFrame getPlantillaInJInternalFrame(String Titulo, String TextoParrafos, BufferedImage Imagen) {
		JInternalFrame JInternalFrame = new JInternalFrame();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit computadora = getToolkit();
		Plantilla_Ventanas este = this;
		JInternalFrame.setTitle(Titulo);
		JInternalFrame.setBounds(0, 0, (int)(computadora.getScreenSize().getWidth()/4), (int)(computadora.getScreenSize().getHeight()/4));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Constantes.ColorSecundario);
		JInternalFrame.setContentPane(contentPane);
		
		
		JPanel JPanelTitulo = new JPanel();
		JPanelTitulo.setBackground(Constantes.ColorSecundario);
		contentPane.add(JPanelTitulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel(Titulo);// Cambiar Titulo
		lblTitulo.setForeground(Constantes.ColorPrimario);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, (int)computadora.getScreenSize().getWidth()/(Titulo.length())));
		JPanelTitulo.add(lblTitulo);
		
		

		
		
		JPanel JPaneContenido = new JPanel();
		contentPane.add(JPaneContenido, BorderLayout.CENTER);
		JPaneContenido.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		JPanel JPanel_Texto = new JPanel();
		JPaneContenido.add(JPanel_Texto);
		JPanel_Texto.setLayout(new BorderLayout());
		
		JScrollPane ScrollViewTexto = new JScrollPane();
		ScrollViewTexto.setSize(JPanel_Texto.getMaximumSize());
		ScrollViewTexto.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel_Texto.add(ScrollViewTexto);
		
		JTextPane Parrafos = new JTextPane();
		Parrafos.setBackground(Constantes.ColorSecundario);
		Parrafos.setForeground(Color.BLACK);
		Parrafos.setFont(new Font("", 0, 20));
		Parrafos.setEditable(false);
		Parrafos.setSize(ScrollViewTexto.getMaximumSize());
		Parrafos.setText(TextoParrafos); /// remplazar con los parrafos 
		ScrollViewTexto.setViewportView(Parrafos);
		
		

		
	
		
		JPanel Ficha = new JPanel();
		Ficha.setBackground(Constantes.ColorSecundario);
		Ficha.setLayout(new BorderLayout());
		Image ImagenPreview = null;		
	//	try {
		//	 ImagenPreview = ImageIO.read(getClass().getResource(Imagen));// Poner nombre del archivo de la imagen 
		//	 ImagenPreview = ImagenPreview.getScaledInstance(computadora.getScreenSize().width/5, computadora.getScreenSize().width/5, Image.SCALE_SMOOTH);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		JLabel label = null;
	
			label = new JLabel( new ImageIcon( Imagen));
	
			
		Ficha.add(label,BorderLayout.NORTH);
	

		
		JScrollPane ScrollViewData = new JScrollPane(Ficha);
		ScrollViewData.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPaneContenido.add(ScrollViewData);		
		
		JInternalFrame.setVisible(true);	
		JInternalFrame.setIconifiable(true);
		JInternalFrame.setClosable(false);
		JInternalFrame.setMaximizable(true);
		JInternalFrame.setResizable(true);
		JInternalFrame.setVisible(true);
		return JInternalFrame;
	}



}
