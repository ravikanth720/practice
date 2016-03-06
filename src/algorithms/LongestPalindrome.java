package algorithms;

import java.util.Arrays;

public class LongestPalindrome {

	public int lps(String s){
		int len = s.length();
		boolean[][] ispal = new boolean[len][len];
		int maxlen = 0;
		if(len > 0){
			maxlen = 1;
			for(int i=0; i< len; i++){
				ispal[i][i] = true;
			}
		}
		if(len>1){
			for(int i=0; i< len-1; i++){
				if(s.charAt(i)==s.charAt(i+1)){
					ispal[i][i+1] = true;
					maxlen = 2;
				}
			}
			
			int k = 2;
			while(k<len){
				for(int i=0; i<len-k; i++){
					if((s.charAt(i)==s.charAt(i+k)) && ispal[i+1][i+k-1]){					
						ispal[i][i+k] = true;
						maxlen = k+1;
					}
				}
				k++;
			}
		}
		return maxlen;
	}
	
	public static void main(String args[]){
		LongestPalindrome lp = new LongestPalindrome();
		String word = "bobageekkeegaasasasesw";
		System.out.println("Longest substring of "+word+" is "+lp.lps(word));
	}
}