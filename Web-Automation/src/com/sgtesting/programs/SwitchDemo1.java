package com.sgtesting.programs;

public class SwitchDemo1 {

	public static void main(String[] args) {

		char ch='U';
		switch(ch)
		{
		case 'A':case 'E': case 'I':case 'O':case 'U':
			System.out.println(ch+" is a Vowel");
		    break;
		case 'a':case 'e': case 'i':case 'o':case 'u':
			System.out.println(ch+" is a Vowel");
		    break;
		default:
			System.out.println("It is not a Vowel");
		
		}

	}

}
