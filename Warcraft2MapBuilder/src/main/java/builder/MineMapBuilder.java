package builder;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MineMapBuilder extends MapBuilder {

	static String imgFile="MinecraftSprite.jpg" ;
	
	public MineMapBuilder(int imgW, int imgH,int s) {
		super(imgW, imgH,s);
		
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
		return new SpriteSheet(img,0, 0, 0, 0, new Point(75,75));
	}

	@Override
	protected ArrayList<Point> grassPoints() {
		int[] x= {4};
		int[] y= {3};
		return getPoints(x,y);
	}

	@Override
	protected ArrayList<Point> treePoints() {
		int[] x= {7};
		int[] y= {7};
		return getPoints(x,y);
	}

	@Override
	protected ArrayList<Point> sandPoints() {
		int[] x= {7};
		int[] y= {2};
		return getPoints(x,y);
	}

	@Override
	protected ArrayList<Point> waterPoints() {
		int[] x= {7};
		int[] y= {0};
		return getPoints(x,y);
	}

	@Override
	protected ArrayList<Point> dirtPoints() {
		int[] x= {0};
		int[] y= {9};
		return getPoints(x,y);
	}
	

}
