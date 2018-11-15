package dynamicProgram;

public class Fibonacci {
	public int fib(int n){
		if (n==1) return 1;
		if (n==0) return 0;
		return fib(n-1)+fib(n-2);
	}
	
	public int fib2(int n){
		if(n==1|| n==2) return 1;
		return fib(n-1)+fib(n-2);
		
	}
	public int fib3(int n){
		int result=0;
		int[] meno=new int[n+1];
		result=fibDp(n,meno,result);
		return result;
	}
	
	public int fibDp(int n, int[] meno, int result){
		if (meno[n]!=0) result =meno[n];
		if (n==1 || n==2){
			result=1;
		}
		else {
			result=fib(n-1)+fib(n-2);
			meno[n]=result;
		}
		return result;
	}
	
	public static void main(String[] args){
		Fibonacci f= new Fibonacci();
		int res=f.fib3(6);
		System.out.println(res);
		
	}

}
