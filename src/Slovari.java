import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class Slovari
{
    public static void main(String[] args)
            throws Exception
    {
        String httpsURL = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=dict.1.1.20141122T120306Z.4e46765dd206010a.3e4a1b182df5d892fd74dd3e44f389b0e5aeea24&lang=en-ru&text=bean";
        URL myurl = new URL(httpsURL);

        InputStream ins;
        HttpsURLConnection con;

        con = (HttpsURLConnection) myurl.openConnection();

        try {
            ins = con.getInputStream();
        } catch (FileNotFoundException e) {
            ins = con.getErrorStream();
        }

        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader in = new BufferedReader(isr);

        String inputLine;

        while ((inputLine = in.readLine()) != null)
        {
            System.out.println(inputLine);
        }

        in.close();
    }
}