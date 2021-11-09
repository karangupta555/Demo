package com.qa.tests;

import com.aventstack.extentreports.Status;
import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.reports.ExtentReport;
import com.qa.utils.StringParser;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.InputStream;

import static org.testng.AssertJUnit.assertEquals;

public class Demo extends BaseTest {
     @Parameters({"envID"})
      @BeforeClass
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

    @Test(enabled = false)
    public void debug() throws Exception {
        LoginPage loginPage = new LoginPage();
        Thread.sleep(3000);
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("sprint@clrmail.com");
        loginPage.clickContinue();
        loginPage.enterLoginPassword("Test@123");
        loginPage.clickContinue();
        Thread.sleep(3000);
    }

    @Test
    public void test() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("sprint@clrmail.com");
        loginPage.clickContinue();
        loginPage.enterLoginPassword("Test@123");
        loginPage.clickShowPasswordButton();
        loginPage.clickHidePasswordButton();
        loginPage.clickForgotPassword();
        loginPage.clickContinue();
        Thread.sleep(5000);
        loginPage.clickNotificationTab();
        loginPage.validateNotificationTab();
        loginPage.clickMarkAllReadNotifications();
        loginPage.clickSearchTab();
        loginPage.searchCourse("Class1");
        loginPage.viewSpecificCourse("Class1");
        loginPage.clickEnrollNow();
        loginPage.clickStartCourse();
        loginPage.clickNextLesson();
        loginPage.clickTakeAssessment();
        loginPage.clickTakeAssessment();
        loginPage.answerSingleChoiceQuestion();
        loginPage.clickCompleteAssessment();
        loginPage.clickProceed();
        loginPage.clickSearchTab();
        loginPage.searchCourse("Class1");
        Assert.assertTrue(loginPage.isNoResultFound());
        loginPage.clickHomeTab();
        loginPage.clickSearchTab();
        loginPage.searchCourse("Class2");
        loginPage.viewSpecificCourse("Class2");
        loginPage.clickEnrollNow();
        loginPage.clickStartCourse();
        loginPage.clickTakeAssessment();
        loginPage.clickTakeAssessment();
        loginPage.answerSingleChoiceQuestion();
        loginPage.clickCompleteAssessment();
        loginPage.clickProceed();
        loginPage.clickViewCertificate();
        getDriver().navigate().back();
        System.out.println("Pressed Back Button from Mobile");
        Thread.sleep(5000);
        loginPage.clickBackButton();
        Assert.assertTrue(loginPage.isCompletedButtonPresent());
        loginPage.clickBackButton();
        loginPage.clickSearchTab();
        loginPage.searchCourse("Class2");
        Assert.assertTrue(loginPage.isNoResultFound());
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
