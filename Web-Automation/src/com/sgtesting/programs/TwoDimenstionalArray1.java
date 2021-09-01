package com.sgtesting.programs;

public class TwoDimenstionalArray1 {

	public static void main(String[] args) {
		
		int a[][]= {{10,20,30},{40,50,60},{70,80,90}};
		
		System.out.println("# of Rows :"+a.length);
		System.out.println("# of columns :"+a[0].length);
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]+"   ");
			}
			System.out.println();
		}

	}

}
