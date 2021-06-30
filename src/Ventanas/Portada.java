package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import ElementosPersonalizados.SonidoClip;
import PaquetePrincipal.Constantes;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.awt.Color;


public class Portada extends JFrame implements ActionListener{
    
	SonidoClip MenuAudio = new SonidoClip("/PortadaAudio.wav");
	
	

	public void dispose() {
		
		MenuAudio.stop();
		super.dispose();
	}
	public Portada() throws IOException {
		MenuAudio.loop();
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("D"),"Siguiente");
		((JComponent)this.rootPane).getActionMap().put("Siguiente", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Introduccion(); dispose();
				MenuAudio.stop();
				System.out.println("Siguiente");
			}
		});
			((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("E"),"REPRODUCIR");
			((JComponent)this.rootPane).getActionMap().put("REPRODUCIR", new AbstractAction() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
				MenuAudio.stop();
				MenuAudio.loop();
				
					
				}
			});
		
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("W"),"Temario");
		((JComponent)this.rootPane).getActionMap().put("Temario", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Temario(); dispose();
				MenuAudio.stop();
				System.out.println("Temario");
				
			}
		});
		
		
		
		setBounds(0,0 ,2*(Constantes.ComputadoraWidth/3), 3*(Constantes.ComputadoraHeight/4));
		getContentPane().setBackground(Constantes.ColorFondo);    
		
		
		
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Constantes.ColorFondo);   
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut, BorderLayout.EAST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(214);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("EL FACTOR HUMANO");
		lblNewLabel.setForeground(Constantes.ColorTitulos);
		lblNewLabel.setFont(Constantes.Titulos);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Constantes.ColorFondo);    
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Constantes.ColorFondo);   
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_3, BorderLayout.NORTH);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_4, BorderLayout.SOUTH);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(85);
		panel_2.add(horizontalStrut_5, BorderLayout.WEST);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_6, BorderLayout.EAST);
		
		JButton btnNewButton = Constantes.BotonRedondeado("Continuar");
		btnNewButton.setActionCommand("Temario");
		btnNewButton.addActionListener(this);
		btnNewButton.setText("Temario (W)");
		panel_2.add(btnNewButton, BorderLayout.CENTER);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Constantes.ColorFondo);   
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_5, BorderLayout.NORTH);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_6, BorderLayout.SOUTH);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_7, BorderLayout.WEST);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(85);
		panel_3.add(horizontalStrut_8, BorderLayout.EAST);
		
		JButton btnNewButton_1 = Constantes.BotonRedondeado("Continuar");
		btnNewButton_1.setText("Continuar (D)");
		btnNewButton_1.setActionCommand("Continuar");
		btnNewButton_1.addActionListener(this);
		panel_3.add(btnNewButton_1, BorderLayout.CENTER);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		getContentPane().add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		getContentPane().add(horizontalStrut_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Constantes.ColorFondo); 
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut_2 = Box.createVerticalStrut(216);
		panel_4.add(verticalStrut_2, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_2 = new JButton(new ImageIcon(ImageIO.read(this.getClass().getResource("/IconoInfo.png")).getScaledInstance(getWidth()/30,getWidth()/30,Image.SCALE_SMOOTH)));
		panel_5.add(btnNewButton_2, BorderLayout.SOUTH);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand()) {
		case "Temario":  new Temario(); dispose(); break;
		case "Continuar": new Introduccion(); dispose(); break;
		
		case "Inicio": try {
			new Portada();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} dispose(); break;
		}
		
	}



}
