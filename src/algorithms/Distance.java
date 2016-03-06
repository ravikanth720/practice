package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import datastructures.Point;

public class Distance {
	public void kClosest(ArrayList<Point> points, int k){
		Comparator<Point> pointComparator = new PointComparator();
		PriorityQueue<Point> pQ = new PriorityQueue<Point>(new Comparator<Point>(){
			public int compare(Point p1, Point p2){
				if(p1.dist > p1.dist){
					return -1;
				}else if(p1.dist < p1.dist){
					return 1;
				}else{
					return 0;
				}
			}
		});
		
		if(k>points.size()){
			System.out.println("Too far");
			return;
		}
		
		for(Point curr:points){
			//System.out.println("pQ.size() = "+pQ.size()+" k = "+k);
			if(pQ.size() < k){
				pQ.add(curr);
			}else{
				if(pointComparator.compare(curr,pQ.peek())>0){
					//System.out.println("Came in with ");
					pQ.poll();
					pQ.add(curr);
				}
			}
		}
		System.out.println(pQ.toString());
		
		pQ.peek().display();

	}
	
	public void input(){
		ArrayList<Point> points = new ArrayList<Point>();
        Point origin = new Point(0, 0);
        points.add(new Point(1, 1, origin));
        points.add(new Point(1, -1, origin));
        points.add(new Point(1, 4, origin));
        points.add(new Point(-1, -6, origin));
        points.add(new Point(1, -1, origin));
        points.add(new Point(3, -1, origin));
        points.add(new Point(-1, -1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(2, 2, origin));
        
        kClosest(points, 6);
	}
	
	class PointComparator implements Comparator<Point>{

		public int compare(Point o1, Point o2) {
			if(o1.dist > o2.dist){
				return -1;
			}else if(o1.dist < o2.dist){
				return 1;
			}else{
				return 0;
			}
		}
		
	}
		
}

