package com.qa.tests.Courses;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class certificates extends BaseTest {

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
            loginPage.enterLoginEmail("auzmor@zetmail.com");
            loginPage.clickContinue();
            loginPage.enterLoginPassword("Test@123");
            loginPage.clickShowPasswordButton();
            loginPage.clickHidePasswordButton();
            loginPage.clickForgotPassword();
            loginPage.clickContinue();
            Thread.sleep(5000);
            loginPage.clickSearchTab();
            Thread.sleep(5000);
            loginPage.searchCourse("Course 80760");
            loginPage.viewSpecificCourse("Course 80760");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickNextLesson();
            loginPage.clickCompleteButton();
            loginPage.clickBackToCoursesButton();
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
                loginPage.iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail("auzmor@zetmail.com");
            loginPage.clickContinue();
            loginPage.enterLoginPassword("Test@123");
            loginPage.clickShowPasswordButton();
            loginPage.clickHidePasswordButton();
            loginPage.clickForgotPassword();
            loginPage.clickContinue();
            Thread.sleep(5000);
            loginPage.clickSearchTab();
            Thread.sleep(5000);
            loginPage.searchCourse("Course 81218");
            loginPage.viewSpecificCourse("Course 81218");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickNextLesson();
            loginPage.clickNextLesson();
            loginPage.clickCompleteButton();
            loginPage.clickBackToCoursesButton();
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
                loginPage.iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail("auzmor@zetmail.com");
            loginPage.clickContinue();
            loginPage.enterLoginPassword("Test@123");
            loginPage.clickShowPasswordButton();
            loginPage.clickHidePasswordButton();
            loginPage.clickForgotPassword();
            loginPage.clickContinue();
            Thread.sleep(5000);
            loginPage.clickSearchTab();
            Thread.sleep(5000);
            loginPage.searchCourse("Course 80773");
            loginPage.viewSpecificCourse("Course 80773");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.answerSingleChoiceQuestion("a");
            loginPage.clickCompleteAssessment();
            loginPage.clickProceed();
            loginPage.clickViewCertificate();
            loginPage.pressBackButtonFromMobile();
            loginPage.clickBackToCoursesButton();
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
                loginPage.iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail("auzmor@zetmail.com");
            loginPage.clickContinue();
            loginPage.enterLoginPassword("Test@123");
            loginPage.clickShowPasswordButton();
            loginPage.clickHidePasswordButton();
            loginPage.clickForgotPassword();
            loginPage.clickContinue();
            Thread.sleep(5000);
            loginPage.clickSearchTab();
            Thread.sleep(5000);
            loginPage.searchCourse("Course 80777");
            loginPage.viewSpecificCourse("Course 80777");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickTakeAssessment();
            loginPage.clickTakeAssessment();
            loginPage.answerSingleChoiceQuestion("b"); // Correct Answer: 'a'
            loginPage.clickCompleteAssessment();
            loginPage.clickProceed();
            loginPage.clickViewCertificate();
            loginPage.pressBackButtonFromMobile();
            loginPage.clickBackToCoursesButton();
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
    @Description("Learner - Able to complete the course with admin evaluated assessment and with certificate")
    public void adminEvaluatedAssessmentWithCertificate(String platformName) throws  Exception {
        /*
        Requirements:
            Name: Course 81188
            lessons: 1
            certificate: yes
            assessment: yes(admin evaluation)
            access: public
        */
        try {
            LoginPage loginPage = new LoginPage();
            if(platformName.equals("iOS")) {
                loginPage.iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail("auzmor@zetmail.com");
            loginPage.clickContinue();
            loginPage.enterLoginPassword("Test@123");
            loginPage.clickShowPasswordButton();
            loginPage.clickHidePasswordButton();
            loginPage.clickForgotPassword();
            loginPage.clickContinue();
            Thread.sleep(5000);
            loginPage.clickSearchTab();
            Thread.sleep(5000);
            loginPage.searchCourse("Course 81188");
            loginPage.viewSpecificCourse("Course 81188");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickCompleteButton();
            loginPage.clickBackToCoursesButton();
            loginPage.clickSearchTab();
            loginPage.searchCourse("Course 81188");
            Assert.assertTrue(loginPage.isNoResultFound());
            // https://auzmorhr.testrail.io/index.php?/cases/view/81188
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }// 81188

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
                loginPage.iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail("auzmor@zetmail.com");
            loginPage.clickContinue();
            loginPage.enterLoginPassword("Test@123");
            loginPage.clickShowPasswordButton();
            loginPage.clickHidePasswordButton();
            loginPage.clickForgotPassword();
            loginPage.clickContinue();
            Thread.sleep(5000);
            loginPage.clickSearchTab();
            Thread.sleep(5000);
            loginPage.searchCourse("Course 80778");
            loginPage.viewSpecificCourse("Course 80778");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickCompleteButton();
            loginPage.clickBackToCoursesButton();
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
                loginPage.iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail("auzmor@zetmail.com");
            loginPage.clickContinue();
            loginPage.enterLoginPassword("Test@123");
            loginPage.clickShowPasswordButton();
            loginPage.clickHidePasswordButton();
            loginPage.clickForgotPassword();
            loginPage.clickContinue();
            Thread.sleep(5000);
            loginPage.clickSearchTab();
            Thread.sleep(5000);
            loginPage.searchCourse("Course 80779");
            loginPage.viewSpecificCourse("Course 80779");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickCompleteButton();
            loginPage.clickBackToCoursesButton();
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
                loginPage.iOSPermissions();
            }
            loginPage.clickSignInBtn();
            loginPage.enterLoginEmail("auzmor@zetmail.com");
            loginPage.clickContinue();
            loginPage.enterLoginPassword("Test@123");
            loginPage.clickShowPasswordButton();
            loginPage.clickHidePasswordButton();
            loginPage.clickForgotPassword();
            loginPage.clickContinue();
            Thread.sleep(5000);
            loginPage.clickSearchTab();
            Thread.sleep(5000);
            loginPage.searchCourse("Course 80780");
            loginPage.viewSpecificCourse("Course 80780");
            loginPage.clickEnrollNow();
            loginPage.clickStartCourse();
            loginPage.clickCompleteButton();
            loginPage.clickBackToCoursesButton();
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
