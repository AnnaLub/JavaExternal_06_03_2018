package url_connection_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLConnectionReader {

    public static Map<String, TreeMap<String, Integer>> getWordsMapping(URL[] urls, String searchedWord) throws IOException {
        Map<String, TreeMap<String, Integer>> map = new HashMap<>();
        for (URL url : urls) {
            URLConnection con = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = br.readLine()) != null)
                sb.append(inputLine);
            String[] words = sb.toString().split(" ");
            for (String word : words) {
                if (word.equals(searchedWord)) {
                    TreeMap<String, Integer> treeMap = map.get(word);
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                        treeMap.put(url.toString(), 1);
                    } else {
                        treeMap.put(url.toString(), treeMap.get(url.toString()) == null ? 1 : treeMap.get(url.toString()) + 1);
                    }
                    map.put(word, treeMap);
                }
            }
        }
        return map;
    }

    private static TreeMap<String, Integer> getURLMapping(URL url) throws IOException {
        TreeMap<String, Integer> map = new TreeMap<>();
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = br.readLine()) != null)
                sb.append(inputLine);
            String[] words = sb.toString().split(" ");
            for (String word : words) {
                map.get(word);
                if (word.length()!=0 ) {
                    if (map == null) {
                        map = new TreeMap<>();
                        map.put(word, 1);
                    } else {
                        map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
                    }
                }
            }
        return map;
    }

    public static Map<String, TreeMap<String, Integer>> getURLsWordsMapping(URL[] urls) throws IOException {
        Map<String, TreeMap<String, Integer>> map = new HashMap<>();
        for (URL url : urls) {
            map.put(url.toString(), getURLMapping(url));
        }
        return map;
    }

  /*  public static ArrayList<String> getMatchedWords(URL url) throws IOException {

        Matcher matcher;

        Pattern pattern = Pattern.compile("<a href=\"#\">ZZZ</a>");
        ArrayList<String> matchedWords = new ArrayList<>();
        int counter = 0;

        URLConnection con = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = br.readLine()) != null)
            sb.append(inputLine);
        String[] words = sb.toString().split(" ");
        for (int i = 0; i < words.length; i++) {
            matcher = pattern.matcher(words[i]);
            if (matcher.matches()) {
                matchedWords.add(words[i]);
                counter++;
                if (counter == 20) {
                    break;
                }
            }
        }
        return matchedWords;
    }*/

    public static HashSet<String> getURLs(URL url) throws IOException {
        final String regex = "<a\\s+(?:[^>]*?\\s+)?href=(\"([^\"]*)\")";
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        HashSet<String> matchedUrl = new HashSet<>();
        String inputLine;

        while ((inputLine = br.readLine()) != null) {
            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find() & matchedUrl.size()<20) {
                String str = matcher.group(2);
                if(str.startsWith("http")) {
                    matchedUrl.add(matcher.group(2));
                }
            }
        }
        return matchedUrl;
    }
}







