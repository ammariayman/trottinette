package com.is.trottinette.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.is.trottinette.models.Trottinette;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class TrottinetteLoader {
    private static final String MAINTENANCE_URL = "http://localhost:8080/trottinette/";
    private static Map<Long, Trottinette> trottinettes = null;

    public static void load() throws Exception {
        Map<Long, Trottinette> temp = new HashMap<>();
        String texte = getTrottinettesOverHttp();
        ObjectMapper mapper = new ObjectMapper();
        List<Trottinette> list = Arrays.asList(mapper.readValue(texte, Trottinette[].class));
        list.forEach((t) -> temp.put(t.getId(), t));

        // A la fin, pour être sûr que le test échoue avant :
        trottinettes = temp;
    }

    public static Map<Long, Trottinette> getTrottinettes() {
        return trottinettes;
    }

    // Chargement des trottinettes depuis le serveur HTTP déployé dans le projet maintenance

    /**
     * This example demonstrates the use of the {@link ResponseHandler} to simplify
     * the process of processing the HTTP response and releasing associated resources.
     *
     * Source : Apache HTTP Components
     * http://hc.apache.org/httpcomponents-client-ga/examples.html -> Response handling
     */
    private static String getTrottinettesOverHttp() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String responseBody = null;
        try {
            HttpGet httpget = new HttpGet(MAINTENANCE_URL);

            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
        return responseBody;
    }

}