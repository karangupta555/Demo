package com.qa.lms.mobile;

import com.aventstack.extentreports.Status;
import com.qa.lms.mobile.reports.ExtentReport;
import com.qa.lms.mobile.utils.JsonParser;
import com.qa.lms.mobile.utils.StringParser;
import com.qa.lms.mobile.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    protected static ThreadLocal<Properties> props = new ThreadLocal<Properties>();
    protected static ThreadLocal<HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
    protected static ThreadLocal<String> platform = new ThreadLocal<String>();
    protected static ThreadLocal<String> dateTime = new ThreadLocal<String>();
    protected static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static AppiumDriverLocalService server;
    TestUtils utils = new TestUtils();

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    public Properties getProps() {
        return props.get();
    }

    public void setProps(Properties props2) {
        props.set(props2);
    }

    public HashMap<String, String> getString() {
        return strings.get();
    }

    public void setStrings(HashMap<String, String> strings2) {
        strings.set(strings2);
    }

    public String getPlatform() {
        return platform.get();
    }

    public void setPlatform(String platform2) {
        platform.set(platform2);
    }

    public String getDateTime() {
        return dateTime.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDateTime(String dateTime2) {
        dateTime.set(dateTime2);
    }


    /*@Parameters({"envID"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(@Optional String envID) throws Exception {
        if (true) {
            ThreadContext.put("ROUTINGKEY", "ServerLogs");
            server = getAppiumService("Windows"); // Windows or Mac
            if (!checkIfAppiumServerIsRunnning(4723)) {
                server.start();
                server.clearOutPutStreams();
                utils.log().info("Appium server started");
            } else {
                utils.log().info("Appium server already running");
            }
            utils.log().info("'beforeSuite' Executed for Local");
        } else {
            utils.log().info("'beforeSuite' Executed for Remote");
        }
    }

    @Parameters({"envID"})
    @AfterSuite(alwaysRun = true)
    public void afterSuite(@Optional String envID) {
        if (true) {
            server.stop();
            utils.log().info("'afterSuite' Executed for Local");
        } else {
            utils.log().info("'afterSuite' Executed for Remote");
        }
    }*/

    public AppiumDriverLocalService getAppiumService(String platform) throws Exception {
        HashMap<String, String> environment = new HashMap<String, String>();
        switch(platform) {
            case "Windows": {
                environment.put("PATH", "C:\\Users\\New User\\AppData\\Local\\Android\\Sdk:-:-" + System.getenv("PATH"));
                environment.put("ANDROID_HOME", "C:\\Users\\New User\\AppData\\Local\\Android\\Sdk");
                return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                        .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                        .withAppiumJS(new File("C:\\Users\\New User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                        .usingPort(4723).withArgument(GeneralServerFlag.SESSION_OVERRIDE).withEnvironment(environment)
                        .withLogFile(new File("ServerLogs/server.log")));
            }
            case "Mac OS X": {
                environment.put("PATH", "/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home/bin:/Users/ravikanth/Library/Android/sdk/tools:/Users/ravikanth/Library/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/munki:/Library/Apple/usr/bin" + System.getenv("PATH"));
                environment.put("ANDROID_HOME", "/Users/ravikanth/Library/Android/sdk");
                environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home");
                return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                        .usingDriverExecutable(new File("/usr/local/bin/node"))
                        .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                        .usingPort(4723).withArgument(GeneralServerFlag.SESSION_OVERRIDE).withEnvironment(environment)
                        .withLogFile(new File("ServerLogs/server.log")));
            }
            default: {
                utils.log().info("Something wrong with 'getAppiumService()'");
                throw new Exception("Something wrong with 'getAppiumService()'");
            }
        }
    }

    public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
        boolean isAppiumServerRunning = false;
        ServerSocket socket;
        try {
            socket = new ServerSocket(port);
            socket.close();
        } catch (IOException e) {
            utils.log().info("Appium Server is Running!");
            isAppiumServerRunning = true;
        } finally {
            socket = null;
        }
        return isAppiumServerRunning;
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    @Parameters({"envID", "platformName", "udid", "deviceName"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(@Optional String envID, String platformName, String UDID, String deviceName) throws Exception {
        try {
            DriverManager objDriver = new DriverManager();
            if (envID.equals("local")) {
                // Driver Initialization for Local
                objDriver.initializeLocalDriver(platformName, UDID, deviceName);
                utils.log().info("'beforeTest' Executed for Local");
            } else {
                // Driver Initialization for Remote(SauceLabs)
                objDriver.initializeCloudDriver(platformName);
                utils.log().info("'beforeTest' Executed for Remote");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Parameters({"envID"})
    @AfterTest(alwaysRun = true)
    public void quit(@Optional String envID) {
        if (getDriver() != null) {
            getDriver().quit();
        }
        if (envID.equals("local")) {
            utils.log().info("'afterTest' Executed for Local");
        } else {
            utils.log().info("'afterTest' Executed for Remote");
        }
    }

    @Parameters({"envID"})
    @BeforeClass
    public void beforeClass(String envID) throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/loginData.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            JSONObject loginUsers = new JSONObject(tokener);
            HashMap<String,String> testData = StringParser.parseStringXML("strings/TestDataValidation.xml");
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        } finally {
            if(datais != null){
                datais.close();
            }
        }
        if(envID.equals("local")) {
            utils.log().info("'beforeClass' Executed for Local");
        }
        else {
            utils.log().info("'beforeClass' Executed for Remote");
        }
    }

    @Parameters({"envID"})
    @AfterClass
    public void afterClass(String envID) {
        if(envID.equals("local")) {
            utils.log().info("'afterClass' Executed for Local");
        }
        else {
            utils.log().info("'afterClass' Executed for Remote");
        }
    }

    @Parameters({"envID"})
    @BeforeMethod
    public void beforeMethod (String envID) throws InterruptedException {
        launchApp();
        if(envID.equals("local")) {
            ((CanRecordScreen) getDriver()).startRecordingScreen();
            utils.log().info("'beforeMethod' Executed for Local");
        } else {
            utils.log().info("'beforeMethod' Executed for Remote");
        }
    }

    @Parameters({"envID", "platformName"})
    @AfterMethod
    public synchronized void afterMethod (ITestResult result, String envID, String platformName) throws Exception {
        closeApp();
        if(envID.equals("local")) {
            JSONObject deviceData = JsonParser.getDevicesData(platformName);
            String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
            String dir = "videos" + File.separator + platformName + "_" + deviceData.get("OSVersion").toString() + "_" + deviceData.get("deviceName").toString() + File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
            File videoDir = new File(dir);
            synchronized (videoDir) {
                if (!videoDir.exists()) {
                    videoDir.mkdirs();
                }
            }
            FileOutputStream stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
            stream.write(Base64.decodeBase64(media));
            utils.log().info("'afterMethod' Executed for Local");
        }else {
            utils.log().info("'afterMethod' Executed for Remote");
        }
    }

    public void launchApp() {
        utils.log().info("Launching App...");
        getDriver().launchApp();
    }

    public void closeApp() {
        utils.log().info("App Closed!!");
        getDriver().closeApp();
    }

    public void iOSPermissions() throws Exception {
        try {
            waitForVisibility((MobileElement)getDriver().findElement(By.name("Allow Access to All Photos")));
            getDriver().findElement(By.name("Allow Access to All Photos")).click();
            utils.log().info("'Allow Access to All Photos' Permission allowed Successfully");
            ExtentReport.getTest().log(Status.INFO, "'Allow Access to All Photos' Permission allowed Successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to 'Allow Access to All Photos' Permission");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to 'Allow Access to All Photos' Permission");
            throw new Exception("Error: Unable to 'Allow Access to All Photos' Permission!");
        }
    }

    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void clear(MobileElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.clear();
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getText(MobileElement e, String msg) {
        String txt = null;
        System.out.println("Platform Name: " + getPlatform());
        switch (getPlatform()) {
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
        }
        utils.log().info(msg + txt);
        ExtentReport.getTest().log(Status.INFO, msg + txt);
        return txt;
    }

    public void OpenAppWithDeepLinks(String url) {
        switch(Objects.requireNonNull(getDriver().getPlatformName())) {
            case "Android":
                HashMap<String,String> deepUrl = new HashMap<>();
                deepUrl.put("url", url);
                deepUrl.put("package", "com.swaglabsmobileapp");
                getDriver().executeScript("mobile: deepLink", deepUrl);
                break;
            case "iOS":
                By urlBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'URL'");
                By urlFld = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField' && name CONTAINS 'URL'");
                By openBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'Open'");
                getDriver().activateApp("com.apple.mobilesafari");
                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(urlBtn)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(urlFld)).sendKeys("" + url + "\uE007");
                wait.until(ExpectedConditions.visibilityOfElementLocated(openBtn)).click();
                break;
        }
    }
}
