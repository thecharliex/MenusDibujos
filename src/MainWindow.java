import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;


public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar menu_bar;
	private PanelDibujo panel_dibujo;
	private ChangeColor change_color;
	private ChangeShape change_shape;
	JRadioButtonMenuItem[] color_item;
	JRadioButtonMenuItem[] figura_item;
	
	public MainWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		
		change_color = new ChangeColor();
		change_shape = new ChangeShape();
		
		addPanelDibujo();
		addMenu();
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainWindow();
	}
	
	private void addMenu() {
		menu_bar = new JMenuBar();
		
		JMenu menu_figura = new JMenu("Figura");
		JMenu menu_color = new JMenu("Color");
		
		String[] colores = { "Negro", "Azul", "Rojo", "Verde" };
		color_item = new JRadioButtonMenuItem[colores.length];
		ButtonGroup gpo_colores = new ButtonGroup();
		
		for(int i = 0; i < colores.length; i++) {
			color_item[i] = new JRadioButtonMenuItem(colores[i], true);
			color_item[i].addActionListener(change_color);
			gpo_colores.add(color_item[i]);
			menu_color.add(color_item[i]);
		}		
		String[] figuras = { "Rectangulo", "Circulo", "Ovalo", "Linea" };
		figura_item = new JRadioButtonMenuItem[colores.length];
		ButtonGroup gpo_figura = new ButtonGroup();
		
		for(int i = 0; i < figuras.length; i++) {
			figura_item[i] = new JRadioButtonMenuItem(figuras[i]);
			figura_item[i].addActionListener(change_shape);
			gpo_figura.add(figura_item[i]);
			menu_figura.add(figura_item[i]);
		}
		
		menu_bar.add(menu_figura);
		menu_bar.add(menu_color);
		
		this.setJMenuBar(menu_bar);
	}

	private void addPanelDibujo() {
		panel_dibujo = new PanelDibujo();
		panel_dibujo.setBackground(Color.YELLOW);
		this.add(panel_dibujo, BorderLayout.CENTER);
	}
	
	private class ChangeColor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String color = "";
			for(int i = 0; i < color_item.length; i++) {
				if(color_item[i].isSelected()) {
					color = color_item[i].getText();
					break;
				}
			}
			
			if(color == "Negro") {
				panel_dibujo.setColor(Color.BLACK);
			} else if(color == "Azul") {
				panel_dibujo.setColor(Color.BLUE);
			} else if(color == "Rojo") {
				panel_dibujo.setColor(Color.RED);
			} else if(color == "Verde") {
				panel_dibujo.setColor(Color.GREEN);
			}
			
			panel_dibujo.repaint();
			
		}
		
	}
	
	private class ChangeShape implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String figura = "";
			
			for(int i = 0; i < figura_item.length; i++) {
				if(figura_item[i].isSelected()) {
					figura = figura_item[i].getText();					
					break;
				}
			}
			
			panel_dibujo.setShape(figura);
			
		}
		
	}
}
