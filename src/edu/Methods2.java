package edu;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Methods2 {
	
	private int z = 0;
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}



	public boolean recursiveSearch(ArrayList<Integer> array, int wantedNum) {
		
		if(array.size() == 0 || z == 10) {
			if(z == 10) System.out.println("z == 10");
			z = 0;
			return false;
		}

		Random r = new Random();
		int random = r.nextInt(array.size());
		
		if(array.get(random) == wantedNum) {
			System.out.println("wanted: " + wantedNum + " DONE! index: " + random + " number: " + array.get(random) + "\n");
			return true;
		}else {
			z++;
			System.out.println("index: " + random + " number: " + array.get(random) + " array size: " + array.size());
			 array.remove(random);
			return recursiveSearch(array, wantedNum);
		}
	}

}
