package directors;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import builder.Builder;

public class ASCIIDirector implements Director {

	FileReader fr;
	BufferedReader br;
	File file;
	public ASCIIDirector(String f)  {
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
		int r;
		int x=0;
		int y=0;
		 try {
			while ((r = br.read()) != -1) {
			        char ch = (char) r;
			        switch(ch) {
			        case 'T':
			        	b.createTree(new Point(x,y));
			        	break;
			        case 'G':
			        	b.createGrass(new Point(x,y));
			        	break;
			        case 'D':
			        	b.createDirt(new Point(x,y));
			        	break;
			        case 'S':
			        	b.createSand(new Point(x,y));
			        	break;
			        case 'W':
			        	b.createWater(new Point(x,y));
			        	break;
			        }
			        x+=1;
			        if (ch=='\n') {
			        	x=0;
			        	y+=1;
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
