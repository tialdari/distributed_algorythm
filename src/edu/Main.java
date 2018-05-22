package edu;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;

public class Main {
		
	
	public static void main(String [] args) {
		
		Parser parser = new Parser("sequence.txt");
		parser.read();
		
		int timer = 0;
		int upperLimit = 50;
		int migrationNum = 0;
		int enquiriesNum = 0;
		
		ArrayList<Processor> processors = new ArrayList<Processor>();
		
		for(int i = 0; i < 30; i++) {
			processors.add(new Processor(i));
		}
		
		List<Proces> allProcesses = parser.getAllProcesses();
		Iterator<Proces> iterator = allProcesses.iterator();
		Proces nextProces = iterator.next();
		
		SearchMethods sm = new SearchMethods();
		
		int procNum = 0;
		
		while(timer < 6945) {
		
			if(nextProces.getArrivalTime() <= timer) {	
				
				procNum = sm.recursiveSearch(new ArrayList(processors), nextProces, upperLimit);
				 if(procNum >= 0) {
					 processors.get(procNum).addProcess(nextProces);
					 System.out.print(" current usage: " + processors.get(procNum).getCurrentUsage() + "\n");
				 }else {
					 System.out.println("To your own processor");
					 processors.get(nextProces.getProcessorNumber()).addProcess(nextProces);
				 }
				
				nextProces = iterator.next();
			}			
			
			if(!iterator.hasNext()) {
				break;
			}

			timer++;
			
			 
		}
		System.out.println("the end");
		
	}

}
