package edu;

import java.util.ArrayList;
import java.util.Random;
import edu.*;

public class SearchMethods {
	
	private int enquiryNum;
	private int migrationNum;
	
	
	public int getEnquiryNum() {
		return enquiryNum;
	}

	public void setEnquiryNum(int enquiryNum) {
		this.enquiryNum = enquiryNum;
	}

	public int getMigrationNum() {
		return migrationNum;
	}

	public void setMigrationNum(int migrationNum) {
		this.migrationNum = migrationNum;
	}

public int recursiveSearch(ArrayList<Processor> array, Proces proces,  int upperLimit) {
	

		if(array.size() == 20) {
			return -1;
		}
		Random r = new Random();
		int random = r.nextInt(array.size());
		
		if(array.get(random).getCurrentUsage() < upperLimit && array.get(random).getNumber() != proces.getProcessorNumber()) {
		//	System.out.println("Ask proc no: " + random + " of usage: " + array.get(random).getCurrentUsage());

			if(array.size() < 30) migrationNum++;
		//	System.out.println("Accepted");
			return (array.get(random).getNumber());
		}else {
			enquiryNum++;
		//	System.out.println("Ask proc no: " + random + " of usage: " + array.get(random).getCurrentUsage());
			 array.remove(random);
			return recursiveSearch(array, proces,  upperLimit);
		}
	}
	
	
}
