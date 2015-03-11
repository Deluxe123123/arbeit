import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Oberfläche extends JFrame {


	private Toolkit t;
	private int x, y;
	
	
	private	JMenuBar menuBar1;
	private JMenu menuBar1_menu1;
	private JMenu menuBar1_menu2;
	private JMenu menuBar1_menu3;
	private JMenu menuBar1_menu4;
	private JMenu menuBar1_menu5;
	private JMenuItem menuBar1_menu1_item1;
	private JMenuItem menuBar1_menu1_item2;
	private JMenuItem menuBar1_menu1_item3;
	private JMenuItem menuBar1_menu2_item1;
	private JMenuItem menuBar1_menu2_item2;
	private JMenuItem menuBar1_menu2_item3;
	private JMenuItem menuBar1_menu3_item1;
	private JMenuItem menuBar1_menu3_item2;
	private JMenuItem menuBar1_menu3_item3;
	private JMenuItem menuBar1_menu4_item1;
	private JMenuItem menuBar1_menu4_item2;
	private JMenuItem menuBar1_menu4_item3;
	private JMenuItem menuBar1_menu5_item1;
	private JMenuItem menuBar1_menu5_item2;

	
	public static void main(String[] args) {
		
		new Oberfläche("Console", 500, 500, true);
				
	}
	
	
	public Oberfläche(String Titel, int höhe, int breite, boolean mitMenu) {
		
		t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		y = (int) ((d.getHeight()-höhe) /2);
		x = (int) ((d.getWidth()-breite)/2);
		
		setTitle("Console");
		setBounds(x,y,breite,höhe);
		getContentPane().setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (mitMenu) {
			this.initMenu();	
			this.lauscher();
		}
		
	
		
		setResizable(true);
		setVisible(true);
	
	}
	
	
	public void lauscher() {
		
		this.menuBar1_menu1_item1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
								
				new Oberfläche("Neu", 300, 300, false);
				
			}
		});
		
	}
	
	private void initMenu(){
		this.menuBar1 = new JMenuBar();
		
		this.menuBar1_menu1 = new JMenu("Datei");
		this.menuBar1_menu2 = new JMenu("Bearbeiten");
		this.menuBar1_menu3 = new JMenu("Einstellungen");
		this.menuBar1_menu4 = new JMenu("Ansicht");
		this.menuBar1_menu5 = new JMenu("Info");
		
		this.menuBar1_menu1_item1 = new JMenuItem("Neu");
		this.menuBar1_menu1_item2 = new JMenuItem("Datei öffnen");
		this.menuBar1_menu1_item3 = new JMenuItem("Speichern");
		
		this.menuBar1_menu2_item1 = new JMenuItem("Rückgängig");
		this.menuBar1_menu2_item2 = new JMenuItem("Kopieren");
		this.menuBar1_menu2_item3 = new JMenuItem("Ausschneiden");
		
		this.menuBar1_menu3_item1 = new JMenuItem("Fenster Einstellungen");
		this.menuBar1_menu3_item2 = new JMenuItem("Anfänger Modus");
		this.menuBar1_menu3_item3 = new JMenuItem("Erweiterte Einstellungen");
		
		this.menuBar1_menu4_item1 = new JMenuItem("Neue Menüleiste");
		this.menuBar1_menu4_item2 = new JMenuItem("Symbole");
		this.menuBar1_menu4_item3 = new JMenuItem("Invert");
		
		this.menuBar1_menu5_item1 = new JMenuItem("Führe Update durch");
		this.menuBar1_menu5_item2 = new JMenuItem("Über uns");
	
		
		this.setJMenuBar(this.menuBar1);
		
		this.menuBar1.add(menuBar1_menu1);
		this.menuBar1.add(menuBar1_menu2);
		this.menuBar1.add(menuBar1_menu3);
		this.menuBar1.add(menuBar1_menu4);
		this.menuBar1.add(menuBar1_menu5);
		
		this.menuBar1_menu1.add(menuBar1_menu1_item1);
		this.menuBar1_menu1.add(menuBar1_menu1_item2);
		this.menuBar1_menu1.add(menuBar1_menu1_item3);
		
		this.menuBar1_menu2.add(menuBar1_menu2_item1);
		this.menuBar1_menu2.add(menuBar1_menu2_item2);
		this.menuBar1_menu2.add(menuBar1_menu2_item3);
		
		this.menuBar1_menu3.add(menuBar1_menu3_item1);
		this.menuBar1_menu3.add(menuBar1_menu3_item2);
		this.menuBar1_menu3.add(menuBar1_menu3_item3);
		
		this.menuBar1_menu4.add(menuBar1_menu4_item1);
		this.menuBar1_menu4.add(menuBar1_menu4_item2);
		this.menuBar1_menu4.add(menuBar1_menu4_item3);
		
		this.menuBar1_menu5.add(menuBar1_menu5_item1);
		this.menuBar1_menu5.add(menuBar1_menu5_item2);
			
	}
}
