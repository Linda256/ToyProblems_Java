/*
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. Initial positions increment by from at the front of the line to at the back.

Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others. For example, if and bribes , the queue will look like this: .

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!

Function Description

Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of bribes necessary, or Too chaotic if the line configuration is not possible.

minimumBribes has the following parameter(s):

    q: an array of integers

 */
package hackerRank;

public class NewYearChoas {
	static void minimumBribes(int[] q) {
		//loop through q starting from the last element
		//if the element is greater than its index + 3 return (too chaotic)
		//if an element is greater than its index+1
		    //while it is greater than its index
		        //swap it with the number at its right side
		        //increase the count
		    //set the index back 1 step to check curr item greater than its index+1 or not
		//return count
		int count = 0;
        boolean swapped = false;
        int len=q.length-1;
        for (int i = len; i >= 0; i--) {
            if(q[i]>i+3) {
                System.out.println("Too chaotic");
                return;
            }
            if (q[i] > i + 1) {
                int j=i;
                while (q[j] > j + 1) {
                    swap(q, j, j + 1);
                    count++;
                    j++;
                    swapped=true;
                }
                if (swapped==true) i++;
            } 
        }
        System.out.println(count);
    }

    private static void swap(int[] q, int l, int r) {
        int temp = q[l];
        q[l] = q[r];
        q[r] = temp;
    }
    
    public static void main(String[] args){
    	int[] q={1,2,5,3,7,8,6,4};
    	minimumBribes(q);
    }

}
