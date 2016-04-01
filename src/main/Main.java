package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

import algorithms.Dijkstras;
import algorithms.Distance;
import algorithms.FindImage;
import datastructures.AdjNode;
import datastructures.LLNode;
import dsimpl.LinkedList;

public class Main {

	public static void main(String[] args) {
		FindImage fi = new FindImage();
		fi.imagesPathLength("dir1\n dir11\n dir12\n  pic.png\n  img1.png\ndir2\n img2.png");
		
//		Distance d = new Distance();
//		d.input();
//		
//		Main m = new Main();
//		//m.reverseHalf();
//		m.amazonDebug();
	}

	private void amazonDebug() {
		
		
	}

	private static HashMap<String, ArrayList<AdjNode>> reverseMap(
			HashMap<String, ArrayList<AdjNode>> cityMap) {
		// TODO Auto-generated method stub
		HashMap<String, ArrayList<AdjNode>> reverseMap = new HashMap<String, ArrayList<AdjNode>>();

		for (String city : cityMap.keySet()) {

			for (AdjNode srcCity : cityMap.get(city)) {
				AdjNode rneighbor = new AdjNode(city, srcCity.getDist());
				if (reverseMap.containsKey(srcCity.getNode())) {
					reverseMap.get(srcCity.getNode()).add(rneighbor);
				} else {
					ArrayList<AdjNode> neighborList = new ArrayList<AdjNode>();
					neighborList.add(rneighbor);
					reverseMap.put(srcCity.getNode(), neighborList);
				}
			}
		}
		System.out.println("\n Printing reversed map\n");

		for (String city : reverseMap.keySet()) {
			System.out.print("City" + city + ": ");
			for (AdjNode rnode : reverseMap.get(city)) {
				System.out.println("(city" + rnode.getNode() + ", "
						+ rnode.getDist() + ") ");
			}
			System.out.println();
		}

		return reverseMap;
	}

	private void reversebtwLL() {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		LLNode root = new LLNode(7);
		root.next = new LLNode(6);

		root = ll.reversebtwList(0, 1, root);
		System.out.println("reversed");
		if (root == null) {
			System.out.println("root is null");
		}
		ll.display(root);
	}
	
	public void reverseHalf(){
		LinkedList ll = new LinkedList();
		LLNode root = new LLNode(7);
		root.next = new LLNode(6);
		root.next.next = new LLNode(5);
		root.next.next.next = new LLNode(4);
		root.next.next.next.next = new LLNode(3);
		root.next.next.next.next.next = new LLNode(2);
		
		ll.display(root);
		ll.reverseHalf(root);
		//ll.display(root);
	}

}
