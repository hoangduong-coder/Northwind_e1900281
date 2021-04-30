package fi.vamk.e1900281.finalProject.CreatingFileFolder;

import java.net.http.HttpClient;
import javax.net.ssl.SSLContext;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class EnableHTTPS {
    RestTemplate restTemplate() throws Exception {
        SSLContext sslContext = new SSLContextBuilder()
          .loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray())
          .build();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
        HttpClient httpClient = HttpClients.custom()
          .setSSLSocketFactory(socketFactory)
          .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }
    @Test
    public void whenGETanHTTPSResource_thenCorrectResponse() throws Exception {
        ResponseEntity<String> response = 
        restTemplate().getForEntity(WELCOME_URL, String.class, Collections.emptyMap());

        assertEquals("<h1>Welcome to Secured Site</h1>", response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
