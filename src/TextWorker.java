import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TextWorker {
    public static HashMap<String,Integer> getWordStatistics(LinkedList<String> words){
        String buf;
        HashMap<String,Integer> result = new HashMap<>();
        while(!words.isEmpty()){
            buf = words.pollFirst();
            if(result.containsKey(buf)){
                result.put(buf,result.get(buf)+1);
            }else{
                result.put(buf,1);
            }
        }
        return result;
    }

    public static LinkedList<String> getWordList(String text){
        String[] words = text.split("['\\\\/ «»,.!?\";©:()\n\r\t\\[\\]]");
        LinkedList<String> result = new LinkedList<>();
        for(String str:words){
            if(!str.equals("") && !str.equals("‑") && !str.equals("-")  && !str.equals("—")) result.add(str.trim().toLowerCase());
        }
        return result;
    }
}
