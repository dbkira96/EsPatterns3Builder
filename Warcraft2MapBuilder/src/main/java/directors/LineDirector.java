package directors;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import builder.Builder;

public class LineDirector implements Director{
	FileReader fr;
	BufferedReader br;
	File file;
	public LineDirector(String f)  {
		file=new File(f);
		
			
		
	}
	public void initialize() {
		try {
			fr=new FileReader(file);
			br =new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void construct(Builder b)  {
		initialize();
		String line ;
		int x=0;
		int y=0;
		String type;
		 try {
			while ((line = br.readLine()) != null) {
			       
					type=line.split(",")[0];
					x= Integer.parseInt(line.split(",")[1]);
					y= Integer.parseInt(line.split(",")[2]);
					
					switch(type) {
			        case "TREE":
			        	b.createTree(new Point(x,y));
			        	break;
			        case "GRASS":
			        	b.createGrass(new Point(x,y));
			        	break;
			        case "DIRT":
			        	b.createDirt(new Point(x,y));
			        	break;
			        case "SAND":
			        	b.createSand(new Point(x,y));
			        	break;
			        case "WATER":
			        	b.createWater(new Point(x,y));
			        	break;
			        }
					
			    }
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
