package directors;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import builder.Builder;

public class ASCIIDirector {

	FileReader fr;
	BufferedReader br;
	public ASCIIDirector(File f)  {
	
			try {
				fr=new FileReader(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			br =new BufferedReader(fr);
		
	}
	public void Construct(Builder b)  {
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
			        	b.createDirt(new Point(x,y));
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
