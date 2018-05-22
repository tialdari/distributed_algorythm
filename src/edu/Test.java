package edu;

import java.util.ArrayList;

public class Test {
	
	public static void main  (String [] args) {
		
		ArrayList<Integer>  numbers  = new ArrayList();
		
		for(int i = 1; i <= 30; i++) {
			numbers.add(i);
			//System.out.println("index: " + numbers.indexOf(i) + " number: " + i);
		}
		
		numbers.remove(0);
		
		for(Integer number : numbers) {
			System.out.println("index: " + numbers.indexOf(number) + " number: " + number);
		}
		
	}
}
