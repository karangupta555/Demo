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
    public void android() throws  Exception{
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("auzmor@zetmail.com");
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
        Thread.sleep(5000);
        loginPage.clickSearchTab();
        Thread.sleep(5000);
        loginPage.searchCourse("Class1");
        loginPage.viewSpecificCourse("Class1");
        loginPage.clickEnrollNow();
        loginPage.clickStartCourse();
        loginPage.clickNextLesson();
        loginPage.clickTakeAssessment();
        loginPage.clickTakeAssessment();
        loginPage.answerSingleChoiceQuestion("a");
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
        loginPage.answerSingleChoiceQuestion("a");
        loginPage.clickCompleteAssessment();
        loginPage.clickProceed();
        loginPage.clickViewCertificate();
        loginPage.pressBackButtonFromMobile();
        Thread.sleep(5000);
        loginPage.clickBackButtonOnViewCertificatePage();
        Assert.assertTrue(loginPage.isCompletedButtonPresent());
        loginPage.clickBackButtonOnCourseDetailsPage();
        loginPage.clickSearchTab();
        loginPage.searchCourse("Class2");
        Assert.assertTrue(loginPage.isNoResultFound());
    }

    @Test(enabled = false)
    public void ios() throws  Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.iOSPermissions();
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("auzmor@zetmail.com");
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
        Thread.sleep(5000);
        loginPage.clickSearchTab();
        Thread.sleep(5000);
        loginPage.searchCourse("Class1");
        loginPage.viewSpecificCourse("Class1");
        loginPage.clickEnrollNow();
        loginPage.clickStartCourse();
        loginPage.clickNextLesson();
        loginPage.clickTakeAssessment();
        loginPage.clickTakeAssessment();
        loginPage.answerSingleChoiceQuestion("a");
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
        loginPage.answerSingleChoiceQuestion("a");
        loginPage.clickCompleteAssessment();
        loginPage.clickProceed();
        System.out.println("Current Context: "+ getDriver().getContext());
        loginPage.clickViewCertificate();
        //Set<String> contextNames = getDriver().getContextHandles();
        //getDriver().context((String)contextNames.toArray()[0]);
        getDriver().context("NATIVE_APP");
        loginPage.clickGoBackButton();
        Thread.sleep(5000);
        getDriver().launchApp();
        loginPage.iOSPermissions();
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("cane@zetmail.com");
        loginPage.clickContinue();
        loginPage.enterLoginPassword("Test@123");
        loginPage.clickShowPasswordButton();
        loginPage.clickHidePasswordButton();
        loginPage.clickForgotPassword();
        loginPage.clickContinue();
        Thread.sleep(5000);
        loginPage.clickSearchTab();
        loginPage.searchCourse("Class2");
        Assert.assertTrue(loginPage.isNoResultFound());
    }

    @Test(enabled = true)
    public void debugMethod() throws  Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.iOSPermissions();
        loginPage.clickSignInBtn();
        loginPage.enterLoginEmail("auzmor@zetmail.com");
        loginPage.clickContinue();
        loginPage.enterLoginPassword("Test@123");
        loginPage.clickContinue();
        Thread.sleep(5000);
        loginPage.clickSearchTab();
        loginPage.searchCourse("touch");
        loginPage.viewSpecificCourse("touch");
        Thread.sleep(3000);
        loginPage.bedug();
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
