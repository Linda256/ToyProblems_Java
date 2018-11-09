package others;

import java.util.ArrayList;


public class SecondRepeatChar {
	public int secondNonRepeat(String s){
		ArrayList<Character> visited = new ArrayList<>();
		ArrayList<Character> nonRepeat = new ArrayList<>();
		String str=s.toLowerCase();
		for(int i=0;i<str.length();i++){
			char curr=str.charAt(i);
			if(curr==' ') continue;
			if (visited.contains(curr)){	
				nonRepeat.remove((Object)curr);
			}else {
				visited.add(curr);
				nonRepeat.add(curr);
			}
		}
		if (nonRepeat.size()<2) return -1;
		char c= nonRepeat.get(1);
		return s.indexOf(c);
	}
	
	public static void main(String[] args){
		SecondRepeatChar sc= new SecondRepeatChar();
		String name="Cracking Code Interview";
		//String name="abcd";
		int result=sc.secondNonRepeat(name);
		System.out.println(result);	
	}	
	

}
