package edu;

import java.util.List;
import java.util.ArrayList;

public class Processor {
	
	private int currentUsage;
	private int summedUsage;
	private int averageUsage;
	private int number;
	private List<Proces> ownProcesses;
	
	public Processor() {
		currentUsage = 0;
		summedUsage = 0;
		averageUsage = 0;
		ownProcesses = new ArrayList<Proces>();
	}

	public Processor(int number) {
		this.number = number;
		currentUsage = 0;
		summedUsage = 0;
		averageUsage = 0;
		ownProcesses = new ArrayList<Proces>();
	}
	
	public int getCurrentUsage() {
		return currentUsage;
	}

	public void setCurrentUsage(int currentUsage) {
		this.currentUsage = currentUsage;
	}

	public int getSummedUsage() {
		return summedUsage;
	}

	public void setSummedUsage(int summedUsage) {
		this.summedUsage = summedUsage;
	}

	public int getAverageUsage() {
		return averageUsage;
	}

	public void setAverageUsage(int averageUsage) {
		this.averageUsage = averageUsage;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Proces> getOwnProcesses() {
		return ownProcesses;
	}

	public void setOwnProcesses(List<Proces> ownProcesses) {
		this.ownProcesses = ownProcesses;
	}
	
	public boolean addProcess(Proces proces) {
		
		ownProcesses.add(proces);
		
		//increase the processor's usage
		int newUsage = getCurrentUsage() + proces.getUsage();
		setCurrentUsage(newUsage);

		return true;
	}
	
	public boolean terminateProcess(int time) { 	
		
		
		for(Proces proc : ownProcesses) {
			if(time == proc.getExitTime()) {
				
				//jeśli próbuję usunąć proces, wywala concurrent exception i to się chyba da obejść,
				//ale właściwie nie jest potrzebne usuwanie tutaj procesy; wystarczy odjąć jego obciążenie i tyle
				//	ownProcesses.remove(proc); 
				
				int newUsage = getCurrentUsage() - proc.getUsage();
				setCurrentUsage(newUsage);
			
			}
		}

		return true;	
	}
	
	public void countUsage() {	//metoda do zliczania obciążenia w każdej sekundzie
				
		int newSummedUsage = getSummedUsage() + getCurrentUsage();
		setSummedUsage(newSummedUsage);
	}
	
	public int averageUsage(int time) { //metoda do liczenia średniego obciążenia
		
		int averageUsage = summedUsage / time;
	//	System.out.println("averageUsage: " + averageUsage);
		return averageUsage;
	}
}
