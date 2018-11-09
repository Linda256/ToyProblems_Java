package others;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Trie {
	
	private TrieNode root;
	public Trie(){
		root = new TrieNode();		
	}

		
	private class TrieNode{
		Map<Character,TrieNode> children;
		boolean endOfWord;
		
		public TrieNode(){
			children = new HashMap<>();
			endOfWord=false;
		}

	}
	
	public void insert(String word){
		char[] charArr = word.toCharArray();
		TrieNode curr = root;
		for(char c:charArr){
			if (curr.children.get(c) != null){
				curr=curr.children.get(c);
			} 
			else{
				curr.children.put(c, new TrieNode());
				curr=curr.children.get(c);
			}
		}
		curr.endOfWord = true;
	}
	
	public boolean search(String word){
		boolean found = false;
		char[] charArr = word.toCharArray();
		TrieNode curr = root;
		for(char c:charArr){
			if (curr.children.get(c)==null) return false;
			curr=curr.children.get(c);
		}
		if(curr.endOfWord == true) found=true;
		return found;
	}
	
	public  void  printTrie(){
		
		StringBuilder sb = new StringBuilder();
		Stack<TrieNode> st = new Stack<>();
		st.push(root);
		//System.out.print(root.children);
		while (!st.isEmpty()){
			TrieNode curr = st.pop();
			if (curr.children != null){
				for (char c:curr.children.keySet()){
					sb.append(c);
					sb.append("->");
					System.out.println(sb);
					st.push(curr.children.get(c));
				}
				
			}
			//System.out.println();
		}
		System.out.println(sb);
	}

	public static void main(String[] args){
		Trie t = new Trie();
		t.insert("hello");
		t.insert("blue");
		t.insert("abc");
		t.insert("ha");
		//boolean found = t.search("hello");
		boolean found2 = t.search("bc");
		System.out.println(found2);
		t.printTrie();
	}
}
