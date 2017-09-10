package myArrayList.test;
import java.util.Random;
import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {
	private int testCaseNumber;
	private MyArrayList arr;
	private Results result;
	private String separate;
	private String testCase;
	
	public MyArrayListTest() {
		testCaseNumber=0;
		separate = "\n\n----------------------------------------------------------------\n----------------------------------------------------------------\n";
		testCase="";
	}
	
	public void testMe(Results resultIn, MyArrayList arrIn){
		this.arr = arrIn;
		this.result = resultIn;
		test1();
		test2();
		test3();
		test4();
		test5();
		
	}
	private int[] convertListToArray(){
		int[] array = new int[arr.size()];
		for(int i=0;i<arr.size();i++){
			array[i] = arr.valueAt(i);
		}
		return array;
	}
	
	private void compareTest(int testCaseNumber, String testCase, int expected, int actual) {
		String testCaseResult = "FAILED";
		if(expected == actual){
			testCaseResult = "PASSED";
		}
		StringBuilder str = new StringBuilder("\n Test Case Number: " +testCaseNumber + "\n Test: "+testCase+"\n Expected Output: "+expected+ "\n Actual Output: "+actual+
				"\n Result: "+testCaseResult);
		if(testCaseResult.equalsIgnoreCase("passed")){
			str.append("\n Test Case "+testCase+" Passed.");
		}
		str.append(separate);
		result.storeNewResult(str.toString());	
	}
	private void test1() {
		testCaseNumber++;
		testCase = "Insert a new value to the array list and check if the size increases or not.";
		int expectedSize = arr.size()+1;
		Random rand = new Random();
		int newNum = rand.nextInt(10000);
		arr.insertSorted(newNum);
		int actualSize = arr.size();
		compareTest(testCaseNumber,testCase,expectedSize,actualSize);
		//result.storeNewResult("");
		
	}


	private void test2() {
		testCaseNumber++;
		testCase = "Check the sum of all values";
		int sum = 0;
		int[] array = convertListToArray();
		for(int i=0;i<array.length;i++)
			sum = sum + array[i];
		int expectedSum = sum;
		int actualSum = arr.sum();
		compareTest(testCaseNumber, testCase, expectedSum, actualSum);
	}

	private void test3() {
		testCaseNumber++;
		testCase = "Insert largest number and check index";
		int value = 10000;
		arr.insertSorted(value);
		int expectedIndex = arr.size();
		int actualIndex = arr.indexOf(10000) + 1;
		compareTest(testCaseNumber, testCase, expectedIndex, actualIndex);
		
	}
	
	private void test4(){
		testCaseNumber++;
		testCase= "Clear the list. Size must be Zero";
		arr.clear();
		int expectedSize = 0;
		int actualSize = arr.size();
		compareTest(testCaseNumber, testCase, expectedSize, actualSize);
		
	}
	private void test5(){
		testCaseNumber++;
		testCase = "Empty List size must be Zero";
		int expectedSum = 0;
		int actualSum = arr.sum();
		compareTest(testCaseNumber, testCase, expectedSum, actualSum);
	}
}
