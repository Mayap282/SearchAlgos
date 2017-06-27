package edu.files.prac;

import java.io.*;
import java.nio.CharBuffer;

import edu.algo.sort.BubbleSort;

public class BubbleSortFileHandling {
	
	public static void fileHandling(){
	int i=0;
	String s = new String();
	
	int size = 0;
	
	try
	{

		File f = new File("array.txt");
		FileReader fr = new FileReader("array.txt");
		BufferedReader br = new BufferedReader(fr);
		s=br.readLine();
		String[] in=s.split(" ");
		int[] arr = new int[in.length];
		for(i=0;i<in.length;i++)
		{
			//System.out.print(in[i]);
			arr[i]=Integer.parseInt(in[i]);
		}
		fr.close();
		BubbleSort.bubbleSort(arr, arr.length);
		for(i=0;i<arr.length;i++)
		{
			System.out.print("\t"+arr[i]);
		}
		File f1 = new File("array_outpput.txt");
		f1.createNewFile();
		PrintWriter pw = new PrintWriter(f1);
		for(i=0;i<arr.length;i++)
		{
			pw.print("\t"+arr[i]);
		}
		pw.flush();
		pw.close();
		
	}
	catch(IOException e){
		System.out.println("File Not founds");
	}
	}
}
