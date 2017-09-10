package myArrayList;

import java.util.Arrays;

public class MyArrayList {
	private int[] array;
	private int size;
	private int capacity;
	
	//MyArrayList constructor to initialize private data members of the class.
	public MyArrayList() {
		capacity = 10;
		size = 0;
		array = new int[capacity];
		array = initializeArray(array,size);
	}
	int[] initializeArray(int[] arr,int size){
		for(int i=size;i<arr.length;i++){
			arr[i] = Integer.MAX_VALUE;
		}
		return arr;
	}
	private void sortMyArrayList(){
		Arrays.sort(array);
	}
	public void insertSorted(int value){
		if(size>=array.length){
			increaseLength();
		}
		array[size] = value;
		size++;
		sortMyArrayList();
		
	}
	private void increaseLength() {
		capacity = capacity + (capacity/2);
		int[] newArray = new int[capacity];
		for(int i=0;i<array.length;i++){
			newArray[i] = array[i];
		}
		newArray = initializeArray(newArray,size);
		array = newArray;
	}
	
	public int indexOf(int value){
		for(int i=0;i<size;i++){
			if(array[i]==value){
				return i;
			}
		}
		return -1;
	}
	
	public int sum(){
		int sum=0;
		for(int i=0;i<size;i++){
			sum = sum + array[i];
		}
		return sum;
	}
	
	public int size(){
		return size;
	}
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
