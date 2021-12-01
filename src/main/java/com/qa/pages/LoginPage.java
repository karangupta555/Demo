package com.qa.pages;

import com.aventstack.extentreports.Status;
import com.qa.BaseTest;
import com.qa.reports.ExtentReport;
import com.qa.utils.TestUtils;
import io.appium.java_client.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class LoginPage extends BaseTest {
    TestUtils utils =  new TestUtils();

    /* Tabs*/
    @AndroidFindBy(accessibility = "Tab 1 of 4")
    @iOSXCUITFindBy(accessibility = "Tab 1 of 4")
    private MobileElement homeTab;

    @AndroidFindBy(accessibility = "Tab 2 of 4")
    @iOSXCUITFindBy(accessibility = "Tab 2 of 4")
    private MobileElement searchTab;
    // Search by course title

    @AndroidFindBy(accessibility = "Tab 3 of 4")
    @iOSXCUITFindBy(accessibility = "Tab 3 of 4")
    private MobileElement notificationTab;

    @AndroidFindBy(accessibility = "Notifications")
    @iOSXCUITFindBy(accessibility = "Notifications")
    private MobileElement validateNotificationTab;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"SM Tab 4 of 4\"]")
    private MobileElement profileTab;

    @AndroidFindBy(accessibility = "Enroll now")
    @iOSXCUITFindBy(accessibility = "Enroll now")
    private MobileElement enrollNowButton;

    @AndroidFindBy(accessibility = "Start course")
    @iOSXCUITFindBy(accessibility = "Start course")
    private MobileElement startCourseButton;

    @AndroidFindBy(accessibility = "Next lesson")
    @iOSXCUITFindBy(accessibility = "Next lesson")
    private MobileElement nextLessonButton;

    @AndroidFindBy(accessibility = "Take assessment")
    @iOSXCUITFindBy(accessibility = "Take assessment")
    private MobileElement takeAssessmentButton;

    @AndroidFindBy(accessibility = "Attend later")
    @iOSXCUITFindBy(accessibility = "Attend later")
    private MobileElement attendLaterButton;

    @AndroidFindBy(accessibility = "Complete Assessment")
    @iOSXCUITFindBy(accessibility = "Complete Assessment")
    private MobileElement completeAssessmentButton;

    @AndroidFindBy(accessibility = "Assessment summary")
    @iOSXCUITFindBy(accessibility = "Assessment summary")
    private MobileElement assessmentSummaryButton;

    @AndroidFindBy(accessibility = "Proceed")
    @iOSXCUITFindBy(accessibility = "Proceed")
    private MobileElement proceedButton;

    @AndroidFindBy(accessibility = "View Certificate")
    @iOSXCUITFindBy(accessibility = "View Certificate")
    private MobileElement viewCertificateButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    @iOSXCUITFindBy(className = "XCUIElementTypeImage")
    private MobileElement backButtonOnViewCertificatePage;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[1]")
    private MobileElement backButtonOnCourseDetailsPage; // Completed Course

    @AndroidFindBy(accessibility = "Go Back")
    @iOSXCUITFindBy(accessibility = "Go Back")
    private MobileElement goBackButton;

    @AndroidFindBy(accessibility = "undefined")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Done\"]")
    private MobileElement doneButtonInAppBrowser;

    @AndroidFindBy(accessibility = "undefined")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ReloadButton\"]")
    private MobileElement reloadButtonInAppBrowser;

    @AndroidFindBy(accessibility = "undefined")
    @iOSXCUITFindBy(xpath = "Export as PDF")
    private MobileElement certificateExportAsPDF;

    @AndroidFindBy(accessibility = "undefined")
    @iOSXCUITFindBy(accessibility = "Export as Image")
    private MobileElement certificateExportAsImage;

    @AndroidFindBy(accessibility = "undefined")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"URL\"]")
    private MobileElement clickURLInAppBrowser;

    /* Notifications */ // android.view.View
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage")
    private MobileElement goBackFromNotificationsTab;

    @AndroidFindBy(accessibility = "mark all read")
    @iOSXCUITFindBy(accessibility = "mark all read")
    private MobileElement markAllReadNotifications;

    /* Sign in */
    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private MobileElement textBox;

    @AndroidFindBy(accessibility = "Continue")
    @iOSXCUITFindBy(accessibility = "Continue")
    private MobileElement continueBtn;

    @AndroidFindBy(accessibility = "Sign in")
    @iOSXCUITFindBy(accessibility = "Sign in")
    private MobileElement signInButton;

    @AndroidFindBy(accessibility = "Sign in with SSO")
    @iOSXCUITFindBy(accessibility = "Sign in with SSO")
    private MobileElement signInSSOButton;

    @AndroidFindBy(accessibility = "Forgot password?")
    @iOSXCUITFindBy(accessibility = "Forgot password?")
    private MobileElement forgotPasswordButton;

    @AndroidFindBy(accessibility = "Show")
    @iOSXCUITFindBy(accessibility = "Show")
    private MobileElement showPasswordButton;

    @AndroidFindBy(accessibility = "Hide")
    @iOSXCUITFindBy(accessibility = "Hide")
    private MobileElement hidePasswordButton;

    @AndroidFindBy(xpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView")
    @iOSXCUITFindBy(className = "XCUIElementTypeImage")
    private MobileElement backButtonOnPasswordPage;

    /* Profile */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"SM\"]")
    private MobileElement editProfile;

    @AndroidFindBy(accessibility = "Save")
    @iOSXCUITFindBy(accessibility = "Save")
    private MobileElement saveButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    private MobileElement certificates; // className = "android.widget.ImageView"

    @AndroidFindBy(accessibility = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    private MobileElement logout;

    @AndroidFindBy(accessibility = "Sign Out")
    @iOSXCUITFindBy(accessibility = "Sign Out")
    private MobileElement signout;

    @AndroidFindBy(accessibility = "Cancel")
    @iOSXCUITFindBy(accessibility = "Cancel")
    private MobileElement cancel;

    public LoginPage clickSignInBtn() throws Exception {
        Thread.sleep(4000);
        try {
            click(signInButton);
            utils.log().info("Clicked SignIn Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked SignIn Button");
        }
        catch (Exception e){
            e.printStackTrace();
            utils.log().info("Error: Unable to Click SignIn Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click SignIn Button");
            throw new Exception("Error: Unable to Click SignIn Button");
        }
        Thread.sleep(4000);
        return this;
    }

    public LoginPage enterLoginEmail(String username) throws InterruptedException {
        Thread.sleep(2000);
        //sendKeys(username); // This approach will take some time to enter/send values
        getDriver().getKeyboard().sendKeys(username);
        utils.log().info("Entered userName/Email: " + username);
        ExtentReport.getTest().log(Status.INFO, "Entered userName/Email: " + username);
        return this;
    }

    public LoginPage enterLoginPassword(String password) throws InterruptedException {
        Thread.sleep(2000);
        //sendKeys(password); // This approach will take some time to enter/send values
        getDriver().getKeyboard().sendKeys(password);
        utils.log().info("Entered Password: " + password);
        ExtentReport.getTest().log(Status.INFO, "Entered Password: " + password);
        return this;
    }

    public LoginPage clickShowPasswordButton() throws InterruptedException {
        click(showPasswordButton);
        utils.log().info("Clicked Show Password Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Show Password Button");
        Thread.sleep(3000);
        return this;
    }

    public LoginPage clickHidePasswordButton() throws InterruptedException {
        click(hidePasswordButton);
        utils.log().info("Clicked Hide Password Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Hide Password Button");
        Thread.sleep(3000);
        return this;
    }

    public LoginPage clickForgotPassword() throws InterruptedException {
        click(forgotPasswordButton);
        utils.log().info("Clicked Forgot Password Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Forgot Password Button");
        Thread.sleep(6000);
        return this;
    }

    public LoginPage clickContinue() throws InterruptedException {
        Thread.sleep(3000);
        click(continueBtn);
        utils.log().info("Clicked Continue Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Continue Button");
        Thread.sleep(2000);
        return this;
    }

    public LoginPage clickHomeTab() throws InterruptedException {
        Thread.sleep(2000);
        click(homeTab);
        utils.log().info("Switched to Home Tab");
        ExtentReport.getTest().log(Status.INFO, "Switched to Home Tab");
        Thread.sleep(4000);
        return this;
    }

    public LoginPage clickSearchTab() throws InterruptedException {
        click(searchTab);
        utils.log().info("Switched to Search/Explore Tab");
        ExtentReport.getTest().log(Status.INFO, "Switched to Search/Explore Tab");
        Thread.sleep(4000);
        return this;
    }

    public LoginPage clickNotificationTab() throws InterruptedException {
        click(notificationTab);
        utils.log().info("Switched to Notification Tab");
        ExtentReport.getTest().log(Status.INFO, "Switched to Notification Tab");
        Thread.sleep(4000);
        return this;
    }

    public LoginPage validateNotificationTab() throws Exception {
        try {
            Thread.sleep(3000);
            click(validateNotificationTab);
            utils.log().info("Validated Notification Tab");
            ExtentReport.getTest().log(Status.INFO, "Validated Notification Tab");
        }catch (Exception e){
            e.printStackTrace();
            utils.log().info("Error: Unable to Validated Notification Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Validated Notification Tab");
            throw new Exception("Error: Unable to Validated Notification Tab");
        }
        return this;
    }

    public LoginPage clickMarkAllReadNotifications() throws Exception {
        try{
            Thread.sleep(6000);
            click(markAllReadNotifications);
            utils.log().info("Clicked on \"Mark all Read\" Button in Notifications");
            ExtentReport.getTest().log(Status.INFO, "Clicked on \"Mark all Read\" Button in Notifications");
        }
        catch (Exception e){
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on \"Mark all Read\" Button in Notifications");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on \"Mark all Read\" Button in Notifications");
            throw new Exception("Error: Unable to Click on \"Mark all Read\" Button in Notifications");
        }
        Thread.sleep(6000);
        return this;
    }

    public LoginPage clickProfileTab() throws InterruptedException {
        Thread.sleep(4000);
        click(profileTab);
        utils.log().info("Switched to Profile Tab");
        ExtentReport.getTest().log(Status.INFO, "Switched to Profile Tab");
        return this;
    }

    public LoginPage searchCourse(String courseName) throws InterruptedException {
        Thread.sleep(5000);
        click(textBox);
        textBox.clear();/****/
        getDriver().getKeyboard().sendKeys(courseName);
        utils.log().info("Searched Course: " + courseName);
        ExtentReport.getTest().log(Status.INFO, "Searched Course: " + courseName);
        getDriver().hideKeyboard();
        return this;
    }

    public LoginPage viewSpecificCourse(String courseName) throws InterruptedException {
        getDriver().findElementByAccessibilityId(courseName).click();
        utils.log().info("Clicked on '"+courseName+"' Course");
        ExtentReport.getTest().log(Status.INFO, "Clicked on '"+courseName+"' Course");
        Thread.sleep(4000);
        return this;
    }

    public LoginPage clickEnrollNow() throws InterruptedException {
        click(enrollNowButton);
        utils.log().info("Clicked on Enroll Now Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked on Enroll Now Button");
        Thread.sleep(6000);
        return this;
    }

    public LoginPage clickStartCourse() throws InterruptedException {
        click(startCourseButton);
        utils.log().info("Clicked on Start Course Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked on Start Course Button");
        Thread.sleep(6000);
        return this;
    }

    public LoginPage clickNextLesson() throws InterruptedException {
        Thread.sleep(8000);
        click(nextLessonButton);
        utils.log().info("Clicked on Next Lesson Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked on Next Lesson Button");
        Thread.sleep(5000);
        return this;
    }

    public LoginPage clickTakeAssessment() throws InterruptedException {
        Thread.sleep(6500);
        click(takeAssessmentButton);
        utils.log().info("Clicked on Take Assessment Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked on Take Assessment Button");
        return this;
    }

    public LoginPage clickAttendLater() throws InterruptedException {
        Thread.sleep(6500);
        click(attendLaterButton);
        utils.log().info("Clicked on Attend Later Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked on Attend Later Button");
        return this;
    }

    public LoginPage clickCompleteAssessment() throws InterruptedException {
        click(completeAssessmentButton);
        utils.log().info("Clicked on Complete Assessment Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked on Complete Assessment Button");
        Thread.sleep(5000);
        return this;
    }

    public LoginPage answerSingleChoiceQuestion(String option) throws InterruptedException {
        getDriver().findElementByAccessibilityId(option).click();
        utils.log().info("Selected Option '"+option+"'");
        ExtentReport.getTest().log(Status.INFO, "Selected Option '"+option+"'");
        Thread.sleep(5000);
        return this;
    }

    public LoginPage clickAssessmentSummary() throws InterruptedException {
        click(assessmentSummaryButton);
        utils.log().info("Clicked on Assessment Summary Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked on Assessment Summary Button");
        Thread.sleep(5000);
        return this;
    }

    public LoginPage clickProceed() throws InterruptedException {
        Thread.sleep(6000);
        click(proceedButton);
        utils.log().info("Clicked on Proceed Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked on Proceed Button");
        Thread.sleep(6000);
        return this;
    }

    public LoginPage clickViewCertificate() throws InterruptedException {
        Thread.sleep(4000);
        click(viewCertificateButton);
        utils.log().info("Clicked on View Certificate Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked on View Certificate Button");
        Thread.sleep(10000);
        return this;
    }

    public LoginPage pressBackButtonFromMobile() throws  InterruptedException {
        getDriver().navigate().back();
        utils.log().info("Clicked Back Button from Mobile");
        ExtentReport.getTest().log(Status.INFO, "Clicked Back Button from Mobile");
        return this;
    }

    public LoginPage clickBackButtonOnViewCertificatePage() throws InterruptedException {
        click(backButtonOnViewCertificatePage);
        utils.log().info("Clicked Back Button on View Certificate Button Page");
        ExtentReport.getTest().log(Status.INFO, "Clicked Back Button on View Certificate Button Page");
        Thread.sleep(5000);
        return this;
    }

    public LoginPage clickBackButtonOnCourseDetailsPage() throws InterruptedException {
        click(backButtonOnCourseDetailsPage);
        utils.log().info("Clicked Back Button in Course Details");
        ExtentReport.getTest().log(Status.INFO, "Clicked Back Button in Course Details");
        Thread.sleep(5000);
        return this;
    }

    public LoginPage clickGoBackButton() throws InterruptedException {
        click(goBackButton);
        utils.log().info("Clicked Go Back Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Go Back Button");
        Thread.sleep(5000);
        return this;
    }

    public LoginPage clickDoneButtonInAppBrowser() throws InterruptedException {
        click(doneButtonInAppBrowser);
        utils.log().info("Clicked Go Back Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Go Back Button");
        Thread.sleep(5000);
        return this;
    }

    public boolean isNoResultFound() throws InterruptedException {
        if(getDriver().findElementsByAccessibilityId("Uh oh!! We searched the whole space but couldn't find it").size()>0){
            utils.log().info("No Result Found");
            ExtentReport.getTest().log(Status.INFO, "No Result Found");
            return true;
        }
        utils.log().info("Result Found");
        ExtentReport.getTest().log(Status.INFO, "Result Found");
        return false;
    }

    public boolean isCompletedButtonPresent() throws InterruptedException {
        if(getDriver().findElementsByAccessibilityId("Completed").size()>0){
            utils.log().info("Completed Button Present");
            ExtentReport.getTest().log(Status.INFO, "Completed Button Present");
            return true;
        }
        utils.log().info("Completed Button Not Present");
        ExtentReport.getTest().log(Status.INFO, "Completed Button Not Present");
        return false;
    }

     /*****************
       Actions Examples
     *****************/

    public LoginPage tap() throws InterruptedException {
        // Similar to Click
        TouchAction action = new TouchAction(getDriver());
        action.tap(ElementOption.element(getDriver().findElementByAccessibilityId("Enroll now"))).perform();
        utils.log().info("");
        ExtentReport.getTest().log(Status.INFO, "");
        return this;
    }

    public LoginPage press() throws InterruptedException {
        // Similar to Click
        TouchAction action = new TouchAction(getDriver());
        action.press(ElementOption.element(getDriver().findElementByAccessibilityId(""))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).release().perform();
        utils.log().info("");
        ExtentReport.getTest().log(Status.INFO, "");
        return this;
    }

    public LoginPage longPress() throws InterruptedException {
        TouchAction action = new TouchAction(getDriver());
        action.longPress(ElementOption.element(getDriver().findElementByAccessibilityId(""))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(10000))).release().perform();
        utils.log().info("");
        ExtentReport.getTest().log(Status.INFO, "");
        return this;
    }

    public LoginPage checkNotifications() throws InterruptedException {
        TouchAction action = new TouchAction(getDriver());
        Dimension size = getDriver().manage().window().getSize();
        size.getHeight();
        size.getWidth();
        System.out.println("Height of the screen: " + getDriver().manage().window().getSize().getHeight());
        System.out.println("Width of the screen: " + getDriver().manage().window().getSize().getWidth());
        // Drag from Top-Bottom
        action.press(PointOption.point(10,10))
                .waitAction(waitOptions(Duration.ofMillis(1200)))
                .moveTo(PointOption.point(900,900))
                .release()
                .perform();
        Thread.sleep(5000);
        // Drag from Bottom-Top
        action.press(PointOption.point(900,900))
                .waitAction(waitOptions(Duration.ofMillis(1200)))
                .moveTo(PointOption.point(10,10))
                .release()
                .perform();
        return this;
    }

    public LoginPage scroll() throws InterruptedException {
        TouchAction action = new TouchAction(getDriver());
        /*
        xOffset = startScrollingFromX
        yOffset = startScrollingFromY

        Same x,y points are required for end_points
         */
        action.press(PointOption.point(0,800))
                .waitAction(waitOptions(Duration.ofMillis(1500)))
                .moveTo(PointOption.point(0,200))
                .release()
                .perform();
        Thread.sleep(5000);
        return this;
    }

    public LoginPage bedug() throws InterruptedException {
        TouchAction action = new TouchAction(getDriver());
        action.press(PointOption.point(0,800))
                .waitAction(waitOptions(Duration.ofMillis(1500)))
                .moveTo(PointOption.point(0,200))
                .release()
                .perform();
        Thread.sleep(5000);
        return this;
    }

    // Toasters
    public LoginPage getToasterMessage() throws InterruptedException {
        String message="";
        utils.log().info("Toaster Message Captured: " + message);
        ExtentReport.getTest().log(Status.INFO, "Toaster Message Captured: " + message);
        return this;
    }

    /****/
    public LoginPage backButtonOnPassword() {
        click(backButtonOnPasswordPage);
        return this;
    }

    public LoginPage clickEditProfile() {
        click(editProfile);
        return this;
    }

    public LoginPage clickLogout() {
        click(logout);
        return this;
    }

    public LoginPage clickSignOutBtn() {
        click(signout);
        return this;
    }

    public LoginPage iOSPermissions() {
        getDriver().findElement(By.name("Allow Access to All Photos")).click();
        return this;
    }

    /********************************************* Debugging methods ********************************************/


    // driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));
    // driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumeup"));
    // driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "volumedown"));

    int heightOfScreen = getDriver().manage().window().getSize().getHeight();
    int widthOfScreen = getDriver().manage().window().getSize().getWidth();
    int middleHeightOfScreen = heightOfScreen/2;

    //50% of width/Width
    double x = widthOfScreen * 0.5;
    double y = heightOfScreen * 0.5;

    public LoginPage touches() {
        TouchAction touchAction = new TouchAction(getDriver());
        //touchAction.longPress();
        //touchAction.moveTo();
        //touchAction.cancel();
        //touchAction.perform().longPress();

        touchAction.tap(PointOption.point(1280, 1013)).perform();
        return this;
    }

    public LoginPage swipe() {
        TouchAction swipe = new TouchAction(getDriver())
                .press(PointOption.point(972,500))
                .waitAction(waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(108,500))
                .release()
                .perform();
        return this;
    }

    public LoginPage multiTouches() {
        // Multiple touches at a time
        TouchAction touchActionOne = new TouchAction(getDriver());
        touchActionOne.press(PointOption.point(100, 100));
        touchActionOne.release();

        TouchAction touchActionTwo = new TouchAction(getDriver());
        touchActionTwo.press(PointOption.point(200, 200));
        touchActionTwo.release();

        MultiTouchAction action = new MultiTouchAction(getDriver());
        action.add(touchActionOne);
        action.add(touchActionTwo);
        action.perform();

        // perform multi touch on particular elements
        TouchAction touchAction1 = new TouchAction(getDriver())
                .tap(ElementOption.element(signInButton))
                .release();

        TouchAction touchAction2 = new TouchAction(getDriver())
                .tap(ElementOption.element(signInButton))
                .release();

        MultiTouchAction action1 = new MultiTouchAction(getDriver());
        action1.add(touchAction1);
        action1.add(touchAction2);
        action1.perform();
        return this;
    }

    public MobileElement scrollToElement(String elementName) {
        return (MobileElement) ((FindsByAndroidUIAutomator) getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().description("+elementName+"));");
    }

    public void scrollToElement2(String elementName) {
        RemoteWebElement element = (RemoteWebElement)getDriver().findElement(By.name(elementName));
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
        scrollObject.put("direction", "down");
        scrollObject.put("predicateString", "label == 'certificate'");
        scrollObject.put("name", "certificate");
        scrollObject.put("toVisible", "sdfnjksdnfkld");
        getDriver().executeScript("mobile:scroll", scrollObject);
    }
}

// https://kobiton.com/book/chapter-11-automating-gestures
// http://appium.io/docs/en/writing-running-appium/tutorial/swipe-tutorial/
// https://www.google.com/search?q=swiping+actions+on+appium+app+automtion&oq=swiping+actions+on+appium+app+automtion&aqs=chrome..69i57j33i10i160.15882j0j1&sourceid=chrome&ie=UTF-8
