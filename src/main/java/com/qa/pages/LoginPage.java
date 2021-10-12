package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BaseTest {
    TestUtils utils =  new TestUtils();

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

    public LoginPage enterUserName(String username) {
        //WebElement e = wait.until(ExpectedConditions.visibilityOf(usernameTxtFld));
        sendKeys(usernameTxtFld, username, "userNameFF");
        return this;
    }

    public LoginPage enterPassword(String password) {
        //WebElement e = wait.until(ExpectedConditions.visibilityOf(passwordTxtFld));
        sendKeys(passwordTxtFld, password, "PasswordFF");
        return this;
    }

    public com.qa.pages.ProductsPage pressLoginBtn() {
        //wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
        click(loginBtn);
        return new com.qa.pages.ProductsPage();
    }

    public com.qa.pages.ProductsPage login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
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

    @AndroidFindBy(accessibility = "Tab 3 of 4")
    private MobileElement notificationTab;

    @AndroidFindBy(accessibility = "SM Tab 4 of 4")
    private MobileElement profileTab;

    /* Notifications */
    @AndroidFindBy(accessibility = "Notifications")
    private MobileElement goBackFromNotificationsTab;

    @AndroidFindBy(accessibility = "mark all read")
    private MobileElement markAllReadNotifications;

    /* Sign in */
    @AndroidFindBy(tagName = "Enter email ID or username")
    private MobileElement signEmail;
    // className = "android.widget.EditText"

    @AndroidFindBy(tagName = "Enter password")
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

    /* Permissions */
    @AndroidFindBy(accessibility = "permission_allow_button")
    private MobileElement allow_access_media;

    @AndroidFindBy(accessibility = "permission_deny_button")
    private MobileElement deny_access_media;

    /* Profile */
    @AndroidFindBy(accessibility = "SM")
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

    public LoginPage enterUserName1(String username) {
        sendKeys(signEmail, username, "");
        return this;
    }

    public LoginPage enterPassword1(String password) {
        sendKeys(this.password, password, "");
        return this;
    }

    public com.qa.pages.ProductsPage pressSignInBtn() {
        click(signInButton);
        return new com.qa.pages.ProductsPage();
    }
}
