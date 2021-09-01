package com.sgtesting.programs;

import java.util.Arrays;

public class ArrayDemo1 {

	public static void main(String[] args) {
		
		int a[]={10,20,30,40};
		
		
		int i=0;
		for(int kk:a)
		{
			if(i==2)
			{
				System.out.println(kk);
				break;
			}
			i+=1;
		}
		
		
	

	}

}
