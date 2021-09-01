package com.sgtesting.programs;

public class TwoDimenstionalArray3 {

	public static void main(String[] args) {
		
		int a[][]= {{1,2,3},{4,5,6}};
		int b[][]= {{7,8},{9,10},{11,12}};
		int c[][]=new int[2][2];
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b[i].length;j++)
			{
				c[i][j]=0;
				for(int k=0;k<b.length;k++)
				{
					c[i][j]=c[i][j]+(a[i][k]*b[k][j]);
					
				}
				System.out.print(c[i][j]+"   ");
			}
			System.out.println();
		}
	}

}
