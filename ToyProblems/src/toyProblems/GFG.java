package toyProblems;

import java.util.Arrays;

public class GFG {
	 public static int[] countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
	    {
	       int[] result = new int[arr1.length];
	       Arrays.sort(arr2);
//	       for (int a : arr2){
//	    	   System.out.println(a);
//	       }
	       
	       for (int i=0;i<arr1.length;i++){
	           int currCount=numOfHigherOrEqual(arr1[i],arr2);
	           result[i]=currCount;
	       }
	       return result;
	    }
	    
	    public static int numOfHigherOrEqual(int n, int arr[]){
	        int hi=arr.length-1;
	        int lo=0;
	        if (n>=arr[hi]) return hi+1;
	        if (n<arr[lo]) return -1;
	        while(lo<=hi){
	            int mid = lo+(hi-lo)/2;
	            if (n==arr[mid]) {
	                while(arr[mid]==arr[mid+1]){
	                    mid++;
	                };
	                return mid+1;
	            }
	            else if (n<arr[mid]){
	                if (n>=arr[mid-1]) return mid;
	                hi=mid-1;
	            }
	            else{
	                if (n<=arr[mid+1]) return mid+1;
	                lo=mid+1;
	            }
	        }
	        return -1;
	    }
	
	  public static void main(String[] args){
		  //GFG test = new GFG();
		  int[] arr={0,1,1,1,2,4};
		  int countN=GFG.numOfHigherOrEqual(4, arr);
		  System.out.println(countN);
		  int[] arr1={1, 2, 3, 4, 7, 9};
		  int[] arr2={0, 1, 2, 1, 1, 4};
		  int[] countArr=GFG.countEleLessThanOrEqual(arr1, arr2, 6, 6);
		  for (int n:countArr){
			  System.out.println(n);
		  }
		  
	  }
}
