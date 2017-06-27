package edu.files.prac;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BasicFileHandling {
	public static  void fileHandling(){
		char[] in =new char[50];
		int size =0;
		try
		{
			File file =new File("fileWrite1.txt");
			FileWriter fw = new FileWriter(file);
			fw.write("amazing \nme\n");
			fw.flush();
			fw.close();
			FileReader fr = new FileReader(file);
			size = fr.read(in);
			System.out.println(size+ " ");
			for(char c :in)
				System.out.print(c);
			File mydir = new File("mydir");
			mydir.mkdir();
			File myfile =new File(mydir,"myfile.txt");
			myfile.createNewFile();
			PrintWriter pw = new PrintWriter(myfile);
			pw.print("new stuff");
			pw.flush();
			pw.close();
			
		}
		catch(IOException e)
		{
			
		}
	}

}
