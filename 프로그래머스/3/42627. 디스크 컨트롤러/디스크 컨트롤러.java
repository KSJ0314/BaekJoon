import java.util.*;

class Solution {
    public class Job implements Comparable<Job>{
		int time, request, no;
        Job next;

		public Job(int time, int request, int no, Solution.Job next) {
			this.time = time;
			this.request = request;
			this.no = no;
			this.next = next;
		}
        
        @Override
        public int compareTo(Job o){
            if (this.time != o.time){
                return Integer.compare(this.time, o.time);   
            } else if (this.request != o.request){
                return Integer.compare(this.request, o.request);
            } else {
                return Integer.compare(this.no, o.no);   
            }
        }
	}
    public int solution(int[][] jobs) {
    	int n = jobs.length;
        Job[] jobArr = new Job[1001];
        for (int i = 0; i < n; i++){
            jobArr[jobs[i][0]] = new Job(jobs[i][1], jobs[i][0], i, jobArr[jobs[i][0]]);
        }
        PriorityQueue<Job> pQ = new PriorityQueue<>();
        Job crtJob = null;
        int returnTimeSum = 0;
        int endTime = -1;
        for (int time = 0, cnt = 0; cnt < n; time++){
        	if (time <= 1000) {
        		for (Job job = jobArr[time]; job != null; job = job.next) {
        			pQ.add(job);
        		}
        	}
        	if (crtJob != null && endTime == time) {
        		returnTimeSum += endTime - crtJob.request;
        		crtJob = null;
        	}
        	if (crtJob == null && !pQ.isEmpty() && pQ.peek().request <= time) {
        		crtJob = pQ.poll();
        		endTime = time + crtJob.time;
        		cnt++;
        	}
        }
		returnTimeSum += endTime - crtJob.request;
        return returnTimeSum / n;
    }
}