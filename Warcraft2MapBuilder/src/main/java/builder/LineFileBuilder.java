package builder;

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LineFileBuilder implements Builder {
	 File file = null;
     FileWriter fr = null;
     BufferedWriter br = null;
	public LineFileBuilder(String filename) {
		file= new File(filename); 
		Initialize();
	}
	
	public void Initialize() {
		try {
			 fr = new FileWriter(file);
	         br = new BufferedWriter(fr);
		}
	   catch (IOException e) {
          e.printStackTrace();
      }
	}
	
	public void createDirt(Point p) {

		try {
			br.write("DIRT,"+p.x+","+p.y);
			br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createGrass(Point p) {
		try {
			br.write("GRASS,"+p.x+","+p.y);
			br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	public void createTree(Point p) {
		try {
			br.write("TREE,"+p.x+","+p.y);
			br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createSand(Point p) {
		try {
			br.write("SAND,"+p.x+","+p.y);
			br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createWater(Point p) {
		try {
			br.write("WATER,"+p.x+","+p.y);
			br.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void getResult() {
		 try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}
}
