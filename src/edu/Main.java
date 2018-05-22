package edu;

import java.util.List;

public class Main {
		
	
	public static void main(String [] args) {
		Parser parser = new Parser("sequence.txt");
		parser.read();
		
		List<Proces> allProcesses = parser.getAllProcesses();
		
		for(Proces p : allProcesses) {
			
			 System.out.println(String.format("aT: %d, eT: %d, us: %d, pN: %d", p.getArrivalTime(), p.getExitTime(),
				 p.getUsage(), p.getProcessorNumber()));
             
		}
	}
}
