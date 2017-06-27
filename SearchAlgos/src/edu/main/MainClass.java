package edu.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.xml.bind.helpers.DefaultValidationEventHandler;

import edu.chap7.generics.DVDInfo;
import edu.chap7.generics.Employee;


public class MainClass {
	
	public static void main(String args[])
	{
		DVDInfo title = null;
		
		DVDInfo d = new DVDInfo("a","b","c");
		DVDInfo d1 = new DVDInfo("a1","b1","c1");
		DVDInfo d2 = new DVDInfo("a2","b2","c2");
		DVDInfo d3 = new DVDInfo("a3","b3","c3");
		d.toString();
		d.compareTo(title);
		
	}

}
