package algorithms;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduling {
	

	public float waitingTimeRobin(int[] jobArr, int[] rt, int q, int n){
		
		while(n>0){
			int totalTime = jobArr[0];
			Queue<Job> waitQ = new LinkedList<Job>();
			int i =1;
			int idletime = 0;
			float waittime = 0;
			waitQ.add(new Job(jobArr[0], rt[0]));
			while(i<n){
				
				while(i<n && jobArr[i] <= totalTime){
					waitQ.add(new Job(jobArr[i], rt[i]));
					i++;
				}
				if(!waitQ.isEmpty()){
					Job currJob = waitQ.poll();
					currJob.rt -= q;
					
					if(currJob.rt > 0){
						waitQ.add(currJob);
						totalTime += q; 
					}else{ 
						totalTime += q + currJob.rt;
						waittime += totalTime - currJob.at - currJob.ort;
					}
				}else{
					if(i<n){
						idletime += jobArr[i]- totalTime; 
						totalTime = jobArr[i];
					}
				}
			}
			System.out.println("idletime = "+idletime);
			
			System.out.println("total time = "+totalTime);
			System.out.println("waittime time = "+waittime);
			return (waittime)/n;
		}
		return 0;
	}
	
	public class Job{
		int at;
		int rt;
		int ort;
		Job(int at, int rt){
			this.at = at;
			this.ort = rt;
			this.rt = rt;
		}
	
	}
	
	public static void main(String[] args) {
		Scheduling s = new Scheduling();
		int[] rt = {3, 2, 4, 3, 2};
		int[] at = {1, 1, 7, 11, 14};
		System.out.println(s.waitingTimeRobin(at, rt, 3, 5));
	}
}
