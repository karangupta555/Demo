package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.utils.StringParser;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.InputStream;

public class Demo extends BaseTest {

    @Parameters({"envID"})
    @BeforeClass
    /****/ // beforeClass, beforeMethod in other files
    public void beforeClass(String envID) throws Exception {
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

    @Test
    public void successfulLogin() throws Exception {
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
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("sprint@clrmail.com");
        loginPage.clickContinue();
        loginPage.enterLoginPassword("Test@123");
        loginPage.clickShowPasswordButton();
        loginPage.clickHidePasswordButton();
        loginPage.clickForgotPassword();
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
