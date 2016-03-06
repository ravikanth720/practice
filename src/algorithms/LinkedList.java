package algorithms;

public class LinkedList {

	public Node circularInsert(int val, Node root) {
         // base case
		if (root == null) {
			Node n = new Node(val);
			n.next = n;
			return n;
		}
        
		Node prev = root;
		Node curr = root.next;
        
		// there is only one node
		if (curr == prev) {
			Node ret = new Node(val);
			curr.next = ret;
			ret.next = prev;
			return ret;
		}

		while (curr != root) {
			
			if(prev.data > curr.data){
				if(prev.data <= val || curr.data >= val){
					Node ret = new Node(val);
					prev.next = ret;
					ret.next = curr;
					return ret;
				}else {
					System.out.println("else");
					prev = curr;
					curr = curr.next;
				}
			}		
			else if (prev.data <= curr.data){
				if ((prev.data < val && curr.data > val) || prev.data == val
						|| curr.data == val) {
					System.out.println("entered with prev = "+prev.data+" curr = "+curr.data);
					Node ret = new Node(val);
					prev.next = ret;
					ret.next = curr;
					
					return ret;
					
				} else {
					System.out.println("else");
					prev = curr;
					curr = curr.next;
				}
			}
		}
		
		Node ret = new Node(val);
		prev.next = ret;
		ret.next = curr;
		
		return ret;
	}

	public class Node {
		int data;
		Node next;

		Node(int v) {
			data = v;
			next = null;
		}
	}
	
	public void test(){
		Node root = new Node(1);
		Node n = root.next = new Node(2);
		n.next = root;
		//Node n = root.next.next = new Node(3);
		//root.next.next.next = new Node(4);
		//n.next = root;
		
		Node ret = circularInsert(3, n);
		
		Node it = ret;
		System.out.println();
		do{
			System.out.print(it.data+" ");
			it = it.next;
		}while(it != ret);
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.test();
	}

}
