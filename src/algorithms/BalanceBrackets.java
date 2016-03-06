package algorithms;
import java.util.Stack;

public class BalanceBrackets {
	public int isBalanced(String input){
		int count = 0;
		Stack<Character> bracket = new Stack<Character>();
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == '('){
				bracket.push('(');
			}else if(input.charAt(i) == ')'){
				if(bracket.isEmpty()){
					return -1;
				}else{
					count++;
					bracket.pop();
				}
			}
		}
		
		
		return count;
	}
	
	public static void main(String args[] ){
		BalanceBrackets b = new BalanceBrackets();
		System.out.println(b.isBalanced("(()()()(()))"));
	}
}
