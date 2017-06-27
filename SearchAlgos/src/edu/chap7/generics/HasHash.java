package edu.chap7.generics;

public class HasHash {
	
	public int x;
	public HasHash(int xVal) {
		x=xVal;
	}
	public boolean equals(Object o)
	{
		HasHash h = (HasHash)o;
		if(h.x==this.x)
		{
			System.out.println("same hash code");
			return true;
		}
		else
			return false;
		
	}
	public int hashCode(){
		return (x*17);
	}


}
