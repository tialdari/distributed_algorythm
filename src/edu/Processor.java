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
		
		//increase the processor's usage by the process's required usage
		int newUsage = getCurrentUsage() + proces.getUsage();
		setCurrentUsage(newUsage);
		
		int newSummedUsage = getSummedUsage() + newUsage;
		setSummedUsage(newSummedUsage);
		
		return true;
	}
}
