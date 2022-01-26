import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HTMLParser {
    public static String getTextFrom(String url){
        try{
            Document document = Jsoup.connect(url).get();
            return document.text();
        }catch(IOException e){
            System.out.print(e.getMessage());
            return "";
        }
    }
}
