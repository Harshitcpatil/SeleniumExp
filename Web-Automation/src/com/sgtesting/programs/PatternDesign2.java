package com.sgtesting.programs;

public class PatternDesign2 {

	public static void main(String[] args) {
		
		/*
		 1
		 2  2
		 3  3  3
		 4  4  4  4
		 5  5  5  5  5
		 */
		int i=1;
		do
		{
			int k=1;
			do
			{
				System.out.print(i+"  ");
				k=k+1;
			}while(k<=i);
			i=i+1;
			System.out.println();
		}while(i<=5);

	}

}
