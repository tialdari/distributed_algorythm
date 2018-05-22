package edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import edu.Proces;

public class Parser {
	
	
	private File file;
	private List<Proces> allProcesses;
	
	public Parser() {
		file = new File("sequence.txt");
		allProcesses = new ArrayList<Proces>();
	}
	
	public Parser(String fileName) {
		file = new File(fileName);
		allProcesses = new ArrayList<Proces>();
	}

	
	public List<Proces> getAllProcesses() {
		return allProcesses;
	}

	public void setAllProcesses(List<Proces> allProcesses) {
		this.allProcesses = allProcesses;
	}

	public void  read() {
		
		try{
			
            Scanner sc = new Scanner(file);            
            String line = sc.nextLine();
            
            int arrivalTime = 0;
            int exitTime = 0;
            int usage = 0;
            int processorNumber = 0;

            while(sc.hasNext()) {

                arrivalTime = sc.nextInt();
                exitTime = sc.nextInt();
                usage = sc.nextInt();
                processorNumber = sc.nextInt();
                
                allProcesses.add(new Proces(arrivalTime, exitTime, usage, processorNumber));
            }
            sc.close();

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

		
	}
    
}



