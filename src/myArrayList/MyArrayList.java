package myArrayList;

import java.util.Arrays;

public class MyArrayList {
	private int[] array;
	private int size;
	private int capacity;
	
	/**
	 * MyArrayList constructor to initialize private data members of the class
	 */
	public MyArrayList() {
		capacity = 10;
		size = 0;
		array = new int[capacity];
		array = initializeArray(array,size);
	}

	/**
	 * Function to set values in the arrayList to Maximum Value of Integer
	 * and return the value initialized array
	 * @param arr: it is the object of MyArrayList class that is in reference.
	 * @param size: it is the size of the array.
	 * @return initialized array.
	 */
	int[] initializeArray(int[] arr,int size){
		for(int i=size;i<arr.length;i++){
			arr[i] = Integer.MAX_VALUE;
		}
		return arr;
	}

	/**
	 * private function to sort the array.
	 */
	private void sortMyArrayList(){
		Arrays.sort(array);
	}

	/**
	 * public function to be called to insert the value into arrayList and then sort the list.
	 */
	public void insertSorted(int value){
		if(value >=0 && value <=10000){
			if(size>=array.length){
				increaseLength();
			}
			array[size] = value;
			size++;
			sortMyArrayList();
		}
	}
	
	/**
	 * private function to increase the length of the Array when the array is full.
	 */
	private void increaseLength() {
		capacity = capacity + (capacity/2);
		int[] newArray = new int[capacity];
		for(int i=0;i<array.length;i++){
			newArray[i] = array[i];
		}
		newArray = initializeArray(newArray,size);
		array = newArray;
	}
	
	/**
	 * public function that returns the index of the value if
	 * it exists else return -1.
	 */ 
	public int indexOf(int value){
		for(int i=0;i<size;i++){
			if(array[i]==value){
				return i;
			}
		}
		return -1;
	}
	/**
	 * Sums all the elements in the arrayList
	 * @return integer that is the sum of all values
	 */
	public int sum(){
		int sum=0;
		for(int i=0;i<size;i++){
			sum = sum + array[i];
		}
		return sum;
	}
	
	/**
	 * It returns the size of the arrayList
	 * @return integer value that is the size
	 */
	public int size(){
		return size;
	}
	
	/**
	 * The function removes the value from the arrayList if exists.
	 * @param value: value passed to find and delete from arrayList 
	 */
	public void removeValue(int value){
		int index;
		int count=0;
		while((index = indexOf(value)) > -1){
			count++;
			array[index] = Integer.MAX_VALUE;
			size--;
		}
		if(count>0)
			sortMyArrayList();
		else
			System.out.println("Int value not found.");
	}
	
	/**
	 * This function clears the arrayList
	 */
	public void clear(){
		for(int i = 0; i <size;i++){
			array[i] = Integer.MAX_VALUE;
		}
		size = 0;
	}
	
	/**
	 * a function that return the value at an index
	 * @param index: the index to find the value at that index
	 * @return: value at that index
	 */
	public int valueAt(int index){
		return array[index];
	}
	
	/**
	 * Overridden method toString that returns all the values in the arrayList as a String
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<size ;i++){
			String str = array[i] + " ";
			sb.append(str);
		}
		return sb.toString();
	}
}
