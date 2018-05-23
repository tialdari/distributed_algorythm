package edu;

public class Proces {//tu chyba wszystko jasne
	
	
	
	private int arrivalTime;
	private int exitTime;
	private int usage;
	private int processorNumber;
	
	public Proces() {
		arrivalTime = 0;
		usage = 3;
		exitTime = 0;
		processorNumber = 1;
	}
	
	public Proces(int arrivalTime, int usage, int exitTime, int processorNumber) {
		this.arrivalTime = arrivalTime;
		this.usage = usage;
		this.exitTime = exitTime + arrivalTime;
		this.processorNumber = processorNumber;
	}

	public Integer getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getExitTime() {
		return exitTime;
	}

	public void setExitTime(int exitTime) {
		this.exitTime = exitTime;
	}

	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}

	public int getProcessorNumber() {
		return processorNumber;
	}

	public void setProcessorNumber(int processorNumber) {
		this.processorNumber = processorNumber;
	}
	
	
}
