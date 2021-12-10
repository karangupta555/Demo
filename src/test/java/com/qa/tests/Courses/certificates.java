package com.qa.tests.Courses;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.utils.JsonParser;
import org.json.JSONObject;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class certificates extends BaseTest {
    JSONObject loginData = JsonParser.getLoginData();
    JSONObject testData = JsonParser.getTestData();

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to complete the course without assessment and with certificate")
    public void completeCourseWithCertificateWithoutAssessment(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 80760
            lessons: 3
            certificate: yes
            assessment: no
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                loginPage.iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner1").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80760");
            loginPage.viewSpecificCourse("Course 80760");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickNextLesson();
            loginPage.clickCompleteButton();
            if(!platformName.equals("iOS")) {
                loginPage.clickViewCertificate();
                loginPage.pressBackButtonFromMobile();
            }
            loginPage.clickBackButtonOnViewCertificatePage();
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80760");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80760
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80760

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to complete the course without assessment and with certificate and download the certificate")
    public void completeCourseWithCertificateAndDownload(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 81218
            lessons: 3
            certificate: yes
            assessment: no
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner1").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 81218");
            loginPage.viewSpecificCourse("Course 81218");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickNextLesson();
            loginPage.clickCompleteButton();
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.clickBackButtonOnViewCertificatePage();
            }
            else {
                launchApp();
                iOSPermissions();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("learner1").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.viewSpecificCourse("Course 81218");
                loginPage.clickCompletedButton();
                loginPage.clickNextLesson();
                loginPage.clickNextLesson();
                loginPage.clickCompleteButton();
                loginPage.clickViewCertificate();
                loginPage.clickDownloadButton();
                loginPage.clickBackToCourseButton();
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 81218");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80760
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 81218

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to complete the course with mandatory assessment and with certificate")
    public void completeCourseWithCertificateAndAssessment(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 80773
            lessons: 2
            certificate: yes
            assessment: yes
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80773");
            loginPage.viewSpecificCourse("Course 80773");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.answerSingleChoiceQuestion("a");
            loginPage.clickCompleteAssessment();
            loginPage.clickAssessmentSummary();
            loginPage.clickBackButtonOnAssessmentSummaryPage();
            loginPage.clickProceed();
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.clickBackButtonOnViewCertificatePage();
            }
            else {
                launchApp();
                iOSPermissions();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.viewSpecificCourse("Course 80773");
                loginPage.clickCompletedButton();
                loginPage.clickNextLesson();
                loginPage.clickNextLesson();
                loginPage.clickCompleteButton();
                loginPage.clickViewCertificate();
                loginPage.clickDownloadButton();
                loginPage.clickBackToCourseButton();
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80773");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80773
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80773

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to Fail in the course with mandatory assessment and with certificate")
    public void failMandatoryAssessmentWithCertificate(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 80777
            lessons: 1
            certificate: yes
            assessment: no
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80777");
            loginPage.viewSpecificCourse("Course 80777");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.answerSingleChoiceQuestion("b");
            loginPage.clickCompleteAssessment();
            Assert.assertFalse(loginPage.validateAssessmentStatus());
            loginPage.clickAssessmentSummary();
            loginPage.clickBackButtonOnAssessmentSummaryPage();
            loginPage.clickProceed();
            loginPage.viewSpecificCourse("Course 80777");
            loginPage.clickResumeButton();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.answerSingleChoiceQuestion("a");
            loginPage.clickCompleteAssessment();
            Assert.assertTrue(loginPage.validateAssessmentStatus());
            loginPage.clickAssessmentSummary();
            loginPage.clickBackButtonOnAssessmentSummaryPage();
            loginPage.clickProceed();
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.clickBackButtonOnViewCertificatePage();
            }
            else {
                launchApp();
                iOSPermissions();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.clickCompletedButton();
                loginPage.clickNextLesson();
                loginPage.clickNextLesson();
                loginPage.clickCompleteButton();
                loginPage.clickViewCertificate();
                loginPage.clickDownloadButton();
                loginPage.clickBackToCourseButton();
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80777");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80773
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80777

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to complete the course with optional assessment and with certificate")
    public void optionalAssessmentWithCertificate(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 80778
            lessons: 1
            certificate: yes
            assessment: yes(admin evaluation)
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80778");
            loginPage.viewSpecificCourse("Course 80778");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickSkipAssessment();
            loginPage.clickBackButton();
            loginPage.clickSkipAssessment();
            loginPage.clickSkipButton();
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.clickBackButtonOnViewCertificatePage();
            }
            else {
                launchApp();
                iOSPermissions();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.clickCompletedButton();
                loginPage.clickNextLesson();
                loginPage.clickNextLesson();
                loginPage.clickCompleteButton();
                loginPage.clickViewCertificate();
                loginPage.clickDownloadButton();
                loginPage.clickBackToCourseButton();
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80778");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80778
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80778

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to Fail in the course with optional assessment and with certificate")
    public void failOptionalAssessmentWithCertificate(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 80779
            lessons: 1
            certificate: yes
            assessment: yes(admin evaluation)
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80779");
            loginPage.viewSpecificCourse("Course 80779");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.answerSingleChoiceQuestion("b");
            loginPage.clickCompleteAssessment();
            Assert.assertFalse(loginPage.validateAssessmentStatus());
            loginPage.clickAssessmentSummary();
            loginPage.clickBackButtonOnAssessmentSummaryPage();
            loginPage.clickProceed();
            /****/
            // Bug/Active Thread
            /*
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.clickBackButtonOnViewCertificatePage();
            }
            else {
                launchApp();
                iOSPermissions();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.clickCompletedButton();
                loginPage.clickNextLesson();
                loginPage.clickNextLesson();
                loginPage.clickCompleteButton();
                loginPage.clickViewCertificate();
                loginPage.clickDownloadButton();
                loginPage.clickBackToCourseButton();
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            loginPage.clickBackButtonOnCourseDetailsPage();
            */
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80779");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80779
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80779

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to skip the assessment and get certificate")
    public void skipAssessmentWithCertificate(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 80780
            lessons: 1
            certificate: yes
            assessment: yes(admin evaluation)
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80780");
            loginPage.viewSpecificCourse("Course 80780");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickSkipAssessment();
            loginPage.clickBackButton();
            loginPage.clickSkipAssessment();
            loginPage.clickSkipButton();
            loginPage.clickViewCertificate();
            if(!platformName.equals("iOS")) {
                loginPage.downloadCertificateImage();
                loginPage.downloadCertificateImage();/****/
                loginPage.downloadCertificatePDF();
                loginPage.downloadCertificatePDF();
                loginPage.pressBackButtonFromMobile();
                loginPage.clickBackButtonOnViewCertificatePage();
            }
            else {
                launchApp();
                iOSPermissions();
                loginPage.clickSignInBtn();
                loginPage.enterLoginEmail(platformName, loginData.get("padmin").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.clickCompletedButton();
                loginPage.clickNextLesson();
                loginPage.clickNextLesson();
                loginPage.clickCompleteButton();
                loginPage.clickViewCertificate();
                loginPage.clickDownloadButton();
                loginPage.clickBackToCourseButton();
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80780");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80780
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80780
}
