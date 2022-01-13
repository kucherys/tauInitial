package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver;
    public static AppiumDriverLocalService service;

    public static AppiumDriverLocalService startServer() {
        boolean flag = checkIfServerIsRunning(4723);
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static boolean checkIfServerIsRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", " 7.1");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/ToDo.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public void iOS_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("isHeadless",true);
        capabilities.setCapability("showXcodeLog",true);
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        capabilities.setCapability("wdaStartupRetries", "4");
        capabilities.setCapability("iosInstallPause","8000" );
        capabilities.setCapability("wdaStartupRetryInterval", "20000");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public void iOS_setUpRyse() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("isHeadless",true);
        capabilities.setCapability("showXcodeLog",true);
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/iOSApp/Digibank.app");
        capabilities.setCapability("wdaStartupRetries", "4");
        capabilities.setCapability("iosInstallPause","8000" );
        capabilities.setCapability("wdaStartupRetryInterval", "20000");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public void iOS_setUpDigibank () throws IOException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
//        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.3");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap.setCapability("isHeadless",true);
        cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
//        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability("app",
                System.getProperty("user.dir") + "/apps/iOSApp/Digibank.app");
        cap.setCapability("wdaStartupRetries", "4");
        cap.setCapability("iosInstallPause","8000" );
        cap.setCapability("wdaStartupRetryInterval", "20000");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
