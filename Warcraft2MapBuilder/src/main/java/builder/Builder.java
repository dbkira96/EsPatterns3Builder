package builder;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;

public interface Builder {
	public void createDirt(Point p);
	public void createGrass(Point p);
	public void createTree(Point p);
	public void createSand(Point p);
	public void createWater(Point p);
}
