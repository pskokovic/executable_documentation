package com.qualityhouse.course.ait.executable_documentation.pageobjects;

import com.qualityhouse.course.ait.executable_documentation.support.Utils;
import com.qualityhouse.course.ait.executable_documentation.testdata.UsersTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePageObject {

    private WebDriver driver;

    private CommonPageObjects common = new CommonPageObjects(driver);

    public EditProfilePageObject (WebDriver driver) {
        this.driver = driver;
    }


    /* list of page components */

    public String editProfileURL = "";

    public By txtEmail = By.name("cEmail");

    public By txtName = By.name("cName");

    public By txtPhone = By.name("cPhone");

    public By txtAddress = By.name("cAddress");

    public By btnSubmit = By.cssSelector("input[type='submit'][value='Submit']");


    /* list of page actions */

    public void open() {
        Utils.waitForClicableElement(driver, common.menuEditProfile).click();
    }

    public void populateEmail(String email) {
        driver.findElement(txtEmail).clear();

        driver.findElement(txtEmail).sendKeys(email);
    }

    public void populateName(String name) {
        driver.findElement(txtName).clear();

        driver.findElement(txtName).sendKeys(name);
    }

    public void populatePhone(String phone) {
        driver.findElement(txtPhone).clear();

        driver.findElement(txtPhone).sendKeys(phone);
    }

    public void populateAddress(String address) {
        driver.findElement(txtAddress).clear();

        driver.findElement(txtAddress).sendKeys(address);
    }

    public void submitProfileDetails() {
        Utils.waitForClicableElement(driver, btnSubmit).click();
    }


    /* list of keywords */

    public void modifyProfileDetails(String email, String name, String phone, String address) {
        populateEmail(email);

        populateName(name);

        populatePhone(phone);

        populateAddress(address);

        submitProfileDetails();
    }

    public void modifyProfileDetailsOf(String user) {
        modifyProfileDetails(UsersTestData.getEmail(user), UsersTestData.getName(user), UsersTestData.getPhone(user), UsersTestData.getAddress(user));
    }

    public void modifyProfileWithValidDetails() {
        String validUser = "User1";
        modifyProfileDetailsOf(validUser);
    }

}
