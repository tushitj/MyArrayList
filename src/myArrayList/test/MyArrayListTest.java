package myArrayList.test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {
	private int testCaseNumber;
	private MyArrayList arr;
	private Results result;
	private String separate;
	private String testCase;

	/**
	 * Public constructor to initialize private data members of the class
	 */
	public MyArrayListTest() {
		testCaseNumber=0;
		separate = "\n\n----------------------------------------------------------------\n----------------------------------------------------------------\n";
		testCase="";
	}
	/**
	 * This function calls all the test Methods by using java reflection.
	 * @param resultIn: Object of Result passed from Driver class.
	 * @param arrIn: Object of MyArrayList passed from Drive class.
	 */
	public void testMe(Results resultIn, MyArrayList arrIn){
		this.arr = arrIn;
		this.result = resultIn;
		for(int i =1;i<=10;i++){
			Method method;
			try {
				method = this.getClass().getDeclaredMethod("test"+i,(Class<?>[]) null);
				method.invoke(this,(Object[])null);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * A function that converts the arrayList from MyArrayList object to array for testing.
	 * @return an array of values in arrayList.
	 */
	public int[] convertListToArray(){
		int[] array = new int[arr.size()];
		for(int i=0;i<arr.size();i++){
			array[i] = arr.valueAt(i);
		}
		return array;
	}
	
	/**
	 * This function generates a random number between 0 and 10000
	 * @return An int value that is random number.
	 */
	public int getRandomNumber(){
		Random rand = new Random();
		return rand.nextInt(10000);
	}
	
	/**
	 * This function compares the expected and actual values of the test case and stores the relevant output to the Results object
	 * @param testCaseNumber: this is the int value of the test case that tells the number of test case.
	 * @param testCase: this is the string value that tells the type of test case.
	 * @param expected: this is the int value to be expected from the test
	 * @param actual: this is the int value actually returned by the test
	 */
	public void compareTest(int testCaseNumber, String testCase, int expected, int actual) {
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
	public void test1() {
		testCaseNumber++;
		testCase = "Insert a new value to the array list and check if the size increases or not.";
		int expectedSize = arr.size()+1;
		int newNum = getRandomNumber();
		arr.insertSorted(newNum);
		int actualSize = arr.size();
		compareTest(testCaseNumber,testCase,expectedSize,actualSize);

	}


	public void test2() {
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

	public void test3() {
		testCaseNumber++;
		testCase = "Insert largest number and check index";
		int value = 10000;
		arr.insertSorted(value);
		int expectedIndex = arr.size();
		int actualIndex = arr.indexOf(10000) + 1;
		compareTest(testCaseNumber, testCase, expectedIndex, actualIndex);

	}

	public void test4(){
		testCaseNumber++;
		testCase= "Clear the list. Size must be Zero";
		arr.clear();
		int expectedSize = 0;
		int actualSize = arr.size();
		compareTest(testCaseNumber, testCase, expectedSize, actualSize);

	}
	public void test5(){
		testCaseNumber++;
		testCase = "Empty List size must be Zero";
		int expectedSum = 0;
		int actualSum = arr.sum();
		compareTest(testCaseNumber, testCase, expectedSum, actualSum);
	}
	public void test6(){
		testCaseNumber++;
		testCase = "Test Case to add 100 numbers and remove the 100 numbers,array list size must be zero";
		arr.clear();
		for(int i =0 ;i<100;i++){
			arr.insertSorted(i);
		}
		for(int i =0 ;i<100;i++){
			arr.removeValue(i);
		}
		int actualSize = arr.size();
		int expectedSize = 0;
		compareTest(testCaseNumber, testCase,expectedSize,actualSize);
	}
	public void test7(){
		testCaseNumber++;
		testCase = "Insert a random number and check if it is added or not";
		int value = getRandomNumber();
		while(arr.indexOf(value) != -1){
			value = getRandomNumber();
		}
		arr.insertSorted(value);
		int expectedOutput = 0;
		int actualOutput = arr.indexOf(value);
		if(actualOutput > -1){
			expectedOutput = actualOutput;
		}
		compareTest(testCaseNumber, testCase,expectedOutput,actualOutput);
	}
	public void test8(){
		testCaseNumber++;
		testCase="Remove all instances of a number";
		arr.insertSorted(5);
		arr.insertSorted(5);
		arr.removeValue(5);
		int actualOutput = arr.indexOf(5);
		int expectedOutput = -1;
		compareTest(testCaseNumber, testCase,expectedOutput,actualOutput);
		
	}
	public void test9(){
		testCaseNumber++;
		testCase="Insert 51 elements and size of List must be 51";
		arr.clear();
		for(int i = 0;i<51;i++){
			arr.insertSorted(i);
		}
		int expectedSize = 51;
		int actualSize = arr.size();
		compareTest(testCaseNumber, testCase,expectedSize,actualSize);
	}
	public void test10(){
		testCaseNumber++;
		testCase = "Add a number and check the sum";
		int sum = arr.sum();
		arr.insertSorted(10);
		int actualSum = arr.sum();
		int expectedSum = sum + 10;
		compareTest(testCaseNumber, testCase,expectedSum,actualSum);
	}
	/**
	 * An overridden method toString to describe the class
	 */
	@Override
	public String toString(){
		return "MyArrayListTest is a testCase class for MyArrayList class";
	}

}
