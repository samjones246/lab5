import java.util.*;
public class WordGroup {

    String words;
    public WordGroup(String s){
        words = s.toLowerCase();
    }

    // Return an array made by splitting the instance variable words at each space (" ")
    public String[] getWordArray(){
        return words.split(" ");
    }

    // Return a HashSet composed of the words in this word group and another
    public HashSet<String> getWordSet(WordGroup groupToCombine){
        // Create the empty HashSet
        HashSet<String> set = new HashSet<>();

        // Add the words from the array in this WordGroup
        for(String word : groupToCombine.getWordArray()){
            set.add(word);
        }

        // Add the words from the array in the other WordGroup
        for(String word : this.getWordArray()){
            set.add(word);
        }

        // Return the now populated HashSet
        return set;
    }

    // Returns a HashMap containing the words in this group as keys and the number of times they appear as values
    public HashMap<String, Integer> getWordCounts(){
        // Create the empty HashMap "map"
        HashMap<String, Integer> map = new HashMap<>();
        // Create an array of the words in this group
        String[] array = this.getWordArray();
        /*
        Iterates through each word in the group.
        If the word is not in map, add it as a key with value 1
        If it does exist map, increment the value of the key matching this word by 1
        */
        for(String word : array){
            // putIfAbsent will only return a non-null value if the given key is already in map
            if(map.putIfAbsent(word, 1)!=null){
                map.replace(word, map.get(word)+1);
            }
        }
        return map;
    }
}
