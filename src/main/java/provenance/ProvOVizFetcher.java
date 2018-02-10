package provenance;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProvOVizFetcher {
    private static final String URL = "http://provoviz.org/service";

    public static String getProvDoc(String contentData) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(URL);

        List<NameValuePair> arguments = new ArrayList<>(3);
        arguments.add(new BasicNameValuePair("data", contentData));
        post.setEntity(new UrlEncodedFormEntity(arguments));
        HttpResponse response = client.execute(post);

        // Print out the response message
        return EntityUtils.toString(response.getEntity());

    }
}
