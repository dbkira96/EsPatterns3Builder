package builder;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class MapBuilder implements Builder {
	
	int imgWidth=640;
	int imgHeight=640;
	
	public SpriteSheet sprite;
	protected BufferedImage buf;
	protected Graphics2D g2d ;
	int squaresize;
	
	public  MapBuilder(int imgW ,int imgH, int sqrsize) {
		
		imgWidth=imgW;
		imgHeight=imgH;
		squaresize=sqrsize;
		sprite=loadSprite();
		reset();
		
	}
	protected abstract SpriteSheet  loadSprite();
	
	protected ArrayList<Point> getPoints(int[] x,int[]y){
		ArrayList<Point> points=new ArrayList<Point>();
		for (int i=0;i<x.length;i++) 
			points.add(new Point(x[i],y[i]));	
		return points;
	}

	protected void DrawTile(ArrayList<Point> points, Point p) {
		Random r =new Random();
		Point pos =points.get(r.nextInt()&points.size()-1);
		//Point pos =points.get(r.nextInt());
		BufferedImage tile = sprite.getImageFor(pos);
		
		
		g2d.drawImage(tile,  p.x*squaresize, p.y*squaresize, squaresize, squaresize, null);
		
	}

	protected abstract ArrayList<Point> grassPoints();
	protected abstract ArrayList<Point> treePoints();
	protected abstract ArrayList<Point> sandPoints();
	protected abstract ArrayList<Point> waterPoints();
	protected abstract ArrayList<Point> dirtPoints();
	
	public void createDirt(Point p) {
		DrawTile(dirtPoints(),p);
	}
	public void createGrass(Point p) {
		DrawTile(grassPoints(),p);
	}
	public void createTree(Point p) {
		DrawTile(treePoints(),p);
	}
	public void createSand(Point p) {
		DrawTile(sandPoints(),p);
	}
	public void createWater(Point p) {
		DrawTile(waterPoints(),p);
	}
	public BufferedImage getResult() {
			return buf;
	}
	public void reset() {
		
        buf = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        g2d = buf.createGraphics();
	}
}
