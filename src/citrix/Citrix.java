package citrix;

import java.util.Arrays;

public class Citrix {
	public static void main(String[] args) {
		// initializing unsorted int array
		int intArr[] = { 2, 2, 2, 2 ,2,2};

		// sorting array
		Arrays.sort(intArr);

		// let us print all the elements available in list
		System.out.println("The sorted int array is:");
		for (int number : intArr) {
			System.out.println("Number = " + number);
		}

		// entering the value to be searched
		int searchVal = 2;

		int retVal = Arrays.binarySearch(intArr, searchVal);

		System.out.println("The index of element  is : " + retVal);
	}
}
