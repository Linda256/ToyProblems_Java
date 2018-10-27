package codility;
/*
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
 */
import java.util.Stack;
// call convertToBinary to get the binary code  N as str
// initiate maxZeros = 0;
// loop through the str.
  // count consecutive zeros as currZeros 
//      //if s[i]=0, 
//          //find the next 1.(nextOne = index of 1 start at i)
//          // currZeros = nextOne - i;
//          // if currZeros > maxZeros maxZeros = currZeros
//          // i= nextOne
// return maxZeros

public class BinaryGap {
	public int solution(int N) {
		if(N==0) return 0;
		int	maxZeros = 0;
		String str= convertToBinary(N);
		for (int i=0; i<str.length();i++){
			if (str.charAt(i)=='0'){
				int nextOne=str.indexOf("1",i);
				if(nextOne==-1) break;
				int currZeros = nextOne - i;
				if (currZeros > maxZeros){
					maxZeros = currZeros;
				}
				i= nextOne;
			}
		}

      return maxZeros;
       
	}
//    
        //initiate a stack  to store the remaider
        // while (N > 1) , divide N by 2 push the remaider to stack
        // pop the item into string b
       // return b
    public static String convertToBinary(int N){
        String bstr = "";
        Stack s = new Stack(); 
        while (N>1){
            int r = N%2;
            N=N/2;
            s.push(r);
        }
        if(N==1){
            bstr="1";
        }
        else bstr="0";
        
        while (!s.isEmpty()){
            bstr += s.pop();
         }
        return bstr;
    }
    
    public static void main(String[] args){
    	BinaryGap bg= new BinaryGap();
    	//int N=20;
    	//int N=529;
    	//int N=328;
    	int N=1376796946;
    	String s = BinaryGap.convertToBinary(N);
    	int result = bg.solution(N);
    	System.out.println(result);
    	System.out.println(s);
    	
    }
}
