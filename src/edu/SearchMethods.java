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

	
	//metoda na wejściu otrzymuje kopię listy procesorów z maina, więc oryginalna pozostaje nietknięta
public int recursiveSearch(ArrayList<Processor> array, Proces proces,  int upperLimit) {
	
	
		//jeśli było już 10 zapytań do procesorów, opuść metodę
		if(array.size() == 20) {
			return -1;
		}
		Random r = new Random();
		//generujemy losową liczbę z przedziału od zera do aktualnego rozmiary listy
		int random = r.nextInt(array.size());
		
		//jeśli dany procesor jest obciążony poniżej limitu i nie jest to procesor danego procesu, 
		//dodaj proces do tego procesora i opuść metodę
		if(array.get(random).getCurrentUsage() < upperLimit && array.get(random).getNumber() != proces.getProcessorNumber()) {
			
			// inkrementuj liczbę migracji
			migrationNum++;
			return (array.get(random).getNumber());
		}else {
			//jeśli dany procesor jest zajęty szukamy dalej i inkrementujemy liczbę zapytań
			enquiryNum++;
			//usuwamy element o danym indeksie, żeby wykluczyć go z dalszych poszukiwań
			 array.remove(random);
			 //wywołujemy rekursywnie metodę, tym razem z pomniejszoną listą
			return recursiveSearch(array, proces,  upperLimit);
		}
	}
	
	
}
