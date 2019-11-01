package builder;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class MapBuilder implements Builder {
	
	int imgWidth=640;
	int imgHeight=640;
	int square=32;
	public SpriteSheet sprite;
	protected BufferedImage buf;
	protected Graphics2D g2d ;
	
	public void createDirt(Point p) {
		// TODO Auto-generated method stub

	}

	public void createGrass(Point p) {
		// TODO Auto-generated method stub

	}

	public BufferedImage getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createTree(Point p) {
		// TODO Auto-generated method stub

	}

	public void createSand(Point p) {
		// TODO Auto-generated method stub

	}

	public void createWater(Point p) {
		// TODO Auto-generated method stub

	}

}
