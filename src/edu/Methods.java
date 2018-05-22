package edu;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Methods {
	
	
	public static void main(String [] args) {
		
		 int [] numbers = new int [10];
		 
		 numbers[0] = 4;
		 numbers[1] = 0;
		 numbers[2] = 3;
		 numbers[3] = 7;
		 numbers[4] = 1;
		 numbers[5] = 9;
		 numbers[6] = 5;
		 numbers[7] = 2;
		 numbers[8] = 6;
		 numbers[9] = 8;
	
		 int [] auxiliarNums = numbers;
		 
		 ArrayList<Integer> nums = new ArrayList<Integer>();
			 nums.add(4);
			 nums.add(0);
			 nums.add(3);
			 nums.add(7);
			 nums.add(1);
			 nums.add(9);
			 nums.add(5);
			 nums.add(2);
			 nums.add(6);
			 nums.add(8); 
			 
			 Methods2 m = new Methods2();

			 
			 ArrayList<Integer> nums2 = new ArrayList(nums); 
			System.out.println( m.recursiveSearch(nums2, 8)); 
			
			 ArrayList<Integer> nums3 = new ArrayList(nums);
			 System.out.println( m.recursiveSearch(nums3, 8)); 
			 
			 ArrayList<Integer> nums4 = new ArrayList(nums); 
			 System.out.println(	 m.recursiveSearch(nums4, 8)); 
			
			 ArrayList<Integer> nums5 = new ArrayList(nums);
			 System.out.println(	 m.recursiveSearch(nums5, 8)); 
			 
			 ArrayList<Integer> nums6 = new ArrayList(nums);
			 System.out.println(	 m.recursiveSearch(nums6, 8)); 

	} 
	
	
}
	
		
		
	
