package com.qa.lms.mobile;

import com.qa.lms.mobile.utils.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
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

    public void initializeLocalDriver(String platformName) throws Exception {
        try {
            AppiumDriver driver;

            //  Reading Data
            JSONObject deviceData = JsonParser.getDevicesData(platformName);
            Properties props = new Properties();
            String propFileName = "config.properties";
            props.load((InputStream)getClass().getClassLoader().getResourceAsStream(propFileName));
            setProps(props);

            setPlatform(platformName); /****/
            setDeviceName(deviceData.get("deviceName").toString()); /****/

            // App
            String app = (System.getProperty("user.dir") + File.separator + deviceData.get("app").toString()).replace("\\", "/");

            // Capabilities
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            desiredCapabilities.setCapability("build", platformName+" "+deviceData.get("build").toString());
            desiredCapabilities.setCapability("name", "Backlogs");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceData.get("deviceName").toString());
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, props.getProperty("deviceID"));
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
            desiredCapabilities.setCapability("appPackage", props.getProperty("appPackage"));
            desiredCapabilities.setCapability("appActivity", props.getProperty("appActivity"));
            desiredCapabilities.setCapability("fullReset", false);
            desiredCapabilities.setCapability("autoGrantPermissions", true);
            desiredCapabilities.setCapability("autoAcceptAlerts", true);
            // desiredCapabilities.setCapability("noReset", true);
            // desiredCapabilities.setCapability("printPageSourceOnFindFailure", true);
            // desiredCapabilities.setCapability("autoWebview", true);
            URL url = new URL(props.getProperty("appiumURL"));

            switch (platformName) {
                case "Android": {
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
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
        try {
            AppiumDriver driver;

            // Reading Config, TestData files
            JSONObject deviceData = JsonParser.getDevicesData(platformName);
            Properties props = new Properties();
            String propFileName = "config.properties";
            props.load((InputStream)getClass().getClassLoader().getResourceAsStream(propFileName));
            setProps(props);

            String userName = props.getProperty("sauceLabsUserName");
            String accessKey = props.getProperty("sauceLabsAccessKey");

            URL url = new URL("https://" + userName + ":" + accessKey + (String)props.getProperty("sauceLabsURL"));

            // Capabilities
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", platformName);
            desiredCapabilities.setCapability("build", platformName+" "+deviceData.get("build").toString());
            desiredCapabilities.setCapability("name", "Backlogs");
            // desiredCapabilities.setCapability("deviceName", deviceData.get("cloudDeviceName").toString());
            // desiredCapabilities.setCapability("platformVersion", deviceData.get("cloudOSVersion").toString());
            desiredCapabilities.setCapability("app", deviceData.get("cloudApp").toString());
            desiredCapabilities.setCapability("appPackage", props.getProperty("appPackage"));
            desiredCapabilities.setCapability("appActivity", props.getProperty("appActivity"));
            desiredCapabilities.setCapability("fullReset", false);
            desiredCapabilities.setCapability("autoGrantPermissions", true);
            desiredCapabilities.setCapability("autoAcceptAlerts", true);
            // desiredCapabilities.setCapability("noReset", true);
            // desiredCapabilities.setCapability("printPageSourceOnFindFailure", true);
            // desiredCapabilities.setCapability("autoWebview", true);

            switch (platformName) {
                case "Android":
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    driver = new AndroidDriver(url, desiredCapabilities);
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    break;
                case "iOS":
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    driver = new IOSDriver(url, desiredCapabilities);
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    break;
                default:
                    throw new IllegalStateException("Invalid Platform id" + platformName);
            }
            setDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
