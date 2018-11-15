package dynamicProgram;

public class Fibonacci {
	public int fib(int n){
		if (n==1) return 1;
		if (n==0) return 0;
		return fib(n-1)+fib(n-2);
	}
	
	public static void main(String[] args){
		Fibonacci f= new Fibonacci();
		int res=f.fib(8);
		System.out.println(res);
		
	}

}
