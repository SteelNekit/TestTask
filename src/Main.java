import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> buf = TextWorker.getWordList(HTMLParser.getTextFrom("https://www.simbirsoft.com/"));

        for(Map.Entry<String, Integer> pair:  TextWorker.getWordStatistics(buf).entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
