package com.qualityhouse.course.ait.executable_documentation.support;

import com.qualityhouse.course.ait.executable_documentation.support.browsers.BrowserFacet;
import com.qualityhouse.course.ait.executable_documentation.support.browsers.ChromeFacet;
import com.qualityhouse.course.ait.executable_documentation.support.browsers.EdgeFacet;
import com.qualityhouse.course.ait.executable_documentation.support.browsers.FirefoxFacet;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class SharedDriver {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    @Before
    public void setUp() {
        if (DRIVER.get() == null) {
            String browserType = System.getProperty("browser", "chrome").toLowerCase(); // Default is Chrome
            WebDriver webDriver = createWebDriver(browserType);
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            DRIVER.set(webDriver);
        }
    }

    private WebDriver createWebDriver(String browserType) {
        BrowserFacet browserFacet;
        switch (browserType) {
            case "firefox":
                browserFacet = new FirefoxFacet();
                break;
            case "edge":
                browserFacet = new EdgeFacet();
                break;
            case "chrome":
            default:
                browserFacet = new ChromeFacet();
                break;
        }
        return browserFacet.initializeDriver();
    }

    public static WebDriver getDriver() {
        return DRIVER.get();  // Return the WebDriver instance specific to the current thread
    }

    @After(order = 1000)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
        if (DRIVER.get() != null) {
            DRIVER.get().quit();  // Quit the WebDriver instance for the current thread
            DRIVER.remove();  // Remove the WebDriver instance from the current thread
        }
    }

    private void takeScreenshot(Scenario scenario) {
        if (DRIVER.get() instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) DRIVER.get();
            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
            try {
                String screenshotDirectory = "target/screenshots/";
                Path screenshotPath = Paths.get(screenshotDirectory);
                if (!Files.exists(screenshotPath)) {
                    Files.createDirectories(screenshotPath);
                }
                String screenshotName = screenshotDirectory + scenario.getName().replaceAll(" ", "_") + ".png";
                Files.copy(screenshot.toPath(), Paths.get(screenshotName));
                System.out.println("Screenshot saved at: " + screenshotName);
            } catch (IOException e) {
                System.out.println("Error saving screenshot: " + e.getMessage());
            }
        }
    }
}
