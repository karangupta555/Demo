package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
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

public class LoginTests extends BaseTest {
    ProductsPage productsPage;
    TestUtils utils = new TestUtils();

    @Parameters({"envID"})
    @BeforeClass   /****/ // beforeClass, beforeMethod in other files
    public void beforeClass(String envID) throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/loginUsers.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            loginUsers = new JSONObject(tokener);
            testData = StringParser.parseStringXML("strings/TestDataValidation.xml");
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        } finally {
            if(datais != null){
                datais.close();
            }
        }
        if(envID.equals("local")) {
            closeApp();
            launchApp();
            System.out.println("beforeClass Executed for Local");
        }
        else {
            System.out.println("beforeClass Executed for Remote");
        }
    }

    @Test
    public void invalidUserName() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
        loginPage.pressLoginBtn();
        String actualErrTxt = loginPage.getErrTxt();
        String expectedErrTxt = getString().get("err_invalid_username_or_password");
        utils.log().info("actual error text - " + actualErrTxt + "\n" + "expected error text - " + expectedErrTxt);
        Assert.assertEquals(actualErrTxt,expectedErrTxt);
    }

    @Test
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("invalidPassword").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
        loginPage.pressLoginBtn();
        String actualErrTxt = loginPage.getErrTxt();
        String expectedErrTxt = getString().get("err_invalid_username_or_password");
        utils.log().info("actual error text - " + actualErrTxt + "\n" + "expected error text - " + expectedErrTxt);
        Assert.assertEquals(actualErrTxt,expectedErrTxt);
    }

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
        ProductsPage productsPage = loginPage.pressLoginBtn();
        String actualProductTitle = productsPage.getTitle();
        String expectedProductTitle = getString().get("product_title");
        utils.log().info("actual product title - " + actualProductTitle + "\n" + "expected product title - " + expectedProductTitle);
        Assert.assertEquals(actualProductTitle,expectedProductTitle);
    }
/*
    @Test
    public void invalidUserName() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
        loginPage.pressLoginBtn();
        Assert.assertEquals(loginPage.getErrTxt(), testData.get("err_invalid_username_or_password"));
    }

    @Test
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("invalidPassword").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
        loginPage.pressLoginBtn();
        Assert.assertEquals(loginPage.getErrTxt(), testData.get("err_invalid_username_or_password"));
    }

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
        ProductsPage productsPage = loginPage.pressLoginBtn();
        Assert.assertEquals(productsPage.getTitle(), testData.get("product_title"));
    }*/

    @Parameters({"envID"})
    @AfterClass
    public void afterClass(String envID) {
        if(envID.equals("local")) {
            System.out.println("afterClass Executed for Local");
        }
        else {
            System.out.println("afterClass Executed for Remote");
        }
    }
}