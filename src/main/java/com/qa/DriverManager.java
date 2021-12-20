package com.qa;

import com.qa.utils.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.lang.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverManager extends BaseTest {

    public void initializeLocalDriver(String platformName, String udid, String deviceName) throws Exception {
        JSONObject deviceData = JsonParser.getDevicesData(platformName);

        // setting logs
        String strFile = "logs" + File.separator + platformName + "_" + deviceName;
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
        ThreadContext.put("ROUTINGKEY", strFile);
        utils.log().info("Log(s) for this Run is initiated at: " + strFile);

        try {
            setPlatform(platformName);
            setDeviceName(deviceName);
            AppiumDriver driver;

            // App
            String app = (System.getProperty("user.dir") + File.separator + deviceData.get("app").toString()).replace("\\", "/");
            // Capabilities
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
            desiredCapabilities.setCapability("appPackage", deviceData.get("appPackage").toString());
            desiredCapabilities.setCapability("fullReset", false);
            // desiredCapabilities.setCapability("noReset", true);
            // desiredCapabilities.setCapability("printPageSourceOnFindFailure", true);
            // desiredCapabilities.setCapability("autoWebview", true);
            URL url = new URL(deviceData.get("appiumURL").toString());

            switch (platformName) {
                case "Android": {
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    desiredCapabilities.setCapability("autoGrantPermissions", true);
                    driver = new AndroidDriver(url, desiredCapabilities);
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    break;
                }
                case "iOS": {
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    driver = new IOSDriver(url, desiredCapabilities);
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    break;
                }
                default:
                    throw new Exception("Invalid Platform! - " + platformName);
            }
            setDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeCloudDriver(String platformName) throws Exception {
        BaseTest objBaseTest = new BaseTest();
        JSONObject deviceData = JsonParser.getDevicesData(platformName);

        AppiumDriver driver;

        Properties props = new Properties();
        String propFileName = "config.properties";
        props.load((InputStream)getClass().getClassLoader().getResourceAsStream(propFileName));
        setProps(props);

        String userName = props.getProperty("sauceLabsUserName");
        String accessKey = props.getProperty("sauceLabsAccessKey");

        URL url = new URL("https://" + userName + ":" + accessKey + (String)props.getProperty("driverCreationURL"));

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceData.get("cloudDeviceName").toString());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceData.get("cloudOSVersion").toString());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability("app", deviceData.get("cloudAppURL1").toString());
        desiredCapabilities.setCapability("build", platformName);
        desiredCapabilities.setCapability("name", "Sample Test Run");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("fullReset", false);

        // cloudAppURL = using from past; cloudAppURL1 = pre-prod(1.0.4); cloudAppURL2 = flutter-changes debug

        switch (platformName) {
            case "Android":
                driver = new AndroidDriver(url, desiredCapabilities);
                break;
            case "iOS":
                driver = new IOSDriver(url, desiredCapabilities);
                break;
            default:
                throw new IllegalStateException("Invalid Platform id" + platformName);
        }
        objBaseTest.setDriver(driver);
    }
}
