/**
 * 
 */
package edu.algo.sort;

/**
 * @author Maya
 *
 */
public class BubbleSort{

	public static int[] bubbleSort(int[] inputs,int n){
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(inputs[j]>inputs[j+1])
				{
					swap(inputs, j, j+1);
				}
			}
		}
		return inputs;
	}
	public static void  swap(int []inputs,int i,int j)
	{
		int temp=inputs[i];
		inputs[i]=inputs[j];
		inputs[j]=temp;
	}
}
