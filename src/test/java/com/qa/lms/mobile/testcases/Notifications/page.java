package com.qa.lms.mobile.testcases.Notifications;


import com.aventstack.extentreports.Status;
import com.qa.lms.mobile.BaseTest;

import com.qa.lms.mobile.pages.LoginPage;
import com.qa.lms.mobile.reports.ExtentReport;
import com.qa.lms.mobile.utils.TestUtils;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class page extends BaseTest {
    TestUtils utils = new TestUtils();
    WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
    Actions actionsObject;


    public page clickSkipButton() throws Exception {
        try {
            wait.until(visibilityOfElementLocated(MobileBy.AccessibilityId("Skip")));
            wait.until(elementToBeClickable(MobileBy.AccessibilityId("Skip"))).click();
            utils.log().info("Clicked on Skip Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Skip Button");
            throw new Exception("Error: Unable to Click on Skip Button");
        }
        return this;
    }

    public page clickSignInButton() throws Exception{
        try {
            Thread.sleep(1000);
            wait.until(visibilityOfElementLocated(MobileBy.AccessibilityId("Sign In")));
            wait.until(elementToBeClickable(MobileBy.AccessibilityId("Sign In"))).click();
            utils.log().info("Clicked SignIn Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked SignIn Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click SignIn Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click SignIn Button");
            throw new Exception("Error: Unable to Click SignIn Button");
        }
        return this;
    }

    public page enterLoginEmail(String platformName, String username) throws Exception {
        By inputField;
        try {
            if(platformName.equals("iOS")) {
                inputField = By.className("XCUIElementTypeTextField");
            } else {
                inputField = By.className("android.widget.EditText");
            }
            getDriver().findElement(inputField).click();
            getDriver().findElement(inputField).clear(); //prefilled text - saved login details
            getDriver().getKeyboard().sendKeys(username);
            utils.log().info("Entered userName/Email: '" + username + "'");
            ExtentReport.getTest().log(Status.INFO, "Entered userName/Email: " + username + "'");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to enter login email");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to enter login email");
            throw new Exception("Error: Unable to enter login email");
        }
        return this;
    }

    public page clickContinueButton() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("Continue").click();
            utils.log().info("Clicked Continue Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Continue Button");
            throw new Exception("Error: Unable to Click on Continue Button");
        }
        return this;
    }

    public page enterLoginPassword(String platformName, String password) throws Exception {
        try {
//            getDriver().findElement(By.className("android.widget.EditText")).sendKeys(password);
            actionsObject = new Actions(getDriver());
            actionsObject.sendKeys(password);
            actionsObject.perform();
            utils.log().info("Entered Password: " + password + "'");
            ExtentReport.getTest().log(Status.INFO, "Entered Password: " + password + "'");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to enter login password");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to enter login password");
            throw new Exception("Error: Unable to enter login password");
        }
        return this;
    }


    public page clickShowPasswordButton() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("Show").click();
            utils.log().info("Clicked Show Password Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked Show Password Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Show Password Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Show Password Button");
            throw new Exception("Error: Unable to Click on Show Password Button");
        }
        return this;
    }

    public page clickHidePasswordButton() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("Hide").click();
            utils.log().info("Clicked Hide Password Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked Hide Password Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Hide Password Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Hide Password Button");
            throw new Exception("Error: Unable to Click on Hide Password Button");
        }
        return this;
    }

    public page clickSearchTab() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("search-tab").click();
            utils.log().info("Clicked on Search/Explore Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Search/Explore Tab");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click Search/Explore Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click Search/Explore Tab");
            throw new Exception("Error: Unable to Click Search/Explore Tab");
        }
        return this;
    }

    public page searchCourse(String platformName, String courseName) throws Exception {
        Thread.sleep(1000);
        By searchTextBox;
        try {
            if(platformName.equals("iOS")) {
                searchTextBox = By.xpath("(//XCUIElementTypeTextField)[1]");
            } else {
                searchTextBox = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView");
            }
            getDriver().findElement(searchTextBox).click();
            getDriver().findElement(searchTextBox).clear();
            getDriver().getKeyboard().sendKeys(courseName);
            ExtentReport.getTest().log(Status.INFO, "Searched Course: '" + courseName + "'");
            getDriver().hideKeyboard();
            utils.log().info("Closed keyboard!");
            ExtentReport.getTest().log(Status.INFO, "Closed keyboard!");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Searching Course Failed!");
            ExtentReport.getTest().log(Status.INFO, "Error: Searching Course Failed!");
            throw new Exception("Error: Searching Course Failed!");
        }
        return this;
    }

    public page completedSearchCourse(String platformName, String courseName) throws Exception {
        Thread.sleep(1000);
        By searchTextBox;
        try {
            if(platformName.equals("iOS")) {
                searchTextBox = By.xpath("(//XCUIElementTypeTextField)[1]");
            } else {
                searchTextBox = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView");
            }
            getDriver().findElement(searchTextBox).click();
            getDriver().findElement(searchTextBox).clear();
            getDriver().getKeyboard().sendKeys(courseName);
            getDriver().hideKeyboard();
            utils.log().info("Closed keyboard!");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Searching Course Failed!");
            throw new Exception("Error: Searching Course Failed!");
        }
        return this;
    }

    public page viewSpecificCourse(String courseName) throws Exception {
        try {
            getDriver().findElementByAccessibilityId(courseName).click();
            utils.log().info("Clicked on '" + courseName + "' Course");
            ExtentReport.getTest().log(Status.INFO, "Clicked on '" + courseName + "' Course");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on '" + courseName + "' Course");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on '" + courseName + "' Course");
            throw new Exception("Error: Unable to Click on '" + courseName + "' Course");
        }
        return this;
    }

    public page clickEnrollNow() throws Exception {
        try {
            wait.until(visibilityOfElementLocated(MobileBy.AccessibilityId("Enroll Now")));
            wait.until(elementToBeClickable(MobileBy.AccessibilityId("Enroll Now"))).click();
            utils.log().info("Clicked on Enroll Now Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Enroll Now Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Enroll Now Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Enroll Now Button");
            throw new Exception("Error: Unable to Click on Enroll Now Button");
        }
        return this;
    }

    public page clickStartCourse() throws Exception {
        try {
            wait.until(visibilityOfElementLocated(MobileBy.AccessibilityId("Start Course")));
            wait.until(elementToBeClickable(MobileBy.AccessibilityId("Start Course"))).click();
            utils.log().info("Clicked on Start Course Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Start Course Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Start Course Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Start Course Button");
            throw new Exception("Error: Unable to Click on Start Course Button");
        }
        return this;
    }

    public page clickNextLesson() throws Exception {
        try {
            Thread.sleep(1500);
            wait.until(visibilityOfElementLocated(MobileBy.AccessibilityId("Next lesson")));
            wait.until(elementToBeClickable(MobileBy.AccessibilityId("Next lesson"))).click();
            utils.log().info("Clicked on Next Lesson Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Next Lesson Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Next Lesson Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Next Lesson Button");
            throw new Exception("Error: Unable to Click on Next Lesson Button");
        }
        return this;
    }

    public page clickTakeAssessment() throws Exception {
        try {
            Thread.sleep(1500);
            getDriver().findElementByAccessibilityId("Take Assessment").click();
            utils.log().info("Clicked on Take Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Take Assessment Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Take Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Take Assessment Button");
            throw new Exception("Error: Unable to Click on Take Assessment Button");
        }
        return this;
    }

    public page selectOption(String option) throws Exception {
        try {
            getDriver().findElementByAccessibilityId(option).click();
            utils.log().info("Selected Option '" + option + "'");
            ExtentReport.getTest().log(Status.INFO, "Selected Option '" + option + "'");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click/select Option '" + option + "'");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click/select Option '" + option + "'");
            throw new Exception("Error: Unable to click/select Option '" + option + "'");
        }
        return this;
    }

    public page clickCompleteAssessment() throws Exception {
        try {
            Thread.sleep(1500);
            getDriver().findElementByAccessibilityId("Complete Assessment").click();
            utils.log().info("Clicked on Complete Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Complete Assessment Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Complete Assessment Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Complete Assessment Button");
            throw new Exception("Error: Unable to click Complete Assessment Button");
        }
        return this;
    }

    public page clickViewAll() throws Exception {
        try {
            Thread.sleep(1500);
            getDriver().findElementByAccessibilityId("View All").click();
            utils.log().info("Clicked on View All Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click View All Button");
            throw new Exception("Error: Unable to click View All Button");
        }
        return this;
    }


    public page clickCompleteLesson() throws Exception {
        try {
            Thread.sleep(1500);
            getDriver().findElementByAccessibilityId("Complete Lesson").click();
            utils.log().info("Clicked on Complete Lesson Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Complete Lesson Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Complete Lesson Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Complete Lesson Button");
            throw new Exception("Error: Unable to click Complete Lesson Button");
        }
        return this;
    }

    public page clickSubmitButton() throws Exception{
        try {
            Thread.sleep(1500);
            getDriver().findElementByAccessibilityId("Submit").click();
            utils.log().info("Clicked on Submit Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Submit Button");
            throw new Exception("Error: Unable to click Submit Button");
        }
        return this;
    }

    public page clickAssessmentSummary() throws Exception {
        try {
            // click(assessmentSummaryButton);
            getDriver().findElementByAccessibilityId("Assessment summary").click();
            utils.log().info("Clicked on Assessment Summary Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Assessment Summary Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Assessment Summary Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Assessment Summary Button");
            throw new Exception("Error: Unable to click Assessment Summary Button");
        }
        return this;
    }

    public page navigateBack() throws Exception {
        try {
            wait.until(visibilityOfElementLocated(MobileBy.AccessibilityId("back")));
            wait.until(elementToBeClickable(MobileBy.AccessibilityId("back"))).click();
            utils.log().info("Clicked on Back Button Arrow");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Back Button Arrow");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Back Button Arrow");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Back Button Arrow");
            throw new Exception("Error: Unable to Click on Back Button Arrow");
        }
        return this;
    }

    public page clickProceed() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("Proceed").click();
            utils.log().info("Clicked on Proceed Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Proceed Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Proceed Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click Proceed Button");
            throw new Exception("Error: Unable to click Proceed Button");
        }
        return this;
    }

    public page clickViewCertificate() throws Exception {
        try {
            getDriver().findElementByAccessibilityId("View Certificate").click();
            utils.log().info("Clicked on View Certificate Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on View Certificate Button");
            Thread.sleep(10000);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click View Certificate Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click View Certificate Button");
            throw new Exception("Error: Unable to click View Certificate Button");
        }
        return this;
    }

    public page clickGoBackButton() throws Exception{
        try {
            Thread.sleep(1500);
            getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.widget.Button")).click();
            utils.log().info("Clicked on View Certificate Button");
            Thread.sleep(10000);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click View Certificate Button");
            throw new Exception("Error: Unable to click View Certificate Button");
        }
        return this;
    }

    public page closeTab() throws Exception{
        try {
            Thread.sleep(1500);
            getDriver().findElementByAccessibilityId("Close tab").click();
            utils.log().info("Clicked on Closed Tab");
            Thread.sleep(10000);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Close Tab");
            throw new Exception("Error: Unable to click Close Tab");
        }
        return this;
    }

    public boolean isCertificateTabPresent() throws Exception {
        utils.log().info("Validating Certificate Tab");
        ExtentReport.getTest().log(Status.INFO, "Validating Certificate Tab");
        // Alternate Approach: '//android.view.View[@content-desc[contains(., 'Certificate')]]")).size() == 2'
        if(getDriver().findElementsByAccessibilityId(("Certificate")).size() > 0) {
            utils.log().info("Certificate Tab Present");
            return true;
        }
        utils.log().info("Certificate Tab Not Present");
        return false;
    }

    public boolean isAssessmentPresent() throws Exception{
        utils.log().info("Validating Certificate Tab");
        if(getDriver().findElementsByAccessibilityId(("1 Question")).size() > 0) {
            utils.log().info("Assessment is Present");
            ExtentReport.getTest().log(Status.INFO, "Certificate Tab Present");
            return true;
        }
        utils.log().info("Assessment is not Present");
        ExtentReport.getTest().log(Status.INFO, "Certificate Tab Not Present");
        return false;
    }

    public boolean isCourseCompleted() throws Exception{
        utils.log().info("Validation if course is completed ot not");
        if(getDriver().findElementsByAccessibilityId(("Completed")).size() > 0) {
            utils.log().info("Course is Completed");
            return true;
        }
        utils.log().info("Course is not Completed");
        return false;
    }

    public page clickAllowButton() throws Exception{
        try {
            getDriver().findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            utils.log().info("Clicked on Allow Button");
            Thread.sleep(10000);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click Allow Button");
            throw new Exception("Error: Unable to click Allow Button");
        }
        return this;
    }

    public page scrollDown() throws Exception {
        // Consider Exception: The swipe action is based on device screen ratio/width which is a dependency(differs device-to-device)
        TouchAction action = new TouchAction(getDriver());
        action.press(PointOption.point(0, 400)).waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(0, 100)).release().perform();
        action.press(PointOption.point(0, 400)).waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(0, 100)).release().perform();
        action.press(PointOption.point(0, 400)).waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(0, 100)).release().perform();
        utils.log().info("Screen Scrolled Down");
        ExtentReport.getTest().log(Status.INFO, "Screen Scrolled Down");
        return this;
    }

    public page scrollRight() throws Exception {
        TouchAction action = new TouchAction(getDriver());
        action.press(PointOption.point(1058, 1418)).waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(85, 1416)).release().perform();
        action.press(PointOption.point(1058, 1418)).waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(85, 1416)).release().perform();
        utils.log().info("Screen Scrolled Right");
        ExtentReport.getTest().log(Status.INFO, "Screen Scrolled Right");
        return this;
    }





}
