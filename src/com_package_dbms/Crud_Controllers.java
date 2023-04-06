package com_package_dbms;

import com_package_dbms.Util_Methods;
import com_package_dbms.Schema;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Crud_Controllers {

	public static void saveDetails(String name, int roll, String dept){
		Schema schema = new Schema(roll,name,dept);
		String newData = "";
		newData += name + " " +  roll + " " + dept;
		
		//FILES
		String dataFile = "data.txt";
		String indexFile = "index.txt";
		
		try{
			int lastIndex = Util_Methods.readLastIndex(indexFile);			
			Util_Methods.saveData(dataFile, lastIndex+1, newData);
			Util_Methods.writeLastIndex(indexFile, lastIndex+1);
		
		}catch(IOException e){
			System.out.println("An error has occurred.");
            e.printStackTrace();
		}
	}
	
	public static void readDetails(){
		try{
			  File Obj = new File("data.txt");
	            Scanner Reader = new Scanner(Obj);
	            while (Reader.hasNextLine()) {
	                String data = Reader.nextLine();
	                System.out.println(data);
	            }
	            Reader.close();
		}catch(FileNotFoundException e){
			System.out.println("An error has occurred.");
            e.printStackTrace();
		}
	}
	
	public static void readDataById(int id){
		//FILES
		String dataFile = "data.txt";
		
		try{
			System.out.print(Util_Methods.readDataById(dataFile, id));
			
		
		}catch(IOException e){
			System.out.println("An error has occurred.");
            e.printStackTrace();
		}
	}
	
	public static void editDataById(int id, String newData){
		String dataFile = "data.txt";
		try{
			System.out.print(Util_Methods.editDataById(dataFile, id, newData));
		}catch(IOException e){
			System.out.println("An error has occurred.");
            e.printStackTrace();
		}
	}
	
	public static void deleteDataById(int id){
		try{
			FileReader filereader = new FileReader("data.txt");
			FileWriter filewriter = new FileWriter("data.txt" + ".temp");
			BufferedReader bufferedreader = new BufferedReader(filereader);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);

			String line;
			boolean found = false;
			
			while ((line = bufferedreader.readLine()) != null) {
                String[] parts = line.split(",");
                int partIndex = Integer.parseInt(parts[0].trim());
                if(partIndex != id)
                	bufferedwriter.write(line + "\n");
                else
                	found = true;
            }
			System.out.print("Deleted Successfully!");
			bufferedreader.close();
			bufferedwriter.close();
			
			if(found){
				File originalFile = new File("data.txt");
				File tempFile = new File("data.txt"  +".temp");
				originalFile.delete();
				tempFile.renameTo(originalFile);
			}
			else{
				File tempFile = new File("data.txt" + ".temp");
				tempFile.delete();
			}				
		}catch(IOException e){
			System.out.println("An error has occurred.");
            e.printStackTrace();
		}
	}
	
}
