package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Temario extends JFrame implements ActionListener {
	SonidoClip MenuAudio = new SonidoClip("/TemarioMenuAudio.wav");;
	
	public Temario() {
		MenuAudio.loop();
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("E"),"REPRODUCIR");
		((JComponent)this.rootPane).getActionMap().put("REPRODUCIR", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			MenuAudio.stop();
			MenuAudio.loop();
			
				
			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("Z"),"INT");
		((JComponent)this.rootPane).getActionMap().put("INT", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Introduccion(); MenuAudio.stop(); dispose(); 
				
			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("X"),"SIS");
		((JComponent)this.rootPane).getActionMap().put("SIS", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SistemasDeEntradaYSalida(); MenuAudio.stop(); dispose();				
			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("C"),"PERC");
		((JComponent)this.rootPane).getActionMap().put("PERC", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PercepcionDeTiempo(); MenuAudio.stop(); dispose();			
			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("V"),"GESTALT");
		((JComponent)this.rootPane).getActionMap().put("GESTALT", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 new PrincipioGESTAL(); MenuAudio.stop(); dispose();			}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("B"),"COG");
		((JComponent)this.rootPane).getActionMap().put("COG", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 new Memorias(); MenuAudio.stop(); dispose();		}
		});
		
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("N"),"CARAPOYO");
		((JComponent)this.rootPane).getActionMap().put("CARAPOYO", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new CarDeApoyo(); MenuAudio.stop(); dispose();		}
		});
		
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("M"),"INTU");
		((JComponent)this.rootPane).getActionMap().put("INTU", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					new CaptacionIntuitiva();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} MenuAudio.stop(); dispose();		}
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
				} MenuAudio.stop(); dispose();	}
		});
		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("D"),"Siguiente");
		((JComponent)this.rootPane).getActionMap().put("Siguiente", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Introduccion();   MenuAudio.stop(); dispose();	}
		});
		
		setBackground(Constantes.ColorFondo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0 ,2*(Constantes.ComputadoraWidth/3), 3*(Constantes.ComputadoraHeight/4));
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(Constantes.ColorFondo);

		
		
		JLabel titulo = new JLabel("Temario");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(Constantes.Titulos);
		getContentPane().add(titulo,BorderLayout.NORTH);
		
		
		JPanel principal = new JPanel(new GridLayout(0,1,0,0));
		principal.setBackground(Constantes.ColorFondo);

		String[] palabras = {"INTRODUCCIÓN (Z)","SISTEMAS DE ENTRADA Y SALIDA (X)","PERCEPCI\u00D3N DE TIEMPO (C)","GESTALT (V)","COGNICIÓN (B)","CARACTERISTICAS PARA LA MEMORIA A LARGO PLAZO (N)","INTUICIÓN EN EL DESARROLLO (M)"};
		BotonesEnCascada btns = new BotonesEnCascada(palabras, this, new Font("",2,Constantes.PantallaSize.width/50), new Color(0.65f,0.45f,0.23f,1));
		
		
		btns.setComponentsInJPanel(principal);
		getContentPane().add(principal,BorderLayout.CENTER);
		
		getContentPane().add(new PanelGuia(this),BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Anterior": try {
				new Portada();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   MenuAudio.stop(); dispose(); break;
		case "Siguiente": new Introduccion();   MenuAudio.stop(); dispose(); break;
		case "INTRODUCCIÓN (Z)": new Introduccion(); MenuAudio.stop(); dispose(); break;
		case "SISTEMAS DE ENTRADA Y SALIDA (X)": new SistemasDeEntradaYSalida(); MenuAudio.stop(); dispose(); break;
		case "PERCEPCI\u00D3N DE TIEMPO (C)": new PercepcionDeTiempo(); MenuAudio.stop(); dispose(); break;
		case "GESTALT (V)": new PrincipioGESTAL(); MenuAudio.stop(); dispose(); break;
		case "COGNICIÓN (B)": new Memorias(); MenuAudio.stop(); dispose(); break;
		case "CARACTERISTICAS PARA LA MEMORIA A LARGO PLAZO (N)": new CarDeApoyo(); MenuAudio.stop(); dispose(); break;
		case "INTUICIÓN EN EL DESARROLLO (M)":try {
				new CaptacionIntuitiva();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} MenuAudio.stop(); dispose(); break;
		case "Inicio": try {
			new Portada();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} MenuAudio.stop(); dispose(); break;
		
		}		
	}

}
