package builder;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class AllyMapBuilder implements Builder {

	int imgX=600;
	int imgY=600;
	int square=100;
	private SpriteSheet sprite;
	private BufferedImage buf;
	private Graphics2D g2d ;
	
	public AllyMapBuilder(int x,int y,int s) {
		imgX=x;
		imgY=y;
		square=s;
		//sprite=new SpriteSheet(new BufferedImage(), s, s, s, s, null);
		reset();
	}
	
	public void createDirt(int x, int y) {
		// TODO Auto-generated method stub

	}

	public void createGrass(int x, int y) {
		// TODO Auto-generated method stub

	}

	public File getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public void reset() {
		// Constructs a BufferedImage of one of the predefined image types.
         buf = new BufferedImage(imgX, imgY, BufferedImage.TYPE_INT_RGB);
         g2d = buf.createGraphics();
	}
}
