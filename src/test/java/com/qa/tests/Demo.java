package com.qa.tests;

import com.beust.jcommander.internal.Nullable;
import com.qa.BaseTest;
import com.qa.FlutterElement;
import com.qa.FlutterFinder;
import com.qa.pages.LoginPage;
import com.qa.utils.StringParser;

import io.appium.java_client.MobileElement;
import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Set;

import static org.apache.commons.io.FileUtils.waitFor;

public class Demo extends BaseTest {

    protected FlutterFinder finder;

    @Before("")
    public void setUp() throws Exception {
        //super.setUp();
        super.getDriver();
        finder = new FlutterFinder(getDriver());
    }

     /* @Parameters({"envID"})
      @BeforeClass
      public void beforeClass(String envID) throws Exception {
          System.out.println("Class Begin: grsdvxc");
        InputStream datais = null;
        try {
            String dataFileName = "data/loginUsers.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            loginUsers = new JSONObject(tokener);
            testData = StringParser.parseStringXML("strings/TestDataValidation.xml");
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        } finally {
            if(datais != null){
                datais.close();
            }
        }
        if(envID.equals("local")) {
            closeApp();
            launchApp();
            System.out.println("beforeClass Executed for Local");
        }
        else {
            System.out.println("beforeClass Executed for Remote");
        }
          System.out.println("Class End: jifek");
    }*/

    @Test(enabled = false)
    public void successfulLogin() throws Exception {
        //UIAutomator2
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("sprint@clrmail.com");
        loginPage.clickContinue();
        loginPage.enterLoginPassword("Test@123");
        loginPage.clickShowPasswordButton();
        loginPage.clickHidePasswordButton();
        loginPage.clickContinue();
        Thread.sleep(5000);
        loginPage.clickNotificationTab();
        loginPage.validateNotificationTab();
        loginPage.clickMarkAllReadNotifications();
        Thread.sleep(4000);
    }

    @Test(enabled = false)
    public void forgotPassword() throws Exception {
        //UIAutomator2
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("sprint@clrmail.com");
        loginPage.clickContinue();
        loginPage.enterLoginPassword("Test@123");
        loginPage.clickShowPasswordButton();
        loginPage.clickHidePasswordButton();
        loginPage.clickForgotPassword();
    }

    @Test
    public void test() throws InterruptedException {
        try {
            System.out.println("Test Case:");
            switchContext("FLUTTER");
            //loginPage.iOSPermissions();
            //FlutterFinder finder = new FlutterFinder(getDriver());
            FlutterElement signInButton = finder.byValueKey("sign_in");
            FlutterElement signInSSOButton = finder.byValueKey("sign_in_sso");
            FlutterElement signInEmailInput = finder.byValueKey("email_or_domain_input");
            FlutterElement submitEmailButton = finder.byValueKey("submit_email"); //continue
            FlutterElement submitDomainSSOButton = finder.byValueKey("submit_domain"); //continue
            FlutterElement signInPasswordInput = finder.byValueKey("password_input");
            FlutterElement signInSubmitButton = finder.byValueKey("sign_in_submit");
            FlutterElement showPassword = finder.byValueKey("show_pass");
            FlutterElement forgotPassword = finder.byValueKey("forgot_password");

            MobileElement a = finder.byValueKey("sign_in");


            System.out.println("Test Case Started!");
            System.out.println("SignIn Contains: "+signInButton+"\n");
            System.out.println("SignIn Contains: "+a+"\n");

            a.click();
            clickToElement("Sign In");
            System.out.println("1");

            signInEmailInput.sendKeys("sprint@clrmail.com");
            System.out.println("2");

            submitEmailButton.click();
            System.out.println("3");

            signInPasswordInput.sendKeys("Test@123");
            System.out.println("4");

            signInSubmitButton.click();
            Thread.sleep(5000);
            System.out.println("Test Case PASSED!");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("Test Case FAILED!");
        }
    }

    @Test(enabled = false)
    public void test1() throws InterruptedException {

        FlutterElement txt_username = finder.byValueKey("txt_username");
        FlutterElement txt_password = finder.byValueKey("txt_password");
        FlutterElement button_login = finder.byValueKey("button_login");
        Thread.sleep(3000);

        System.out.print("Test Case Started!");
        txt_username.sendKeys("user@yopmailcom");
        txt_password.sendKeys("123456");
        button_login.click();
    }

    private String getWebContext() {
        ArrayList<String> contexts = new ArrayList<String>(getDriver().getContextHandles());
        for (String context : contexts) {
            if (!context.equals("NATIVE_APP")) {
                return context;
            }
        }
        return null;
    }

    public void switchContext(String context) {
        getDriver().getContext();
        Set<String> con = getDriver().getContextHandles();
        for (String c : con) {
            if (c.contains(context)) {
                getDriver().context(c);
                break;
            }
        }
    }

    private void clickToElement(String locator){
        MobileElement el = waitFor(locator);
        el.click();
    }

    private MobileElement waitFor(String locator){
        return (MobileElement) getDriver().executeScript("flutter:waitFor", finder.byValueKey(locator), 30);
    }

    @Parameters({"envID"})
    @AfterClass
    public void afterClass(String envID) {
        if(envID.equals("local")) {
            System.out.println("afterClass Executed for Local");
        }
        else {
            System.out.println("afterClass Executed for Remote");
        }
    }
}
