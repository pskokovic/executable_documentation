package com.qualityhouse.course.ait.executable_documentation.stepdefs;

import com.qualityhouse.course.ait.executable_documentation.support.SharedDriver;
import com.qualityhouse.course.ait.executable_documentation.testdata.UsersTestData;
import com.qualityhouse.course.ait.executable_documentation.pageobjects.CommonPageObjects;
import com.qualityhouse.course.ait.executable_documentation.pageobjects.LoginPageObject;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
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
    public void iAmOnTheLoginPage(String pageName) {
        common.openApplication();
        if (pageName.equals("Login")) { loginPage.open(); }
        Assert.assertEquals("This is not login page!", true, loginPage.isLoginPageDisplayed());
    }

    @When("^I enter (.*) credentials$")
    public void iEnterAdminCredentials(String user) {
        loginPage.populateUsername(UsersTestData.getUsername(user));
        loginPage.populatePassword(UsersTestData.getPassword(user));
    }

    @And("^I log in$")
    public void iLogIn() {
        loginPage.login();
    }

    @Then("^I am logged in$")
    public void iAmLoggedIn() {
        Assert.assertEquals("User is not logged in!", true, common.isUserLoggedIn());
    }

    @When("^I log in as (.*)$")
    public void iLogInAsUser(String user) {
        loginPage.loginAsUser(user);
    }

    @After
    public void teardown() {
        common.logout();
    }
}
