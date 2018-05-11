package app;

        /*написать поисковый сервис
        по указаному слову найти все URL упорядоченые по возрастанию частоты слова
        по произвольному URL перейти и спомощью регулярного выражения найти 20 URL каждому указываете ключевые слова с частотами*/

        /*Mock для проекта проилюстрировать необходимость
        http://www.stihi-rus.ru/World/Shekspir/*/

import print_values.PrintValues;
import url_connection_reader.URLConnectionReader;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        URL[] shakespeare = {
                new URL("http://www.stihi-rus.ru/World/Shekspir/1.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/2.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/3.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/4.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/5.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/6.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/7.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/8.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/9.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/10.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/11.htm"),
                new URL("http://www.stihi-rus.ru/World/Shekspir/12.htm")
        };

        URL [] urls = {
                new URL("https://leboutique.com/deal/tovary-dlya-doma-aktivnogo-otdyha-i-shashlykov-1847664"),
                new URL("https://mail.ukr.net/q/start#msglist"),
                new URL("https://alitems.com/g/1e8d1144949dd2fa56bb16525dc3e8/"),
                new URL("http://kinoafisha.ua/ua/?utm_source=ukr.net&utm_medium=link&utm_campaign=izbranoe"),
                new URL("http://avtosale.ua"),
                new URL("http://www.booking.com/index.html?aid=375206"),
                new URL("https://mail.ukr.net/q/reg"),
                new URL("http://rozetka.com.ua/?utm_source=ukr_net_main&utm_medium=banner_logo&utm_campaign=logo_main"),
                new URL("https://born2be.com.ua/?utm_source=ukrnet&utm_medium=cpc&utm_campaign=20180201_wielkawyprz"),
                new URL("https://mail.ukr.net/desktop/login"),
                new URL("http://orakul.com"),
                new URL("http://tvgid.ua/"),
                new URL("http://auto.ria.com/?utm_source=ukrnet&utm_medium=clikukrnet&utm_campaign=favorites"),
                new URL("http://wiki.ukr.net/Error_auth"),
                new URL("https://edisk.ukr.net/"),
                new URL("http://rst.ua/"),
                new URL("https://ua.sinoptik.ua/"),
                new URL("https://mail.ukr.net/"),
        };

       /* Map<String, TreeMap<String, Integer>> map = URLConnectionReader.getWordsMapping(shakespeare,"with");
        PrintValues pv = new PrintValues();
        pv.printValues(map);*/
        /*URL url = new URL("https://www.adme.ru/");
        HashSet<String> matchedUrl = URLConnectionReader.getURLs(url);
        for (String s : matchedUrl) {
            System.out.println(s);
        }*/


        //1-й метод
        /*System.out.println("Enter serched word: ");
        Scanner sc = new Scanner(System.in);
        String searchedWord = sc.nextLine();
        Map<String, Integer> matchedMap = URLConnectionReader.getMatchedWords(searchedWord, map);*/

        Map<String, TreeMap<String, Integer>> map = URLConnectionReader.getURLsWordsMapping(urls);
        PrintValues pv = new PrintValues();
        pv.printFirstValues(map);



    }
}
