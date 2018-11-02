package codility;

import java.util.Arrays;

public class MissingInt {
	public int solution(int[] A){
		int len = A.length;
		Arrays.sort(A);
		int i=0,n=1;
		while(i<len-1 && A[i] < 1 ){
			i++;
		}
		if (i==len || A[i]>1) return 1;
		while(i<len){
			if (i<len-1&&A[i]==A[i+1]) i++;
			else if (A[i]==n){
				i++;
				n++;
			}
			else return n;
		}
		return A[len-1]+1;
	}
	
	public static void main(String[] args){
		//int[] A = {-1, 1, 4, -1, 2,6};
		int[] A={1};
		MissingInt mi = new MissingInt();
		System.out.println(mi.solution(A));
		System.out.println(Arrays.toString(A));
		
	}
}
