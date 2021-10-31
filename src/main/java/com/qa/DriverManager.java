package com.qa;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverManager{

    public static void initializeDriver (String envID, String deviceID) throws Exception {
        BaseTest objBaseTest = new BaseTest();
        AppiumDriver driver;
        //HashMap<String, String> testDataValidation = new HashMap<>();
        //testDataValidation = StringParser.parseStringXML("TestDataValidation.xml");
        //JSONObject deviceObj = new JSONObject(JsonParser.parse("Devices.json").getJSONObject(deviceID).toString());

        DesiredCapabilities caps = new DesiredCapabilities();

        String userName = "oauth-gojur.ravikanth-77299";
        String accessKey = "2f1b6b64-c96a-4242-979b-42c6516c21d8";
        URL url = new URL("https://" + userName + ":" + accessKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        caps.setCapability("device", /*deviceObj.getString("device")*/"Samsung Galaxy S9");
        caps.setCapability("os_version", /*deviceObj.getString("os_version")*/"9");
        caps.setCapability("project", "LMSMobile");
        caps.setCapability("build", "1.0.4");
        caps.setCapability("name", "Sample Test Run");
        caps.setCapability("autoGrantPermissions", true);

        switch (deviceID) {
            case "1":
                caps.setCapability("app", /*deviceObj.getString("app_url")*/"storage:6bd8d42c-215c-4599-952b-7fba702ce427");
                driver = new AndroidDriver(url, caps);
                break;
            case "2":
                caps.setCapability("app", /*deviceObj.getString("app_url")*/"storage:dbf85b9a-dce3-428b-87ac-b9ec6ed0f183");
                driver = new IOSDriver(url, caps);
                break;
            default:
                throw new IllegalStateException("Invalid Device id" + deviceID);
        }
        objBaseTest.setDriver(driver);
    }
}

// (netstat -ano|findstr "PID :4723"),  (taskkill /pid enter_pid_here /f)
//"app_url": "storage:6bd8d42c-215c-4599-952b-7fba702ce427" // lmsAndroid
//"app_url": "storage:dbf85b9a-dce3-428b-87ac-b9ec6ed0f183" // lmsIOS
//"app_url": "storage:1c0dd137-09ab-4534-8263-5053d72b2d98" // sauceAndroid
//"app_url": "storage:81c3825c-d215-424a-bb8f-a648f210d958" // sauceIOS