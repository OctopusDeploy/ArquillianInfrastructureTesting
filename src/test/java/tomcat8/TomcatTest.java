package tomcat8;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Arquillian.class)
public class TomcatTest {

    @Test
    public void connectToTomcat() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpGet httpGet = new HttpGet("http://localhost:8080");
            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                final int responseCode = response1.getStatusLine().getStatusCode();
                Assert.assertTrue(responseCode >= 200);
                Assert.assertTrue(responseCode <= 399);
            }
        }
    }
}
