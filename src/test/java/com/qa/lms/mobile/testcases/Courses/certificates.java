package com.qa.lms.mobile.testcases.Courses;

import com.qa.lms.mobile.BaseTest;
import com.qa.lms.mobile.pages.LoginPage;
import com.qa.lms.mobile.utils.JsonParser;
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80760");
            loginPage.viewSpecificCourse("Course 80760");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
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
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 81218");
            loginPage.viewSpecificCourse("Course 81218");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
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
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.viewSpecificCourse("Course 81218");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 81218");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/81218
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 81218

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to see Certificate in Course details screen ")
    public void validateCertificateInCourseDetails(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 80770
            lessons: 2
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80770");
            loginPage.viewSpecificCourse("Course 80770");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
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
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.viewSpecificCourse("Course 80770");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80770");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80770
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80770

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to see Certificate Tab in Course details screen during enrollment")
    public void validateCertificateTabWhileEnrolling(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 80771
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80771");
            loginPage.viewSpecificCourse("Course 80771");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
            loginPage.clickEnrollNow();
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80771");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80771
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80771

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to see all the information in the certificate as per admin's configuration")
    public void validateInformationOnCertificate(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 80772
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80772");
            loginPage.viewSpecificCourse("Course 80772");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
            loginPage.clickEnrollNow();
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
            loginPage.clickStartCourse();
            loginPage.clickCompleteButton();
            if(!platformName.equals("iOS")) {
                loginPage.clickViewCertificate();
                /****/ // validate data on certificate
                loginPage.pressBackButtonFromMobile();
            }
            loginPage.clickBackButtonOnViewCertificatePage();
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80772");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80772
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80772

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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80773");
            loginPage.viewSpecificCourse("Course 80773");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.selectOption("a");
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
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.viewSpecificCourse("Course 80773");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80777");
            loginPage.viewSpecificCourse("Course 80777");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.selectOption("b");
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
            loginPage.selectOption("a");
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
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.viewSpecificCourse("Course 80777");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80777");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/80777
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
            lessons: 2
            certificate: yes
            assessment: yes(optional)
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80778");
            loginPage.viewSpecificCourse("Course 80778");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
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
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.viewSpecificCourse("Course 80778");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
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
            lessons: 2
            certificate: yes
            assessment: yes(optional)
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80779");
            loginPage.viewSpecificCourse("Course 80779");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.selectOption("b");
            loginPage.clickCompleteAssessment();
            Assert.assertFalse(loginPage.validateAssessmentStatus());
            loginPage.clickAssessmentSummary();
            loginPage.clickBackButtonOnAssessmentSummaryPage();
            loginPage.clickProceed();
            loginPage.scroll();
            loginPage.viewSpecificCourse("Course 80779");
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
            /****/ // View Certificate
            loginPage.clickBackButtonOnCourseDetailsPage();
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 80780");
            loginPage.viewSpecificCourse("Course 80780");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
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
                loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
                loginPage.clickContinue();
                loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
                loginPage.clickContinue();
                loginPage.scroll();
                loginPage.viewSpecificCourse("Course 80780");
            }
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
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

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see all the information in the certificate under My certificate")
    public void validateInfoInMyCertificates(String platformName) throws  Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            // https://auzmorhr.testrail.io/index.php?/cases/view/80783
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80783

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see all the Certificate in My certificate and download it")
    public void downloadFromMyCertificates(String platformName) throws  Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            // https://auzmorhr.testrail.io/index.php?/cases/view/80784
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 80784

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see all the Certificate under My certificate in sorted order")
    public void myCertificatesInSortedOrder(String platformName) throws  Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            // https://auzmorhr.testrail.io/index.php?/cases/view/82525
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 82525

    @Parameters({"platformName"})
    @Test
    @Description("Learner - Able to see the certificate even the user kills the application in the certificate screen ")
    public void killTheAppAfterCourseCompletion(String platformName) throws  Exception {
        /*
        Requirements:
            Requirements:
            Name: Course 81217
            lessons: 1
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
            loginPage.enterLoginEmail(platformName, loginData.get("learner2").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 81217");
            loginPage.viewSpecificCourse("Course 81217");
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertFalse(loginPage.isCertificateAvailable());
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickCompleteButton();
            loginPage.terminateApp(platformName);
            launchApp();
            if(platformName.equals("iOS")) {
                loginPage.iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner2").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.scroll();
            loginPage.viewSpecificCourse("Course 81217");
            Assert.assertTrue(loginPage.isCompletedButtonPresent());
            Assert.assertTrue(loginPage.isCertificateTabPresent());
            Assert.assertTrue(loginPage.isCertificateAvailable());
            loginPage.clickBackButtonOnCourseDetailsPage();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 81217");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/81217
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 81217

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to see all the preview information under My certificate ")
    public void previewMyCertificates(String platformName) throws  Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            // https://auzmorhr.testrail.io/index.php?/cases/view/81213
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 81213

    @Parameters({"platformName"})
    @Test(enabled = false)
    @Description("Learner - Able to view the certificate gained from Web/Mobile browser")
    public void validateCertificateGainedOnBrowser(String platformName) throws  Exception {
        /*
        Requirements:
            Learner should have earned some Certificates
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail(platformName, loginData.get("learner").toString());
            loginPage.clickContinue();
            loginPage.enterLoginPassword(platformName, loginData.get("password").toString());
            loginPage.clickContinue();
            loginPage.clickProfileTab();
            loginPage.viewMyCertificates();
            loginPage.clickOnFirstCertificate();
            /****/
            // https://auzmorhr.testrail.io/index.php?/cases/view/82966
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 82966
}
