package provenance;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Git2ProvFetcher {
    private static final String URL = "http://www.git2prov.org/git2prov";

    public static String getProvDoc(String repoURL) throws Exception {
        StringBuilder result = new StringBuilder();
        java.net.URL url = new URL(getUrl(repoURL));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/text");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static String getUrl(String repoURL) throws MalformedURLException {
        String url = URL + "?giturl=" + repoURL + "&" +"serialization=PROV-O";
        System.out.println(url);
        return url;
    }
}