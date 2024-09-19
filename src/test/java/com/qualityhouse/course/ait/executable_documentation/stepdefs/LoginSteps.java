package com.qualityhouse.course.ait.executable_documentation.stepdefs;

import com.qualityhouse.course.ait.executable_documentation.pageobjects.CommonPageObjects;
import com.qualityhouse.course.ait.executable_documentation.pageobjects.LoginPageObject;
import com.qualityhouse.course.ait.executable_documentation.support.SharedDriver;
import com.qualityhouse.course.ait.executable_documentation.testdata.UsersTestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private final LoginPageObject loginPage;
    private final CommonPageObjects common;

    public LoginSteps() {
        WebDriver webDriver = SharedDriver.getDriver();
        loginPage = new LoginPageObject(webDriver);
        common = new CommonPageObjects(webDriver);
    }

    @Given("^I am on the (.*) page$")
    public void iAmOnTheLoginPage(String pageName) {
        common.openApplication();
        if (pageName.equals("Login")) { loginPage.open(); }
        Assert.assertEquals(true, loginPage.isLoginPageDisplayed(), "This is not login page!");
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
        Assert.assertEquals(true, common.isUserLoggedIn(), "User is not logged in!");
    }

    @When("^I log in as (.*)$")
    public void iLogInAsUser(String user) {
        loginPage.loginAsUser(user);
    }

}
