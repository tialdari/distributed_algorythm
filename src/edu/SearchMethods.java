package edu;

import java.util.ArrayList;
import java.util.Random;
import edu.*;

public class SearchMethods {

public int recursiveSearch(ArrayList<Processor> array, Proces proces,  int upperLimit) {
		
		if(array.size() == 0) return -1;

		Random r = new Random();
		int random = r.nextInt(array.size());
		
		if(array.get(random).getCurrentUsage() < upperLimit && array.get(random).getNumber() != proces.getProcessorNumber()) {
		//	System.out.print("proces time: " + proces.getArrivalTime() + " to p no: " + array.get(random).getNumber());
			return (array.get(random).getNumber());
		}else {
			 array.remove(random);
			return recursiveSearch(array, proces,  upperLimit);
		}
	}
	
	
}
