package com_package_dbms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Util_Methods {
	public static int readLastIndex(String filename) throws IOException{
			int lastIndex = 0;
			try{
				FileReader filereader = new FileReader(filename);
				BufferedReader bufferedreader = new BufferedReader(filereader);
				String line;
				if((line = bufferedreader.readLine()) != null)
					lastIndex = Integer.parseInt(line);
				bufferedreader.close();
			}catch(IOException e){
				 System.err.println("Error reading from file: " + e.getMessage());
		         throw e;
			}
			return lastIndex;
	}
	
	public static void writeLastIndex(String filename,int index) throws IOException{
		try{
			FileWriter filewriter = new FileWriter(filename,false);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			bufferedwriter.write(Integer.toString(index));
			bufferedwriter.close();
		}catch(IOException e){
			System.err.println("Error reading from file: " + e.getMessage());
	         throw e;
		}
	}
	
	public static void saveData(String filename, int index, String data) throws IOException{
		try{
			FileWriter filewriter = new FileWriter(filename,true);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			
			bufferedwriter.write(index + " , " + data);
			bufferedwriter.newLine();
			bufferedwriter.close();
			System.out.println("Data has been saved!!");
		}catch(IOException e){
			System.err.println("Error reading from file: " + e.getMessage());
	         throw e;
		}
	}
	
}
