package com.qa.tests;

import com.qa.BaseTest;
import com.qa.FlutterElement;
import com.qa.FlutterFinder;
import com.qa.pages.LoginPage;
import com.qa.utils.StringParser;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.InputStream;

public class Demo extends BaseTest {

    /*  @Parameters({"envID"})
      @BeforeClass
      /****/ // beforeClass, beforeMethod in other files
   /* public void beforeClass(String envID) throws Exception {
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
    }
*/
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
        FlutterFinder finder = new FlutterFinder(getDriver());
        //LoginPage loginPage = new LoginPage();
        //loginPage.permissions();

        FlutterElement txt_username = finder.byValueKey("txt_username");
        FlutterElement txt_password = finder.byValueKey("txt_password");
        FlutterElement button_login = finder.byValueKey("button_login");


        /*txt_username.sendKeys("user@yopmailcom");
        txt_password.sendKeys("123456");
        button_login.click();*/

        FlutterElement signInButton = finder.byValueKey("sign_in");
        FlutterElement signInSSOButton = finder.byValueKey("sign_in_sso");
        FlutterElement signInEmailInput = finder.byValueKey("email_or_domain_input");
        FlutterElement submitEmailButton = finder.byValueKey("submit_email"); //continue
        FlutterElement submitDomainSSOButton = finder.byValueKey("submit_domain"); //continue
        FlutterElement signInPasswordInput = finder.byValueKey("password_input");
        FlutterElement signInSubmitButton = finder.byValueKey("sign_in_submit");
        FlutterElement showPassword = finder.byValueKey("show_pass");
        FlutterElement forgotPassword = finder.byValueKey("forgot_password");
        System.out.print("Hello:"+signInButton);
        /*signInButton.click();
        signInEmailInput.sendKeys("sprint@clrmail.com");
        submitEmailButton.click();
        signInPasswordInput.sendKeys("Test@123");
        signInSubmitButton.click();*/
        Thread.sleep(5000);
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
