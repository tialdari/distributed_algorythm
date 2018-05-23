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
		System.out.println("processor " + number + " of usage " + currentUsage + " add usage: " + proces.getUsage());
		setCurrentUsage(newUsage);

		return true;
	}
	
	public boolean terminateProcess(int time) {
		
		
		for(Proces proc : ownProcesses) {
			if(time == proc.getExitTime()) {
				ownProcesses.remove(proc);
				//decrease the processor's usage
				
				int oldUsage = getCurrentUsage();
				int newUsage = getCurrentUsage() - proc.getUsage();
				setCurrentUsage(newUsage);
			//	System.out.println("time: " + time + "processor no " + number + " of usage " + currentUsage);
			//	System.out.println("time: " + time + " processor " + number +" old usage: " + oldUsage + ", process usage: " + proces.getUsage() 
			//	+ ", new usage: " + newUsage);
				System.out.println("processor " + number + " substract usage: " + proc.getUsage() + " and get : " + currentUsage);

			}
		}

		return true;	
	}
	
	public void countUsage() {
				
		int newSummedUsage = getSummedUsage() + getCurrentUsage();
		setSummedUsage(newSummedUsage);
		
		//System.out.println("the usage of " + number + " is " + summedUsage);
	}
}
