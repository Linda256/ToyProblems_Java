package codility;

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
