package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import org.testng.annotations.Test;

public class Demo extends BaseTest {
    @Test
    public void invalidUserName() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
        loginPage.pressSignInBtn();
        //String actualErrTxt = loginPage.getErrTxt();
        //String expectedErrTxt = getString().get("err_invalid_username_or_password");
        //utils.log().info("actual error text - " + actualErrTxt + "\n" + "expected error text - " + expectedErrTxt);
        //Assert.assertEquals(actualErrTxt,expectedErrTxt);
    }

    @Test
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName1(loginUsers.getJSONObject("invalidPassword").getString("username"));
        loginPage.enterPassword1(loginUsers.getJSONObject("invalidPassword").getString("password"));
        loginPage.pressSignInBtn();
        //String actualErrTxt = loginPage.getErrTxt();
        //String expectedErrTxt = getString().get("err_invalid_username_or_password");
        //utils.log().info("actual error text - " + actualErrTxt + "\n" + "expected error text - " + expectedErrTxt);
        //Assert.assertEquals(actualErrTxt,expectedErrTxt);
    }

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("valid").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("valid").getString("password"));
        //ProductsPage productsPage = loginPage.pressSignInBtn();
        //String actualProductTitle = productsPage.getTitle();
        //String expectedProductTitle = getString().get("product_title");
        //utils.log().info("actual product title - " + actualProductTitle + "\n" + "expected product title - " + expectedProductTitle);
        //Assert.assertEquals(actualProductTitle,expectedProductTitle);
    }
}
