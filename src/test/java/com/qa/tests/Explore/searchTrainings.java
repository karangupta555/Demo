package com.qa.tests.Explore;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.utils.StringParser;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.HashMap;

public class searchTrainings extends BaseTest {

    @Test
    public void searchAndViewSpecificTraining() throws  Exception{
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
        loginPage.clickSearchTab();
        Thread.sleep(5000);
        loginPage.searchCourse("rgwsdfrwe");
        Assert.assertTrue(loginPage.isNoResultFound());
        loginPage.pressBackButtonFromMobile();
        loginPage.clickSearchTab();
        Thread.sleep(5000);
        loginPage.searchCourse("Native");
        Assert.assertTrue(loginPage.isNoResultFound());
    }

    @Test
    public void searchAndValidateResults() throws  Exception{
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
        loginPage.clickSearchTab();
        Thread.sleep(5000);
        loginPage.searchCourse("rgwsdfrwe");
        Assert.assertTrue(loginPage.isNoResultFound());
        loginPage.pressBackButtonFromMobile();
        loginPage.clickSearchTab();
        Thread.sleep(5000);
        loginPage.searchCourse("Native");
        Assert.assertTrue(loginPage.isNoResultFound());
    }
}
