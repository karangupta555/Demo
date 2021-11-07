package com.qa.pages;

import com.aventstack.extentreports.Status;
import com.qa.BaseTest;
import com.qa.FlutterFinder;
import com.qa.reports.ExtentReport;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {
    TestUtils utils =  new TestUtils();

    /**************************************** Sauce Labs *****************************************/

    @AndroidFindBy(accessibility = "test-Username")
    @iOSXCUITFindBy(id = "test-Username")
    private MobileElement usernameTxtFld;

    @AndroidFindBy(accessibility = "test-Password")
    @iOSXCUITFindBy(id = "test-Password")
    private MobileElement passwordTxtFld;

    @AndroidFindBy(accessibility = "test-LOGIN")
    @iOSXCUITFindBy(id = "test-LOGIN")
    private MobileElement loginBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
    private MobileElement errTxt;

    public LoginPage enterUserNameS(String username) {
        //WebElement e = wait.until(ExpectedConditions.visibilityOf(usernameTxtFld));
        sendKeys(usernameTxtFld, username, "userNameFF");
        return this;
    }

    public LoginPage enterPasswordS(String password) {
        //WebElement e = wait.until(ExpectedConditions.visibilityOf(passwordTxtFld));
        sendKeys(passwordTxtFld, password, "PasswordFF");
        // ((IOSDriver) driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
        // ((IOSDriver) driver).hideKeyboard();
        return this;
    }

    public com.qa.pages.ProductsPage pressLoginBtnS() {
        //wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
        click(loginBtn);
        return new com.qa.pages.ProductsPage();
    }

    public com.qa.pages.ProductsPage login(String username, String password) {
        enterUserNameS(username);
        enterPasswordS(password);
        return pressLoginBtnS();
    }

    public String getErrTxt() {
        return errTxt.getText();
        //return wait.until(ExpectedConditions.visibilityOf(errTxt)).getText();
    }

    /************************************  LMS  ***************************************/

    /* Tabs*/
    @AndroidFindBy(accessibility = "Tab 1 of 4")
    private MobileElement homeTab;

    @AndroidFindBy(accessibility = "Tab 2 of 4")
    private MobileElement searchTab;
    // Search by course title

    @AndroidFindBy(accessibility = "Tab 3 of 4")
    private MobileElement notificationTab;

    @AndroidFindBy(accessibility = "Notifications")
    private MobileElement validateNotificationTab;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"SM Tab 4 of 4\"]")
    private MobileElement profileTab;

    /* Notifications */ // android.view.View
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView")
    private MobileElement goBackFromNotificationsTab;

    @AndroidFindBy(accessibility = "mark all read")
    private MobileElement markAllReadNotifications;

    /* Sign in */
    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement signEmail;

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement password;

    @AndroidFindBy(accessibility = "Continue")
    private MobileElement continueBtn;

    @AndroidFindBy(accessibility = "Sign in")
    private MobileElement signInButton;

    @AndroidFindBy(accessibility = "Sign in with SSO")
    private MobileElement signInSSOButton;

    @AndroidFindBy(accessibility = "Forgot password?")
    private MobileElement forgotPasswordButton;

    @AndroidFindBy(accessibility = "Show")
    private MobileElement showPasswordButton;

    @AndroidFindBy(accessibility = "Hide")
    private MobileElement hidePasswordButton;

    @AndroidFindBy(xpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView")
    private MobileElement backButtonOnPasswordPage;

    /* Profile */
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"SM\"]")
    private MobileElement editProfile;

    @AndroidFindBy(accessibility = "Save")
    private MobileElement saveButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    private MobileElement certificates; // className = "android.widget.ImageView"

    @AndroidFindBy(accessibility = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    private MobileElement logout;

    @AndroidFindBy(accessibility = "Sign Out")
    private MobileElement signout;

    @AndroidFindBy(accessibility = "Cancel")
    private MobileElement cancel;

    public LoginPage clickSignInBtn() throws Exception {
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
        return this;
    }

    public LoginPage enterLoginEmail(String username) {
        sendKeys(username);
        utils.log().info("Entered userName/Email: " + username);
        ExtentReport.getTest().log(Status.INFO, "Entered userName/Email: " + username);
        return this;
    }

    public LoginPage enterLoginPassword(String password) {
        sendKeys(password);
        utils.log().info("Entered Password: " + password);
        ExtentReport.getTest().log(Status.INFO, "Entered Password: " + password);
        return this;
    }

    public LoginPage clickShowPasswordButton() {
        click(showPasswordButton);
        utils.log().info("Clicked Show Password Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Show Password Button");
        return this;
    }

    public LoginPage clickHidePasswordButton() {
        click(hidePasswordButton);
        utils.log().info("Clicked Hide Password Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Hide Password Button");
        return this;
    }

    public LoginPage clickForgotPassword() {
        click(forgotPasswordButton);
        utils.log().info("Clicked Forgot Password Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Forgot Password Button");
        return this;
    }

    public LoginPage clickContinue() {
        click(continueBtn);
        utils.log().info("Clicked Continue Button");
        ExtentReport.getTest().log(Status.INFO, "Clicked Continue Button");
        return this;
    }

    public LoginPage clickHomeTab() throws InterruptedException {
        Thread.sleep(4000);
        click(homeTab);
        utils.log().info("Switched to Home Tab");
        ExtentReport.getTest().log(Status.INFO, "Switched to Home Tab");
        return this;
    }

    public LoginPage clickSearchTab() throws InterruptedException {
        Thread.sleep(4000);
        click(searchTab);
        utils.log().info("Switched to Search/Explore Tab");
        ExtentReport.getTest().log(Status.INFO, "Switched to Search/Explore Tab");
        return this;
    }

    public LoginPage clickNotificationTab() throws InterruptedException {
        Thread.sleep(4000);
        click(notificationTab);
        utils.log().info("Switched to Notification Tab");
        ExtentReport.getTest().log(Status.INFO, "Switched to Notification Tab");
        return this;
    }

    public LoginPage validateNotificationTab() throws Exception {
        try {
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
            Thread.sleep(2000);
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
        return this;
    }

    public LoginPage clickProfileTab() throws InterruptedException {
        Thread.sleep(4000);
        click(profileTab);
        utils.log().info("Switched to Profile Tab");
        ExtentReport.getTest().log(Status.INFO, "Switched to Profile Tab");
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
}
