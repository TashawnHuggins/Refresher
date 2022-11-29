package tests.EndtoEndTests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

@RunWith(Cucumber.class) // this sets Cucumber as the framework to run our tests
@CucumberOptions(
        /*
            features: this determines which feature file/s will be used
            glue: this tells Cucumber where the step implementations are. Direct it to a package
            plugin: this is an optional setting we use to generate a nice html report of the test results
         */
        features = {"src/test/java/tests/EndtoEndTests/features"},
        //glue = "src/test/java/endtoendTests/steps",
        glue = {"endtoendTests.steps"},
        plugin = {"pretty","html:src/html-e2e-report.html"}
)

public class TestRunner
{
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup()
    {
        // the three lines below is used to set up your driver
        File file = new File("chromedriver.exe"); //content root
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath()); //this directs selenium to the type of driver and its location
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
    }


    @AfterClass
    public static void teardown()
    {
        driver.quit();
    }



}
