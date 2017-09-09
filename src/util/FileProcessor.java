package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	private String fileName;
	BufferedReader br;
	FileReader fin;
	
	public FileProcessor(String fileNameIn) {
		if(fileNameIn == null || (fileNameIn.trim().length() < 1)){
			System.err.println("Invalid File Name");
			System.exit(0);
		}	
		fileName = fileNameIn;
		try{
			fin = new FileReader(fileName);
			br = new BufferedReader(fin);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public String readLine(){
		String line = "";
		try{
			line = br.readLine();
			if(line == null || (line.trim().length()<1)){
				return null;
			}
			else{
				return line;
			}		
		}catch(IOException e){
			e.printStackTrace();
		}
		return line;
		
	}
	

}
