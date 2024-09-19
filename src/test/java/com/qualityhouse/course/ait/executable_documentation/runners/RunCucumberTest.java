package com.qualityhouse.course.ait.executable_documentation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        glue = {"com.qualityhouse.course.ait.executable_documentation"},
        features = "src/test/resources/features"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
