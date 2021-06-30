package PaquetePrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.Borders;

public interface Constantes {
	
	
	public static Color ColorFondo =  new Color(245,247,178);//new Color(170, 216, 211);
	public static Color ColorTitulos = new Color(137,5,150);//new Color(207,10,10);
	public static Color ColorSecundario = new Color(245,247,178);
	public static Color  ColorPrimario = new Color(137,5,150);


	
	public static Toolkit Computadora = Toolkit.getDefaultToolkit();
	
	public static Dimension PantallaSize = Computadora.getScreenSize();
	
	public static int ComputadoraWidth = PantallaSize.width;
	public static int ComputadoraHeight = PantallaSize.height;
	
	public static Font Titulos = new Font("",3, ComputadoraWidth/30);
	
	public static JButton BotonRedondeado(String n,Color BG, Color FG) {
		JButton okButton = new JButton(n);
		okButton.setBackground(BG);
		okButton.setForeground(FG);
		okButton.setOpaque(false);
		okButton.setFont(new Font("",2,30));
		okButton.setFont(new Font("",2,ComputadoraWidth/50));
		okButton.setBorder(new LineBorder(BG, 10, true));
	return 	okButton;
	}
	public static JButton BotonRedondeado(String n) {
		JButton okButton = new JButton(n);
		okButton.setBackground(ColorPrimario);
		okButton.setForeground(ColorPrimario);
		okButton.setOpaque(false);
		okButton.setFont(new Font("",2,ComputadoraWidth/50));
		okButton.setBorder(new LineBorder(ColorPrimario, 10, true));
	return 	okButton;
	}
	

}
