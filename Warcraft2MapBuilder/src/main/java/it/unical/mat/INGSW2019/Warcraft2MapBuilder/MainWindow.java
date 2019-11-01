package it.unical.mat.INGSW2019.Warcraft2MapBuilder;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import builder.AllyMapBuilder;

import java.awt.BorderLayout;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	JLabel imglabel;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 768, 724);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		imglabel = new JLabel("");
		imglabel.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(imglabel);
		AllyMapBuilder mp=new AllyMapBuilder(600,600);
		mp.createDirt(new Point(3,3));
		mp.createDirt(new Point(4,3));
		mp.createDirt(new Point(5,3));
		mp.createDirt(new Point(6,3));
		mp.createDirt(new Point(3,4));
		mp.createDirt(new Point(4,4));
		mp.createDirt(new Point(5,4));
		mp.createDirt(new Point(6,4));
		mp.createDirt(new Point(3,5));
		mp.createDirt(new Point(4,5));
		mp.createDirt(new Point(5,5));
		mp.createDirt(new Point(6,5));
		mp.createDirt(new Point(3,6));
		mp.createDirt(new Point(4,6));
		mp.createDirt(new Point(5,6));
		mp.createDirt(new Point(6,6));
		BufferedImage img =mp.getResult();
		imglabel.setIcon(new ImageIcon(img));
		frame.repaint();
	}

}
