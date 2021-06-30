package ElementosPersonalizados;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotonesEnCascada extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> botonesCascada = new ArrayList<JButton>();
	
	public BotonesEnCascada(String Palabra, ActionListener ActionListener, Font Fuente, Color ColorSed) {
		for(int i = 0; i < Palabra.length(); i++) 
			{
			
			JButton BotonNuevo = new JButton(Palabra.charAt(i)+"");
			BotonNuevo.setMargin(new Insets(4,4,4, 4));
			BotonNuevo.setFont(Fuente);
			BotonNuevo.setForeground(Color.white);
			Color Fondo = new Color(i*(ColorSed.getRed()/(Palabra.length())),i*(ColorSed.getGreen()/(Palabra.length())),i*(ColorSed.getBlue()/(Palabra.length())));
			BotonNuevo.setBackground(Fondo);
			BotonNuevo.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					BotonNuevo.setBackground(Fondo);

				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					BotonNuevo.setBackground(ColorSed.brighter());
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			BotonNuevo.addActionListener(ActionListener);
			botonesCascada.add(BotonNuevo);
			
			}
	}
	
	public BotonesEnCascada(String[] Palabra, ActionListener ActionListener, Font Fuente, Color ColorSed) {
		for(int i = 0; i < Palabra.length; i++) 
			{
			JButton BotonNuevo = new JButton(Palabra[i]+"");
			BotonNuevo.setFont(Fuente);
			BotonNuevo.setForeground(Color.white);
			Color Fondo = new Color(i*(ColorSed.getRed()/(Palabra.length)),i*(ColorSed.getGreen()/(Palabra.length)),i*(ColorSed.getBlue()/(Palabra.length)));
			BotonNuevo.setBackground(Fondo);
			BotonNuevo.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					BotonNuevo.setBackground(Fondo);

				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					BotonNuevo.setBackground(ColorSed.brighter());
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			BotonNuevo.setActionCommand(Palabra[i]);
			BotonNuevo.addActionListener(ActionListener);
			botonesCascada.add(BotonNuevo);
			
			}
	}
	
	public void setComponentsInJPanel(JPanel panelPadre ){
	for(JButton e : botonesCascada) {
		panelPadre.add(e);
	}
	}




}
