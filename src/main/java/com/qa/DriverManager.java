package com.qa;

import com.qa.utils.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.InputStream;
import java.net.URL;
import java.lang.*;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverManager extends BaseTest {

    public void initializeSauceLabsDriver(String platformName) throws Exception {
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
        desiredCapabilities.setCapability( MobileCapabilityType.PLATFORM_VERSION, deviceData.get("cloudOSVersion").toString());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, deviceData.get("cloudAppURL").toString());
        desiredCapabilities.setCapability("build", "1.0.4");
        desiredCapabilities.setCapability("name", "Sample Test Run");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("fullReset", false);

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
