package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayExamples {
	public int[] cellCompetition(int[] arr, int days){
		while(days > 0){
			int n = arr.length;
			int[] res = new int[n];
			
			for(int i=1; i<n-1; i++){
				res[i] = arr[i-1]^arr[i+1];
			}
			
			res[0] = 0^arr[1];
			res[n-1] = arr[n-2]^0;
			
			arr = res;
			System.out.println(Arrays.toString(arr));
			days--;
		}
		return arr;
	}
	public ArrayList<Integer> calculateWindow(ArrayList<Integer> list, int w){
		ArrayList<Integer> res = new ArrayList<Integer>();
		int count =0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<list.size(); i++){
			
			if(list.get(i)<min){
				res.add()
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayExamples obj =  new ArrayExamples();
		int[] arr = {1,1,1,0,1,1,1,1};
		obj.cellCompetition(arr, 2);
	}
}