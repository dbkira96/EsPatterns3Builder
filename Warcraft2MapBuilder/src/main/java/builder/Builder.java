package builder;

import java.io.File;

public interface Builder {
	public void createDirt(int x,int y);
	public void createGrass(int x,int y);
	public File getResult();
}
