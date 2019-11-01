package builder;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class AllyMapBuilder implements Builder {

	int imgWidth=600;
	int imgHeight=600;
	int square=32;
	public SpriteSheet sprite;
	private BufferedImage buf;
	private Graphics2D g2d ;
	
	public AllyMapBuilder(int x,int y) {
		imgWidth=x;
		imgHeight=y;
		
		try {
			BufferedImage img= ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\"+"AllyTerrain.png")); 
			sprite=new SpriteSheet(img,0, 0, 1, 1, new Point(32,32));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reset();
	}
	
	public void createDirt(Point p) {
		int[] x= {9,10,11,12,13,14,15,17,18,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int[] y= {9,9,9,9,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		ArrayList<Point> points = getPoints(x,y);
		Random r =new Random();
		Point pos =points.get(r.nextInt()&points.size());
		BufferedImage tile = sprite.getImageFor(pos);
		g2d.drawImage(tile,  p.x*square, p.y*square, square, square, null);
	}

	public void createGrass(Point p) {
		

	}

	public BufferedImage getResult() {
		// TODO Auto-generated method stub
		return buf;
	}
	
	private ArrayList<Point> getPoints(int[] x,int[]y){
		ArrayList<Point> points=new ArrayList<Point>();
		for (int i=0;i<x.length;i++) 
			points.add(new Point(x[i],y[i]));	
		return points;
	}
	
	public void reset() {
		// Constructs a BufferedImage of one of the predefined image types.
         buf = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
         g2d = buf.createGraphics();
	}
}
