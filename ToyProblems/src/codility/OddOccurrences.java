/*
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Write an efficient algorithm for the following assumptions:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.
 */
package codility;
import java.util.*;

// write your code in Java SE 8
// initiate HashSet visited
//loop through A
// if A[i] is in visited. delete A[i] in visited
// else put A[i] in visited
// return what left in visited.
public class OddOccurrences {
	    public int solution(int[] A) {
	         HashSet<Integer> visited = new HashSet<>();
	        //loop through A
	        for (int i=0;i<A.length;i++){
	            // if A[i] is in visited. delete A[i] in visited
	            if(visited.contains(A[i])) visited.remove(A[i]);
	            else visited.add(A[i]);
	        }
	        // return what left in visited.
	        Iterator<Integer> iterator = visited.iterator();
	        int result = iterator.next();
	        return result;
	        
	    }
	    
	    public static void  main(String[] args){
	    	OddOccurrences odd = new OddOccurrences();
	    	int[] nums = {3,4,12,9,12,3,9};
	    	System.out.println(odd.solution(nums));
	    }
}
