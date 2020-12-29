package test;

import driver.DriverSingleton;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import service.TestDataReader;
import util.TestListener;

import java.util.List;

@Listeners(TestListener.class)
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod
    protected void browserStart() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void browserTearDown() {
        DriverSingleton.deleteAllCookies();
    }

    @AfterTest
    protected void quiteBrowserAfterTest() {
        DriverSingleton.closeDriver();
    }

    public SoftAssertions generateSoftAssertionWithContains(List<String> collection, String contains){
        SoftAssertions softAssertions=new SoftAssertions();
        collection.stream().forEach(element->softAssertions.assertThat(element.contains(contains)));
        return softAssertions;
    }

}
