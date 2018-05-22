package edu;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Methods2 {
	
	public boolean recursiveSearch(ArrayList<Integer> array, int wantedNum) {
		
		if(array.size() == 0) return false;

		Random r = new Random();
		int random = r.nextInt(array.size());
		
		if(array.get(random) == wantedNum) {
			System.out.println("wanted: " + wantedNum + " DONE! index: " + random + " number: " + array.get(random) + "\n");
			return true;
		}else {
			System.out.println("index: " + random + " number: " + array.get(random) + " array size: " + array.size());
			 array.remove(random);
			return recursiveSearch(array, wantedNum);
		}
	}

}
