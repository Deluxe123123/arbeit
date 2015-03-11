package tests;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;

public class Firstswing extends JFrame {

	
	private static final long serialVersionUID = -6708597768192860080L;
	private JPanel contentPane;
	private Timer animator;
	int breite = 750, höhe = 750, i = 1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Firstswing frame = new Firstswing();
					// Firstswing frameZwei = new Firstswing(150, 150);
					Firstswing frameDrei = new Firstswing(50, 50);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					// frameZwei.setLocationRelativeTo(null);
					// frameZwei.setVisible(true);
					frameDrei.setLocationRelativeTo(null);
					frameDrei.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Firstswing() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, breite, höhe);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnEdit = new JButton("Edit");
		menuBar.add(btnEdit);

		JButton btnDrckDenButten = new JButton("Drück den Butten und es Kracht");
		menuBar.add(btnDrckDenButten);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		final JLabel lblNeuerTextfeld = new JLabel("Neuer TextFeld");
		lblNeuerTextfeld.setFont(new Font("Arial Black", Font.BOLD, 75));
		lblNeuerTextfeld.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNeuerTextfeld, BorderLayout.CENTER);

		animator = new Timer(100, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				lblNeuerTextfeld
						.setFont(new Font("Arial Black", Font.BOLD, i++));
				if (i == 50) {
					i = 1;

				}

			}

		});

		animator.start();

	}

	public Firstswing(int breite, int höhe) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, breite, höhe);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnEdit = new JButton("Edit");
		menuBar.add(btnEdit);
		JButton btnEdit1 = new JButton("Edit1");
		menuBar.add(btnEdit1);
		JButton btnEdit2 = new JButton("Edit2");
		menuBar.add(btnEdit2);
		JButton btnEdit3 = new JButton("Edit3");
		menuBar.add(btnEdit3);

		JButton btnDrckDenButten = new JButton("Drück den Butten und es Kracht");
		menuBar.add(btnDrckDenButten);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
