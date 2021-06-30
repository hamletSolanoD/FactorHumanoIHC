package ElementosPersonalizados;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import PaquetePrincipal.Constantes;

public class PanelGuia extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGuia(ActionListener listener) {
		
		this.setLayout(new GridLayout(1, 0, 0, 0));
		setBackground(Constantes.ColorFondo);
		JButton Btn_Anterior = Constantes.BotonRedondeado("Articulo Anterior",Constantes.ColorFondo,Constantes.ColorPrimario);
		Btn_Anterior.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Anterior.setActionCommand("Anterior");
		Btn_Anterior.addActionListener(listener);
		this.add(Btn_Anterior);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		this.add(horizontalStrut_1);
		
		JButton Btn_Inicio =Constantes.BotonRedondeado("Inicio",Constantes.ColorFondo,Constantes.ColorPrimario);
		Btn_Inicio.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Inicio.setActionCommand("Inicio");
		Btn_Inicio.addActionListener(listener);
		this.add(Btn_Inicio);
		
	
		Component horizontalStrut = Box.createHorizontalStrut(20);
		this.add(horizontalStrut);
		
		JButton Btn_Siguiente =Constantes.BotonRedondeado("Articulo Siguiente",Constantes.ColorFondo,Constantes.ColorPrimario);
		Btn_Siguiente.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Siguiente.setActionCommand("Siguiente");
		Btn_Siguiente.addActionListener(listener);
		this.add(Btn_Siguiente);
	}
public PanelGuia(ActionListener listener, Color ColorFondo) {
		
		this.setLayout(new GridLayout(1, 0, 0, 0));
		setBackground(ColorFondo);
		JButton Btn_Anterior = Constantes.BotonRedondeado("Articulo Anterior",Constantes.ColorFondo,Constantes.ColorPrimario);
		Btn_Anterior.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Anterior.setActionCommand("Anterior");
		Btn_Anterior.addActionListener(listener);
		this.add(Btn_Anterior);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		this.add(horizontalStrut_1);
		
		JButton Btn_Inicio =Constantes.BotonRedondeado("Inicio",Constantes.ColorFondo,Constantes.ColorPrimario);
		Btn_Inicio.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Inicio.setActionCommand("Inicio");
		Btn_Inicio.addActionListener(listener);
		this.add(Btn_Inicio);
		
	
		Component horizontalStrut = Box.createHorizontalStrut(20);
		this.add(horizontalStrut);
		
		JButton Btn_Siguiente =Constantes.BotonRedondeado("Articulo Siguiente",Constantes.ColorFondo,Constantes.ColorPrimario);
		Btn_Siguiente.setFont(new Font("Tahoma", Font.BOLD, 21));
		Btn_Siguiente.setActionCommand("Siguiente");
		Btn_Siguiente.addActionListener(listener);
		this.add(Btn_Siguiente);
	}

}
