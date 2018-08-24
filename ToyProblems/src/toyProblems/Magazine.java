package toyProblems;

import java.util.HashMap;
import java.util.Hashtable;

public class Magazine {
	static String checkMagazine(String[] megazine, String[] note) {
        //initiate magTable hashtable
        //inititate noteTable hashtable
        //loop through note
        //     if note[i] is the not exit in the noteTable
        //       put note[i] as the key, 1 as the value
        //     else value++
        //loop through note
        //     if magazine[i] is the not exit in the megTable
        //       put magazine[i] as the key, 1 as the value
        //     else value++
        //for each key in noteTable check it is in magTable 
        //      if no,  return false;
        //      if yes, check the value, if value in magTable < value in noteTable return false
        // return true
        
//    Hashtable<String,Integer> megTable = new Hashtable<>();
//    Hashtable<String,Integer> noteTable = new Hashtable<>();
		
	HashMap<String,Integer> magTable = new HashMap<>();
	HashMap<String,Integer> noteTable = new HashMap<>();
    for (int i=0;i<note.length;i++){
        if(noteTable.containsKey(note[i])) noteTable.put(note[i], noteTable.get(note[i])+1);
        else noteTable.put(note[i],1);
    }
    for (int i=0;i<megazine.length;i++){
        if(magTable.containsKey(megazine[i])) magTable.put(megazine[i], magTable.get(megazine[i])+1);
        else magTable.put(megazine[i],1);
    }
    for (String k : noteTable.keySet() ){
        if (!magTable.containsKey(k)) return "No";
        else if (magTable.get(k) < noteTable.get(k)) return "No";    
    }
    return "Yes";
        
    }
	

	public static void main(String[] args) {
		String[] mag={"give", "me", "one", "grand","night"};
		String[] note= {"give", "me","one", "grand","night","give"};
		//Magazine m = new Magazine();
		String result=Magazine.checkMagazine(mag, note);
		System.out.println(result);

	}

}
