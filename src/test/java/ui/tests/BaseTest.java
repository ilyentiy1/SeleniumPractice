package ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.Map;


abstract public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> threadDriver = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        options.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", false,
                "screenResolution", "1920x1080x24"
        ));

//        try {
//            RemoteWebDriver driver = new RemoteWebDriver(
//                    URI.create("http://host.docker.internal:4444/wd/hub").toURL(), options
//            );
//            threadDriver.set(driver);
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("Ошибка в адресе Selenoid", e);
//        }

        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://host.docker.internal:4444/wd/hub").toURL(), options
        );
        threadDriver.set(driver);


        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            threadDriver.remove();
        }
    }
}
