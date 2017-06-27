package edu.chap7.generics;

import java.io.Serializable;

public class SaveMe implements Serializable {
	
	transient int x;
	int y;
	public SaveMe(int xVal ,int yVal) {
		x=xVal;
		y=yVal;
	}
	public int hashCode()
	{
		return x*y;
		
	}
	public boolean equals(Object o)
	{
		SaveMe test = (SaveMe) o;
		if(test.y == y && test.x == x)
			return true;
		else 
			return false;
		
	}

}
