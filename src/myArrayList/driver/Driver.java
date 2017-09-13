package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class Driver {

	public static boolean checkFile(String filePath){
		return filePath !=null && filePath.trim().length() > 0 && !filePath.contains("${arg");
	}
	public static void main(String[] args) {
		int argLength = args.length;
		if(argLength!=2){
			System.out.println("Incorrect number of arguments. 2 files, input and output should be entered");
			System.exit(0);
		}
		String inputFile = args[0];
		String outputFile = args[1];
		if(checkFile(inputFile) && checkFile(outputFile)){
			FileProcessor fp = new FileProcessor(args[0]);
			MyArrayList arr = new MyArrayList();
			String str = "";
			while((str = fp.readLine())!=null){
				try{
					int value = Integer.parseInt(str);
					arr.insertSorted(value);
				}catch(NumberFormatException e){
					System.err.println("Number expected." +e);
				}
			}
			MyArrayListTest test = new MyArrayListTest();
			Results rb = new Results();
			rb.storeNewResult(" The values taken from file are: " +arr.toString());
			rb.storeNewResult(" The sum of all the values in the array list is: "+arr.sum());
			test.testMe(rb, arr);
			rb.writeToStdout(null);
			rb.writeToFile(outputFile);
		}
		else{
			System.out.println("Both input and output files must be present.");
			System.exit(0);
		}
		
	}

}
