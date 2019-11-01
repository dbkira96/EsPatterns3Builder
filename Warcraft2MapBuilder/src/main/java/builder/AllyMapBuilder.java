package builder;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class AllyMapBuilder extends MapBuilder {


	
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
		int[] x= {9,10,11};
		int[] y= {9,9,9};
		ArrayList<Point> points = getPoints(x,y);
		DrawTile(points,p);
	}

	private void DrawTile(ArrayList<Point> points, Point p) {
		Random r =new Random();
		Point pos =points.get(r.nextInt()&points.size()-1);
		//Point pos =points.get(r.nextInt());
		BufferedImage tile = sprite.getImageFor(pos);
		g2d.drawImage(tile,  p.x*square, p.y*square, square, square, null);
		
	}

	public void createGrass(Point p) {
		int[] x= {10,11,12};
		int[] y= {12,12,12};
		
		ArrayList<Point> points = getPoints(x,y);
		DrawTile(points,p);

	}
	public void createTree(Point p) {
		int[] x= {12,13};
		int[] y= {5,5};
		ArrayList<Point> points = getPoints(x,y);
		DrawTile(points,p);
		
	}

	public void createSand(Point p) {
		createDirt(p);
		
	}

	public void createWater(Point p) {
		int[] x= {15,16,17,18};
		int[] y= {15,15,15,15};
		ArrayList<Point> points = getPoints(x,y);
		DrawTile(points,p);
		
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
