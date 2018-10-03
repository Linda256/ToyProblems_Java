package geeksForGeeks;
/*
 * Number of recycled pairs in an array
Given an array of integers arr[], find the number of recycled pairs in the array. A recycled pair of two numbers {a, b} has the following properties :

A should be smaller than B.
Number of digits should be same.
By rotating A any number of times in one direction, we should get B.
Input : arr[] = {32, 42, 13, 23, 9, 5, 31}
Output : 2
Explanation : Since there are two pairs {13, 31} and {23, 32}. 
By rotating 13 for first time, output is 31 and by rotating 23 once output is 32. 
Both of these pairs satisfy our criteria.

Input : arr[] = {1212, 2121}
Output : 1
Explanation : Since there are two pairs {1212, 2121}. By rotating 1212
for first time, output is 2121. This pair satisfies our criteria.
Note that if rotation id done further, rotating 1212 again output is 1212 
which is given number and 2121 which has been already counted.
So discard both of these results. 
 */
import java.util.*;
public class RecylePairs {
	//initiate ArrayList visited, result=0;
	//loop through numbers
	//  curr=numbers[i]
	//  if curr is in visited, break
	//  else put curr into visited;
	//  loop through the rest of numbers start at j(j=i+1);
	//        if numbers[j] and curr have same length. 
	//				check whether they have same digits, 
	//					if yes, result++, put number[j] into visited;
	// return result;
	public int findRecyclePairs(int[] numbers){
		ArrayList<Integer> visited = new ArrayList<> ();
		int count=0;
		int len=numbers.length;
		for (int i=0;i<len;i++){
			int curr=numbers[i];
			if (visited.contains(curr)){
				continue;
			}
			visited.add(curr);
			for (int j=i+1;j<len;j++){
				boolean find=false;
				if (curr==numbers[j]) continue;
				String currStr=Integer.toString(curr);
				String nextStr=Integer.toString(numbers[j]);
				//System.out.println(nextStr);
				if(currStr.length()==nextStr.length()){
					for (int k=0;k<currStr.length();k++){
						if(nextStr.indexOf(currStr.charAt(k))==-1) break;
						if(k==currStr.length()-1){
							visited.add(numbers[j]);
							count++;
							find=true;
						}
					}
					
				}
				if (find==true) break;
				
			}
		}
		return count;
		
	}

	public static void main(String[] args) {
		RecylePairs rp=new RecylePairs();
		int[] numbers={32, 42, 13, 23, 9, 5, 31};
		//int[] numbers={1212,2121,1122};
		int count=rp.findRecyclePairs(numbers);
		System.out.println(count);
		

	}

}
