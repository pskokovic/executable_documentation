package com.qualityhouse.course.automation.execdocs.stepdefs;

import com.qualityhouse.course.automation.execdocs.pageobjects.CommonPageObjects;
import com.qualityhouse.course.automation.execdocs.pageobjects.LoginPageObject;
import com.qualityhouse.course.automation.execdocs.support.SharedDriver;
import com.qualityhouse.course.automation.execdocs.testdata.UsersTestData;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class LoginSteps {

    private WebDriver driver;
    private LoginPageObject loginPage;
    private CommonPageObjects common;

    public LoginSteps(SharedDriver webDriver) {
        loginPage = new LoginPageObject(webDriver);
        common = new CommonPageObjects(webDriver);
    }

    @Given("^I am on the (.*) page$")
    public void iAmOnTheLoginPage(String pageName) throws Throwable {
        common.openApplication();
        if (pageName.equals("Login")) { loginPage.open(); }
        Assert.assertEquals("This is not login page!", true, loginPage.isLoginPageDisplayed());
    }

    @When("^I enter (.*) credentials$")
    public void iEnterAdminCredentials(String user) throws Throwable {
        loginPage.populateUsername(UsersTestData.getUsername(user));
        loginPage.populatePassword(UsersTestData.getPassword(user));
    }

    @And("^I log in$")
    public void iLogIn() throws Throwable {
        loginPage.login();
    }

    @Then("^I am logged in$")
    public void iAmLoggedIn() throws Throwable {
        Assert.assertEquals("User is not logged in!", true, common.isUserLoggedIn());
    }

    @When("^I log in as (.*)$")
    public void iLogInAsUser(String user) throws Throwable {
        loginPage.loginAsUser(user);
    }

    @After
    public void teardown() {
        common.logout();
    }
}
