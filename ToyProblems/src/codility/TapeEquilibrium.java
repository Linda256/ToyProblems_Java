package codility;

public class TapeEquilibrium {
	public int solution(int[] A) {
		//divide A as left part and right part. left part is A[0], right part is items after A[0]
        //calaculate sum right part as rSum;
        // original difference  diff = Math.abs(A[0] - rSum);
        // loop through A from position 1
			// Remove A[i] from right part and add it to the left part; 
			// calculate the current difference of left and right
            // if  currDiff <0 return diff
            // if  currDiff< diff  diff = currDiff  
        // return diff
        int rSum = 0;
        for (int i=1;i<A.length;i++){
            rSum += A[i];
        }
        int lSum=A[0];
        int diff = Math.abs(rSum-lSum);
        for (int i=1;i<A.length-1;i++){
        	 lSum += A[i];
        	 rSum -= A[i];
             int currDiff = Math.abs(rSum -lSum);
             if (currDiff == 0 ) return currDiff;
             if (currDiff < diff)  diff = currDiff;
            
        }
        return diff;
    }
	
	public static void main(String[] args){
		TapeEquilibrium te= new TapeEquilibrium();
		//int[] A = {3,1,2,4,3};
		//int[] A = {3, 3,3,-3,-3,3};
		//int[] A= {-1000,1000};
		int[] A = {-10, -20, -30, -40, 100};
		int result = te.solution(A);
		System.out.println("diff:" + result);
	}

}
