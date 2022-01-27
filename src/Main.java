import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес страницы для анализа: ");//https://www.simbirsoft.com/
        String url = scanner.next();
            LinkedList<String> buf = TextWorker.getWordList(HTMLParser.getTextFrom(url));
            if(buf.isEmpty()) System.out.println("Невозможно отобразить статистику");
            else {
                for(Map.Entry<String, Integer> pair:  TextWorker.getWordStatistics(buf).entrySet()){
                    System.out.println(pair.getKey() + " [" + pair.getValue()+"]");
                }
            }
    }
}
