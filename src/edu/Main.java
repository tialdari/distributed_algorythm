package edu;

import java.util.List;
import java.util.Iterator;

public class Main {
		
	
	public static void main(String [] args) {
		
		Parser parser = new Parser("sequence.txt");
		parser.read();
		List<Proces> allProcesses = parser.getAllProcesses();
		
		int timer = 0;
		int upperLimit = 0;
		int migrationNum = 0;
		int enquiriesNum = 0;
		
		Processor [] processors = new Processor [30];
		
		for(int i = 0; i < processors.length; i++) {
			processors[i] = new Processor();
		}
		
		Iterator<Proces> iterator = allProcesses.iterator();
		Proces nextProces = iterator.next();
		
		while(timer < 6946 && iterator.hasNext()) {
			
			if(nextProces.getArrivalTime() <= timer) {
				
				System.out.println("time: " + timer);
				nextProces = iterator.next();
			}
			
			timer++;

		}
		
	}
}
