import org.testng.Assert;
import org.testng.annotations.Test;
import ui.utils.ConfigProvider;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class EnvironmentMetaTest {

    @Test(groups = "meta", description = "Проверка наличия критических параметров запуска")
    public void testRequiredSystemProperties() {
        Assert.assertNotNull(ConfigProvider.URL, "URL не подтянулся из конфига!");
        Assert.assertFalse(ConfigProvider.URL.isEmpty(), "URL в конфиге пустой!");
        Assert.assertTrue(ConfigProvider.URL.startsWith("http"), "URL должен начинаться с http/https");


    }

    @Test(groups = "meta", description = "Проверка доступности YouTrack перед запуском UI тестов")
    public void testYouTrackIsReachable() {
        String url = ConfigProvider.URL;
        URI uri = URI.create(url);

        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(3))
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

            Assert.assertEquals(response.statusCode(), 200,
                    "YouTrack по адресу " + url + " ответил кодом " + response.statusCode());

        } catch (Exception e) {
            Assert.fail("YouTrack недоступен: " + url + ". Ошибка: " + e.getMessage());
        }
    }
}
