package markovTextGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{	// split sourceText into array words
		// starter = words[0]
		// add words[1] as nextWord to starter
		// create a listNode for starter, 
		// add startNode to wordsList
		
		// for each word start at 1
		// check wordList contains the node with currWord or not
		// if not, create node, 
		//		if it not last word, add word[i+1] into nextWord,
		//      else add word[0] into nextWord, 
		//      put the node into wordList. 
		// else 
		// 		if it not last word, add word[i+1] into nextWord,
		//      else add word[0] into nextWord
		String[] words = sourceText.split(" +" );
//		for (String word:words){
//			System.out.println(word);
//		}
		starter = words[0];
		ListNode startNode = new ListNode(starter);
		startNode.addNextWord(words[1]);
		wordList.add(startNode);
		int len=words.length-1;
		for (int i=1;i<len;i++){
			boolean found = false;
			for (ListNode aNode : wordList){
				if (words[i].equals(aNode.getWord())){
					if(i != len-1)  aNode.addNextWord(words[i+1]);
					else aNode.addNextWord(starter);
				found=true;
				break;
				}
			}
			if (found==false){
				ListNode aNode = new ListNode(words[i]);
				if(i != len-1) aNode.addNextWord(words[i+1]);
				else aNode.addNextWord(starter);
				wordList.add(aNode);
			}
		}
			
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
		String res ="";
		
	   
		return null;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		
	}
	

	
	
	/**   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println("gen is trained: "+ gen.toString());
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list */ 
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		int randomInd = generator.nextInt(nextWords.size());
	    return nextWords.get(randomInd);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}



