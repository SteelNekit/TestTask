import java.util.HashMap;
import java.util.LinkedList;

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
        String[] words = text.split("['\\\\/ «»,!?\";©:()\n\r\t\\[\\]]");
        LinkedList<String> result = new LinkedList<>();
        for(String str:words){
            String buf = str.trim().toLowerCase();//Чтобы слова XЧерт и черт были одним словом
            if(!buf.equals("") && !buf.equals("‑") && !buf.equals("-")  && !buf.equals("—")){//Уже забыл по чему но в наборе оказался дефис в соляного так что пришлось выпилить его
                if(buf.charAt(buf.length()-1) == '.'){//Так как теперь нельзя использовать точку в качестве разделителя, приходиться отпиливать её с конца слова
                    buf = withoutEndDot(buf);
                }
                result.add(buf);
            }
        }
        return result;
    }

    private static String withoutEndDot(String str){
        if(str.charAt(str.length()-1) == '.') return str.substring(0,str.length()-2);
        else return str;
    }
}
