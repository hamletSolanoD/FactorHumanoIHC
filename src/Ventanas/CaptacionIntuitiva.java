package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ElementosPersonalizados.PanelGuia;
import ElementosPersonalizados.SonidoClip;
import PaquetePrincipal.Constantes;

public class CaptacionIntuitiva extends JFrame implements ActionListener{
	SonidoClip MenuAudio = new SonidoClip("/IntuicionEnLasInterfaces.wav");


	
	public void dispose() {
		MenuAudio.stop();
		super.dispose();
	}

	public CaptacionIntuitiva() throws IOException {
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
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0 ,2*(Constantes.ComputadoraWidth/3), 3*(Constantes.ComputadoraHeight/4));
		JFrame ventanaMuestra = new Plantilla_Ventanas("INTUICIÓN EN EL DESARROLLO DE INTERFACES", "Haciendo uso de una forma funcional, visibilidad y coherencia se puede lograr hacer una mec\u00e1nica intuitiva para el uso de cualquier persona sin necesidad de una capacitaci\u00f3n previa complicada o un raciocinio complejo.​\n\nEl punto negativo es que dependiendo del usuario la respuesta obvia puede variar, pero si el objetivo cumple mejor los puntos anteriores puede ser limitado este margen de error.​",ImageIO.read(getClass().getResource("/Intuicion.jpg")),"",true);
		ventanaMuestra.setVisible(false);
		setBackground(Constantes.ColorFondo);
		getContentPane().add(ventanaMuestra.getContentPane(),BorderLayout.CENTER);
		getContentPane().add(new PanelGuia(this,Constantes.ColorSecundario),BorderLayout.SOUTH);
		setVisible(true);
		

		((JComponent)this.rootPane).getInputMap().put(KeyStroke.getKeyStroke("A"),"ANTE");
		((JComponent)this.rootPane).getActionMap().put("ANTE", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 new CarDeApoyo(); dispose();
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
	}


		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand()) {
		case "Anterior": new CarDeApoyo(); dispose(); break;
		case "Siguiente":						break;
		
		case "Inicio": try {
			new Portada();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} dispose(); break;
			
		}
		}
	

}
