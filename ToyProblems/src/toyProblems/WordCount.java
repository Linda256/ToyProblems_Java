package toyProblems;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class WordCount {
		//input: list of words (string) or 'txt’ file (word per line).

		//example input all strings same size:

		// bigdata
		// bigdata
		// fire
		// fire
		// north
		// CA
		// bigdata
		// bigdata
		// people
		// people
		// java
		// java
		// java
		// c++
		// c++
		// bigdata
		// people    

	public HashMap<String,Integer> calulatePup(String[] words){
	     HashMap<String, Integer> popularity = new HashMap<>();
	     for (int i=0; i< words.length; i++){
	       if (!popularity.containsKey(words[i])){
	         popularity.put(words[i],1);
	       } 
	       else {
	         popularity.put(words[i],popularity.get(words[i])+1);
	       }
	     }
	     return popularity;
	}
	
//	public HashMap<String,Integer> sortMap(HashMap<String,Integer> hm){
//		Collections.sort(hm);
//		return hm;
//	}
		  
   public static void main(String[] args){
	   String[] words = {"java","python","javascript","python","javascript","java","java"};
	   WordCount wc = new WordCount();
	   HashMap<String,Integer> result = wc.calulatePup(words);
	   System.out.println(result);
	   
   }
		  

}
