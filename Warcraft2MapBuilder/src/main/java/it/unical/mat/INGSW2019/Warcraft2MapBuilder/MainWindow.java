package it.unical.mat.INGSW2019.Warcraft2MapBuilder;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import builder.AllyMapBuilder;
import builder.HordeMapBuilder;
import builder.LineFileBuilder;
import builder.MapBuilder;
import builder.MineMapBuilder;
import directors.ASCIIDirector;
import directors.LineDirector;

import java.awt.BorderLayout;
import java.awt.Color;

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
		frame.setBounds(0, 0, 640, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		imglabel = new JLabel("");
		imglabel.setBackground(Color.GREEN);
		imglabel.setBounds(0, 0, 640, 640);
		frame.getContentPane().add(imglabel);
		
		//Linedirector->mapBuilder
		MapBuilder mp=new MineMapBuilder(640,640,32);
		ASCIIDirector ldr =new ASCIIDirector(System.getProperty("user.dir")+"\\src\\main\\resources\\"+"mapASCII");
		//LineDirector ldr =new LineDirector(System.getProperty("user.dir")+"\\src\\main\\resources\\"+"mapLINED");
		ldr.construct(mp);
		BufferedImage img =mp.getResult();
		////ASCIIDirector-->LineBuilder
		//ASCIIDirector dr =new ASCIIDirector(System.getProperty("user.dir")+"\\src\\main\\resources\\"+"mapASCII");
		//LineFileBuilder lb = new LineFileBuilder(System.getProperty("user.dir")+"\\src\\main\\resources\\"+"mapLINED");
		//dr.construct(lb);
		//lb.getResult();
		
		
		
		
		
		
		imglabel.setIcon(new ImageIcon(img));
		frame.repaint();
	}

}
