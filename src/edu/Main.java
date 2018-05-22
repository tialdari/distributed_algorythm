package edu;

import java.util.List;
import java.util.Iterator;

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
			processors[i] = new Processor();
		}
		
		Iterator<Proces> iterator = allProcesses.iterator();
		Proces nextProces = iterator.next();
		
		while(timer < 6945) {
			
			if(nextProces.getArrivalTime() <= timer) {				
				for(int i = 0; i < processors.length; i ++) {
					if(nextProces.getProcessorNumber() == (i + 1)) {
						System.out.print(" my processor: " + nextProces.getProcessorNumber());
						if(processors[i].getCurrentUsage() < upperLimit) {
							processors[i].addProcess(nextProces);
							System.out.print(" is NOT over limit");
							
						}else {
							System.out.print(" is over limit");
						}
						System.out.println("");
						break;
					}
				}
				nextProces = iterator.next();

			}
			
			if(!iterator.hasNext()) {

				//System.out.println("time: " + nextProces.getArrivalTime());
				break;
			}
			timer++;

		}
		
	}
}
