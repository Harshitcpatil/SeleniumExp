package com.sgtesting.programs;

public class ArrayDemo3 {

	public static void main(String[] args) {
		/*
		  Programatically assign Even numbers 40 to 60 in to an 1D array
		  Read the Elements from 1D Array
		  Solution:
		  Step 1: try to print the numbers 40 to 60
		  Step 2: In Between 40 to 60 numbers display/find only Even Number
		  Step 3: try to find the size of 1D array [how many Even numbers available 40 to 60]
		  Step 4: Assign  the Even Numbers to an Array
		  Step 5: Read The Elements
		 */
		int size=0;
		for(int i=40;i<=60;i++)
		{
			if(i%2==0)
			{
				size=size+1;
			}
		}
		System.out.println("# of Elements :"+size);
		int a[]=new int[size];
		int k=0;
		for(int j=40;j<=60;j++)
		{
			if(j%2==0)
			{
				a[k]=j;
				k=k+1;
			}
		}
		
		for(int zz:a)
		{
			System.out.print(zz+"  ");
		}
	}

}
