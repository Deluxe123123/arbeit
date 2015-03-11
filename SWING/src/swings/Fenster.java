package swings;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class Fenster extends JFrame {

	private static final long serialVersionUID = 2285985931677908156L;
	private static JPanel mainPanel;
	private JLabel label;
	private int zeilen = 0;
	private int spalten = 0;
	private List<JLabel> lblList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenster frame = new Fenster();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Fenster() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setFocusable(true);
		setVisible(true);
		
		
		mainPanel = new JPanel();
		mainPanel.setSize(new Dimension(560, 300));
		mainPanel.setPreferredSize(new Dimension(560, 300));
		mainPanel.setMinimumSize(new Dimension(560, 300));
		mainPanel.setMaximumSize(new Dimension(560, 300));
		mainPanel.setSize(560, 300);
		mainPanel.setBackground(Color.BLACK);
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		pack();
		
		
		
		lblList = new ArrayList<JLabel>();

		for (int i = 0; i < 2000; i++) {

			label = new JLabel();
			label.setHorizontalTextPosition(SwingConstants.CENTER);
			label.setForeground(Color.WHITE);
			label.setBorder(null);
			label.setFont(new Font("Lucida Console", Font.PLAIN, 12));
			label.setBounds(spalten, zeilen, 7, 12);
			mainPanel.add(label);
			lblList.add(label);
			
			
			
			if (spalten <= 546) {
				spalten = spalten + 7;
			} else {
				spalten = 0;
				zeilen = zeilen + 12;
			}

		}

		Spaceinvaders spaceInvaders = new Spaceinvaders(this);
		Tickrate tickrate = new Tickrate(spaceInvaders);
		tickrate.verzögerung();

	}

	public List<JLabel> getLblList() {
		return lblList;
	}

	public void setLblList(List<JLabel> lblList) {
		this.lblList = lblList;
	}

}
