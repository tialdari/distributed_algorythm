package edu;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;

public class Main {
		
	
	public static void main(String [] args) {
		
		Parser parser = new Parser("sequence.txt");
		parser.read();
		
		int timer = 0;			//licznik
		int upperLimit = 60;	 	// zmienna p
		int migrationNum = 0;
		int enquiriesNum = 0;
		
		
		
		List<Processor> processors = new ArrayList<Processor>();	//zawiera wszystkie 30 procesorów
		
		for(int i = 0; i < 30; i++) {
			processors.add(new Processor(i));
		}
		
		List<Proces> allProcesses = parser.getAllProcesses();
		
		System.out.println("processes number: " + allProcesses.size());
		Iterator<Proces> iterator = allProcesses.iterator();
		Proces nextProces = iterator.next();
		
		SearchMethods sm = new SearchMethods();
		
		int procNum = 0;
		
		while(timer < 6945) {
			
			for(Processor p : processors) {
				//System.out.println("summed usage: " + p.getSummedUsage()) ;
				p.countUsage();
				p.terminateProcess(timer);
			}
			
		
			if(nextProces.getArrivalTime() <= timer) {	
				
				procNum = sm.recursiveSearch(new ArrayList(processors), nextProces, upperLimit);
				 if(procNum >= 0) {
					 processors.get(procNum).addProcess(nextProces);
				//	 System.out.println("to " + procNum + " at time " + timer);
				 }else {
				//	 System.out.println("To your own processor");

					 processors.get(nextProces.getProcessorNumber()).addProcess(nextProces);
					 
				 }
				nextProces = iterator.next();
			}			
		
				
			if(!iterator.hasNext()) {
				break;
			}

			timer++;

			 
		}
		
		int averageSummedUsage = 0;
		
		for(int i = 0; i < processors.size(); i++) {
		//	System.out.println("summed usage: " + processors.get(i).getSummedUsage());
			averageSummedUsage += processors.get(i).averageUsage(timer);
		}
		
		
		System.out.println("averageSummedusage: " + averageSummedUsage);
		
		System.out.println("global average usage: " + averageSummedUsage/processors.size());
		
		System.out.println("Enquiry number: " + sm.getEnquiryNum());
		System.out.println("migration number: " + sm.getMigrationNum());

		
		System.out.println("the end");
		
	}

}
