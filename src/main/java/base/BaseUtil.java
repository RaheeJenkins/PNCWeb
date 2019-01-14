package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseUtil {

    private String CLOUD_URL = "https://sales.experitest.com:443/wd/hub";
    private String ACCESS_KEY = "eyJ4cC51IjoxMzg2NDQsInhwLnAiOjIsInhwLm0iOiJNVFV5TnpJM01EVTVPVFkwTmciLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NDkyNzg3MDMsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.bMME0KO9FuI-HFbFUq43vva3ZXLnA0IqNz1SX6VBJt4";

//    private String CLOUD_URL = "https://uscloud.experitest.com:443/wd/hub";
//    private String ACCESS_KEY = "eyJ4cC51IjoxMDQ0MjksInhwLnAiOjIsInhwLm0iOiJNVFV5TURJNE1UUTFNamswTmciLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NTI4OTM4MTksImlzcyI6ImNvbS5leHBlcml0ZXN0In0.LFWcGB-dTCgDPVfMsZ9zPM1zGVZ67r62kGXT2064WYg";

    public ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public RemoteWebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters({"browserName", "browserVersion", "platform"})
    public void setUp(@Optional(BrowserType.CHROME) String browserName, @Optional("Any") String browserVersion,
                      String platform, @Optional Method method) throws MalformedURLException {
        startBrowser(browserName, browserVersion, platform, method);
        maximizeWindow();
    }

    private void startBrowser(String browserName, String browserVersion, String platform, Method method) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("testName", method.getName());
        dc.setCapability("newSessionWaitTimeout", 300);

        if (platform.equalsIgnoreCase("Windows")) {

            dc.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
            dc.setCapability(CapabilityType.VERSION, browserVersion);

            if (browserName.equalsIgnoreCase("Chrome")) {
                startChrome(dc);
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                startFirefox(dc);
            } else if (browserName.equalsIgnoreCase("IE")) {
                startIE(dc);
            }
        } else if (platform.equalsIgnoreCase("Mac")) {

            dc.setCapability(CapabilityType.PLATFORM, Platform.MAC);
            dc.setCapability(CapabilityType.VERSION, browserVersion);

            if (browserName.equalsIgnoreCase("Chrome")) {
                startChrome(dc);
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                startFirefox(dc);
            } else if (browserName.equalsIgnoreCase("IE")) {
                startIE(dc);
            } else if (browserName.equalsIgnoreCase("Safari")) {
                startSafari(dc);
            }
        }
    }

    private void startChrome(DesiredCapabilities dc) throws MalformedURLException {
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        dc.setCapability("PNC", "PNC_Chrome_Desktop");
        driver.set(new RemoteWebDriver(new URL(CLOUD_URL), dc));
    }

    private void startFirefox(DesiredCapabilities dc) throws MalformedURLException {
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        dc.setCapability("PNC", "PNC_Firefox_Desktop");
        driver.set(new RemoteWebDriver(new URL(CLOUD_URL), dc));
    }

    private void startIE(DesiredCapabilities dc) throws MalformedURLException {
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IE);
        dc.setCapability("PNC", "PNC_IE_Desktop");
        driver.set(new RemoteWebDriver(new URL(CLOUD_URL), dc));
    }

    private void startSafari(DesiredCapabilities dc) throws MalformedURLException {
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.SAFARI);
        dc.setCapability("PNC", "PNC_Safari_Desktop");
        driver.set(new RemoteWebDriver(new URL(CLOUD_URL), dc));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }

    private void maximizeWindow() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int width = (int) toolkit.getScreenSize().getWidth();
        int height = (int) toolkit.getScreenSize().getHeight();
        getDriver().manage().window().setSize(new Dimension(width, height));
    }
    
}
