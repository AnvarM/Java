import java.util.HashMap;

public class JHMap {
    public static void main(String[] args){
        String[] list = new String[20];

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < 20; i ++){
            hm.put(i, i + 100); //fill hm with elements
        }

        hm.put(1, 1); // add element to hashmap
        hm.remove("First"); //remove element from hashmap with key
        hm.containsKey(3); //return boolean if hm contains key = 3

        //Iterate through each element of hashmap
        for(HashMap.Entry<Integer, Integer> p : hm.entrySet()){
            System.out.println(p.getKey() + " : " + p.getValue());
        }
    }
}
