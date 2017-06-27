package edu.algo.sort;

public class MergeSort {

	public static int[][] split(int[] inputs)
	{
		int len = inputs.length;
		int mid=len/2;
		int []a = new int[mid];
		int []b = new int[len-mid];
		int[][] output=new int[2][];
		for(int i=0;i<mid;i++)
		{
			a[i]=inputs[i];
		}
		for(int i=mid,j=0;i<len;i++)
		{
			
			b[j]=inputs[i];
			j++;
		}
		output[0]=a;
		output[1]=b;
		return output;
	}
	

}
