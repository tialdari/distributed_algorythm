package edu;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;

public class Main {
		
	
	public static void main(String [] args) {
		
		//parser działa na pewno
		final String fileName = "sequence.txt";
		Parser parser = new Parser(fileName);
		parser.read();
		
		int timer = 0;			//licznik
		int upperLimit = 60;	 	// zmienna p
		
		
		//zawiera wszystkie 30 procesorów
		List<Processor> processors = new ArrayList<Processor>();	
		
		for(int i = 0; i < 30; i++) {
			processors.add(new Processor(i));
		}
		
		//zawiera wszystkie procesy z parsera
		List<Proces> allProcesses = parser.getAllProcesses();
				
		//iterator, żeby przejść po liście ze wszystkimi procesami
		Iterator<Proces> iterator = allProcesses.iterator();
		Proces nextProces = iterator.next();
		
		SearchMethods sm = new SearchMethods();
		
		int procNum = 0;
		
		//do czasu 7100 wszystkie procesy powinny się już wykonać
		final int maxCounterValue = 7300;
		while(timer < maxCounterValue) {
			
			//iterujemy po procesorach, żeby w każdej sekundzie dodać aktualne obciążenie i ew. zakończyć procesy
			for(Processor p : processors) {
				//System.out.println("summed usage: " + p.getSummedUsage()) ;
				p.countUsage();
				p.terminateProcess(timer);
			}
			
			if(!iterator.hasNext()) {
				timer++;
				//proces z ostatniej linii, do uzupełnienia
				continue;
			}
		
			//jeśli w danej sekundzie ma wejść proces, szukamy dla niego procesora
			if(nextProces.getArrivalTime() <= timer) {	
				
				procNum = sm.recursiveSearch(new ArrayList<>(processors), nextProces, upperLimit);
				 
				//jeśli proces nie znalazł innego procesora niż swój, metoda zwraca - 1, dlatego warunek jest >= 0
				if(procNum >= 0) {
					 processors.get(procNum).addProcess(nextProces);
				 }else {
					 //jeśli nie znaleźliśmy, proces wykonuje się na swoim procesorze
					 processors.get(nextProces.getProcessorNumber()).addProcess(nextProces);
				 }
				nextProces = iterator.next();
			}			
			timer++;
				
			
			
			//koniec pętli
			 
		}
		
		
		int averageSummedUsage = 0; 
		
		//zsumowane średnie obciążenia wszystkich procesorów
		for(int i = 0; i < processors.size(); i++) {
			averageSummedUsage += processors.get(i).averageUsage(timer);
		}
		
		//System.out.println("averageSummedusage: " + averageSummedUsage);
		
		//średnią globalną liczymy poprzez podzielenie suma średnich przez liczbę procesorów
		System.out.println("global average usage: " + averageSummedUsage/processors.size());
		System.out.println("Enquiry number: " + sm.getEnquiryNum());
		System.out.println("migration number: " + sm.getMigrationNum());

		
		System.out.println("the end");
		
	}

}
