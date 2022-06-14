package com.qa.lms.mobile.testcases.Notifications;


import com.qa.lms.mobile.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class course extends BaseTest {

    @Parameters({"platformName"})
    @Test(enabled = true)
    public void courseWAAC(String platformName) throws Exception{ //Course With Assessment and Certificate
        page page = new page();
        page.clickSkipButton();
        page.clickSignInButton();
        page.enterLoginEmail("","mobile-prod@getnada.com");
        page.clickContinueButton();
        page.enterLoginPassword("","Mobile@123");
        page.clickShowPasswordButton();
        page.clickHidePasswordButton();
        page.clickContinueButton();
        Thread.sleep(6000);
        page.clickSearchTab();
        page.searchCourse("","Copy of WAAC3");   //course Name
        page.viewSpecificCourse("Copy of WAAC3");    //course Name
        Assert.assertTrue(page.isAssessmentPresent());
        Assert.assertTrue(page.isCertificateTabPresent());
        page.clickEnrollNow();
        page.clickStartCourse();
        page.clickNextLesson();
        page.clickTakeAssessment();
        page.clickTakeAssessment();
        page.selectOption("a");     //select option
        page.clickCompleteAssessment();
        Thread.sleep(1500);
        //page.clickSubmitButton();
        page.clickAssessmentSummary();
        page.navigateBack();
        page.clickProceed();
        page.clickViewCertificate();
        Thread.sleep(5000);
        //page.clickGoBackButton();
        page.closeTab();
        page.navigateBack();
        Assert.assertTrue(page.isCourseCompleted());
        page.navigateBack();
    }

    @Parameters({"platformName"})
    @Test(enabled = true)
    public void courseWC(String platformName) throws Exception{ //Course With Certificate
        page page = new page();
        page.clickSkipButton();
        page.clickSignInButton();
        page.enterLoginEmail("","mobile-prod@getnada.com");
        page.clickContinueButton();
        page.enterLoginPassword("","Mobile@123");
        page.clickShowPasswordButton();
        page.clickHidePasswordButton();
        page.clickContinueButton();
        Thread.sleep(6000);
        page.clickSearchTab();
        Thread.sleep(1500);
        page.searchCourse("","Copy of WC");   //course Name
        page.viewSpecificCourse("Copy of WC");    //course Name
        Assert.assertTrue(page.isCertificateTabPresent());
        Assert.assertFalse(page.isAssessmentPresent());
        page.clickEnrollNow();
        page.clickStartCourse();
        page.clickNextLesson();
        page.clickCompleteLesson();
        Thread.sleep(1500);
        page.clickViewCertificate();
        Thread.sleep(5000);
        //page.clickGoBackButton();
        page.closeTab();
        page.navigateBack();
        Assert.assertTrue(page.isCourseCompleted());
        page.navigateBack();
    }

    @Parameters({"platformName"})
    @Test(enabled = true)
    public void courseWA(String platformName) throws Exception{ //Course With Assessment
        page page = new page();
        page.clickSkipButton();
        page.clickSignInButton();
        page.enterLoginEmail("","mobile-prod@getnada.com");
        page.clickContinueButton();
        page.enterLoginPassword("","Mobile@123");
        page.clickShowPasswordButton();
        page.clickHidePasswordButton();
        page.clickContinueButton();
        Thread.sleep(6000);
        page.clickSearchTab();
        page.searchCourse("","Copy of WA");   //course Name
        Thread.sleep(3000);
        page.viewSpecificCourse("Copy of WA");    //course Name
        Assert.assertTrue(page.isAssessmentPresent());
        page.clickEnrollNow();
        page.clickStartCourse();
        page.clickNextLesson();
        page.clickTakeAssessment();
        page.clickTakeAssessment();
        Thread.sleep(1500);
        page.selectOption("a");     //select option
        page.clickCompleteAssessment();
        //page.clickSubmitButton();
        page.clickAssessmentSummary();
        page.navigateBack();
        page.clickProceed();
        Thread.sleep(6000);
        page.scrollDown();
        page.scrollRight();
        page.clickViewAll();
        page.completedSearchCourse("","Copy of WA");
        page.viewSpecificCourse("Copy of WA");
        Assert.assertTrue(page.isCourseCompleted());
        page.navigateBack();
    }

}
