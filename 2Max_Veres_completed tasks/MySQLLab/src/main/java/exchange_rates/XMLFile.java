package exchange_rates;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class XMLFile {
    public static void getHTTPConnection() throws IOException {
        FileWriter fw = new FileWriter("data/organiz.xml");
        URL url = new URL("http://resources.finance.ua/ru/public/currency-cash.xml");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        int responseCode = con.getResponseCode();
        System.out.println("Responce code"+responseCode);
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while((inputLine=br.readLine())!=null){
            fw.write(inputLine+"\n");
        }
        br.close();
        fw.close();
    }
}
