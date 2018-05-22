package edu;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;

public class Main {
		
	
	public static void main(String [] args) {
		
		Parser parser = new Parser("sequence.txt");
		parser.read();
		List<Proces> allProcesses = parser.getAllProcesses();
		
		int timer = 0;
		int upperLimit = 50;
		int migrationNum = 0;
		int enquiriesNum = 0;
		
		Processor [] processors = new Processor [30];
		
		for(int i = 0; i < processors.length; i++) {
			processors[i] = new Processor(i);
			//System.out.println("number: " + processors[i].getNumber());
		}
		
		Iterator<Proces> iterator = allProcesses.iterator();
		Proces nextProces = iterator.next();

		Integer [] numbers = new Integer[30];
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(4);
		array.add(5);
		array.add(3);
		array.add(8);

		
		
		
		/*
		while(timer < 6945) {
		
			if(nextProces.getArrivalTime() <= timer) {	
				
				//recursiveSearch();
				 if(recursiveSearch == false) {
				 	//assign the process to its own processor
				 
				 //here look for executed processes
				
				nextProces = iterator.next();
			}			
			
			if(!iterator.hasNext()) {
				break;
			}

			timer++;
			
			 
		}
		//System.out.println("the end");
		*/
	}

}
