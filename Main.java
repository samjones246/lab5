import java.util.*;
public class Main {

    public static void main(String[] args) {
        // Create the WordGroups with the sentences given in the spec
        WordGroup groupA = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
        WordGroup groupB = new WordGroup("When you play play hard when you work don't play at all");
        // Use the getWordArray methods of these WordGroups to create two arrays of Strings
        String[] arrayA = groupA.getWordArray();
        String[] arrayB = groupB.getWordArray();
        // Output by iterating through these arrays
        System.out.println("----Word Array A----");
        for(String word : arrayA){
            System.out.println(word);
        }
        System.out.println("----Word Array B----");
        for(String word : arrayB){
            System.out.println(word);
        }

        // Get the HashSet of the words in groups A and B and the iterator for this set
        HashSet<String> set = groupA.getWordSet(groupB);
        Iterator<String> itr = set.iterator();
        System.out.println("----Word Set----");
        // Output by iterating through this set
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // Creates a HashMap, Set of keys and Iterator for both WordGroups
        HashMap<String, Integer> countsA = groupA.getWordCounts(), countsB = groupB.getWordCounts();
        Set<String> setA = countsA.keySet(), setB = countsB.keySet();
        Iterator<String> itrA = setA.iterator(), itrB = setB.iterator();

        System.out.println("----Word Counts A----");
        // Output by iterating through the wordGroupA HashMap
        while (itrA.hasNext()){
            String toPrint = itrA.next();
            System.out.println(toPrint + " " + countsA.get(toPrint)); // Concatenate the key and value from the map
        }
        // As above but for wordGroupB
        System.out.println("----Word Counts B----");
        for(Integer i=0;i<setB.size();i++){
            String toPrint = itrB.next();
            System.out.println(toPrint + " " + countsB.get(toPrint));
        }

        itr = set.iterator();   // Reset the iterator for the HashSet which we created earlier
        System.out.println("----Combined Word Counts----");
        // Iterate through the HashSet and pull the counts of each word from the HashMaps to get a total count for each word
        while(itr.hasNext()){
            String toPrint = itr.next();
            int count=0;    // Variable to store the total count for the current word
            // Add the number of times the word appears in each HashMap to the count variable
            // If statements used to avoid errors when the word is not in the HashMap
            if(countsA.get(toPrint)!=null){
                count+=countsA.get(toPrint);
            }
            if(countsB.get(toPrint)!=null){
                count+=countsB.get(toPrint);
            }
            System.out.println(toPrint + " " + count);
        }
        
    }
    
}
