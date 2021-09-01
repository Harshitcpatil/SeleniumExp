package com.sgtesting.programs;

public class TwoDimenstionalArray2 {

	public static void main(String[] args) {
		/*
		    Matrix Multiplication 
		 */
		int a[][]= {{1,1,1},{2,2,2},{3,3,3}};
		int b[][]= {{4,4,4},{5,5,5},{6,6,6}};
		int c[][]=new int[3][3];
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				c[i][j]=0;
				for(int k=0;k<a.length;k++)
				{
					c[i][j]=c[i][j]+(a[i][k]*b[k][j]);
					
				}
				System.out.print(c[i][j]+"   ");
			}
			System.out.println();
		}
		
	}

}
