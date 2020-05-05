import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class News {
    public static void main(String[] args) throws IOException {
        try {
            String link = "https://vnexpress.net/the-gioi";
            URL url = new URL(link);
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content.replaceAll("\\n+","");
            Pattern pattern = Pattern.compile("alt=\"(.*?) class=");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()){
                System.out.println(matcher.group(1));
            }
//            System.out.println(content);
        }catch (Exception e){
            System.out.println("Máy ghẻ");
        }
    }
}
