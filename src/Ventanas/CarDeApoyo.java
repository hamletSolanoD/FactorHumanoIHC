package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ElementosPersonalizados.BotonesEnCascada;
import ElementosPersonalizados.PanelGuia;
import ElementosPersonalizados.SonidoClip;
import PaquetePrincipal.Constantes;

public class CarDeApoyo extends JFrame implements ActionListener {
	SonidoClip MenuAudio = new SonidoClip("/CarDeApoyoMenuAudio.wav");

	@Override
	public void dispose() {
		MenuAudio.stop();
		super.dispose();
		
	}
	
	public CarDeApoyo() {
		rootPane.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				MenuAudio.stop();
				MenuAudio.loop();

			}
		});
		MenuAudio.loop();
		getContentPane().setBackground(Constantes.ColorFondo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0 ,2*(Constantes.ComputadoraWidth/3), 3*(Constantes.ComputadoraHeight/4));
		getContentPane().setLayout(new BorderLayout());
		
		
		JLabel titulo = new JLabel("CARACTERISTICAS PARA LA MEMORIA A LARGO PLAZO");
		titulo.setForeground(Constantes.ColorTitulos);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(Constantes.Titulos);
		getContentPane().add(titulo,BorderLayout.NORTH);
		
		
		JPanel principal = new JPanel(new GridLayout(0,1,0,0));
		principal.setBackground(Constantes.ColorFondo);
		String[] palabras = {"Relacionar la nueva informaci\u00f3n con recuerdos ya previos","Uso de m\u00e1s de un solo estimulo sensorial","Uso de patrones","Resaltar la informaci\u00f3n constantemente​","Repetici\u00f3n de la informaci\u00f3n sin ser invasivo​"};
		BotonesEnCascada btns = new BotonesEnCascada(palabras, this, new Font("",2,Constantes.PantallaSize.width/50), new Color(0.65f,0.45f,0.23f,1));
		btns.setComponentsInJPanel(principal);
		getContentPane().add(principal,BorderLayout.CENTER);
		
		getContentPane().add(new PanelGuia(this),BorderLayout.SOUTH);
		
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("A"),"ANTE");
		((JComponent)this.rootPane).getActionMap().put("ANTE", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Memorias(); dispose();
					}
		});
		
		
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("D"),"DESP");
		((JComponent)this.rootPane).getActionMap().put("DESP", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 try {
						new CaptacionIntuitiva();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} dispose(); 
					}
		});
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
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
	case "Anterior": new Memorias(); dispose(); break;
	case "Siguiente": try {
				new CaptacionIntuitiva();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} dispose(); break;
	case "Inicio": try {
		new Portada();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} dispose(); break;
		}
	}

}
