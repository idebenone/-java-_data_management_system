package com_package_dbms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Util_Methods {
	public static int readLastIndex(String filename) throws IOException{
			int lastIndex = 0;
			FileReader filereader = new FileReader(filename);
			BufferedReader bufferedreader = new BufferedReader(filereader);
			String line;
			if((line = bufferedreader.readLine()) != null)
				lastIndex = Integer.parseInt(line);
			bufferedreader.close();
			return lastIndex;
	}
	
	public static void writeLastIndex(String filename,int index) throws IOException{
		
			FileWriter filewriter = new FileWriter(filename,false);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			bufferedwriter.write(Integer.toString(index));
			bufferedwriter.close();
	}
	
	public static void saveData(String filename, int index, String data) throws IOException{
			FileWriter filewriter = new FileWriter(filename,true);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			
			bufferedwriter.write(index + " , " + data);
			bufferedwriter.newLine();
			bufferedwriter.close();
			System.out.println("Data has been saved!!");
	}
	
	public static String readDataById(String filename,int id) throws IOException{
		String res = "";
		FileReader filereader = new FileReader(filename);
		BufferedReader bufferedreader = new BufferedReader(filereader);	
		String line;	
		while ((line = bufferedreader.readLine()) != null) {
            String[] parts = line.split(",");
            int partIndex = Integer.parseInt(parts[0].trim());
            if(partIndex == id)
            res += parts[1].trim();
        }
		bufferedreader.close();
		return res;
	}
	
	public static String editDataById(String filename,int id, String newData) throws IOException{
		
		FileReader filereader = new FileReader(filename);
		FileWriter filewriter = new FileWriter(filename + ".temp");
		BufferedReader bufferedreader = new BufferedReader(filereader);
		BufferedWriter bufferedwriter = new BufferedWriter(filewriter);

		String line;
		boolean found = false;
		
		while ((line = bufferedreader.readLine()) != null) {
            String[] parts = line.split(",");
            int partIndex = Integer.parseInt(parts[0].trim());
            if(partIndex == id)
            	parts[1] = newData;
            	found = true;
            String newLine = String.join(",", parts);
            bufferedwriter.write(newLine + "\n");
        }
		bufferedreader.close();
		bufferedwriter.close();
		
		if(found){
			File originalFile = new File(filename);
			File tempFile = new File(filename  +".temp");
			originalFile.delete();
			tempFile.renameTo(originalFile);
		}
		else{
			File tempFile = new File(filename + ".temp");
			tempFile.delete();
		}
		return "Edited Successfully!";
	}
}
