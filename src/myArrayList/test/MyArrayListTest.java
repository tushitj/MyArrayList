package myArrayList.test;
import java.util.Random;
import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {
	private MyArrayList arr;
	private Results result;
	String separate = "\n\n----------------------------------------------------------------\n----------------------------------------------------------------\n";

	public void testMe(Results resultIn, MyArrayList arrIn){
		this.arr = arrIn;
		this.result = resultIn;
		test1();
		//test2();
		//test3();
		
	}
	private void test1() {
		int testCaseNumber = 1;
		String testCase = "Insert a new value to the array list and check if the size increases or not.";
		int expectedSize = arr.size()+1;
		Random rand = new Random();
		int newNum = rand.nextInt(10000);
		arr.insertSorted(newNum);
		int actualSize = arr.size();
		compareTest(testCaseNumber,testCase,expectedSize,actualSize);
		//result.storeNewResult("");
		
	}

	private void compareTest(int testCaseNumber, String testCase, int expected, int actual) {
		String testCaseResult = "FAILED";
		if(expected == actual){
			testCaseResult = "PASSED";
		}
		StringBuilder str = new StringBuilder("\n Test Case Number: " +testCaseNumber + "\n Test: "+testCase+"\n Expected Output: "+expected+ "\n Actual Output: "+actual+
				"\n Result: "+testCaseResult);
		if(testCaseResult.equalsIgnoreCase("passed")){
			str.append("\n Test Case ArrayList size Passed.");
		}
		str.append(separate);
		result.storeNewResult(str.toString());
		
	}
	private void test2() {
		
	}


	private void test3() {
		
	}
}
