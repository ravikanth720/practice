package dsimpl;

import datastructures.LLNode;

public class LinkedList {
	
	public LLNode reverseList(LLNode root){
		
		if(root != null){
			LLNode prev = root;
			if(root.next != null)
			{
				LLNode curr = root.next;
				
					while(curr != null){
						LLNode tmp = curr.next; 
						curr.next = prev;
						prev = curr;
						curr = tmp;			
					}
					
					root.next = null;
					System.out.println("last term = "+root.data);
					root = prev;
				}else{
					System.out.println("root next null");
				}
			}else{
				System.out.println("root is null");
			}
		display(root);
		return root;
		
		}
		
	public LLNode reversebtwList(int fst, int lst, LLNode root ){
		
		int i = 0;
		LLNode hook1 = null;
		LLNode hook2 = null;
		LLNode root2 = null;
		LLNode curr = root;
		boolean isHook1Set = false;
		while(curr != null){
			
			if(!isHook1Set)
				hook1 = curr;
			i++;
			System.out.println("i = "+i+" hook1 = "+hook1.data);
			curr = curr.next;
			if(i == fst){
				isHook1Set = true;
				root2 = curr;
				System.out.println("i == fst,  root2 = "+root2.data);
			}
			if(i == lst){
				hook2 = curr.next;
				System.out.println("i == lst,  hook2 = "+hook2.data);
				curr.next = null;
				hook1.next = reverseList(root2);
				System.out.println("returned node = "+hook1.next.data);
				break;
			}
		}
		
		while(hook1.next != null){
			
			hook1 = hook1.next;
			System.out.println("hook1 data = "+hook1.data);
			
		}
		System.out.println("hook1 next = "+hook1.data);
		hook1.next = hook2;
		
		return root;
	}
	
	public LLNode reverseHalf(LLNode root){
		LLNode curr = root;
		if(root != null){
			if(curr.next !=null){
				LLNode fast = curr.next;
				while(fast != null && fast.next !=null && fast.next.next!=null){
					curr = curr.next;
					fast = fast.next.next;
				}
				
				LLNode next = curr.next;
				curr.next = null;
				while(next!=null){
					LLNode tmp = next.next;
					next.next = curr;
					curr = next;
					next = tmp;
				}
				
			}
		}
		System.out.println("\nReversed");
		while(root!=null){
			System.out.print(root.data+" ");
			root = root.next;
		}
		LLNode tmp = curr; 
		while(tmp!=null){
			System.out.print(tmp.data+" ");
			tmp = tmp.next;
		}
		
		return curr;
	}
	public void display(LLNode root) {
		// TODO Auto-generated method stub
		System.out.println("Disply");
		while(root != null){
			System.out.print(root.data+" ");
			root = root.next;
		}
		
	}

}
