package com.sgtesting.programs;

public class ExampleDemo2 {

	public static void main(String[] args) {
		
		int marks=44;
		if((marks>=70) && (marks<=100))
		{
			System.out.println("FCD Result");
		}
		else if((marks>=60) && (marks<70))
		{
			System.out.println("FC Result");
		}
		else if((marks>=50) && (marks<60))
		{
			System.out.println("SC Result");
		}
		else if((marks>=35) && (marks<50))
		{
			System.out.println("PC Result");
		}
		else if((marks>=0) && (marks<35))
		{
			System.out.println("Failed Result");
		}
		else
		{
			System.out.println("Invalid Marks");
		}
	}

}
