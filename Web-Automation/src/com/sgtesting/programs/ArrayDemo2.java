package com.sgtesting.programs;

import java.util.Arrays;

public class ArrayDemo2 {

	public static void main(String[] args) {
		int a[]= {4,6,1,10,2,5};
		Arrays.sort(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+"  ");
		}

	}

}
