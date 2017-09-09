package myArrayList.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	private String fileName;
	BufferedReader br;
	FileReader fin;

	public FileProcessor(String fileNameIn) {
		if(fileNameIn != null && (fileNameIn.trim().length() > 0)){
			fileName = fileNameIn;
			try{
				File file = new File(fileName);
				if(!file.isDirectory() && file.exists()){
					fin = new FileReader(file);
					br = new BufferedReader(fin);
				}
				else{
					System.err.println("No file found");
					System.exit(0);
				}
			}catch(FileNotFoundException e){
				e.printStackTrace();
				System.exit(0);
			}
//			finally{
//				if(br !=null){
//					try {
//						br.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//				if(fin != null){
//					try {
//						fin.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
		}
		else{
			System.out.println("Invalid File Name");
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
