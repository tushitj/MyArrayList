package myArrayList.driver;

import myArrayList.util.FileProcessor;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileProcessor fPro = new FileProcessor(args[0]);
		
		String str ="";
		
		while((str = fPro.readLine())!=null){
			System.out.println(str);
		}
	}

}
