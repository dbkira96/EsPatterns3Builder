package builder;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class AllyMapBuilder extends MapBuilder {

	static String imgFile="AllyTerrain.png" ;
	
	public AllyMapBuilder(int x,int y,int s) {
		super(x,y,s);
	}
	
	public ArrayList<Point> dirtPoints() {
		int[] x= {9,10,11};
		int[] y= {9,9,9};
		return getPoints(x,y);
	}
	protected ArrayList<Point> grassPoints(){
		int[] x= {10,11,12};
		int[] y= {12,12,12};
		return getPoints(x,y);
	}
	public ArrayList<Point> treePoints() {
		int[] x= {12,13};
		int[] y= {5,5};
		return getPoints(x,y);	
	}

	public ArrayList<Point> sandPoints() {
		int[] x= {11};
		int[] y= {17};
		return getPoints(x,y);		
	}

	public ArrayList<Point> waterPoints() {
		int[] x= {15,16,17,18};
		int[] y= {15,15,15,15};
		return getPoints(x,y);
		
	}

	@Override
	protected SpriteSheet loadSprite() {
		BufferedImage img=null;
		try {
			img = ImageIO.read(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\"+imgFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SpriteSheet(img,0, 0, 1, 1, new Point(32,32));
	}
	
}
