package com.qualityhouse.course.ait.executable_documentation.pageobjects;

import com.qualityhouse.course.ait.executable_documentation.support.Utils;
import com.qualityhouse.course.ait.executable_documentation.testdata.UsersTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {

    private WebDriver driver;

    public LoginPageObject(WebDriver webDriver) {
        driver = webDriver;
    }

    private CommonPageObjects common = new CommonPageObjects(driver);

    /* list of page components */

    public String loginPageURL = "?page=login";

    public By txtUsername = By.id("username");

    public By txtPassword = By.name("userpass");

    public By btnLogin = By.name("ses_login");


    /* list of page actions */

    public void open() {
        driver.get(common.applicationURL + loginPageURL);
    }

    public void populateUsername(String username) {
        driver.findElement(txtUsername).clear();
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void populatePassword(String pwd) {
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(pwd);
    }

    public void login() {
        driver.findElement(btnLogin).click();
    }


    /* list of keywords */

    public Boolean isLoginPageDisplayed() {
        return Utils.isPresent(driver, btnLogin);
    }

    public void loginWithCredentials(String username, String password) {
        open();

        populateUsername(username);

        populatePassword(password);

        login();
    }

    public void loginAsUser(String user) {
        loginWithCredentials(UsersTestData.getUsername(user), UsersTestData.getPassword(user));
    }

    public void loginWithValidCredentials() {
        String validUser = "User1";
        loginWithCredentials(UsersTestData.getUsername(validUser), UsersTestData.getPassword(validUser));
    }

    public void loginWithInvalidCredentials() {
        String invalidUser = "Invalid User";
        loginWithCredentials(UsersTestData.getUsername(invalidUser), UsersTestData.getPassword(invalidUser));
    }

}
