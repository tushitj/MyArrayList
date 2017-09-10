package myArrayList.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private StringBuilder sb;
	public Results(){
		sb = new StringBuilder();
	}
	
	public void storeNewResult(String s){
		sb.append(s);
		sb.append("\n");
	}
	public void makeString(int i){
		sb.append(i);
		sb.append("\n");
	}
	@Override
	public void writeToStdout(String s) {
		System.out.println(sb);
	}

	@Override
	public void writeToFile(String s) {
		File file;
			file = new File(s);
			if(!file.isDirectory() && file.exists()){
				file.delete();
			}
			
			PrintWriter out;
			try {
				out = new PrintWriter(new FileWriter("output.txt", true), true);
				out.write(sb.toString());
			    out.close();
			} catch (IOException e) {
				System.out.println("There was some error in creating the file");
				e.printStackTrace();
			}
		      
		
	}
	

}
