package myArrayList;

import java.util.Arrays;

public class MyArrayList {
	private int[] array;
	private int size;
	
	//MyArrayList constructor to initialize private data members of the class.
	public MyArrayList() {
		size = 0;
		array = new int[10];
		Arrays.fill(array, 0);
	}
	
	public static void main(String[] args) {
		MyArrayList arr = new MyArrayList();
		for(int i=0;i<arr.array.length;i++)
		System.out.println(arr.array[i]);
	}

}
